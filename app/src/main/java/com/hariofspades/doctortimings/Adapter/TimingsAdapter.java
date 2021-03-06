package com.hariofspades.doctortimings.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hariofspades.doctortimings.Pojo.Timings;
import com.hariofspades.doctortimings.R;

import java.util.ArrayList;

/**
 * Created by Hari on 15/02/16.
 */
public class TimingsAdapter extends RecyclerView.Adapter<TimingsAdapter.MyViewHolder> {

    //Creating an arraylist of POJO objects
    private ArrayList<Timings> list_members=new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context context;

    public TimingsAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.timing_row, parent, false);
        holder=new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Timings list_items=list_members.get(position);
        holder.weekday.setText(list_items.getWeek());
    }

    //Setting the arraylist
    public void setListContent(ArrayList<Timings> list_members){
        this.list_members=list_members;
        notifyItemRangeChanged(0,list_members.size());

    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView weekday;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
           weekday=(TextView)itemView.findViewById(R.id.weekday);

        }
        @Override
        public void onClick(View v) {

        }
    }
    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }

}
