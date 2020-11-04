package com.example.sqlitecodigo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecodigo.Data;
import com.example.sqlitecodigo.POJOs.Usuario;
import com.example.sqlitecodigo.R;
import com.example.sqlitecodigo.SQLConstants;

public class UpdateActivity extends AppCompatActivity {

    EditText idUpdate,nombre,edad,correo;
    Button search,Update;
    Data data;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        idUpdate = findViewById(R.id.idUpdate);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);

        search = findViewById(R.id.btnsearch);
        Update = findViewById(R.id.btnupdate);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                String idRead = idUpdate.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                usuario = data.readUsuario(idRead);

                nombre.setText(usuario.getNombre());
                edad.setText(String.valueOf(usuario.getEdad()));
                correo.setText(usuario.getCorreo());
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idUpdate.getText().toString();
                ContentValues contentValues = new ContentValues(4);
                contentValues.put(SQLConstants.COLUMN_NOMBRE, nombre.getText().toString());
                contentValues.put(SQLConstants.COLUMN_EDAD, Integer.valueOf(edad.getText().toString()));
                contentValues.put(SQLConstants.COLUMN_CORREO, correo.getText().toString());

                data.updateUser(id, contentValues );
                Toast.makeText(UpdateActivity.this, "usuario actualizado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}