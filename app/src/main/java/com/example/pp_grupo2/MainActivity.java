package com.example.pp_grupo2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public void agregar_contacto(View view) {
        Intent intent = new Intent(this, AgregarContacto.class);
        startActivity(intent);
    }

    public void contactos(View view) {
        Intent intent = new Intent(this, Contactos.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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