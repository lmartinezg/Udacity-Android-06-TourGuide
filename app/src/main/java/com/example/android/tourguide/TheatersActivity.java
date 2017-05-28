package com.example.android.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class TheatersActivity extends AppCompatActivity {

    private static final String LOG_TAG = PoIAdapter.class.getSimpleName();

    Uri gmmIntentUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);

        // Create a list of words
        final ArrayList<PoI> pois = new ArrayList<PoI>();

        pois.add(new PoI(
                "Museu del Patriarca",
                "39.4712413,-0.3791624,1630",
                "Museu del Patriarca",
                PoI.NO_IMAGE_PROVIDED,
                null,
                "http://patriarcavalencia.es"));
        pois.add(new PoI(
                "Museu del Patriarca",
                "39.4712413,-0.3791624,1630",
                "Museu del Patriarca",
                PoI.NO_IMAGE_PROVIDED,
                null,
                "http://patriarcavalencia.es"));
        pois.add(new PoI(
                "Museu del Patriarca",
                "39.4712413,-0.3791624,1630",
                "Museu del Patriarca",
                PoI.NO_IMAGE_PROVIDED,
                null,
                "http://patriarcavalencia.es"));
        pois.add(new PoI(
                "Museu del Patriarca",
                "39.4712413,-0.3791624,1630",
                "Museu del Patriarca",
                PoI.NO_IMAGE_PROVIDED,
                null,
                "http://patriarcavalencia.es"));

        // Create an {@link PoIAdapter}, whose data source is a list of {@link PoIs}s. The
        // adapter knows how to create list items for each item in the list.
        PoIAdapter adapter = new PoIAdapter(this, pois, R.color.category_theaters);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to show the map whe the user clicks on this item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link PoI} object at the given position the user clicked on
                PoI poi = pois.get(position);

                Log.v(LOG_TAG, "Current POI: " + poi);

                Intent intent = new Intent(TheatersActivity.this, DetailActivity.class);

                Bundle b = new Bundle();
                b.putString("name", poi.getName());
                b.putString("desc", poi.getDescription());
                b.putString("geo", poi.getGeo());
                b.putString("url", poi.getUrl());
                b.putInt("imageId", poi.getImageResourceId());

                startActivity(intent);
            }
        });

    }

}
