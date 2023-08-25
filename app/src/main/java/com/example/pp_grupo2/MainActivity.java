package com.example.pp_grupo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void agregar_contacto(View view) {
        Intent intent = new Intent(this, AgregarContacto.class);
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
    public boolean onOptionsItemSelected(MenuItem agregarContactoOption) {
        Integer id = agregarContactoOption.getItemId();

        if (id == R.id.agregarContactos) {
            agregar_contacto(null);
        }

        return super.onOptionsItemSelected(agregarContactoOption);
    }
}