package br.com.senai.selectioncontrols;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageView imageView;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Activity 2");

        imageButton = findViewById(R.id.bt_foto);
        imageView = findViewById(R.id.imageView);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foto = new Intent();
                foto.setType("image/*");foto.setAction(Intent.ACTION_PICK);
                startActivityForResult(foto, 1232);
            }
        });

        //galeria = findViewById(R.id.img_fotos);
        //galeria.setOnClickListener(new View.OnClickListener(){
        //@Override
        //public void onClick(View view) {
        //Intent foto = new Intent();
        //foto.setType("image/*");
        //foto.setAction(Intent.ACTION_GET_CONTENT);
        //startActivityForResult(foto, 0);
        //}
        //});
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        Log.d("Valor do resultCode = ", String.valueOf(resultCode));

        if (requestCode == 1232){
            Uri path = data.getData();

            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);

                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
