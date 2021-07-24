package com.thenight.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.thenight.myapplication.R;

import org.jetbrains.annotations.NotNull;


public class BerandaFragment extends Fragment {

    ViewFlipper flipper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        int images[] = {R.drawable.slide1,R.drawable.slide2};

        flipper = view.findViewById(R.id.flip);

        for (int image :images ){
            flipperImages(image);
        }

        return view;
    }
    private  void flipperImages(int slide){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(slide);
        flipper.addView(imageView);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getContext(), android.R.anim.fade_in);
        flipper.setOutAnimation(getContext(), android.R.anim.fade_out);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}
