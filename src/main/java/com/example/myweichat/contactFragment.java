package com.example.myweichat;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class contactFragment extends Fragment {
    private View view;
    private ArrayList<String> mylist = new ArrayList<>();
    int[] imageId;
    public contactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.click_2, container, false);
        initdata();

        initView();

        return view;
    }

    private void initdata() {
        mylist.add("No.1,小张");
        mylist.add("No.2,小司");
        mylist.add("No.3,李华");
        mylist.add("No.4,美团");
        mylist.add("No.5,湖北大学");
        mylist.add("No.6,小明");
        mylist.add("No.7,小红");
        mylist.add("No.8,明天");
        mylist.add("No.9,老妈");
        mylist.add("No.10,老爸");
        mylist.add("No.11,小弟");
        mylist.add("No.12,小妹");
        mylist.add("No.13,大姐");
        mylist.add("No.14,刘同学");
        imageId= new int[]{R.drawable.item1,
                R.drawable.item2,
                R.drawable.item3,
                R.drawable.item4,
                R.drawable.item1,
                R.drawable.item2,
                R.drawable.item3,
                R.drawable.item4,
                R.drawable.item1,
                R.drawable.item2,
                R.drawable.item3,
                R.drawable.item4,
                R.drawable.item1,
                R.drawable.item2
        };
    }

    private void initView() {
        MyAdapter adapter = new MyAdapter(getContext());
        RecyclerView RecyclerView = view.findViewById(R.id.click_2);

        ItemTouchHelper.Callback callback = new swipeItemTouchHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(RecyclerView);

        RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.setHasFixedSize(true);
        RecyclerView.setAdapter(adapter);

        adapter.setClickDataList(mylist,imageId);





    }
}
