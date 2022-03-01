package com.example.mymocktest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ListView theListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        // Set the listview.
        int[] passedIntArr = getIntent().getIntArrayExtra("passedIntArr");
        String[] stringArr = new String[passedIntArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = String.valueOf(passedIntArr[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArr);

        theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(adapter);

        //
        this.setTheListViewClickListener();
    }


    private void setTheListViewClickListener() {

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String msg = "";

                switch (i) {
                    case 0:
                        msg = "A ==>";
                        break;
                    case 1:
                        msg = "B ==>";
                        break;
                    case 2:
                        msg = "C ==>";
                        break;
                }

                msg += " " + i;

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}