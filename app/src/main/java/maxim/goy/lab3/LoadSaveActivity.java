package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class LoadSaveActivity extends AppCompatActivity implements SavedIntent {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_save);
        intent = getIntent();
    }

    public void save(View v) {
        String name = intent.getStringExtra("name");
        String town = intent.getStringExtra("name");
        Calendar date = new GregorianCalendar(
                intent.getIntExtra("year", 1900),
                intent.getIntExtra("month", 0),
                intent.getIntExtra("day", 1)
        );
        String coach = intent.getStringExtra("coach");
        int capacity = intent.getIntExtra("capacity", 0);
        String stadium = intent.getStringExtra("stadium");
        int players = intent.getIntExtra("players", 0);
        StringTokenizer tournaments = new StringTokenizer(intent.getStringExtra("tournament"),
                ",");
        ArrayList<String> tournamentsList = new ArrayList<>(tournaments.countTokens());
        while (tournaments.hasMoreElements())
            tournamentsList.add(tournaments.nextToken());
        Club club = new Club(
                name, town, date, coach, capacity, stadium, players
        );
        try {
            FileOutputStream fileOutputStream = openFileOutput(club.path, MODE_PRIVATE);
            Gson gson = new Gson();
            fileOutputStream.write(gson.toJson(club).getBytes());
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            Toast.makeText(this, "Не удалось сохранить", Toast.LENGTH_SHORT);
        }
    }

    public void load(View v) {

    }

    public void backPage(View v) {

    }

    @Override
    public void saveInfoInIntent(Intent intent) {

    }
}