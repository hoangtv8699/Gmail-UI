package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mail.adapters.mailItemAdapter;
import com.example.mail.models.mailItem;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<mailItem> items;
    String[] colors;
    Random generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        colors = new String[]{
                "#fff44336", "#ffe91e63", "#ff9c27b0", "#ff673ab7",
                "#ff3f51b5", "#ff2196f3", "#ff03a9f4", "#ff00bcd4",
                "#ff009688", "#ff4caf50", "#ff8bc34a", "#ffcddc39",
                "#ffffeb3b", "#ffffc107", "#ffff9800", "#ffff5722",
                "#ff795548", "#ff9e9e9e", "#ff607d8b", "#ff333333"
        };

        generator = new Random(1);
        Time time;
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            time = new Time(generator.nextInt(24), generator.nextInt(60), 4);
            items.add(new mailItem(faker.name.name(), faker.lorem.paragraph(), time, false, colors[generator.nextInt(colors.length - 1)]));
        }

        mailItemAdapter adapter = new mailItemAdapter(this, items);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}