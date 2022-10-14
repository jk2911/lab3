package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserDataActivity extends AppCompatActivity {
    EditText phone, email;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        bundle = getIntent().getBundleExtra("club");

        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, LoadSaveActivity.class);
        intent.putExtra("club", bundle);
        startActivity(intent);
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, TournamentActivity.class);
        startActivity(intent);
    }

    public void call(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent);
    }


}