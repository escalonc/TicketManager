package com.cejteam.ticketmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;
import com.cejteam.data.repositories.UserRepository;
import com.cejteam.presenters.User.DividerItemDecoration;
import com.cejteam.presenters.User.UserRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private List<User> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserRecyclerViewAdapter mAdapter;
    BaseRepository<User> userRepository = new UserRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.user_list_recycler_view);

        mAdapter = new UserRecyclerViewAdapter(userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        prepareData();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void prepareData() {
        for (User user : this.userRepository.getAll()){
            userList.add(user);
        }

        mAdapter.notifyDataSetChanged();
    }

}
