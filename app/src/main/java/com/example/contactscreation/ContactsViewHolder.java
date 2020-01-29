package com.example.contactscreation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsViewHolder extends RecyclerView.ViewHolder {

    TextView tvContactsFirstName;
    TextView tvContactsLastName;


    public ContactsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvContactsFirstName = itemView.findViewById(R.id.tv_item_first_name);
        tvContactsLastName = itemView.findViewById(R.id.tv_item_last_name);
    }

    public void onBind(final PojoContacts contact, final ShowAllDataInterface listener){
        tvContactsFirstName.setText(contact.getFirstName());
        tvContactsLastName.setText(contact.getLastName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.openDetailedView(contact);
            }
        });

        tvContactsLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.openFromLast(tvContactsLastName.getText().toString());
            }
        });
    }
}
