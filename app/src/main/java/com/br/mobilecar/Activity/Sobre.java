package com.br.mobilecar.Activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.renan_dvlp.mobilecar.R;

/**
 * Classe responsável apenas pelo SOBRE do aparelho,
 * esta Classe é toda Visual, nãor ecebe e nem retorna nada daqui.
 */
public class Sobre extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sobre);
    }
}
