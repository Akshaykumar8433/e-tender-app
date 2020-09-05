package com.tender.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tender.R;

import java.io.File;

public class HomeFragment extends Fragment implements View.OnClickListener {

//    private HomeViewModel homeViewModel;
    private static final int REQUEST_CODE = 43;
    TextView path;
    Button b1;
    Button b2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        b1 = (Button) root.findViewById(R.id.button_file);
        path = (TextView) root.findViewById(R.id.path);
        b2 = (Button) root.findViewById(R.id.button_register);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_file:
                startSearch();
//                Toast.makeText(view.getContext(),"File",Toast.LENGTH_LONG).show();
                break;
            case R.id.button_register:
                Toast.makeText(view.getContext(),"Add",Toast.LENGTH_LONG).show();
                break;
        }
    }

    public  void  startSearch(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK){
            if(data != null){
                Uri uri = data.getData();
                File file = new File(uri.getPath());

//                Toast.makeText(this,"Uri:"+uri,Toast.LENGTH_LONG).show();
//                uriText.setText(uri,toString());
                Toast.makeText(getActivity().getApplicationContext(),"File Name:"+file.getName(),Toast.LENGTH_LONG).show();
                path.setText(file.getName());
            }
        }
    }
}