package com.pearl.salon.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pearl.salon.R;
import com.pearl.salon.adapter.InboxListAdapter;
import com.pearl.salon.model.inbox.InboxList;
import com.pearl.salon.utils.AppUtils;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateRandomNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class InboxFragment extends Fragment {

    private RecyclerView rv_inbox;
    private View mainView;
    private ArrayList<InboxList> inboxList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_inbox, container, false);

        rv_inbox = mainView.findViewById(R.id.rv_inbox_list);

        rv_inbox.setLayoutManager(new LinearLayoutManager(getActivity()));

        inboxList = new ArrayList<>();

        InboxList data0 = new InboxList("Daniel Williem", "Hey! How can i change my hair style.", 2, generateRandomNumber(), "10:45 am");
        InboxList data1 = new InboxList("Victor Black", "Which kind of package and offers provide ?", 0, generateRandomNumber(), "06:45 pm");
        InboxList data2 = new InboxList("Kevin Doyle", "Sounds good to me!", 0, generateRandomNumber(), "04:05 pm");
        InboxList data3 = new InboxList("Ben Jonsan", "Hi Mike, How is you hair color now?", 2, generateRandomNumber(), "01:00 pm");
        InboxList data4 = new InboxList("Ankit Kumar", "When will i do next facial makeup", 1, generateRandomNumber(), "05:45 pm");
        InboxList data5 = new InboxList("Daniel Williem", "Hey! How can i change my hair style.", 2, generateRandomNumber(), "10:45 am");
        InboxList data6 = new InboxList("Victor Black", "Which kind of package and offers provide ?", 0, generateRandomNumber(), "06:45 pm");
        InboxList data7 = new InboxList("Kevin Doyle", "Sounds good to me!", 0, generateRandomNumber(), "04:05 pm");
        InboxList data8 = new InboxList("Ben Jonsan", "Hi Mike, How is you hair color now?", 2, generateRandomNumber(), "01:00 pm");
        InboxList data9 = new InboxList("Ankit Kumar", "When will i do next facial makeup", 1, generateRandomNumber(), "05:45 pm");
        InboxList data10 = new InboxList("Daniel Williem", "Hey! How can i change my hair style.", 2, generateRandomNumber(), "10:45 am");
        InboxList data11 = new InboxList("Victor Black", "Which kind of package and offers provide ?", 0, generateRandomNumber(), "06:45 pm");
        InboxList data12 = new InboxList("Kevin Doyle", "Sounds good to me!", 0, generateRandomNumber(), "04:05 pm");
        InboxList data13 = new InboxList("Ben Jonsan", "Hi Mike, How is you hair color now?", 2, generateRandomNumber(), "01:00 pm");
        InboxList data14 = new InboxList("Ankit Kumar", "When will i do next facial makeup", 0, generateRandomNumber(), "05:45 pm");

        inboxList.add(data0);
        inboxList.add(data1);
        inboxList.add(data2);
        inboxList.add(data3);
        inboxList.add(data4);
        inboxList.add(data5);
        inboxList.add(data6);
        inboxList.add(data7);
        inboxList.add(data8);
        inboxList.add(data9);
        inboxList.add(data10);
        inboxList.add(data11);
        inboxList.add(data12);
        inboxList.add(data13);
        inboxList.add(data14);

        rv_inbox.setAdapter(new InboxListAdapter(getActivity(), inboxList));

        return mainView;
    }

}
