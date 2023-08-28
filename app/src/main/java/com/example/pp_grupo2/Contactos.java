package com.example.pp_grupo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Contactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
    }

    public void agregar_contacto(View view) {
        Intent intent = new Intent(this, AgregarContacto.class);
        startActivity(intent);
    }

    public void contactos(View view) {
        Intent intent = new Intent(this, Contactos.class);
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