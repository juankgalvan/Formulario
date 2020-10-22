package com.example.formulario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdaptador extends RecyclerView.Adapter<RecycleViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo,nombre,carrera;

        public ViewHolder(View itemView){
            super(itemView);
            codigo=(TextView)itemView.findViewById(R.id.tvCodigo);
            nombre=(TextView)itemView.findViewById(R.id.tvNombre);
            carrera=(TextView)itemView.findViewById(R.id.tvCarrera);
        }
    }

    public List<estudianteModelo> estudianteModeloList;

    public RecycleViewAdaptador(List<estudianteModelo> estudianteModeloList){
        this.estudianteModeloList=estudianteModeloList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_estudiantes,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.codigo.setText(estudianteModeloList.get(position).getCodigo());
        holder.nombre.setText(estudianteModeloList.get(position).getNombre());
        holder.carrera.setText(estudianteModeloList.get(position).getCarrera());
    }

    @Override
    public int getItemCount() {
        return estudianteModeloList.size();
    }

}
