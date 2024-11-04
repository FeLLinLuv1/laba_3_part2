package com.example.laba_3_part2;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import Data.DatabaseHandler;
import Model.Classmates;

public class ViewDataActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setContentView(R.layout.activity_view_data);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        databaseHandler = new DatabaseHandler(this);
        tvData = findViewById(R.id.tv_data);

        displayData();
    }

    private void displayData() {
        List<Classmates> classmatesList = databaseHandler.getAllClas();
        StringBuilder data = new StringBuilder();

        for (Classmates classmates : classmatesList) {
            data.append("ID: ").append(classmates.getId())
                    .append(", Фамилия: ").append(classmates.getF())
                    .append(", Имя: ").append(classmates.getI())
                    .append(", Отчество: ").append(classmates.getO())
                    .append(", Время: ").append(classmates.getTime())
                    .append("\n");
        }
        tvData.setText(data.toString());
    }
}

