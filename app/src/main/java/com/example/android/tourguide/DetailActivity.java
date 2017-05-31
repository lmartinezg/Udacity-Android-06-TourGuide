package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.tourguide.R.id.imageView;

public class DetailActivity extends AppCompatActivity {

    static private final int MAP_INTENT_TYPE_MAPSAPP = 1;
    static private final int MAP_INTENT_TYPE_FRAGMENT = 2;
    static private final int MAP_INTENT_TYPE = MAP_INTENT_TYPE_FRAGMENT;

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();

        final PoI currentPoI = new PoI(
                b.getString("name"),
                b.getString("geo"),
                b.getString("desc"),
                b.getInt("imageId"),
                b.getString("notice"),
                b.getString("url")
        );

        // Find views
        TextView nameTextView = (TextView) findViewById(R.id.name_textView);
        TextView descTextView = (TextView) findViewById(R.id.desc_textView);
        ImageView imgImageView = (ImageView) findViewById(imageView);
        TextView noticeTextView = (TextView) findViewById(R.id.notice_textView);
        TextView urlTextView = (TextView) findViewById(R.id.url_textview);
        TextView geoTextView = (TextView) findViewById(R.id.geo_textview);

        final String geoString = currentPoI.getGeo();
        final String urlString = currentPoI.getUrl();
        final String nameString = currentPoI.getName();
        final String descriptionString = currentPoI.getDescription();
        final String noticeString = currentPoI.getmImageNotice();

        // Set data for this POI in the correspoding views
        nameTextView.setText(nameString);
        descTextView.setText(descriptionString);
        urlTextView.setText(urlString);
        geoTextView.setText(geoString);
        noticeTextView.setText(noticeString);

        // Hide geo View if no geo data
        if (geoString.equals("")) {
            geoTextView.setVisibility(View.GONE);
        }

        // Hide URL View if no URL
        if (urlString.equals("")) {
            urlTextView.setVisibility(View.GONE);
        }

        // Get the Image Resource Id  from the current PoI object and
        // set this image on the Image ImageView if provided
        imgImageView.setVisibility(View.VISIBLE);
        noticeTextView.setVisibility(View.VISIBLE);
        if (currentPoI.hasImage()) {
            imgImageView.setImageResource(currentPoI.getImageResourceId());
        } else {
            imgImageView.setVisibility(View.GONE);
            noticeTextView.setVisibility(View.GONE);
        }

        // Hide notice View if no data
        if (noticeString == null) {
            noticeTextView.setVisibility(View.GONE);
        } else if (noticeString.equals("")) {
            noticeTextView.setVisibility(View.GONE);
        }

        // Set a click listener to view a map
        geoTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the geo View is clicked on.
            @Override
            public void onClick(View view) {
                if ((geoString.equals(""))) {
                    Toast.makeText(getApplicationContext(), R.string.noGeoData, Toast.LENGTH_SHORT).show();
                } else {

                    switch (MAP_INTENT_TYPE) {

                        case MAP_INTENT_TYPE_MAPSAPP:
                            // Kept here for future reference
                            String uriString_v1 = "geo:0,0?q=loc:" + geoString + "(" + Uri.encode(currentPoI.getName() + ")");
                            String uriString_v2 = "geo:" + geoString;
                            String uriString = uriString_v2;

                            Uri gmmIntentUri = Uri.parse(uriString);
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                                startActivity(mapIntent);
                            } else {
                                Toast.makeText(getApplicationContext(), R.string.noMapsApp, Toast.LENGTH_SHORT).show();
                            }
                            break;

                        case MAP_INTENT_TYPE_FRAGMENT:
                            Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                            Bundle b = new Bundle();
                            b.putString("name", nameString);
                            b.putString("geo", geoString);
                            intent.putExtras(b);
                            startActivity(intent);
                            break;
                    }
                }
            }
        });

        // Set a click listener to view a web site
        urlTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the geo View is clicked on.
            @Override
            public void onClick(View view) {
                if ((urlString.equals(""))) {
                    Toast.makeText(getApplicationContext(), R.string.noWebPage, Toast.LENGTH_SHORT).show();
                } else {
                    String uriString = urlString;
                    if (!uriString.startsWith("http://") && !uriString.startsWith("https://")) {
                        uriString = "http://" + uriString;
                    }
                    Uri intentUri = Uri.parse(uriString);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, intentUri);
                    startActivity(browserIntent);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
