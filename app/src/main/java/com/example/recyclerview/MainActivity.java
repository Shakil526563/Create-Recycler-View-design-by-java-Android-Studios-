package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<contact_model> arcontact=new ArrayList<>();
FloatingActionButton floatingActionButton;
    RecyclerView ryc;
    Recycleradapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatingActionButton);

        RecyclerView ryc=findViewById(R.id.ryc);
        ryc.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_upd_layout);
                EditText txt1=dialog.findViewById(R.id.edittext1);
                EditText txt2=dialog.findViewById(R.id.edittxt2);
                Button btnaction=dialog.findViewById(R.id.btn1);

                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        int image;
                        if(!txt1.getText().toString().equals("")){
                            name=txt1.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Please Enter the Name ", Toast.LENGTH_SHORT).show();
                        }
                        if(!txt2.getText().toString().equals("")){
                            number=txt2.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter the Number", Toast.LENGTH_SHORT).show();
                        }

                        arcontact.add(new contact_model(R.drawable.c,name,number));
                        ryc.scrollToPosition(arcontact.size()-1);
                        dialog.dismiss();






                    }
                });
                dialog.show();

            }
        });
        arcontact.add(new contact_model(R.drawable.c,"A","0445"));
        arcontact.add(new contact_model(R.drawable.a,"B","0445"));
        arcontact.add(new contact_model(R.drawable.d,"C","0445"));
        arcontact.add(new contact_model(R.drawable.b,"D","0445"));
        arcontact.add(new contact_model(R.drawable.c,"E","0445"));
        arcontact.add(new contact_model(R.drawable.a,"F","0445"));
        arcontact.add(new contact_model(R.drawable.d,"G","0445"));
        arcontact.add(new contact_model(R.drawable.b,"H","0445"));
        arcontact.add(new contact_model(R.drawable.c,"I","0445"));
        arcontact.add(new contact_model(R.drawable.a,"J","0445"));
        arcontact.add(new contact_model(R.drawable.d,"K","0445"));
        arcontact.add(new contact_model(R.drawable.b,"L","0445"));
        arcontact.add(new contact_model(R.drawable.c,"M","0445"));
        arcontact.add(new contact_model(R.drawable.a,"M","0445"));
        arcontact.add(new contact_model(R.drawable.d,"N","0445"));
        arcontact.add(new contact_model(R.drawable.b,"O","0445"));
        arcontact.add(new contact_model(R.drawable.c,"P","0445"));
        arcontact.add(new contact_model(R.drawable.a,"Q","0445"));
        arcontact.add(new contact_model(R.drawable.d,"R","0445"));
        arcontact.add(new contact_model(R.drawable.b,"S","0445"));

        Recycleradapter adapter=new Recycleradapter(this,arcontact);
        ryc.setAdapter(adapter);


    }
}