package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class TournamentActivity extends AppCompatActivity {
    CheckBox championsLeague, laLiga, cupSpain, mls, bundesliga, cupGermany, premierLeague;
    String tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        championsLeague = findViewById(R.id.championsLeague);
        laLiga = findViewById(R.id.laLiga);
        cupSpain = findViewById(R.id.cupSpain);
        mls = findViewById(R.id.mls);
        bundesliga = findViewById(R.id.bundesliga);
        cupGermany = findViewById(R.id.cupSpain);
        premierLeague = findViewById(R.id.premierLeague);

        tournament = new String();

    }


    public void nextPage(View v) {
        Intent intent=new Intent(this,LoadSaveActivity.class);
        startActivity(intent);
    }

    public void backPage(View v) {

    }

    public void onCheckBoxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked())
            tournament += checkBox.getText() + " ";
        else
            tournament = tournament.replaceAll(checkBox.getText() + " ", "");
    }
}