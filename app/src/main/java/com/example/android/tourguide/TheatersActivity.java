package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TheatersActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);

        // Create a list of pois
        final ArrayList<PoI> pois = new ArrayList<PoI>();

        pois.add(new PoI(
                getString(R.string.theaters_arts_name),
                getString(R.string.theaters_arts_geo),
                getString(R.string.theaters_arts_desc),
                R.drawable.theaters_arts,
                getString(R.string.theaters_arts_not),
                getString(R.string.theaters_arts_url)));
        pois.add(new PoI(
                getString(R.string.theaters_palau_name),
                getString(R.string.theaters_palau_geo),
                getString(R.string.theaters_palau_desc),
                R.drawable.theaters_musica,
                getString(R.string.theaters_palau_not),
                getString(R.string.theaters_palau_url)));
        pois.add(new PoI(
                getString(R.string.theaters_principal_name),
                getString(R.string.theaters_principal_geo),
                getString(R.string.theaters_principal_desc),
                R.drawable.theaters_principal,
                getString(R.string.theaters_principal_not),
                getString(R.string.theaters_principal_url)));
        pois.add(new PoI(
                getString(R.string.theaters_olympia_name),
                getString(R.string.theaters_olympia_geo),
                getString(R.string.theaters_olympia_desc),
                R.drawable.theaters_olympia,
                getString(R.string.theater_olympia_not),
                getString(R.string.theaters_olympia_url)));
        pois.add(new PoI(
                getString(R.string.theaters_talia_name),
                getString(R.string.theaters_talia_geo),
                getString(R.string.theaters_talia_desc),
                R.drawable.theaters_talia,
                getString(R.string.theaters_talia_not),
                getString(R.string.theaters_talia_url)));
        pois.add(new PoI(
                getString(R.string.theaters_micalet_name),
                getString(R.string.theaters_micalet_geo),
                getString(R.string.theaters_micalet_desc),
                R.drawable.theaters_micalet,
                getString(R.string.theaters_micalet_not),
                getString(R.string.theaters_micalet_url)));

        // Create an {@link PoIAdapter}, whose data source is a list of {@link PoIs}s. The
        // adapter knows how to create list items for each item in the list.
        PoIAdapter adapter = new PoIAdapter(this, pois, R.color.category_museums);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // poi_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PoIAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link PoI} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to show the detail view when the user clicks on this item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link PoI} object at the given position the user clicked on
                PoI poi = pois.get(position);

                Intent intent = new Intent(TheatersActivity.this, DetailActivity.class);

                Bundle b = new Bundle();
                b.putString("name", poi.getName());
                b.putString("desc", poi.getDescription());
                b.putString("geo", poi.getGeo());
                b.putString("url", poi.getUrl());
                b.putInt("imageId", poi.getImageResourceId());
                b.putString("notice", poi.getmImageNotice());

                intent.putExtras(b);

                startActivity(intent);
            }
        });

    }

}
