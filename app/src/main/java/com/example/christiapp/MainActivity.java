package com.example.christiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Etusuario, Etcontraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Poner en el action bar: icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.iconologin);//indicando en donde esta la imagen

        Etusuario = (EditText)findViewById(R.id.Usuario);
        Etcontraseña = (EditText)findViewById(R.id.Contraseña);

    }

    public void Ingresar(View view){
        String usuarioString = Etusuario.getText().toString();
        String contraseñaString = Etcontraseña.getText().toString();

        if (usuarioString.length() == 0){
            Toast.makeText(getApplicationContext(), "Usuario incompleto", Toast.LENGTH_LONG).show();
        }
        if (contraseñaString.length() == 0){
            Toast.makeText(getApplicationContext(), "Contraseña incompleta", Toast.LENGTH_LONG).show();
        }

        if (usuarioString.length() != 0 && contraseñaString.length() != 0){
           /* SharedPreferences preferences = getSharedPreferences("registro", Context.MODE_PRIVATE);
            String nombreString = preferences.getString("user", "");
            String contraString = preferences.getString("pass", "");



            if (usuarioString.length() != nombreString.length()){
                Toast.makeText(this, "Usuario no valido", Toast.LENGTH_LONG).show();
            }
            if (contraseñaString.length() != contraString.length()){
                Toast.makeText(this, "Contraseña no valida", Toast.LENGTH_LONG).show();
            }

            if (usuarioString.length() == nombreString.length() && contraseñaString.length() == contraString.length()){



            }

            */
            Intent InicioActivity = new Intent(getApplicationContext(), Inicio.class);
            InicioActivity.putExtra("DatoUsuario", Etusuario.getText().toString());
            startActivity(InicioActivity);
            Toast.makeText(getApplicationContext(), "Ingreso exitoso", Toast.LENGTH_LONG).show();
        }

    }
    public void registra(View view){
        Intent RegistraActivity = new Intent(getApplicationContext(), Registrar.class);
        startActivity(RegistraActivity);
    }
}
