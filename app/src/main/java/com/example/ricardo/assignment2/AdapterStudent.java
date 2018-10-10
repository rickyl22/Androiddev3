package com.example.ricardo.assignment2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ViewHolderItem> implements View.OnClickListener {

    List<Student> data ;
    private View.OnClickListener listener;
    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student,null,false);
        view.setOnClickListener(this);
        return new ViewHolderItem(view);
    }

    public AdapterStudent(List<Student> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItem viewHolderItem, int i) {
        Student s = data.get(i);
        viewHolderItem.studentDetails.setText("Name: "+s.name+", Roll #: "+s.roll_number);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {
        TextView studentDetails;
        // Aqui van los datos, imagenes, texto etc...
        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            studentDetails = itemView.findViewById(R.id.student_details);
        }


    }
}
