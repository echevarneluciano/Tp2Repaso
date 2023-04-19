package com.example.tp2repaso.ui.gallery;

import static android.content.Intent.getIntent;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tp2repaso.R;
import com.example.tp2repaso.databinding.FragmentDescripcionBinding;
import com.example.tp2repaso.databinding.FragmentSlideshowBinding;
import com.example.tp2repaso.modelo.Actividad;
import com.example.tp2repaso.ui.slideshow.SlideshowViewModel;

import org.w3c.dom.Text;

public class Descripcion extends Fragment {

    private DescripcionViewModel mViewModel;
    private FragmentDescripcionBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        DescripcionViewModel descripcionViewModel =
                new ViewModelProvider(this).get(DescripcionViewModel.class);

        binding = FragmentDescripcionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if(getArguments()!=null){
            Actividad a = (Actividad) getArguments().getSerializable("actividades");
            binding.tvDescripcion.setText(a.getDescripcion());
            binding.tvNombre.setText(a.getNombre());
            binding.tvFecha.setText(a.getFecha()+"");
            binding.tvLugar.setText(a.getLugar());
            binding.tvHora.setText(a.getHora()+"");
        }

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DescripcionViewModel.class);
        // TODO: Use the ViewModel
    }

}