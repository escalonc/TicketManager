package com.cejteam.ticketmanager;

import android.support.v4.util.ArraySet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cejteam.ticketmanager.Adapter.Adapter;

import java.util.Arrays;
import java.util.List;

public class Events_createdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_created);


        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.lista);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        List<Register_events> registers= Arrays.asList(new Register_events("Musical","Ilonka","Te esperamos","26 Mayo", "Gratis","Ven"),
                                                         new Register_events("Musical","Anohana","Estara buenisimo","26 Mayo", "Gratis","Apresurate")        );

        Adapter adapter= new Adapter(registers);
        recyclerView.setAdapter(adapter);

    }
}
