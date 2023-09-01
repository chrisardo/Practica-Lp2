package com.example.christiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    private EditText nombre, user, contraseña;
    private CheckBox CbMasculino, CbFemenino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //Poner en el action bar: icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.iconologin);//indicando en donde esta la imagen

        nombre = (EditText)findViewById(R.id.Nombre);
        user = (EditText)findViewById(R.id.User);
        contraseña = (EditText)findViewById(R.id.Contraseña);
        CbMasculino = (CheckBox)findViewById(R.id.CbMasculino);
        CbFemenino = (CheckBox)findViewById(R.id.CbFemenino);

    }

    public void volverLogin(View view){
        Intent volLogin = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(volLogin);
    }

    public void registro(View view){
        String nombreString = nombre.getText().toString();
        String userString = user.getText().toString();
        String contraseñaString = contraseña.getText().toString();

        if(nombreString.length() == 0){
            Toast.makeText(getApplicationContext(), "Nombre incompleto", Toast.LENGTH_LONG).show();
        }
        if(contraseñaString.length() == 0){
            Toast.makeText(getApplicationContext(), "Contraseña incompleto", Toast.LENGTH_LONG).show();
        }
        if (CbMasculino.isChecked() == false && CbFemenino.isChecked() == false){//Si no esta seleccionado el checkbox masculuno y femenino
            Toast.makeText(getApplicationContext(), "No seleccionó su género", Toast.LENGTH_LONG).show();
        }

        SharedPreferences preferences = getSharedPreferences("registro", Context.MODE_PRIVATE);
        SharedPreferences.Editor ObjecEditor = preferences.edit();
        ObjecEditor.putString("pass", contraseñaString);
        ObjecEditor.putString("user",userString);
        ObjecEditor.commit();

        if (nombreString.length() != 0 && userString.length() != 0 && contraseñaString.length() != 0 && CbMasculino.isChecked() == true || CbFemenino.isChecked() == true ){

            Intent InicioActivity = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(InicioActivity);


            Toast.makeText(getApplicationContext(), "Registro aceptado", Toast.LENGTH_LONG).show();

        }
    }
}
