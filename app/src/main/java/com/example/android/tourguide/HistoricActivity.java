package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);

        // Create a list of pois
        final ArrayList<PoI> pois = new ArrayList<PoI>();
        pois.add(new PoI(
                getString(R.string.his_pvirgen_name),
                getString(R.string.his_pvirgen_geo),
                getString(R.string.his_pvirgen_desc),
                R.drawable.his_pvirgen,
                getString(R.string.his_pvirgen_not),
                getString(R.string.his_pvirgen_url)));
        pois.add(new PoI(
                getString(R.string.his_tquart_name),
                getString(R.string.his_tquart_geo),
                getString(R.string.his_tquart_desc),
                R.drawable.his_tquart,
                getString(R.string.his_tquart_not),
                getString(R.string.his_tquart_url)));
        pois.add(new PoI(
                getString(R.string.his_tserranos_name),
                getString(R.string.his_tserranos_geo),
                getString(R.string.his_tserranos_desc),
                R.drawable.his_tserranos,
                getString(R.string.his_tserranos_not),
                getString(R.string.his_tserranos_url)));
        pois.add(new PoI(
                getString(R.string.his_lonja_name),
                getString(R.string.his_lonja_geo),
                getString(R.string.his_lonja_desc),
                R.drawable.his_lonja,
                getString(R.string.his_lonja_not),
                getString(R.string.his_lonja_url)));
        pois.add(new PoI(
                getString(R.string.his_mcentral_name),
                getString(R.string.his_mcentral_geo),
                getString(R.string.his_mcentral_desc),
                R.drawable.his_mcentral,
                getString(R.string.his_mcentral_not),
                getString(R.string.his_mcentral_url)));
        pois.add(new PoI(
                getString(R.string.his_predonda_name),
                getString(R.string.his_predonda_geo),
                getString(R.string.his_predonda_desc),
                R.drawable.his_predonda,
                getString(R.string.his_predonda_not),
                getString(R.string.his_predonda_url)));
        pois.add(new PoI(
                getString(R.string.his_micalet_name),
                getString(R.string.his_micalet_geo),
                getString(R.string.his_micalet_desc),
                R.drawable.his_micalet,
                getString(R.string.his_micalet_not),
                getString(R.string.his_micalet_url)));

        // Create an {@link PoIAdapter}, whose data source is a list of {@link PoIs}s. The
        // adapter knows how to create list items for each item in the list.
        PoIAdapter adapter = new PoIAdapter(this, pois, R.color.category_historic);

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

                Intent intent = new Intent(HistoricActivity.this, DetailActivity.class);

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
