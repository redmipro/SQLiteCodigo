package com.example.sqlitecodigo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecodigo.Data;
import com.example.sqlitecodigo.POJOs.Usuario;
import com.example.sqlitecodigo.R;

public class InsertActivity extends AppCompatActivity {

    EditText id, nombre, edad, correo;
    Button insert;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);
        insert = findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario(id.getText().toString(), nombre.getText().toString(), Integer.valueOf(edad.getText().toString()), correo.getText().toString());

                data = new Data(getApplicationContext());
                data.open();
                data.insertUsuario(usuario);
                Toast.makeText(InsertActivity.this, "Se agrego el usuario correctamente", Toast.LENGTH_LONG).show();
                data.close();

            }
        });


    }
}