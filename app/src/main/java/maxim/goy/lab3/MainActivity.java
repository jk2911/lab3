package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    TextView dateCreate, nameClub, nameTown;
    Calendar calendar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.intent = getIntent();

        dateCreate = findViewById(R.id.dateCreate);
        nameClub = findViewById(R.id.nameClub);
        nameTown = findViewById(R.id.nameTown);

        nameClub.setText(intent.getStringExtra("name"));
        nameTown.setText(intent.getStringExtra("town"));

        int day = 0, month = 0, year = 0;

        try {
            day = Integer.parseInt(intent.getStringExtra("day"));
            month = Integer.parseInt(intent.getStringExtra("month"));
            year = Integer.parseInt(intent.getStringExtra("year"));
        } catch (Exception e) {
            calendar = Calendar.getInstance();
        }

        if (calendar == null) {
            calendar = new GregorianCalendar(year, month - 1, day);
        }
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

    @SuppressLint("SetTextI18n")
    public void setDateCreate() {
        dateCreate.setText(calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + "."
                + calendar.get(Calendar.YEAR));
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, StadiumActivity.class);
        intent.putExtra("name", nameClub.getText().toString());
        intent.putExtra("town", nameTown.getText().toString());
        intent.putExtra("day", calendar.get(Calendar.DATE));
        intent.putExtra("month", calendar.get(Calendar.MONTH));
        intent.putExtra("year", calendar.get(Calendar.YEAR));
        intent.putExtra("coach", this.intent.getStringExtra("coach"));
        intent.putExtra("stadium", this.intent.getStringExtra("stadium"));
        intent.putExtra("capacity", this.intent.getStringExtra("capacity"));
        intent.putExtra("players", this.intent.getStringExtra("players"));
        intent.putExtra("tournament", this.intent.getStringExtra("tournament"));
        startActivity(intent);
    }
}