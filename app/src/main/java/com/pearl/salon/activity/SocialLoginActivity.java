package com.pearl.salon.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.pearl.salon.utils.AppPrefference.setUserEmail;
import static com.pearl.salon.utils.AppPrefference.setUserGender;
import static com.pearl.salon.utils.AppPrefference.setUserLoggedOut;
import static com.pearl.salon.utils.AppPrefference.setUserName;
import static com.pearl.salon.utils.AppUtils.clearAllIntent;

public class SocialLoginActivity extends AppCompatActivity {

    private boolean doublePressedExit = false;
    private FirebaseAuth mAuth;
    private GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 1001;
    private ProgressDialog pd;
    private CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private LoginButton loginButton;
    private AccessToken mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_login);
//        AppUtils.setBarTransparent(this);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setPermissions(EMAIL);
//        loginButton.setLoginBehavior(LoginBehavior.WEB_ONLY);

        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        callbackManager = CallbackManager.Factory.create();

        pd = new ProgressDialog(this);
        pd.setMessage("Please wait....");
        pd.setCanceledOnTouchOutside(false);

    }

    public void goToLogin(View view) {
        startActivity(new Intent(this, SimpleLoginActivity.class));
    }

    @Override
    public void onBackPressed() {
        if(doublePressedExit){
            super.onBackPressed();
        }else{
            AppUtils.showBottomToast(this, "Please click BACK again to exit");
            doublePressedExit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublePressedExit = false;
                }
            }, 2000);
        }
    }

    @Override
    protected void onResume() {
        if(!AppUtils.isConnectionAvailable(this)){
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
        super.onResume();
    }

    public void googleLogin(View view) {
        if(AppUtils.isConnectionAvailable(this)){
            pd.show();
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }else{
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
    }

    public void facebookLogin(View view) {
        if(AppUtils.isConnectionAvailable(this)){
            loginButton.performClick();
            // Callback registration
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    pd.dismiss();
                    mAccessToken = loginResult.getAccessToken();
                    getUserProfileForFB(mAccessToken);
                }

                @Override
                public void onCancel() {
                    Toast.makeText(SocialLoginActivity.this, "Facebook sign-in cancel", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(FacebookException exception) {
                    Toast.makeText(SocialLoginActivity.this, "Facebook Error: "+exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                pd.dismiss();
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                // ...
            }
        }
    }

    private void getHeshKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.pearl.salon",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String key = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Log.d("KeyHash:", "feacebook key: "+key);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "NameNotFoundException: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (NoSuchAlgorithmException e) {
            Toast.makeText(this, "NoSuchAlgorithmException: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pd.dismiss();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            String Name = mAuth.getCurrentUser().getDisplayName();
                            String Email = mAuth.getCurrentUser().getEmail();
                            String Uid = mAuth.getCurrentUser().getUid();

                            setUserLoggedOut(SocialLoginActivity.this, false);
                            setUserName(SocialLoginActivity.this, Name);
                            setUserEmail(SocialLoginActivity.this, Email);
                            setUserGender(SocialLoginActivity.this, "Male");
                            Intent intent = new Intent(SocialLoginActivity.this, HomeActivity.class);
                            clearAllIntent(intent);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(SocialLoginActivity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        mAuth.signOut();
                        mGoogleSignInClient.signOut();

                        // ...
                    }
                });
    }

    private void getUserProfileForFB(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            String socialId = object.getString("id");
                            String socialName = object.getString("name");
                            String socialEmail = "";
                            try {
                                socialEmail = object.getString("email");
                                setUserLoggedOut(SocialLoginActivity.this, false);
                                setUserName(SocialLoginActivity.this, socialName);
                                setUserEmail(SocialLoginActivity.this, socialEmail);
                                setUserGender(SocialLoginActivity.this, "Male");
                                Intent intent = new Intent(SocialLoginActivity.this, HomeActivity.class);
                                clearAllIntent(intent);
                                startActivity(intent);
                                finish(); 
                            } catch (Exception e) {
                                Toast.makeText(SocialLoginActivity.this, "User email not found from facebook", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        LoginManager.getInstance().logOut();
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();

    }
}
