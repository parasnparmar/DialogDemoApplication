package com.example.dialogdemoapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAlertDialog,btnDatePickerDialog,btnTimePickerDialog,btnLoginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Submit");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setMessage("Do you really want to Submit?");

                //Way-1 Attach listner to buttons on dialog
                builder.setPositiveButton("Yes",new PositiveButtonClickListner());
                builder.setNegativeButton("No", new NegativeButtonClickListner());
                builder.setNeutralButton("Not Confirm", new NeturalButtonCLickListner());


                //way-2
                DialogInterface.OnClickListener listener = new AlertDialogButtonListner();
                builder.setPositiveButton("Yes",listener);
                builder.setNegativeButton("No",listener);
                builder.setNeutralButton("Not Confirmed",listener);

                builder.setOnCancelListener(new CancelClickListner());
                builder.setOnDismissListener(new DismissClickListner());

                AlertDialog alertDialog = builder.create();
                alertDialog.setCancelable(false);
                alertDialog.show();

            }
        });




        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this
                ,new DatePickerDialogClickListner(),2024,03,19);
                datePickerDialog.show();
             }
        });

        btnTimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this
                ,new TimePickerDialogClickListner(),5,34,false);
                timePickerDialog.show();

            }
        });

        btnLoginDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    class AlertDialogButtonListner implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                Toast.makeText(MainActivity.this,"Positive Button Clicked",Toast.LENGTH_SHORT).show();
            } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(MainActivity.this,"Negative Button CLicked",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"Neutral Button CLicked",Toast.LENGTH_SHORT).show();
            }
        }
    }
     class NeturalButtonCLickListner implements DialogInterface.OnClickListener{
         @Override
         public void onClick(DialogInterface dialog, int which) {
             Toast.makeText(MainActivity.this,"Netural Button Clicked",Toast.LENGTH_SHORT).show();
         }
     }
     class PositiveButtonClickListner implements DialogInterface.OnClickListener{
         @Override
         public void onClick(DialogInterface dialog, int which) {
             Toast.makeText(MainActivity.this,"Positive Button Clicked",Toast.LENGTH_SHORT).show();
         }
     }
     class NegativeButtonClickListner implements DialogInterface.OnClickListener{
         @Override
         public void onClick(DialogInterface dialog, int which) {
             Toast.makeText(MainActivity.this,"Negative Button CLicked",Toast.LENGTH_SHORT).show();
         }
     }
    class DatePickerDialogClickListner implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                btnDatePickerDialog.setText(year+"--"+month+"--"+dayOfMonth);
        }
    }
    class TimePickerDialogClickListner implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            btnTimePickerDialog.setText(hourOfDay+"--"+minute);
        }
    }
    public class CancelClickListner implements DialogInterface.OnCancelListener{
        @Override
        public void onCancel(DialogInterface dialog) {
            Toast.makeText(MainActivity.this,"Cancel Clicked",Toast.LENGTH_SHORT).show();
        }
    }
    class DismissClickListner implements DialogInterface.OnDismissListener{
        @Override
        public void onDismiss(DialogInterface dialog) {
            Toast.makeText(MainActivity.this,"Dismiss Clicked",Toast.LENGTH_SHORT).show();
        }
    }
    private void initViews(){
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
        btnLoginDialog = findViewById(R.id.btnLoginDialog);
    }


}