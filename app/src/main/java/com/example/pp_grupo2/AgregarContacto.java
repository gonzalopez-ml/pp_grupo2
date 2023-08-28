package com.example.pp_grupo2;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarContacto extends AppCompatActivity {

    private Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        continuar = (Button) findViewById(R.id.btnContinuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar_contacto2(null);
            }
        });

    }

    public void agregar_contacto(View view) {
        Intent intent = new Intent(this, AgregarContacto.class);
        startActivity(intent);
    }

    public void contactos(View view) {
        Intent intent = new Intent(this, Contactos.class);
        startActivity(intent);
    }

    public void agregar_contacto2(View view) {
        Intent intent = new Intent(this, AgregarContacto2.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer id = menuItem.getItemId();

        if (id == R.id.agregarContactos) {
            agregar_contacto(null);
        }

        if (id == R.id.listarContactos) {
            contactos(null);
        }

        return super.onOptionsItemSelected(menuItem);
    }




}