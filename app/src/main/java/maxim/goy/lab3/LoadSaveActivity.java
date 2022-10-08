package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class LoadSaveActivity extends AppCompatActivity {
    private final String path = "club.json";
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_save);
        bundle = getIntent().getBundleExtra("club");
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void save(View v) {
        String name = bundle.getString("name", "");
        String town = bundle.getString("town", "");
        Calendar date = new GregorianCalendar(
                bundle.getInt("year", 1900),
                bundle.getInt("month", 0),
                bundle.getInt("day", 1)
        );
        String coach = bundle.getString("coach", "");
        int capacity = bundle.getInt("capacity", 0);

        String stadium = bundle.getString("stadium", "");
        int players = bundle.getInt("players", 0);

        ArrayList<String> tournamentsList = bundle.getStringArrayList("tournament");
        Club club = new Club(
                name, town, date, coach, capacity, stadium, players
        );
        club.setTournament(tournamentsList);
        try {
            FileOutputStream fileOutputStream = openFileOutput(path, MODE_PRIVATE);
            Gson gson = new Gson();
            fileOutputStream.write(gson.toJson(club).getBytes());
            Toast.makeText(this, "Сохранено", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Не удалось сохранить", Toast.LENGTH_SHORT).show();
        }
    }

    public void load(View v) {
        try {
            FileInputStream fileInputStream = openFileInput(path);
            byte[] info = new byte[fileInputStream.available()];
            fileInputStream.read(info);
            Gson gson = new Gson();
            Club club = gson.fromJson(new String(info), Club.class);

            bundle.putString("name", club.getName());
            bundle.putString("town", club.getTown());
            bundle.putInt("day", club.getDate().get(Calendar.DATE));
            bundle.putInt("month", club.getDate().get(Calendar.MONTH));
            bundle.putInt("year", club.getDate().get(Calendar.YEAR));
            bundle.putString("coach", club.getNameCoach());
            bundle.putString("stadium", club.getNameStadium());
            bundle.putInt("capacity", club.getCapacityStadium());
            bundle.putInt("players", club.getCountPlayers());
            bundle.putStringArrayList("tournament", club.getTournament());

            Toast.makeText(this, "Загружено", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Не удалось загрузить", Toast.LENGTH_SHORT).show();
        }
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, TournamentActivity.class);
        intent.putExtra("club", bundle);
        startActivity(intent);
    }
}