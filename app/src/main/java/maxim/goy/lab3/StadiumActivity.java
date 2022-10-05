package maxim.goy.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StadiumActivity extends AppCompatActivity implements SavedIntent {
    TextView nameClub;
    EditText nameStadium, nameCoach, capacity, countPlayers;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);
        intent = getIntent();

        nameClub = findViewById(R.id.nameClub);

        nameStadium = findViewById(R.id.nameStadium);
        nameCoach = findViewById(R.id.nameCoach);
        capacity = findViewById(R.id.capacity);
        countPlayers = findViewById(R.id.countPlayers);

        nameClub.setText(intent.getStringExtra("name"));
        nameStadium.setText(intent.getStringExtra("stadium"));
        nameCoach.setText(intent.getStringExtra("coach"));
        capacity.setText(intent.getStringExtra("capacity"));
        countPlayers.setText(intent.getStringExtra("players"));
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        saveInfoInIntent(intent);
        startActivity(intent);
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, TournamentActivity.class);
        saveInfoInIntent(intent);
        startActivity(intent);
    }

    @Override
    public void saveInfoInIntent(Intent intent) {
        intent.putExtra("name", nameClub.getText().toString());
        intent.putExtra("town", this.intent.getStringExtra("town"));
        intent.putExtra("day", this.intent.getStringExtra("day"));
        intent.putExtra("month", this.intent.getStringExtra("month"));
        intent.putExtra("year", this.intent.getStringExtra("year"));
        intent.putExtra("tournament", this.intent.getStringExtra("tournament"));

        intent.putExtra("coach", nameCoach.getText().toString());
        intent.putExtra("stadium", nameStadium.getText().toString());
        intent.putExtra("capacity", capacity.getText().toString());
        intent.putExtra("players", countPlayers.getText().toString());
    }
}