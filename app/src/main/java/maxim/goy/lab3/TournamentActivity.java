package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TournamentActivity extends AppCompatActivity implements SavedIntent {
    CheckBox championsLeague, laLiga, cupSpain, mls, bundesliga,
            cupGermany, premierLeague, europaLeague;
    ArrayList<String> tournament;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);
        bundle = getIntent().getBundleExtra("club");
        this.tournament = bundle.getStringArrayList("tournament");
        if (tournament == null) {
            tournament = new ArrayList<>();
            return;
        }

        championsLeague = findViewById(R.id.championsLeague);
        laLiga = findViewById(R.id.laLiga);
        cupSpain = findViewById(R.id.cupSpain);
        mls = findViewById(R.id.mls);
        bundesliga = findViewById(R.id.bundesliga);
        cupGermany = findViewById(R.id.cupGermany);
        premierLeague = findViewById(R.id.premierLeague);
        europaLeague = findViewById(R.id.europaLeague);

        CheckBox[] tournaments = {championsLeague, laLiga, cupSpain, mls,
                bundesliga, cupGermany, premierLeague, europaLeague};
        for (String string : tournament) {
            for (int i = 0; i < tournaments.length; i++) {
                if (string.equals(tournaments[i].getText().toString())) {
                    tournaments[i].setChecked(true);
                    i = tournaments.length;
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    public void nextPage(View v) {
        Intent intent = new Intent(this, LoadSaveActivity.class);
        saveInfoInIntent(intent);
        startActivity(intent);
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, StadiumActivity.class);
        saveInfoInIntent(intent);
        startActivity(intent);
    }

    public void onCheckBoxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked())
            tournament.add(checkBox.getText().toString());
        else
            tournament.remove(checkBox.getText().toString());
    }

    @Override
    public void saveInfoInIntent(Intent intent) {
        bundle.putStringArrayList("tournament", tournament);
        intent.putExtra("club", bundle);
    }
}