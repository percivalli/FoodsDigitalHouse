package br.com.digitalhouse.foodsdigitalhouse.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Place implements Parcelable {

    private String name;
    private String address;
    private String open;
    private String close;
    private int image;
    private List<Options> optionsList;

    public Place() {
    }

    public Place(String name, String address, String open, String close, int image, List<Options> dishList) {
        this.name = name;
        this.address = address;
        this.open = open;
        this.close = close;
        this.image = image;
        this.optionsList = dishList;
    }

    protected Place(Parcel in) {
        name = in.readString();
        address = in.readString();
        open = in.readString();
        close = in.readString();
        image = in.readInt();
        optionsList = in.createTypedArrayList(Options.CREATOR);
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Options> getDishList() {
        return optionsList;
    }

    public void setDishList(List<Options> dishList) {
        this.optionsList = dishList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(open);
        dest.writeString(close);
        dest.writeInt(image);
        dest.writeTypedList(optionsList);
    }
}
