package com.example.ismail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Inclusion_Exclusion extends AppCompatActivity {

    EditText subjectA, subjectB, subjectAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclusion__exclusion);
        subjectA = (EditText) findViewById(R.id.SubjectA_Stdnt_EditText);
        subjectB = (EditText) findViewById(R.id.SubjectB_Stdnt_EditText);
        subjectAB = (EditText) findViewById(R.id.SubjectAB_Stdnt_EditText);
    }
    public void findIntersection(View v)
    {
        int sA = Integer.parseInt(subjectA.getText().toString());
        int sB = Integer.parseInt(subjectB.getText().toString());
        int sAB = Integer.parseInt(subjectAB.getText().toString());

        Toast.makeText(Inclusion_Exclusion.this, "" + (sA+sB-sAB), Toast.LENGTH_LONG).show();

    }
}
