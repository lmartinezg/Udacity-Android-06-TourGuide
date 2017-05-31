package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MusseumsActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);

        // Create a list of pois
        final ArrayList<PoI> pois = new ArrayList<PoI>();

        pois.add(new PoI(
                getString(R.string.mus_muvim_name),
                getString(R.string.mus_muvim_geo),
                getString(R.string.mus_muvim_desc),
                R.drawable.mus_muvim,
                getString(R.string.mus_muvim_not),
                getString(R.string.mus_muvim_url)));
        pois.add(new PoI(
                getString(R.string.mus_patri_name),
                getString(R.string.mus_patri_geo),
                getString(R.string.mus_patri_desc),
                R.drawable.mus_patriarca,
                getString(R.string.mus_patri_not),
                getString(R.string.mus_patri_url)));
        pois.add(new PoI(
                getString(R.string.mus_ba_name),
                getString(R.string.mus_ba_geo),
                getString(R.string.mus_ba_desc),
                R.drawable.mus_ba,
                getString(R.string.mus_ba_not),
                getString(R.string.mus_ba_url)));
        pois.add(new PoI(
                getString(R.string.mus_prehis_name),
                getString(R.string.mus_prehis_geo),
                getString(R.string.mus_prehis_desc),
                R.drawable.mus_prehis,
                getString(R.string.mus_prehis_not),
                getString(R.string.mus_prehis_url)));
        pois.add(new PoI(
                getString(R.string.mus_ivam_name),
                getString(R.string.mus_ivam_geo),
                getString(R.string.mus_ivam_desc),
                R.drawable.mus_ivam,
                getString(R.string.mus_ivam_not),
                getString(R.string.mus_ivam_url)));
        pois.add(new PoI(
                getString(R.string.mus_mhv_name),
                getString(R.string.mus_mhv_geo),
                getString(R.string.mus_mhv_desc),
                R.drawable.mus_mhv,
                getString(R.string.mus_mhv_not),
                getString(R.string.mus_mhv_url)));
        pois.add(new PoI(
                getString(R.string.mus_carme_name),
                getString(R.string.mus_carme_geo),
                getString(R.string.mus_carme_desc),
                R.drawable.mus_carme,
                getString(R.string.mus_carme_not),
                getString(R.string.mus_carme_url)));

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

                Intent intent = new Intent(MusseumsActivity.this, DetailActivity.class);

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
