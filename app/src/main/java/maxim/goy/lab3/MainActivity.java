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
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = getIntent().getBundleExtra("club");
        if (bundle == null) {
            bundle = new Bundle();
        }


        dateCreate = findViewById(R.id.dateCreate);
        nameClub = findViewById(R.id.nameClub);
        nameTown = findViewById(R.id.nameTown);

        int day = 1, month = 2, year = 1950;

        nameClub.setText(bundle.getString("name", ""));
        nameTown.setText(bundle.getString("town", ""));


        try {
            day = bundle.getInt("day", day);
            month = bundle.getInt("month", month);
            year = bundle.getInt("year", year);
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
        bundle.putString("name", nameClub.getText().toString());
        bundle.putString("town", nameTown.getText().toString());
        bundle.putInt("day", calendar.get(Calendar.DATE));
        bundle.putInt("month", calendar.get(Calendar.MONTH));
        bundle.putInt("year", calendar.get(Calendar.YEAR));

        intent.putExtra("club", bundle);

        /*intent.putExtra("coach", this.intent.getStringExtra("coach"));
        intent.putExtra("stadium", this.intent.getStringExtra("stadium"));
        intent.putExtra("capacity", this.intent.getStringExtra("capacity"));
        intent.putExtra("players", this.intent.getStringExtra("players"));
        intent.putExtra("tournament", this.intent.getStringExtra("tournament"));*/
        startActivity(intent);
    }
}