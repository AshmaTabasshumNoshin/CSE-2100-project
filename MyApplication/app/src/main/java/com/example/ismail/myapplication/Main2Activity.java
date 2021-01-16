package com.example.ismail.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        expandableListView =( ExpandableListView) findViewById(R.id.exp_list);
        final List<String> heading = new ArrayList<String>();
        List<String> child1 = new ArrayList<String>();
        List<String> child2 = new ArrayList<String>();
        List<String> child3 = new ArrayList<String>();
        final HashMap<String,List<String>> children= new HashMap<String, List<String>>();
        String Heading []= getResources().getStringArray(R.array.mainchapter);
        String Child1 []= getResources().getStringArray(R.array.subchapter1);
        String Child2 []= getResources().getStringArray(R.array.subchapter2);
        String Child3 []= getResources().getStringArray(R.array.subchapter3);
        for(String title:Heading)
        {
            heading.add("   "+title);
        }
        for(String title:Child1)
        {
            child1.add(title);
        }
        for(String title:Child2)
        {
            child2.add(title);
        }
        for(String title:Child3)
        {
            child3.add(title);
        }
        children.put(heading.get(0), child1);
        children.put(heading.get(1), child2);
        children.put(heading.get(2), child3);
        Myaddapter myaddapter = new Myaddapter(this,heading,children);
        expandableListView.setAdapter(myaddapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Set"))
                {
                    Intent intent =new Intent(Main2Activity.this,Set.class);
                    startActivity(intent);
                }
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Function"))
                {
                    Intent intent =new Intent(Main2Activity.this,Function.class);
                    startActivity(intent);
                }
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Recurrence relation"))
                {
                    Intent intent =new Intent(Main2Activity.this,Recurrence.class);
                    startActivity(intent);
                }
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Linear recurrence relation"))
                {
                    Intent intent =new Intent(Main2Activity.this,Linear_recurrence.class);
                    startActivity(intent);
                }
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Inclusion and exclusion"))
                {
                    Intent intent =new Intent(Main2Activity.this,Inclusion_Exclusion.class);
                    startActivity(intent);
                }
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Graph terminology"))
                {
                    Intent intent =new Intent(Main2Activity.this,Graph_terminology.class);
                    startActivity(intent);
                }
                if(children.get(heading.get(groupPosition)).get(childPosition).toString().equals("Different type of graphs"))
                {
                    Intent intent =new Intent(Main2Activity.this,Types_of_Graphs.class);
                    startActivity(intent);
                }
                return false;
            }
        });



    }
}
