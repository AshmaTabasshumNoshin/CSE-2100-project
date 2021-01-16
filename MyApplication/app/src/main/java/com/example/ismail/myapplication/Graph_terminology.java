package com.example.ismail.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Graph_terminology extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_terminology);
        pdfView =(PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("graph_terminology1.pdf").load();
        pdfView.fitToWidth();
    }
}
