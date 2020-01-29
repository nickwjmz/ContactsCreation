package com.example.contactscreation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsViewHolder
        extends RecyclerView.ViewHolder {
    TextView tvContactsFirstName;
    TextView tvContactsLastName;
    TextView tvSocialMediaApp;
    TextView tvSocialMediaUrl;

    public ContactsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvContactsFirstName = itemView.findViewById(R.id.tv_item_first_name);
        tvContactsLastName = itemView.findViewById(R.id.tv_item_last_name);
        tvSocialMediaApp = itemView.findViewById(R.id.tv_item_social_media_app);
        tvSocialMediaUrl = itemView.findViewById(R.id.tv_item_social_media_url);
    }

}
