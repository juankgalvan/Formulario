package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerViewEstudiante;
    private RecycleViewAdaptador adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerViewEstudiante=(RecyclerView)findViewById(R.id.recyclerEstudiante);
        recyclerViewEstudiante.setLayoutManager(new LinearLayoutManager(this));

        adaptadorEstudiante=new RecycleViewAdaptador((obtenerEstudiantes()));
        recyclerViewEstudiante.setAdapter(adaptadorEstudiante);
    }

    public List<estudianteModelo> obtenerEstudiantes() {
        List<estudianteModelo> estudiante=new ArrayList<>();
        estudiante.add(new estudianteModelo("1"));
        estudiante.add(new estudianteModelo("2"));
        return estudiante;
    }
}