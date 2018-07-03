package com.shivam.irsc_isafe.CreateActivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.shivam.irsc_isafe.Adaptors.chattingAdaptor;
import com.shivam.irsc_isafe.R;

import java.util.ArrayList;

public class createAdaptor extends RecyclerView.Adapter<createAdaptor.CourseViewHolder> {


    private Context context;
    private ArrayList<Integer> eventslist;

    public createAdaptor(Context context, ArrayList<Integer> eventslist) {
        this.context = context;
        this.eventslist = eventslist;
    }



    @NonNull
    @Override
    public createAdaptor.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(viewType, parent, false);
        return new createAdaptor.CourseViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {


            return R.layout.createeventsadaptor;

    }

    @Override
    public void onBindViewHolder(@NonNull createAdaptor.CourseViewHolder holder, final int position) {
        Integer e =eventslist.get(position);
      holder.eventimage.setImageResource(e);

      holder.eventimage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "Clicked"+position, Toast.LENGTH_SHORT).show();
          }
      });

    }

    @Override
    public int getItemCount() {
        return eventslist.size();
    }





    public static class CourseViewHolder extends RecyclerView.ViewHolder {

       ImageView eventimage;

        public CourseViewHolder(View itemView) {
            super(itemView);
            eventimage = itemView.findViewById(R.id.imageeventcreateadaptor);

        }
    }
}

