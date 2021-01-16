package com.example.ismail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Types_of_Graphs extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of__graphs);
        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("types_of_graph_edited.pdf").load();
        pdfView.fitToWidth();

    }
}
