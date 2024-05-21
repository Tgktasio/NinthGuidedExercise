package com.example.ninthguidedexercise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView nameListView;
    private ArrayAdapter<String> nameAdapter;
    private String[] listOfNames = {"Papsi", "Majoy", "Pol", "Che", "Tin", "Lou", "Renz", "Pel", "Roven", "Chan", "Jher"};
    private double[] listOfSemGrades = {1.00, 1.50, 2.00, 1.25, 3.00, 5.00, 1.75, 2.25, 3.00, 1.00, 2.25};
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameListView = findViewById(R.id.listView);
        nameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfNames);
        nameListView.setAdapter(nameAdapter);

        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = listOfNames[position];
                double selectedSemGrade = listOfSemGrades[position];
                String message = "Name : " + selectedName + "\nSem Grade : " + selectedSemGrade;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView emptyTextView = findViewById(R.id.emptyTextView);
        nameListView.setEmptyView(emptyTextView);
    }
}
