package fuyu.ntub_course.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fuyu.ntub_course.Model.Session;
import fuyu.ntub_course.R;

public class SessionRVAdapter extends CommonRVAdapter {
    private ArrayList<Session> list;

    public SessionRVAdapter(Context context, ArrayList<Session> list) {
        super(context);
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getInflater().inflate(R.layout.item_rv_session, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder h = (ViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View v) {
            super(v);
        }
    }
}
