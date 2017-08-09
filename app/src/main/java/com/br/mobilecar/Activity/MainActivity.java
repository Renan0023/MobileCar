
package com.br.mobilecar.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.os.Handler;

import com.example.renan_dvlp.mobilecar.R;


/**
 * Primeira classe, responsável apenas por mostrar  a imagem do Splashscreen
 */
public class MainActivity extends Activity implements Runnable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        //Responsável pelo tempo que o Splash permanecerá ativo
        Handler handler = new Handler();
        handler.postDelayed(this, 5000 );


    }


    /**
     * Responsável para rodas após o Splash e passar para a segunda tela que seria a "Tela Principal"
     **/
    public void run(){
        startActivity( new Intent(this, ActivityTelaPrincipal.class));
       finish();

    }
}
