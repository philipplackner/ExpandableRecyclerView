package com.phila.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, List<String>> map = new HashMap<>();
        map.put("Fruits", Arrays.asList("Apple", "Banana", "Peach"));
        map.put("Vegetables", Arrays.asList("Cucumber", "Broccoli", "Tomato"));

        ExpandableListView elvList = findViewById(R.id.elvList);
        List<String> titles = new ArrayList<>(map.keySet());
        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(this, titles, map);
        elvList.setAdapter(adapter);
    }
}
