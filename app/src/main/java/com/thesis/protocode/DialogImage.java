package com.thesis.protocode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.thesis.protocode.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by martinlizardo on 4/6/2017.
 */

public class DialogImage extends DialogFragment {

    int imageId;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_image, null);
        final GifImageView gifView=(GifImageView)view.findViewById(R.id.expanded_image);
        imageId=getArguments().getInt("image");
        gifView.setImageResource(imageId);


        builder.setView((view));










        return builder.create();
    }

}
