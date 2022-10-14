package maxim.goy.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class UserDataActivity extends AppCompatActivity {
    EditText phone, email, socMedia;
    ImageView photo;
    Bundle bundle;
    private final int Pick_image = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        bundle = getIntent().getBundleExtra("club");

        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        photo = findViewById(R.id.imageView);
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, LoadSaveActivity.class);
        intent.putExtra("club", bundle);
        startActivity(intent);
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, TournamentActivity.class);
        intent.putExtra("club", bundle);
        startActivity(intent);
    }

    public void call(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent);
    }

    public void image(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, Pick_image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        try {
            final Uri imageUri = imageReturnedIntent.getData();
            final InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            photo.setImageBitmap(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}