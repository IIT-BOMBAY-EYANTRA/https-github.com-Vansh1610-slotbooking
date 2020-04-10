package com.example.timeslotsssss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class confirm extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent =getIntent();
        timeslot time=intent.getParcelableExtra("timeslot");
        Bundle b=intent.getExtras();






        String slot=time.getSlot();

        TextView tv=findViewById(R.id.confirmtime);
        tv.setText("TIMESLOT:-"+slot);
        button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }

}
