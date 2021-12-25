package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inputsClear(View v){
        EditText inputC = (EditText) findViewById(R.id.inputC);
        EditText inputX = (EditText) findViewById(R.id.inputX);
        EditText inputT = (EditText) findViewById(R.id.inputT);
        inputC.setText("");
        inputT.setText("");
        inputX.setText("");
        String mess="Поля очищено";
        showResultMessage(mess);
    }

    public void onCalculate(View v){
        EditText inputC = (EditText) findViewById(R.id.inputC);
        EditText inputX = (EditText) findViewById(R.id.inputX);
        EditText inputT = (EditText) findViewById(R.id.inputT);
        String mess="";
        if(inputT.getText().toString().isEmpty())
            mess="Т не вказано";
        if(inputC.getText().toString().isEmpty())
            if (mess.isEmpty())
                mess=mess+"C не вказано";
            else
                mess=mess+"\n C не вказано ";
        if(inputX.getText().toString().isEmpty())
            if (mess.isEmpty())
                mess=mess+"X не вказано";
            else
                mess=mess+"\n X не вказано ";
        if (mess.isEmpty())
            try {
                double t=Double.parseDouble(inputT.getText().toString());
                double c=Double.parseDouble(inputC.getText().toString());
                double x=Double.parseDouble(inputX.getText().toString());

                if((c+t)<0)
                    mess="Вираз під коренем не може бути менше нуля";
                else if((c+t)==0)
                    mess="На нуль ділити не можна";
                else if(c==0)
                    mess="ctg від 0 не існує";
                else
                {
                    double result=Math.pow((1/Math.tan(c)),2)+((2*Math.pow(x,2)+5)/(Math.sqrt(c+t)));
                    String formattedDouble = new DecimalFormat("#0.00").format(result);
                    mess = "L="+formattedDouble;
                }
            }
            catch (Exception e){
                mess = "Не вдалося конвертувати данні";

            }
        showResultMessage(mess);
    }

    private void showResultMessage(String mess){
        LayoutInflater inflater=getLayoutInflater();
        View layout =inflater.inflate(R.layout.messege_toast, (ViewGroup) findViewById(R.id.showMessage));

        TextView message = layout.findViewById(R.id.message);
        message.setText(mess.toString());

        Toast toast = new Toast(getApplicationContext());

        toast.setGravity(Gravity.CENTER, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void autorInfoToast(View v){
        LayoutInflater inflater=getLayoutInflater();
        View layout =inflater.inflate(R.layout.autor_info_toast, (ViewGroup) findViewById(R.id.authorInfoToast));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}