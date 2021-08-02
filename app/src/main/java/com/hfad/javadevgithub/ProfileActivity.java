package com.hfad.javadevgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView profileImageView = findViewById(R.id.profileImageView);
        TextView userNameTextView = findViewById(R.id.usernameTextView);
        ImageButton shareProfile = findViewById(R.id.shareProfile);
        TextView developerUrl = findViewById(R.id.developerUrl);

        Intent intent = getIntent();
        final String userName = intent.getStringExtra(DevelopersAdapter.KEY_NAME);
        final String profileUrl = intent.getStringExtra(DevelopersAdapter.KEY_URL);
        String image = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);

        userNameTextView.setText(userName);
        developerUrl.setText(profileUrl);


        Picasso.with(this).load(image).into(profileImageView);

        developerUrl.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(profileUrl));
                startActivity(i);
            }
        });

        shareProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer " + userName + ", " + profileUrl);
                Intent chooser = Intent.createChooser(shareIntent, "Share Via");
                if (shareIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser);
                }
            }
        });
    }
}