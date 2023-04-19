package com.example.tp2repaso.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp2repaso.modelo.Actividad;

import java.util.ArrayList;
import java.util.Date;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Actividad>> lista;
    private ArrayList<Actividad> Actividades ;

    public GalleryViewModel() {
        Actividades = new ArrayList<>();
    }

    public LiveData<ArrayList<Actividad>> getLista() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public void llenarLista(){
        Actividades.add(new Actividad("Estudiar", "Estudiar moviles", "San Luis", new Date(2020,10,10),1430));
        Actividades.add(new Actividad("Rendir", "Rendir moviles", "San Luis", new Date(2020,10,15),1500));
        Actividades.add(new Actividad("Dormir","Dormir la ciesta", "San Luis", new Date(2020,10,18),1500 ));
        lista.setValue(Actividades);
    }
}