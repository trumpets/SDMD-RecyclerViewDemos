package com.citycollege.sdmd.recyclerviewdemos;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_OF_ITEMS_TO_GENERATE = 20;

    private Random rng = new Random();
    private int[] colors = new int[] {Color.RED, Color.GREEN, Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Item> items = generateSetOfItems(NUMBER_OF_ITEMS_TO_GENERATE);

        RecyclerView recyclerView = findViewById((R.id.rv_items));
        final ItemAdapter adapter = new ItemAdapter(this, items);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        findViewById(R.id.btn_remove_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (items.size() > 0) {
                    int indexOfItemToRemove = rng.nextInt(items.size());
                    items.remove(indexOfItemToRemove);
                    adapter.notifyItemRemoved(indexOfItemToRemove);
                }
            }
        });
    }

    private List<Item> generateSetOfItems(int itemsToGenerate) {
        List<Item> items = new ArrayList<>(itemsToGenerate);

        for (int i = 0; i < itemsToGenerate; i++) {
            String itemName = "Item " + (i + 1);
            int quantity = rng.nextInt(20);
            int color = colors[rng.nextInt(colors.length)];

            items.add(new Item(itemName, quantity, color));
        }

        return items;
    }
}
