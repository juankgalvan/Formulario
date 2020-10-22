package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editCodigo,editNombre,editCarrera;
    Button btnAgregar,btnMostrar,btnBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo=(EditText)findViewById(R.id.editCodigo);
        editNombre=(EditText)findViewById(R.id.editNombre);
        editCarrera=(EditText)findViewById(R.id.editCarrera);
        btnAgregar=(Button)findViewById(R.id.btnAgregar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnBuscar=(Button)findViewById(R.id.btnBuscar);
        final baseDatos baseDatos=new baseDatos(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.agregarEstudiantes(editCodigo.getText().toString(),editNombre.getText().toString(),editCarrera.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agregaron los datos correctamente",Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarEstudiantes=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(mostrarEstudiantes);
            }
        });
    }
}