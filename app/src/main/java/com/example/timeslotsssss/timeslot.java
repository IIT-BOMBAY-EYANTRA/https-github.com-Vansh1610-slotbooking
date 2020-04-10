package com.example.timeslotsssss;

import android.os.Parcel;
import android.os.Parcelable;

public class timeslot implements Parcelable {
    private String Slot;

    public timeslot() {
    }

    public timeslot(String slot) {
        Slot = slot;
    }

    protected timeslot(Parcel in) {
        Slot = in.readString();
    }

    public static final Creator<timeslot> CREATOR = new Creator<timeslot>() {
        @Override
        public timeslot createFromParcel(Parcel in) {
            return new timeslot(in);
        }

        @Override
        public timeslot[] newArray(int size) {
            return new timeslot[size];
        }
    };

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String slot) {
        Slot = slot;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Slot);
    }
}
