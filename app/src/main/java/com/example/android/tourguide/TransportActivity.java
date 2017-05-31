package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TransportActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);

        // Create a list of pois
        final ArrayList<PoI> pois = new ArrayList<PoI>();

        pois.add(new PoI(
                getString(R.string.transport_puerto_name),
                getString(R.string.transport_puerto_geo),
                getString(R.string.transport_puerto_desc),
                PoI.NO_IMAGE_PROVIDED,
                getString(R.string.transport_puerto_not),
                getString(R.string.transport_puerto_url)));
        pois.add(new PoI(
                getString(R.string.transport_est_nord_name),
                getString(R.string.transport_est_nord_geo),
                getString(R.string.transport_est_nord_desc),
                R.drawable.transport_est_norte,
                getString(R.string.transport_est_nord_not),
                getString(R.string.transport_est_nord_url)));
        pois.add(new PoI(
                getString(R.string.transport_est_cabanyal_name),
                getString(R.string.transport_est_cabanyal_geo),
                getString(R.string.transport_est_cabanyal_desc),
                R.drawable.transport_est_cabanyal,
                getString(R.string.transport_est_cabanyal_not),
                getString(R.string.transport_est_cabanyal_url)));
        pois.add(new PoI(
                getString(R.string.transport_manises_name),
                getString(R.string.transport_manises_geo),
                getString(R.string.transport_manises_desc),
                R.drawable.transport_manises,
                getString(R.string.transport_manises_not),
                getString(R.string.transport_manises_url)));
        pois.add(new PoI(
                getString(R.string.transport_est_bus_name),
                getString(R.string.transport_est_bus_geo),
                getString(R.string.transport_est_bus_desc),
                PoI.NO_IMAGE_PROVIDED,
                getString(R.string.transport_est_bus_not),
                getString(R.string.transport_est_bus_url)));
        pois.add(new PoI(
                getString(R.string.transport_emt_name),
                getString(R.string.transport_emt_geo),
                getString(R.string.transport_emt_desc),
                R.drawable.transport_emt,
                getString(R.string.transport_emt_not),
                getString(R.string.transport_emt_url)));
        pois.add(new PoI(
                getString(R.string.transport_metro_name),
                getString(R.string.transport_metro_geo),
                getString(R.string.transport_metro_desc),
                R.drawable.transport_metro,
                getString(R.string.transport_metro_not),
                getString(R.string.transport_metro_url)));
        pois.add(new PoI(
                getString(R.string.transport_metrobus_name),
                getString(R.string.transport_metrobus_geo),
                getString(R.string.transport_metrobus_desc),
                R.drawable.transport_metrobus,
                getString(R.string.transport_metrobus_not),
                getString(R.string.transport_metrobus_url)));

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

                Intent intent = new Intent(TransportActivity.this, DetailActivity.class);

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
