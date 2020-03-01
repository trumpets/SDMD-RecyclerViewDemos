package com.citycollege.sdmd.recyclerviewdemos;

import android.graphics.Color;
import android.os.Bundle;

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

        RecyclerView recyclerView = findViewById((R.id.rv_items));
        recyclerView.setAdapter(new ItemAdapter(this, generateSetOfItems(NUMBER_OF_ITEMS_TO_GENERATE)));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
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
