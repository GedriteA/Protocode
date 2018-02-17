package com.thesis.protocode.codeit.Compiler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.thesis.protocode.R;

import net.rdrei.android.dirchooser.DirectoryChooserActivity;
import net.rdrei.android.dirchooser.DirectoryChooserConfig;

import java.io.FileOutputStream;

/**
 * Created by martinlizardo on 2/11/2017.
 */

public class SaveFileDialog extends DialogFragment
{
    EditText filepath,txtfilename;
    String code;
    private static final int REQUEST_DIRECTORY = 0;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_save, null);
       filepath=(EditText)view.findViewById(R.id.filepath);
        txtfilename=(EditText)view.findViewById(R.id.filename);
        Bundle bundle=getArguments();
        code=bundle.getString("Code");
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView((view))
                // Add action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        SaveDocu();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SaveFileDialog.this.getDialog().cancel();
                    }
                });


        filepath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveFile();
            }
        });
        return builder.create();

    }

    public void SaveFile(){
        try {
            final Intent chooserIntent = new Intent(getActivity(),
                    DirectoryChooserActivity.class);

            final DirectoryChooserConfig config = DirectoryChooserConfig.builder()
                    .newDirectoryName("DirChooserSample")
                    .allowReadOnlyDirectory(true)
                    .allowNewDirectoryNameModification(true)
                    .build();

            chooserIntent.putExtra(
                    DirectoryChooserActivity.EXTRA_CONFIG,
                    config);

            startActivityForResult(chooserIntent, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void SaveDocu(){

        String filename = filepath.getText() + "/" + txtfilename.getText();;
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(filename);
            outputStream.write(code.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DIRECTORY) {
            Log.i("actviity result", String.format("Return from DirChooser with result %d",
                    resultCode));

            if (resultCode == DirectoryChooserActivity.RESULT_CODE_DIR_SELECTED) {
               filepath.setText(data.getStringExtra(DirectoryChooserActivity.RESULT_SELECTED_DIR));
            }

        }
    }
}
