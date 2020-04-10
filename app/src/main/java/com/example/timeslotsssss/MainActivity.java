package com.example.timeslotsssss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref;
    RecyclerView recyclerView;
    ArrayList<timeslot> list;
    Adapter1 adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recycler_time);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<timeslot>();

        ref= FirebaseDatabase.getInstance().getReference().child("shop1").child("timeslot");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    timeslot t=ds.getValue(timeslot.class);
                    list.add(t);
                }
                adapter1=new Adapter1(MainActivity.this,list);
                recyclerView.setAdapter(adapter1);
                adapter1.setOnItemClickListener(new Adapter1.OnitemClicklisterner() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent=new Intent(MainActivity.this,confirm.class);
                        intent.putExtra("timeslot",list.get(position) );
                         removeitem(position);


                        startActivity(intent);


                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,"oops",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void removeitem(int position){
        list.remove(position);
        adapter1.notifyItemRemoved(position);
    }
}
