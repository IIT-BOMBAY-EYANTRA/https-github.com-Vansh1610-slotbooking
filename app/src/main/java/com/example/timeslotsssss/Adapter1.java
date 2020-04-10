package com.example.timeslotsssss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {
    Context context;
    ArrayList<timeslot> timeslots;
    private OnitemClicklisterner mlistener;
    public interface  OnitemClicklisterner{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnitemClicklisterner listener){
        mlistener=listener;
    }

    public Adapter1(Context c,ArrayList<timeslot> t)
    {
        context=c;
        timeslots=t;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false),mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Slot.setText(timeslots.get(position).getSlot());


    }

    @Override
    public int getItemCount() {
        return timeslots.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Slot=(TextView)itemView.findViewById(R.id.textview1);
        public MyViewHolder(@NonNull View itemView, final OnitemClicklisterner listener) {

            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int postion=getAdapterPosition();
                        if(postion!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(postion);
                        }
                    }

                }
            });
        }
    }
}
