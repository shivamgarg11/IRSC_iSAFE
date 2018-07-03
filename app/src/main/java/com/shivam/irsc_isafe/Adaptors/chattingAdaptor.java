package com.shivam.irsc_isafe.Adaptors;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shivam.irsc_isafe.R;
import com.shivam.irsc_isafe.Classes.messageclass;

import java.util.ArrayList;

public class chattingAdaptor extends RecyclerView.Adapter<chattingAdaptor.CourseViewHolder> {


    private Context context;
    private ArrayList<messageclass> chats;
    private String username;

    public chattingAdaptor(Context context, ArrayList<messageclass> chats,String username) {
        this.context = context;
        this.chats = chats;
        this.username=username;
    }



    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(viewType, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {

        if(chats.get(position).getUser().equals(username)){
            return R.layout.chatting_self_message;
        }else{
            return R.layout.chatting_other_message;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        messageclass m=chats.get(position);
        holder.chatusername.setText(m.getUser());
        holder.chatusermessage.setText(m.getMessage());
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }





    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public TextView chatusername;
        public TextView chatusermessage;

        public CourseViewHolder(View itemView) {
            super(itemView);
            chatusername = itemView.findViewById(R.id.chatusername);
            chatusermessage = itemView.findViewById(R.id.chatusermessage);

        }
    }
}
