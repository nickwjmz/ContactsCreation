package com.example.contactscreation;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PojoContacts implements Parcelable {

    private String firstName;
    private String lastName;
    private List<SocialMedia> socialMediaList;

    // Empty PojoContacts constructor.
    PojoContacts(){}

    // Constructor loaded with Parcel.
    protected PojoContacts(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        socialMediaList = in.readArrayList(SocialMedia.class.getClassLoader());
    }

    public static final Creator<PojoContacts> CREATOR = new Creator<PojoContacts>() {

        @Override
        public PojoContacts createFromParcel(Parcel in) {
            return new PojoContacts(in);
        }

        @Override
        public PojoContacts[] newArray(int size) {
            return new PojoContacts[size];
        }
    };

    @Override
    public String toString() {

        return "PojoContacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialMediaList=" + socialMediaList +
                '}';
    }

    // Getters and Setters for the First and Last Name.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SocialMedia> getSocialMediaList() {
        return socialMediaList;
    }

    public void setSocialMediaList(List<SocialMedia> socialMediaList) {
        this.socialMediaList = socialMediaList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(firstName);
        dest.writeString(lastName);
        // todo read from the list (Social Media)
        dest.writeList(socialMediaList);
    }
}
