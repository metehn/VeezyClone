package com.metehan.veezyclone.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.ViewGroup.LayoutParams;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.metehan.veezyclone.Class.ColdZoneTypes;
import com.metehan.veezyclone.Class.MyDialog;
import com.metehan.veezyclone.MainActivity;
import com.metehan.veezyclone.R;


public class IntelliColdZoneFragment extends Fragment {
    Activity myActivity;
    NumberPicker numberPicker;
    AppCompatButton button_cancel, button_save, bt_dialog, bt_increase_custommode, bt_decrease_custommode, bt_dialog_custommode;
    TextView tv_number_picker_value, tv_header, tv_explanation, tv_header_custommode, tv_temperature_custommode;

    MyDialog dialog;

    MyDialog customDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_intelli_cold_zone, container, false);


        dialog = new MyDialog(myActivity, ColdZoneTypes.SUPERCOOL_CHILLING);
        View viewDialog = inflater.inflate(R.layout.custom_dialog, container, false);
        dialog.setContentView(viewDialog);
        dialog.getWindow().setLayout(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        tv_header = dialog.findViewById(R.id.tv_header);
        tv_explanation = dialog.findViewById(R.id.tv_explanation);
        bt_dialog = dialog.findViewById(R.id.bt_dialog);

        //custom dialog
        customDialog = new MyDialog(myActivity, ColdZoneTypes.CUSTOM_MODE);
        View viewCustomDialog = inflater.inflate(R.layout.custom_custommod_dialog, container, false);
        customDialog.setContentView(viewCustomDialog);
        customDialog.getWindow().setLayout(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        customDialog.setCanceledOnTouchOutside(false);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        bt_increase_custommode = customDialog.findViewById(R.id.bt_increase_custommode);
        bt_decrease_custommode = customDialog.findViewById(R.id.bt_decrease_custommode);
        bt_dialog_custommode = customDialog.findViewById(R.id.bt_dialog_custommode);
        tv_header_custommode = customDialog.findViewById(R.id.tv_header_custommode);
        tv_temperature_custommode = customDialog.findViewById(R.id.tv_temperature_custommode);

        numberPicker = view.findViewById(R.id.numberPicker);
        button_cancel = view.findViewById(R.id.button_cancel);
        button_save = view.findViewById(R.id.button_save);
        tv_number_picker_value = view.findViewById(R.id.tv_number_picker_value);


        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).removeFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (dialog.getMyEnum() == ColdZoneTypes.SUPERCOOL_CHILLING) {

                    updateDialog(MainActivity.SUPERCOOL_CHILLING, R.string.supercool_chilling);

                    bt_dialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //todo cancel timer if there is and set new one, close fragment

                            ((MainActivity) myActivity).removeFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
                            dialog.hide();

                            Toast.makeText(myActivity, "Timer Started", Toast.LENGTH_SHORT).show();

                            new CountDownTimer(5000, 1000) {

                                public void onTick(long millisUntilFinished) {
                                   // mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                                }

                                public void onFinish() {
                                    //Toast.makeText(myActivity, "DONE", Toast.LENGTH_LONG).show();
                                    AlertDialog alertDialog = new AlertDialog.Builder(myActivity).create();
                                    alertDialog.setTitle("Warning!");
                                    alertDialog.setMessage("Your food has been in the fridge for a long time. They may be rotten.");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    alertDialog.show();
                                }
                            }.start();

                        }
                    });
                    dialog.show();
                }
                else if (dialog.getMyEnum() == ColdZoneTypes.SOFT_FREEZE) {

                    updateDialog(MainActivity.SOFT_FREEZE, R.string.soft_freeze);

                    bt_dialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //todo cancel timer if there is and set new one, close fragmet
                            ((MainActivity) myActivity).removeFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
                            dialog.hide();
                            Toast.makeText(myActivity, "Timer Started", Toast.LENGTH_SHORT).show();
                            new CountDownTimer(21000, 1000) {

                                public void onTick(long millisUntilFinished) {
                                    // mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                                }

                                public void onFinish() {
                                    //Toast.makeText(myActivity, "DONE", Toast.LENGTH_LONG).show();
                                    AlertDialog alertDialog = new AlertDialog.Builder(myActivity).create();
                                    alertDialog.setTitle("Warning!");
                                    alertDialog.setMessage("Your food has been in the fridge for a long time. They may be rotten.");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    alertDialog.show();
                                }
                            }.start();
                        }
                    });

                    dialog.show();
                }
                else if (dialog.getMyEnum() == ColdZoneTypes.FREEZER) {

                    updateDialog(MainActivity.FREEZER, R.string.freezer);

                    bt_dialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ((MainActivity) myActivity).removeFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
                            dialog.hide();
                        }
                    });
                    dialog.show();
                }
                else if (dialog.getMyEnum() == ColdZoneTypes.COOLER) {

                    updateDialog(MainActivity.COOLER, R.string.cooler);

                    bt_dialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ((MainActivity) myActivity).removeFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
                            dialog.hide();
                        }
                    });
                    dialog.show();
                }
                else if (dialog.getMyEnum() == ColdZoneTypes.CUSTOM_MODE) {

                    //todo make another dialog
                    tv_header_custommode.setText(MainActivity.CUSTOM_MODE);
                    tv_temperature_custommode.setText("0");

                    bt_increase_custommode.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                  int temp = Integer.parseInt(String.valueOf(tv_temperature_custommode.getText()));
                                   if(temp < 5){
                                       temp++;
                                       tv_temperature_custommode.setText( String.valueOf(temp) );
                                   }
                                }
                            });
                        }
                    });
                    bt_decrease_custommode.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    int temp = Integer.parseInt(String.valueOf(tv_temperature_custommode.getText()));
                                    if(temp > -24){
                                        temp--;
                                        tv_temperature_custommode.setText( String.valueOf(temp) );
                                    }
                                }
                            });
                        }
                    });

                    bt_dialog_custommode.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            RefrigeratorFragment fragment = (RefrigeratorFragment) ((MainActivity) myActivity).findFragment(MainActivity.REFRIGERATOR_FRAGMENT);
                            fragment.updateTemp(Integer.parseInt(String.valueOf(tv_temperature_custommode.getText())), Integer.parseInt(String.valueOf(tv_temperature_custommode.getText())));
                            ((MainActivity) myActivity).removeFragment(MainActivity.INTELLI_COLD_ZONE_FRAGMENT);
                            customDialog.hide();
                        }
                    });

                    customDialog.show();
                }

            }
        });

        if (numberPicker != null) {
            final String[] values = {MainActivity.SUPERCOOL_CHILLING, MainActivity.SOFT_FREEZE, MainActivity.FREEZER, MainActivity.COOLER, MainActivity.CUSTOM_MODE};
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(values.length - 1);
            numberPicker.setDisplayedValues(values);
            numberPicker.setWrapSelectorWheel(false);

            numberPicker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    String text = values[newVal] + "";
                    tv_number_picker_value.setText(text);

                    switch (newVal) {
                        case 0:
                            dialog.setMyEnum(ColdZoneTypes.SUPERCOOL_CHILLING);
                            break;
                        case 1:
                            dialog.setMyEnum(ColdZoneTypes.SOFT_FREEZE);
                            break;
                        case 2:
                            dialog.setMyEnum(ColdZoneTypes.FREEZER);
                            break;
                        case 3:
                            dialog.setMyEnum(ColdZoneTypes.COOLER);
                            break;
                        case 4:
                            dialog.setMyEnum(ColdZoneTypes.CUSTOM_MODE);
                            break;
                    }
                }
            });
        }
/*
        tv_super_chilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrangeDialog(inflater, container, ColdZoneTypes.SUPER_CHILLING);

                tv_header.setText("Super Chilling Mode");
                tv_explanation.setText(R.string.super_chilling_mode);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.hide();
                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo set timer
                        dialog.hide();
                    }
                });

                dialog.show();
            }
        });
*/


        return view;
    }

    public void updateDialog(String str, int i) {
        tv_header.setText(str);
        tv_explanation.setText(i);
    }

}////end of the class