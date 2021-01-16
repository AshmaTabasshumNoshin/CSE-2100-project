package com.example.ismail.myapplication;

        import android.app.Activity;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.Toast;

public class
MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button) findViewById(R.id.button1);


    }
    public void contents(View view){
        Intent intent= new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Contents",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Exit?\n\nDo you really want to exit?");

        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertdialog = builder.create();
        alertdialog.show();
    }
}
