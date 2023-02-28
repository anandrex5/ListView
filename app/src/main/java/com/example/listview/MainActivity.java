package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    //define array
    String countries[];
    //Create an adapter
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView =findViewById(R.id.list);
        countries = getResources().getStringArray(R.array.countries);

        //Creating and Adapter
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        //set listView in Adapter
        listView.setAdapter(adapter);

        //Action Perform while click on listView Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //if we click on first item it will return 0 and if we click on second item it will return 1
                //and after it convert it into string and assign it to string container
               String country_name = parent.getItemAtPosition(position).toString();

               //Print Toast Message
               Toast.makeText(getApplicationContext(),"You selected " + country_name,Toast.LENGTH_LONG).show();
            }
        });
    }
}