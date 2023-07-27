package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.ViewHolder> {
    Context context;
    ArrayList<contact_model> arrcontact;
    Recycleradapter(Context contest, ArrayList<contact_model> arrcontact){
        this.context=contest;
        this.arrcontact=arrcontact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
       ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(arrcontact.get(position).image);
        holder.textView.setText(arrcontact.get(position).name);
        holder.textView2.setText(arrcontact.get(position).number);

        setanimation(holder.itemView,position);

        holder.lilay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.add_upd_layout);

                EditText txt1=dialog.findViewById(R.id.edittext1);
                EditText txt2=dialog.findViewById(R.id.edittxt2);
                Button btnaction=dialog.findViewById(R.id.btn1);
                TextView textView=dialog.findViewById(R.id.txt3);
                textView.setText("Update Contact");
                btnaction.setText("Update");
                txt1.setText(arrcontact.get(position).name);
                txt2.setText(arrcontact.get(position).number);


                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        int image;
                        if(!txt1.getText().toString().equals("")){
                            name=txt1.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Please Enter the Name ", Toast.LENGTH_SHORT).show();
                        }
                        if(!txt2.getText().toString().equals("")){
                            number=txt2.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please Enter the Number", Toast.LENGTH_SHORT).show();
                        }
                        arrcontact.set(position,new contact_model(arrcontact.get(position).image,name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();


                    }
                });
                dialog.show();




            }
        });
        holder.lilay.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Delete contact").setMessage("Are you want to delete this contact number?").setIcon(R.drawable.ic_baseline_delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrcontact.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();


                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrcontact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2;
        ImageView imageView;
        LinearLayout lilay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
            imageView=itemView.findViewById(R.id.imageView);
            lilay=itemView.findViewById(R.id.lilay);
        }
    }
    private void setanimation(View viewtoanimate,int position){
        Animation slideln= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewtoanimate.startAnimation(slideln);
    }


}
