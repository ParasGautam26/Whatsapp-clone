package com.parasgautam.flashchatnewfirebase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;

public class chatListAdapter extends BaseAdapter {
    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private String mDisplayName;
    private ArrayList<DataSnapshot> mSnapshotList;

    public chatListAdapter(Activity activity, DatabaseReference databaseReference, String displayName) {
        mActivity = activity;
        mDatabaseReference = databaseReference.child("message");
        mDisplayName = displayName;
        mSnapshotList = new ArrayList<>();
    }
        static class ViewHolder{
            TextView authorName,body;
            LinearLayout.LayoutParams params;
        }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public InstantMessage getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.chat_msg_row,viewGroup,false);
            final ViewHolder holder = new ViewHolder();
            holder.authorName = view.findViewById(R.id.author);
            holder.body = view.findViewById(R.id.message);
            holder.params = (LinearLayout.LayoutParams)holder.authorName.getLayoutParams();
            view.setTag(holder);
        }
        final InstantMessage instantMessage = getItem(i);
        final ViewHolder holder =  (ViewHolder) view.getTag();
        String author = instantMessage.getAuthor();
        holder.authorName.setText(author);
        String message = instantMessage.getMessage();
        holder.body.setText(message);

        return view;
    }
}