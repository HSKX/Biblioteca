package br.com.aps.Br.com.aps.login;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.aps.BancoController;
import br.com.aps.MainActivity;
import br.com.aps.R;
import br.com.aps.SplashActivity;

public class Tela_de_login extends AppCompatActivity {

    BancoControllerLogin crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        crud = new BancoControllerLogin(getBaseContext());
        Button btnEntrar = (Button) findViewById(R.id.btlogin);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
                TextView txtSenha = (TextView) findViewById(R.id.txtSenha);
                String Email = txtEmail.getText().toString();
                String Senha = txtSenha.getText().toString();
               if(crud.carregaDadoByEmail(Email).getCount() == 1 ){

                   Intent it = new Intent(Tela_de_login.this, MainActivity.class);

                           startActivity(it);
                  alert("Login realizado com sucesso");

               }else{
                   Intent it = new Intent(Tela_de_login.this, SplashActivity.class);

                   startActivity(it);
               }

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
                TextView txtSenha = (TextView) findViewById(R.id.txtSenha);
                String Email = txtEmail.getText().toString();
                String Senha = txtSenha.getText().toString();
                String Resultado;
                Resultado = crud.insereDadologin(Email, Senha);
                alert(Resultado);
            }
        });
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(Tela_de_login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
