package br.com.digitalhouse.foodsdigitalhouse.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Options implements Parcelable {
    private String name;
    private String description;
    private int image;

    public Options() {
    }

    public Options(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    protected Options(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readInt();
    }

    public static final Creator<Options> CREATOR = new Creator<Options>() {
        @Override
        public Options createFromParcel(Parcel in) {
            return new Options(in);
        }

        @Override
        public Options[] newArray(int size) {
            return new Options[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(image);
    }
}