package maxim.goy.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class StadiumActivity extends AppCompatActivity {
    TextView nameClub;
    String path = "club.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);
        nameClub = findViewById(R.id.nameClub);

        Intent intent = getIntent();
        String str = intent.getStringExtra("nameClub");
        nameClub.setText(str);
    }

    public void backPage(View v) {
        Gson gson = new Gson();
        ArrayList<String> toor = new ArrayList<>();
        toor.add("Champions League");
        toor.add("La Liga");
        String club = gson.toJson(new Club("Barcelona", "Barcelona", new GregorianCalendar(),
                "Xavi", 99000, "CampNou", 23, toor));
        try {
            FileOutputStream fileOutputStream = openFileOutput(path, MODE_PRIVATE);
            Log.d("StadiumActivity","start");
            fileOutputStream.write(club.getBytes());
            Log.d("StadiumActivity","stop");
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, TournamentActivity.class);
        startActivity(intent);
    }
    public void nextPage(View v){

        Intent intent = new Intent(this, TournamentActivity.class);
        startActivity(intent);
    }
}