package com.example.pp_grupo2;

import android.content.Intent;

import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class AgregarContacto extends AppCompatActivity {

    private Button continuar;
    private EditText etNombre, etApellido, etTelefono, etMail, etDireccion, etFechaNac;
    private Spinner  spTelefono, spMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        etNombre = (EditText)findViewById(R.id.editTextTextPersonName);
        etApellido = (EditText)findViewById(R.id.editTextTextPersonName2);
        etTelefono = (EditText)findViewById(R.id.editTextPhone);
        etMail = (EditText)findViewById(R.id.editTextTextEmailAddress);
        etDireccion = (EditText)findViewById(R.id.editTextTextPersonName6);
        etFechaNac = (EditText)findViewById(R.id.editTextDate);
        spTelefono = (Spinner) findViewById(R.id.spinnerTel);
        spMail = (Spinner) findViewById(R.id.spinnerMail);

        String [] opciones = {"Casa", "Trabajo", "Movil"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones );
        spTelefono.setAdapter(adapter);
        spMail.setAdapter(adapter);

        spTelefono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                etTelefono.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        spMail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                etMail.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

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

    public void continuar(View view){

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String telefono = etTelefono.getText().toString();
        String mail = etMail.getText().toString();
        String direccion = etDireccion.getText().toString();
        String fechaNac = etFechaNac.getText().toString();

        if (!validarNombreApellido(nombre)) {
            etNombre.setError("Ingresa un nombre válido");
            return;
        }

        if (!validarNombreApellido(apellido)) {
            etApellido.setError("Ingresa un apellido válido");
            return;
        }

        if (!validarTelefono(telefono)) {
            etTelefono.setError("Ingresa un teléfono válido");
            return;
        }

        if (!validarEmail(mail)) {
            etMail.setError("Ingresa un correo electrónico válido");
            return;
        }

        if (!validarFechaNacimiento(fechaNac)) {
            etFechaNac.setError("Ingresa una fecha de nacimiento válida (dd/MM/yyyy)");
            return;
        }

        if (nombre.isEmpty()) {
            etNombre.setError("Este campo es obligatorio");
            return;
        }

        if (apellido.isEmpty()) {
            etApellido.setError("Este campo es obligatorio");
            return;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("Este campo es obligatorio");
            return;
        }

        if (mail.isEmpty()) {
            etMail.setError("Este campo es obligatorio");
            return;
        }

        if (fechaNac.isEmpty()) {
            etFechaNac.setError("Este campo es obligatorio");
            return;
        }

        Intent intent = new Intent(this, AgregarContacto2.class);
        intent.putExtra("nombre", etNombre.getText().toString());
        intent.putExtra("apellido", etApellido.getText().toString());
        intent.putExtra("telefono", etTelefono.getText().toString());
        intent.putExtra("mail", etMail.getText().toString());
        intent.putExtra("direccion", etDireccion.getText().toString());
        intent.putExtra("fechaNac", etFechaNac.getText().toString());
        startActivity(intent);

    }

    private boolean validarNombreApellido(String texto) {
        return !Pattern.matches(".*\\d+.*", texto);
    }

    private boolean validarTelefono(String telefono) {
        return Pattern.matches("\\d{3}-\\d{3}-\\d{4}", telefono); // Cambia el patrón según tus necesidades
    }

    private boolean validarEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validarFechaNacimiento(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }




}