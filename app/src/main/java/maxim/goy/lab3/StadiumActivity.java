package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StadiumActivity extends AppCompatActivity {
    TextView nameClub;

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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}