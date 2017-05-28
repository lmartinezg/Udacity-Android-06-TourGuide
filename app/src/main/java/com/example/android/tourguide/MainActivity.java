package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the historic category
        TextView historic = (TextView) findViewById(R.id.historic);

        // Set a click listener on that View
        historic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the {@link HistoricActivity}
                Intent intent = new Intent(MainActivity.this, HistoricActivity.class);
                startActivity(intent);
            }
        });

        // Find the View that shows the musseums category
        TextView musseums = (TextView) findViewById(R.id.museums);

        // Set a click listener on that View
        musseums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the {@link MusseumsActivity}
                Intent intent = new Intent(MainActivity.this, MusseumsActivity.class);
                startActivity(intent);
            }
        });

        // Find the View that shows the parks category
        TextView parks = (TextView) findViewById(R.id.parks);

        // Set a click listener on that View
        parks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the {@link ParksActivity}
                Intent intent = new Intent(MainActivity.this, ParksActivity.class);
                startActivity(intent);
            }
        });

        // Find the View that shows the theaters category
        TextView theaters = (TextView) findViewById(R.id.theaters);

        // Set a click listener on that View
        theaters.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the {@phrases TheatersActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, TheatersActivity.class);
                startActivity(phrasesIntent);
            }
        });

        // Find the View that shows the transport category
        TextView transport = (TextView) findViewById(R.id.transport);

        // Set a click listener on that View
        transport.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new Intent to open the {@link HistoricActivity}
                Intent intent = new Intent(MainActivity.this, TransportActivity.class);
                startActivity(intent);
            }
        });

    }
}
