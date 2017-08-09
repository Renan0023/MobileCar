package com.br.mobilecar.Activity;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.br.mobilecar.Activity.ActivityControleRemoto;
import com.br.mobilecar.Activity.Sobre;
import com.example.renan_dvlp.mobilecar.R;

import java.util.ArrayList;
import java.util.Set;



/**
 * Classe responsável por Parear o dispositivo e  logo em seguida  para os comandos correspondentes
 * Created by Renan_DVLP on 16/09/2016.
 */
public class ActivityTelaPrincipal extends Activity implements View.OnClickListener {
    int ATIVA_BLUETOOTH = 0;
    BluetoothAdapter meuBluetoothAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * Obtendo o adaptador do bluetooth do aparalho
         */
        meuBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //se  o bluetooh estiver desativado , ele ira informar que não possui bluetooh
        if (meuBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Seu dispositivo não  possui bluetooth", Toast.LENGTH_LONG).show();

        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaprincipal);



        //declarando os Buttons da telaPrincial
        ImageButton btnMostrarSobre = (ImageButton)findViewById(R.id.btn_sobre);
        btnMostrarSobre.setOnClickListener(this);
        ImageButton btnMostrarPareados = (ImageButton)findViewById(R.id.btn_pareados);
        btnMostrarPareados.setOnClickListener(this);

    }
    public void onClick(View v){
        final TextView txtNomeDispositivo = (TextView) findViewById(R.id.txtNomeDispPareado);
        final ImageView btn_Iniciar = (ImageView) findViewById(R.id.btn_iniciar);
        switch (v.getId()){
            /**
             * case responsável por abrir outra Activity
             */
            case R.id.btn_iniciar:

                //  Pegando o nome do dispositivo e passado para a tela do controle Remoto
                Bundle nomeDispositivo = new Bundle();
                nomeDispositivo.putString("nomeDisp", txtNomeDispositivo.getText().toString());
                Intent abrir = new Intent(this,ActivityControleRemoto.class);
                abrir.putExtras(nomeDispositivo);
                startActivity(abrir);


                break;
            /**
             * case que representa os dispositivos Pareados, caso não tenha nenhum dispositivo Pareado, ele retorna um Span informando que não teve retorno de dispositivos
             */
            case R.id.btn_pareados:


                final ImageButton btnControleRemoto = (ImageButton) findViewById(R.id.btn_iniciar);
                btnControleRemoto.setOnClickListener(this);

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                final ArrayList<String> nomeStringDispositivo = new ArrayList<>();


                BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                //               BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                // Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();


               // final String nomeStringDispositivo = bluetoothAdapter.getName();

              //  listaDispositivosPareados.clear();
                //Caso ele ache dispositivos Pareados o botão do controle remoto é acionado para Click
                if (pairedDevices.size() > 0) {
                    for (BluetoothDevice device : pairedDevices) {
                        nomeStringDispositivo.add(device.getName());


                        alertDialog.setTitle("Atenção");
                        alertDialog.setMessage("Dispositivo Pareado : \n"+device.getName()+"\n"+device.getAddress());
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        btnControleRemoto.setEnabled(true);
                                      //  btn_Iniciar.setImageResource(R.drawable.iniciar_solto);
                                        txtNomeDispositivo.setText(nomeStringDispositivo.toString());

                                    }
                                }
                        );
                        alertDialog.setIcon(R.drawable.splashscreen);
                        alertDialog.show();
                    }
                }
                //Caso não ache nenhum dispositivo Pareado o controle remoto não abre
                if(pairedDevices.size() == 0){

                    alertDialog.setTitle("Atenção");
                    alertDialog.setMessage("Nenhum dispositivo pareado !");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    btnControleRemoto.setEnabled(false);
                               //     btn_Iniciar.setImageResource(R.drawable.iniciar_precionado);
                                    txtNomeDispositivo.setText("");
                                }
                            }
                    );
                    alertDialog.setIcon(R.drawable.splashscreen);
                    alertDialog.show();
                }
                break;
            //caso para abrir a activity Sobre
            case R.id.btn_sobre:
                    Intent abrirSobre = new Intent(this,Sobre.class);
                  startActivity(abrirSobre);
                break;

        }
    }
}
