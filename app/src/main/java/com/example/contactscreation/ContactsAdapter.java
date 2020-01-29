package com.example.contactscreation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter
        extends RecyclerView.Adapter<ContactsViewHolder> {

    private List<PojoContacts> dataSet;

    public void setDataSet(List<PojoContacts> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                                                                parent,
                                                                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        holder.tvContactsFirstName.setText(dataSet.get(position).getFirstName());
        holder.tvContactsLastName.setText(dataSet.get(position).getLastName());

        List<SocialMedia> list = dataSet.get(position).getSocialMediaList();

        SocialMedia firstSocial = list.get(0);  // Pulling 1st element from list of Social medias
        holder.tvSocialMediaApp.setText(firstSocial.getSocialMediaApp());
        holder.tvSocialMediaUrl.setText(firstSocial.getUserUrl());
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
