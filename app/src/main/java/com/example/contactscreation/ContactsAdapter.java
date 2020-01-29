package com.example.contactscreation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private List<PojoContacts> dataSet;
    private ShowAllDataInterface listener;

    public void setDataSet(List<PojoContacts> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void setListener(ShowAllDataInterface listener) {
        this.listener = listener;
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
        holder.onBind(dataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
