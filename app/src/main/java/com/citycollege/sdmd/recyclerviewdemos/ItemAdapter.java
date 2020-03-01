package com.citycollege.sdmd.recyclerviewdemos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private List<Item> items;

    ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(this.context).inflate(R.layout.layout_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView quantityTextView;

        ItemViewHolder(View itemView) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.tv_name);
            this.quantityTextView = itemView.findViewById(R.id.tv_quantity);
        }

        void bind(final Item item) {
            nameTextView.setText(item.getName());
            nameTextView.setTextColor(item.getColor());
            quantityTextView.setText(String.valueOf(item.getQuantity()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "You just clicked " + item.getName() + " from RecyclerView", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
