package com.example.android.movieassignment;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Moni on 01-03-2016.
 */
public class MovieTO implements Parcelable {

    private int id;
    private String title; // original_title
    private String image; // poster_path
    private String image2; // backdrop_path
    private String overview;
    private int rating; // vote_average
    private String date; // release_date

    public MovieTO() {

    }

    public MovieTO(JSONObject MovieTO) throws JSONException {
        this.id = MovieTO.getInt("id");
        this.title = MovieTO.getString("original_title");
        this.image = MovieTO.getString("poster_path");
        this.image2 = MovieTO.getString("backdrop_path");
        this.overview = MovieTO.getString("overview");
        this.rating = MovieTO.getInt("vote_average");
        this.date = MovieTO.getString("release_date");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImage2() {
        return image2;
    }

    public String getOverview() {
        return overview;
    }

    public int getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(image2);
        dest.writeString(overview);
        dest.writeInt(rating);
        dest.writeString(date);
    }

    public static final Parcelable.Creator<MovieTO> CREATOR
            = new Parcelable.Creator<MovieTO>() {
        public MovieTO createFromParcel(Parcel in) {
            return new MovieTO(in);
        }

        public MovieTO[] newArray(int size) {
            return new MovieTO[size];
        }
    };

    private MovieTO(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        image2 = in.readString();
        overview = in.readString();
        rating = in.readInt();
        date = in.readString();
    }
}
