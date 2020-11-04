package com.example.sqlitecodigo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlitecodigo.Data;
import com.example.sqlitecodigo.POJOs.Usuario;
import com.example.sqlitecodigo.R;

public class ReadActivity extends AppCompatActivity {

    EditText id;
    Button read;
    Data data;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        usuario = new Usuario();

        id = findViewById(R.id.id);
        read. findViewById(R.id.btnread);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idRead = id.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                usuario = data.readUsuario(idRead);
                Log.e("RESULTADO: " , usuario.getNombre());
                data.close();

            }
        });
    }
}