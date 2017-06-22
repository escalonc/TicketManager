package com.cejteam.presenters.User;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cejteam.data.entities.User;
import com.cejteam.ticketmanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christopher Escalon on 6/12/2017.
 */

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private List<User> mUsers;

    public UserRecyclerViewAdapter(List<User> users) {
        mUsers = users;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTitle, mSubtitle;
        public ViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.row_title);
            mSubtitle = (TextView) view.findViewById(R.id.subtitle);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        User user = mUsers.get(position);
        holder.mTitle.setText(user.getUsername());
        holder.mSubtitle.setText(user.getName() + " - " + user.getUserType().toString());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
