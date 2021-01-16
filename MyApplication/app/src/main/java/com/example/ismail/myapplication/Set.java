package com.example.ismail.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class Set extends AppCompatActivity {

    EditText setA, setB;
    String[] elemA, elemB,elemC,elemD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        setA = (EditText) findViewById(R.id.SetA);
        setB = (EditText) findViewById(R.id.SetB);



    }
    private void showDlg(String title, String body)
    {
       new AlertDialog.Builder(this).setMessage(body).setTitle(title).setPositiveButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
           }
       }).create().show();
    }


    public void getUnion(View v)
    {

        elemA = setA.getText().toString().split(",");
        elemB = setB.getText().toString().split(",");
        for (int i = 0; i < elemA.length; i++) {
            elemA[i] = elemA[i].trim();
        }
        for (int i = 0; i < elemB.length; i++) {
            elemB[i] = elemB[i].trim();
        }
        ArrayList<String> union = new ArrayList<>();
        for(int i = 0; i<elemA.length; i++)
        {
          if(!union.contains(elemA[i]))
          {
              union.add(elemA[i]);
          }
        }
        for(int i = 0; i<elemB.length; i++)
        {
            if(!union.contains(elemB[i]))
            {
                union.add(elemB[i]);
            }
        }
        StringBuilder builder = new StringBuilder("{");
        for(int i = 0; i<union.size(); i++)
        {
            builder.append(union.get(i) + ",");
        }
        builder.append("}");
        showDlg("Union of the Sets", builder.toString());


    }
    public void getIntersection(View v)
    {
        elemC = setA.getText().toString().split(",");
        elemD = setB.getText().toString().split(",");
        for (int i = 0; i < elemC.length; i++) {
            elemC[i] = elemC[i].trim();
        }
        for (int i = 0; i < elemD.length; i++) {
            elemD[i] = elemD[i].trim();
        }
        ArrayList<String> elemCL = new ArrayList(Arrays.asList(elemC));
        ArrayList<String> elemDL = new ArrayList(Arrays.asList(elemD));
        ArrayList<String> intersection = new ArrayList<>();
        Log.d("---------", elemCL.get(0));
        for(int i = 0; i<elemCL.size(); i++)
        {
           if (!intersection.contains(elemCL.get(i)) && elemDL.contains(elemCL.get(i)))
           {
               intersection.add(elemCL.get(i));
           }
        }
        Log.d("---------", elemCL.get(0));
        for(int i = 0; i<elemDL.size(); i++)
        {
            if (!intersection.contains(elemDL.get(i)) && elemCL.contains(elemDL.get(i)))
            {
                intersection.add(elemDL.get(i));
            }
        }
        StringBuilder builder = new StringBuilder("{");
        for(int i = 0; i<intersection.size(); i++)
        {
             builder.append(intersection.get(i) + ",");
        }
        builder.append("}");
        showDlg("Intersection of the Sets", builder.toString());


    }

}
