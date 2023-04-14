package com.metehan.veezyclone.Fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.metehan.veezyclone.Adapter.DevicesRecyclerAdapter;
import com.metehan.veezyclone.Adapter.RoomsRecyclerAdapter;
import com.metehan.veezyclone.Class.MyDevice;
import com.metehan.veezyclone.Class.Room;
import com.metehan.veezyclone.MainActivity;
import com.metehan.veezyclone.R;

import java.util.ArrayList;

public class DemoFragment extends Fragment {

    Activity mActivity;
    AppCompatButton button_exit_demoMode;

    ArrayList<Room> rooms;
    ArrayList<MyDevice> devices;
    RecyclerView rv_fragment_demo_rooms;
    RecyclerView rv_fragment_demo_devices;

    RoomsRecyclerAdapter roomsRecyclerAdapter;
    DevicesRecyclerAdapter devicesRecyclerAdapter;

    LinearLayoutManager layoutManager;
    LinearLayoutManager layoutManager2;

    public DemoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = getActivity();

        rooms = new ArrayList<>();
        devices = new ArrayList<>();

        dummyRooms();

        dummyDevices();

        layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        layoutManager2 = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        button_exit_demoMode = view.findViewById(R.id.button_exit_demoMode);
        button_exit_demoMode.setSoundEffectsEnabled(false);

        //Recycler View components
        rv_fragment_demo_rooms = view.findViewById(R.id.rv_fragment_demo_rooms);
        rv_fragment_demo_rooms.setHasFixedSize(true);
        rv_fragment_demo_rooms.setLayoutManager(layoutManager);

        roomsRecyclerAdapter = new RoomsRecyclerAdapter(mActivity,rooms);
        rv_fragment_demo_rooms.setAdapter(roomsRecyclerAdapter);

        rv_fragment_demo_devices = view.findViewById(R.id.rv_fragment_demo_devices);
        rv_fragment_demo_devices.setHasFixedSize(true);

        devicesRecyclerAdapter = new DevicesRecyclerAdapter(mActivity, devices);
        rv_fragment_demo_devices.setAdapter(devicesRecyclerAdapter);
        rv_fragment_demo_devices.setLayoutManager(layoutManager2);

        button_exit_demoMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) mActivity).removeFragment(MainActivity.DEMO_FRAGMENT);
                //attach & add LOGIN_FRAGMENT
                ((MainActivity) mActivity).addFragment(MainActivity.LOGIN_FRAGMENT);
                ((MainActivity) mActivity).updateStatusBar(R.color.custom_gray_4);
            }
        });

        return view;
    }

    public void dummyRooms(){
        Room livingRoom= new Room("Living Room", 2, R.drawable.device_bg);
        Room kitchen= new Room("Kitchen", 4, R.drawable.device_bg);
        Room bathroom= new Room("Bathroom", 2, R.drawable.device_bg);

        rooms.add(livingRoom);
        rooms.add(kitchen);
        rooms.add(bathroom);
    }

    public void dummyDevices(){
        MyDevice airConditioner = new MyDevice("Air Conditioner", "Living Room", R.drawable.air_conditioner);
        MyDevice dishwasher = new MyDevice("DishWasher", "Kitchen", R.drawable.fridge);
        MyDevice frenchDoorRefrigerator = new MyDevice("French Door Refrigerator", "Kitchen", R.drawable.fridge);
        MyDevice doubleDoorRefrigerator = new MyDevice("Double Door Refrigerator", "Kitchen", R.drawable.fridge);
        MyDevice oven = new MyDevice("Oven", "Kitchen", R.drawable.air_conditioner);
        MyDevice washingMachine = new MyDevice("Washing Machine", "Bathroom", R.drawable.air_conditioner);
        MyDevice tumbleDryer = new MyDevice("Tubmle Dryer", "Bathroom", R.drawable.air_conditioner);

        devices.add(airConditioner);
        devices.add(dishwasher);
        devices.add(frenchDoorRefrigerator);
        devices.add(doubleDoorRefrigerator);
        devices.add(oven);
        devices.add(washingMachine);
        devices.add(tumbleDryer);
    }
}