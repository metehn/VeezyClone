package com.metehan.veezyclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.metehan.veezyclone.Class.Room;
import com.metehan.veezyclone.R;

import java.util.ArrayList;

public class RoomsRecyclerAdapter extends RecyclerView.Adapter<RoomsRecyclerAdapter.MyViewHolder> {

    ArrayList<Room> rooms;
    Context context;

    public RoomsRecyclerAdapter(Context context, ArrayList<Room> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_roooms_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Room selectedRoom = rooms.get(position);

        holder.tv_room_name.setText(selectedRoom.getRoomName());
        holder.tv_room_devices.setText(selectedRoom.getDeviceNumber() + " devices");
        holder.iv_room_image.setImageResource(selectedRoom.getImage());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_room_name, tv_room_devices;

        ShapeableImageView iv_room_image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_room_name = itemView.findViewById(R.id.tv_room_name);
            tv_room_devices = itemView.findViewById(R.id.tv_room_devices);
            iv_room_image = itemView.findViewById(R.id.iv_room_image);

        }




    }
}
