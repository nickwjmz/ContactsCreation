package com.example.contactscreation;

import android.os.Parcel;
import android.os.Parcelable;

class SocialMedia implements Parcelable {
    private String socialMediaApp;
    private String userUrl;

    // Empty constructor
    SocialMedia(){}

    // Constructor loaded with Parcel.
    protected SocialMedia(Parcel in) {
        socialMediaApp = in.readString();
        userUrl = in.readString();
    }

    public static final Creator<SocialMedia> CREATOR = new Creator<SocialMedia>() {
        @Override
        public SocialMedia createFromParcel(Parcel in) {
            return new SocialMedia(in);
        }

        @Override
        public SocialMedia[] newArray(int size) {
            return new SocialMedia[size];
        }
    };

    // Getters and Setters for the Social Media App and Specific URL.
    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getSocialMediaApp() {
        return socialMediaApp;
    }

    public void setSocialMediaApp(String socialMediaApp) {
        this.socialMediaApp = socialMediaApp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(socialMediaApp);
        dest.writeString(userUrl);
    }

}
