package com.example.ismail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Function extends AppCompatActivity {
    EditText seta, setb, relation;
    String[] setAelems, setBelems, relationElems;
    ArrayList<String> elemesArelation,elemsBrelation;
    ArrayList<Func> functions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        elemesArelation = new ArrayList<>();
        elemsBrelation = new ArrayList<>();
        functions = new ArrayList<>();
        seta = (EditText) findViewById(R.id.F_SetA);
        setb = (EditText) findViewById(R.id.F_SetB);
        relation = (EditText) findViewById(R.id.F_Relation);




    }
    public void getFunction(View v)
    {
        functions.clear();
        setAelems = seta.getText().toString().split(",");
        setBelems = setb.getText().toString().split(",");






        relationElems = relation.getText().toString().split(":");
        for(int i =0; i < relationElems.length; i++)
        {
            String curr = relationElems[i];
            //elemesArelation.add(curr.split(",")[0]);
            //elemsBrelation.add(curr.split(",")[1]);
            Func f = new Func(curr.split(",")[0], curr.split(",")[1]);
            functions.add(f);

        }
        if(!isOnto())
        {
            Toast.makeText(Function.this, "Not Onto function", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(Function.this, "Onto function", Toast.LENGTH_LONG).show();
        }
        if(isOneToOne())
        {
            Toast.makeText(Function.this, "One to one", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(Function.this, "Not One to one", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isOnto()
    {
        functions.clear();
        setAelems = seta.getText().toString().split(",");
        setBelems = setb.getText().toString().split(",");
        relationElems = relation.getText().toString().split(":");
        for(int i =0; i < relationElems.length; i++)
        {
            String curr = relationElems[i];
            //elemesArelation.add(curr.split(",")[0]);
            //elemsBrelation.add(curr.split(",")[1]);
            Func f = new Func(curr.split(",")[0], curr.split(",")[1]);
            functions.add(f);

        }
        if(setBelems.length != functions.size())
        {
         return false;
        }
        else
        {
            int k = 0;
            for(int i = 0; i<functions.size(); i++)
            {
                String curr_y = functions.get(i).getY();

                for(int j = 0; j<setBelems.length; j++)
                {
                    if(setBelems[j].equals(curr_y)) k++;
                }
            }
            if(k<setBelems.length) return false;
        }
        return true;

    }

    //checkOneTOOne
    private boolean isOneToOne()
    {
        ArrayList<String> currntCodomains = new ArrayList<>();
        Log.d("--------", functions.size() + " lengyh");
        for (int i = 0; i < functions.size(); i++)
        {
            Func f = functions.get(i);
            Log.d("---------", f.getY());
            if(currntCodomains.contains(f.getY()))
            {
                return false;
            }
            else
            {
                currntCodomains.add(f.getY());
            }

        }
        return true;
    }
   private class Func{
        private String x;
        private String y;
       public Func(String x, String y)
       {
           this.x = x;
           this.y = y;
       }

       public String getX() {
           return x;
       }

       public String getY() {
           return y;
       }
   }
}
