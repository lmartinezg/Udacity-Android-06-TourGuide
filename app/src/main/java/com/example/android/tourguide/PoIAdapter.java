package com.example.android.tourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.tourguide.R.id.desc_text_View;

class PoIAdapter extends ArrayAdapter<PoI> {

    private static final String LOG_TAG = PoIAdapter.class.getSimpleName();

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context         The current context. Used to inflate the layout file.
     * @param pois            A List of Word objects to display in a list
     * @param colorResourceId Background color for the list_item View
     */
    PoIAdapter(Activity context, ArrayList<PoI> pois, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews [and an ImageView], the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, pois);
        this.mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the {@link PoI} object located at this position in the list
        final PoI currentPoI = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the TextView in the list_item.xml layout with the ID desc_text_View
        TextView descTextView = (TextView) listItemView.findViewById(desc_text_View);

        // Get the description from the current PoI object and
        // set this text on the description TextView
        descTextView.setText(currentPoI.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the Image Resource Id  from the current PoI object and
        // set this image on the Image ImageView
        if (currentPoI.hasImage()) {
            imageView.setImageResource(currentPoI.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Retrieve the color corresponding to the color resource ID
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        descTextView.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
