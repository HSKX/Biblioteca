package br.com.aps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.aps.Br.com.aps.login.Tela_de_login;


public class SplashActivity extends Activity {

    //Define tempo que a tela vai exibir. (tempo em milisegundos)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {


            @Override
            public void run() {
                //Método que será executado uma vez.. Na abertura do app.
                        mostrarLoginActivity();
            }
            }, 3000);
    }
    private void mostrarLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, Tela_de_login.class);
        startActivity(intent);
        finish();
    }
}