package com.example.homework_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView tgButton = findViewById(R.id.tg_link);
        tgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://t.me/shirokoff"));
                startActivity(i);
            }
        });

        ImageView vkButton = findViewById(R.id.vk_link);
        vkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://vk.com/tswrim"));
                startActivity(i);
            }
        });

        ImageView ymButton = findViewById(R.id.ym_link);
        ymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://music.yandex.ru/album/4691345"));
                startActivity(i);
            }
        });

        TextView sendMessage = findViewById(R.id.send);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText message = findViewById(R.id.editText);
                Intent sendMailIntent = new Intent(Intent.ACTION_SENDTO);
                sendMailIntent.setData(Uri.parse("mailto: hasturdrums@gmail.com")); // only email apps should handle this
                String subject = "Wazzup!";
                sendMailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                sendMailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                if (sendMailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendMailIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Email app found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }





   /* public void onClick(View v) {
        EditText message = findViewById(R.id.editText);
        Intent sendMailIntent = new Intent(Intent.ACTION_SENDTO);
        sendMailIntent.setData(Uri.parse("mailto: hasturdrums@gmail.com")); // only email apps should handle this
        String subject = "Wazzup!";
        sendMailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendMailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
        if (sendMailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendMailIntent);
        }
        else {
            Toast.makeText(getApplicationContext(), "No Email app found", Toast.LENGTH_LONG).show();
        }
    }*/
}

