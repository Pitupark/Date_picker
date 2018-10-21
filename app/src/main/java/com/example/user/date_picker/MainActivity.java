package com.example.user.date_picker;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private Button btn1, btn3, btn2;
    private int dia, mes, anno, diaSalida, mesSalida, annoSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == btn1) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anno = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                    et1.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }, dia, mes, anno);
            datePickerDialog.show();
            datePickerDialog.updateDate(anno, mes, dia);

        }
        if (v == btn2) {
            final Calendar c = Calendar.getInstance();
            diaSalida = c.get(Calendar.DAY_OF_MONTH);
            mesSalida = c.get(Calendar.MONTH);
            annoSalida = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year2, int month2, int dayOfMonth2) {
                    et2.setText(dayOfMonth2 + "/" + (month2 + 1) + "/" + year2);
                }
            }, diaSalida, mesSalida, annoSalida);
            datePickerDialog.show();
            datePickerDialog.updateDate(annoSalida, mesSalida, diaSalida);

        } if (v == btn3) {
            int resta = diaSalida - dia ;
            String resul = String.valueOf(resta);
            tv1.setText(resul);
        }

    }
}
