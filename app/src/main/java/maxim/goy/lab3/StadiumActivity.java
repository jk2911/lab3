package maxim.goy.lab3;

import android.content.Intent;
import android.content.res.Resources;
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
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);
        bundle = getIntent().getBundleExtra("club");

        nameClub = findViewById(R.id.nameClub);

        nameStadium = findViewById(R.id.nameStadium);
        nameCoach = findViewById(R.id.nameCoach);
        capacity = findViewById(R.id.capacity);
        countPlayers = findViewById(R.id.countPlayers);

        nameClub.setText(bundle.getString("name", ""));
        nameStadium.setText(bundle.getString("stadium", ""));
        nameCoach.setText(bundle.getString("coach", ""));

        try {
            capacity.setText(bundle.getInt("capacity") + "");
            countPlayers.setText(bundle.getInt("players") + "");
        } catch (Resources.NotFoundException notFoundException) {
        }
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
        bundle.putString("coach", nameCoach.getText().toString());
        bundle.putString("stadium", nameStadium.getText().toString());
        String capacity = this.capacity.getText().toString();
        String countPlayers = this.countPlayers.getText().toString();

        if (!capacity.equals(""))
            bundle.putInt("capacity", Integer.parseInt(capacity));

        if (!countPlayers.equals(""))
            bundle.putInt("players", Integer.parseInt(countPlayers));
        intent.putExtra("club", bundle);
    }
}