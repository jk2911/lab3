package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView dateCreate, nameClub;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateCreate = findViewById(R.id.dateCreate);
        nameClub = findViewById(R.id.nameClub);

        setDateCreate();
        /*try {
            FileOutputStream fileOutputStream = openFileOutput("file.txt", MODE_PRIVATE);
            fileOutputStream.write("fuck you".getBytes());
            fileOutputStream.close();
            FileInputStream fileInputStream = openFileInput("file.txt");
            byte[] mess = new byte[fileInputStream.available()];
            fileInputStream.read(mess);
            String str = new String(mess);
            dateCreate.setText(str);
        } catch (IOException e) {
            Log.d("MainActivity", e.getMessage());
        }*/
    }

    public void setDate(View v) {
        new DatePickerDialog(MainActivity.this, d,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setDateCreate();
        }
    };

    public void setDateCreate() {
        dateCreate.setText(calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + "."
                + calendar.get(Calendar.YEAR));
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, StadiumActivity.class);
        intent.putExtra("nameClub", nameClub.getText().toString());
        startActivity(intent);
    }
}