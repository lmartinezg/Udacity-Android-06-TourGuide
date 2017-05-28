package com.example.android.tourguide;

/**
 * {@link PoI represents a Point of Interest.
 * It contains a name, its geo coordinates, a description, an optional image and an optimal URL
 */

class PoI {

    protected static final int NO_IMAGE_PROVIDED = -1;

    private String mName = null;
    private String mGeo = null;
    private String mDescription = null;

    // Optional data
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private String mImageNotice = null;
    private String mUrl = null;

    /**
     * Create a new Point of Interest
     *
     * @param mName            Name
     * @param mGeo             Geo coordinates for Maps
     * @param mDescription     Description for the Point of Interest
     * @param mImageResourceId Optional Image resource ID.
     * @param mImageNotice     Copyright notice for images, if applicable
     * @param mUrl             Optional URL for the POI web site
     */
    public PoI(String mName, String mGeo, String mDescription, int mImageResourceId, String mImageNotice, String mUrl) {
        this.mName = mName;
        this.mGeo = mGeo;
        this.mDescription = mDescription;
        this.mImageResourceId = mImageResourceId;
        this.mImageNotice = mImageNotice;
        this.mUrl = mUrl;
    }

    public String getName() {
        return mName;
    }

    public String getGeo() {
        return mGeo;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getUrl() {
        return mUrl;
    }

    public boolean hasImage() {
        return (this.mImageResourceId != NO_IMAGE_PROVIDED);
    }

    public String getmImageNotice() {
        return mImageNotice;
    }

    @Override
    public String toString() {
        return "PoI{" +
                "mName='" + mName + '\'' +
                ", mGeo='" + mGeo + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mImageNotice='" + mImageNotice + '\'' +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}
