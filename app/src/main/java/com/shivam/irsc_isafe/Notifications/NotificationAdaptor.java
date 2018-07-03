package com.shivam.irsc_isafe.Notifications;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shivam.irsc_isafe.Adaptors.chattingAdaptor;
import com.shivam.irsc_isafe.R;

import java.util.ArrayList;

public class NotificationAdaptor  extends RecyclerView.Adapter<chattingAdaptor.CourseViewHolder> {


    private Context context;
    private ArrayList<NotificationClass> Notifications;

    public NotificationAdaptor(Context context, ArrayList<NotificationClass> Notifications) {
        this.context = context;
        this.Notifications = Notifications;
    }



    @NonNull
    @Override
    public chattingAdaptor.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(viewType, parent, false);
        return new chattingAdaptor.CourseViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {

        return R.layout.chatting_other_message;
    }

    @Override
    public void onBindViewHolder(@NonNull chattingAdaptor.CourseViewHolder holder, int position) {
        NotificationClass m=Notifications.get(position);
        holder.chatusername.setText(m.getNotifytime());
        holder.chatusermessage.setText(m.getNotification());
    }

    @Override
    public int getItemCount() {
        return Notifications.size();
    }





   public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView chatusername, chatusermessage;

        public CourseViewHolder(View itemView) {
            super(itemView);
            chatusername = itemView.findViewById(R.id.chatusername);
            chatusermessage = itemView.findViewById(R.id.chatusermessage);

        }
    }
}

