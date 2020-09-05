package com.tender;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class addtender extends AppCompatActivity {

    private static final int REQUEST_CODE = 43;
    Button select;
    TextView path,uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtender);

        select = (Button) findViewById(R.id.button_file);
        path = (TextView) findViewById(R.id.path);

        select.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startSearch();
            }
        });
    }

    public  void  startSearch(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK){
            if(data != null){
                Uri uri = data.getData();

//                Toast.makeText(this,"Uri:"+uri,Toast.LENGTH_LONG).show();
//                uriText.setText(uri,toString());
                Toast.makeText(this,"Path:"+uri.getPath(),Toast.LENGTH_LONG).show();
                path.setText(uri.getPath().toString());
            }
        }
    }
}