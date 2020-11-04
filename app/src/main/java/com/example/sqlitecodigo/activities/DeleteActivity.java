package com.example.sqlitecodigo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecodigo.Data;
import com.example.sqlitecodigo.R;

public class DeleteActivity extends AppCompatActivity {

    EditText idDelete;
    Button btndelete;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        idDelete = findViewById(R.id.delete);
        btndelete = findViewById(R.id.btndelete);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idDelete.getText().toString();
                data = new Data(getApplicationContext());
                data.deleteUser(id);
                Toast.makeText(DeleteActivity.this, "El Elemento se ha eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}