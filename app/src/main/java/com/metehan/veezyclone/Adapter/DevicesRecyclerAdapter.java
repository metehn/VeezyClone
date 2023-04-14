package com.metehan.veezyclone.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.metehan.veezyclone.Class.MyDevice;
import com.metehan.veezyclone.Class.Room;
import com.metehan.veezyclone.MainActivity;
import com.metehan.veezyclone.R;

import java.util.ArrayList;

public class DevicesRecyclerAdapter  extends RecyclerView.Adapter<DevicesRecyclerAdapter.MyViewHolder>  {

    Activity mActivity;
    ArrayList<MyDevice> devices;


    public DevicesRecyclerAdapter(Activity mActivity, ArrayList<MyDevice> devices) {
        this.mActivity = mActivity;
        this.devices = devices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mActivity).inflate(R.layout.custom_decives_row, parent, false);
        return new DevicesRecyclerAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyDevice selectedDevice = devices.get(position);

        holder.tv_devices_name.setText(selectedDevice.getName());
        holder.tv_devices_room.setText(selectedDevice.getRoom() + "");
        holder.iv_device_image.setImageResource(selectedDevice.getImage());

        holder.ll_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDevice myDevice = devices.get( holder.getAdapterPosition() );

                if(myDevice != null && myDevice.getName().equals("Double Door Refrigerator")){

                    ((MainActivity)mActivity).addFragment(MainActivity.REFRIGERATOR_FRAGMENT);
                    ((MainActivity)mActivity).updateStatusBar(R.color.white);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_devices_name, tv_devices_room;

        ShapeableImageView iv_device_image;

        LinearLayout ll_device;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ll_device = itemView.findViewById(R.id.ll_device);
            tv_devices_name = itemView.findViewById(R.id.tv_devices_name);
            tv_devices_room = itemView.findViewById(R.id.tv_devices_room);
            iv_device_image = itemView.findViewById(R.id.iv_device_image);

        }




    }
}
