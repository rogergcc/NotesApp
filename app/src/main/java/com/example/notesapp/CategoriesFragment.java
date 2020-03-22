package com.example.notesapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class CategoriesFragment extends Fragment implements CategoriesAdapter.OnRecyclerItemClick {

    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;
    private List<NotesModel> modelList;

    private String[] head = {"Video call to client team.",
            "Video call to team lead.",
            "Python practise.",
            "Coding my app",
            "Python practise.",
            "Coding my app"};

    private String[] desc = {"This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout."};

    private String[] time = {"11:15 am", "12:30 am", "2:30 pm", "4:00 pm", "2:30 pm", "4:00 pm"};

    public CategoriesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.recycler);

        modelList = new ArrayList<>();
        for (int i = 0; i < head.length; i++) {
            NotesModel notesModel = new NotesModel();
            notesModel.setHead(head[i]);
            notesModel.setDesc(desc[i]);
            notesModel.setTime(time[i]);
            //if you want to use icons for different categories you can use the following line :
            //notesModel.setView(PASS ICONS HERE LIKE WORK, PERSONAL, ETC);
            modelList.add(notesModel);
        }
        categoriesAdapter = new CategoriesAdapter(modelList, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(categoriesAdapter);

        categoriesAdapter.setOnRecyclerItemClick(this);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onClick(int pos) {

    }
}
