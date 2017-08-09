package com.br.mobilecar.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.RunnableFuture;

import android.widget.Toast;

import com.example.renan_dvlp.mobilecar.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe Respponsável pelo Controle Remoto do sistema
 */
public class ActivityControleRemoto extends Activity  implements View.OnClickListener, Runnable {

    private Boolean motorLigado = false;
    private Boolean portasTravadas = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle_remoto);

        //Recebe o nome do dispositivo e apresenta em uma TextViwe na tela do controleRemoto
        TextView txtNomeDisp = (TextView) findViewById(R.id.txtRecebeNomeDisp);
        Intent intent = getIntent();
        Bundle recebenomeDispositivo = intent.getExtras();
//        String nome = recebenomeDispositivo.getString("nomeDisp");
        txtNomeDisp.setText("teste");

        //processo para trocar a fonte do nome do dispositivo
        Typeface dysplay = Typeface.createFromAsset(getAssets(), "DS-DIGI.TTF");
        TextView dysplayDigital = (TextView) findViewById(R.id.txtRecebeNomeDisp);
        dysplayDigital.setTypeface(dysplay);



        //Declarando todos os botoes
        ImageButton btn_Liga_Desliga = (ImageButton) findViewById(R.id.btn_Liga_Desliga);
        btn_Liga_Desliga.setOnClickListener(this);
        ImageButton btn_sub_dian_esqerd = (ImageButton) findViewById(R.id.btn_sub_dian_esqerd);
        btn_sub_dian_esqerd.setOnClickListener(this);
        ImageButton btn_sub_dian_direi = (ImageButton) findViewById(R.id.btn_sub_dian_direi);
        btn_sub_dian_direi.setOnClickListener(this);
        ImageButton btn_des_dian_esqerd = (ImageButton) findViewById(R.id.btn_des_dian_esqerd);
        btn_des_dian_esqerd.setOnClickListener(this);
        ImageButton btn_des_dian_direi = (ImageButton) findViewById(R.id.btn_des_dian_direi);
        btn_des_dian_direi.setOnClickListener(this);
        ImageButton btn_sub_tras_esqerd = (ImageButton) findViewById(R.id.btn_sub_tras_esqerd);
        btn_sub_tras_esqerd.setOnClickListener(this);
        ImageButton btn_sub_tras_direi = (ImageButton) findViewById(R.id.btn_sub_tras_direi);
        btn_sub_tras_direi.setOnClickListener(this);
        ImageButton btn_des_tras_esqerd = (ImageButton) findViewById(R.id.btn_des_tras_esqerd);
        btn_des_tras_esqerd.setOnClickListener(this);
        ImageButton btn_des_tras_direi = (ImageButton) findViewById(R.id.btn_des_tras_direi);
        btn_des_tras_direi.setOnClickListener(this);
        ImageButton btn_portaMalas = (ImageButton) findViewById(R.id.btn_portaMalas);
        btn_portaMalas.setOnClickListener(this);
        ImageButton btn_trava_destrava =(ImageButton)findViewById(R.id.btn_trava_destrava);
        btn_trava_destrava.setOnClickListener(this);


    }


    public void onClick(View v) {
        final ImageView ledAzul = (ImageView)findViewById(R.id.imgLedAzul);
        final ImageView ledVermelho = (ImageView)findViewById(R.id.imgLedVermelho);
        final ImageView ledAmarelo = (ImageView)findViewById(R.id.imgLedAmarelo);
        final ImageButton btn_trava_destrava =(ImageButton)findViewById(R.id.btn_trava_destrava);
        final ImageButton btn_portaMalas = (ImageButton) findViewById(R.id.btn_portaMalas);
        Handler handler = new Handler();

        /**
         * Metodo Responsável pela telca de cada botão
         */
        switch (v.getId()){
            case R.id.btn_Liga_Desliga:
        if(motorLigado == false) {

            ledAzul.setImageResource(R.drawable.ledazul_acesso);
            handler.postDelayed(this, 5000);
            ledVermelho.setImageResource(R.drawable.ledvermelho_acesso);
            ledAmarelo.setImageResource(R.drawable.ledamaralo_acesso);
            motorLigado = true;

        }else{
                ledVermelho.setImageResource(R.drawable.ledvermelho_apagado);
                ledAmarelo.setImageResource(R.drawable.ledamaralo_apagado);
            motorLigado = false;
            }
                break;
            case R.id.btn_sub_dian_esqerd:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_sub_dian_direi:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_des_dian_esqerd:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_des_dian_direi:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_sub_tras_esqerd:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_sub_tras_direi:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_des_tras_esqerd:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_des_tras_direi:

                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id.btn_portaMalas:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);
                break;
            case R.id. btn_trava_destrava:
                ledAzul.setImageResource(R.drawable.ledazul_acesso);
                handler.postDelayed(this,100);


                if(portasTravadas == true) {
                    btn_trava_destrava.setImageResource(R.drawable.btn_click_cadeado_false);
                    btn_portaMalas.setEnabled(false);
                    portasTravadas = false;
                } else {
                    btn_trava_destrava.setImageResource(R.drawable.btn_click_cadeado_true);
                    btn_portaMalas.setEnabled(true);
                portasTravadas = true;
                }

                break;
        }
    }


    @Override
    public void run() {
        final ImageView ledAzul = (ImageView)findViewById(R.id.imgLedAzul);
        final ImageView ledAmarelo = (ImageView)findViewById(R.id.imgLedAmarelo);

        ledAzul.setImageResource(R.drawable.ledazul_apagado);

        ledAmarelo.setImageResource(R.drawable.ledamaralo_apagado);


    }


}
