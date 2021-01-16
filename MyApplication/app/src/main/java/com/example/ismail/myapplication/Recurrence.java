package com.example.ismail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Recurrence extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurrence);
        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("recurrence.pdf").load();
        pdfView.fitToWidth();
    }
}
