package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);

        // Create a list of pois
        final ArrayList<PoI> pois = new ArrayList<PoI>();

        pois.add(new PoI(
                getString(R.string.parks_bioparc_name),
                getString(R.string.parks_bioparc_geo),
                getString(R.string.parks_bioparc_desc),
                R.drawable.parks_bioparc,
                getString(R.string.parks_bioparc_desc),
                getString(R.string.parks_bioparc_url)));
        pois.add(new PoI(
                getString(R.string.parks_hemisferic_name),
                getString(R.string.parks_hemisferic_geo),
                getString(R.string.parks_hemisferic_desc),
                R.drawable.parks_hemisferic,
                getString(R.string.parks_hemisferic_not),
                getString(R.string.parks_hemisferic_url)));
        pois.add(new PoI(
                getString(R.string.parks_museu_name),
                getString(R.string.parks_museu_geo),
                getString(R.string.parks_museu_desc),
                R.drawable.parks_museu,
                getString(R.string.parks_museu_not),
                getString(R.string.parks_museu_url)));
        pois.add(new PoI(
                getString(R.string.parks_oceanografic_name),
                getString(R.string.parks_oceanografic_geo),
                getString(R.string.parks_oceanografic_desc),
                R.drawable.parks_oceanografic,
                getString(R.string.parks_oceanografic_not),
                getString(R.string.parks_oceanografic_url)));
        pois.add(new PoI(
                getString(R.string.parks_gulliver_name),
                getString(R.string.parks_gulliver_geo),
                getString(R.string.parks_gulliver_desc),
                R.drawable.parks_gulliver,
                getString(R.string.parks_gulliver_not),
                getString(R.string.parks_gulliver_url)));
        pois.add(new PoI(
                getString(R.string.parks_viveros_name),
                getString(R.string.parks_viveros_geo),
                getString(R.string.parks_viveros_desc),
                R.drawable.parks_viveros,
                getString(R.string.parks_viveros_not),
                getString(R.string.parks_viveros_url)));
        pois.add(new PoI(
                getString(R.string.parks_monforte_name),
                getString(R.string.parks_monforte_geo),
                getString(R.string.parks_monforte_desc),
                R.drawable.parks_monforte,
                getString(R.string.parks_monforte_not),
                getString(R.string.parks_monforte_url)));
        pois.add(new PoI(
                getString(R.string.parks_turia_name),
                getString(R.string.parks_turia_geo),
                getString(R.string.parks_turia_desc),
                R.drawable.parks_turia,
                getString(R.string.parks_turia_not),
                getString(R.string.parks_turia_url)));
        pois.add(new PoI(
                getString(R.string.parks_malvarrosa_name),
                getString(R.string.parks_malvarrosa_geo),
                getString(R.string.parks_malvarrosa_desc),
                R.drawable.parks_malvarrosa,
                getString(R.string.parks_malvarrosa_not),
                getString(R.string.parks_malvarrosa_url)));
        pois.add(new PoI(
                getString(R.string.parks_albufera_name),
                getString(R.string.parks_albufera_geo),
                getString(R.string.parks_albufera_desc),
                R.drawable.parks_albufera,
                getString(R.string.parks_albufera_not),
                getString(R.string.parks_albufera_url)));
        pois.add(new PoI(
                getString(R.string.parks_palmar_name),
                getString(R.string.parks_palmar_geo),
                getString(R.string.parks_palmar_desc),
                R.drawable.parks_palmar,
                getString(R.string.parks_palmar_not),
                getString(R.string.parks_palmar_url)));


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

                Intent intent = new Intent(ParksActivity.this, DetailActivity.class);

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
