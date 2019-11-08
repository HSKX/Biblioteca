package br.com.aps.Br.com.aps.login;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.provider.ContactsContract;

import br.com.aps.CriarBanco;

public class BancoControllerLogin {
    private SQLiteDatabase db;
    private CriarBancoLogin bancoLogin;

    //Construtor da controlle do Banco de dados, onde assim que a classe BancoController é chamada é criado automaticamente uma instancia do banco.
    public BancoControllerLogin(Context context){
        bancoLogin = new CriarBancoLogin(context);
    }

    // Classe para realizar a inserção dos dados que estão na tela de cadastro

    public String insereDadologin(String Email, String Senha){
        ContentValues valores;

        long resultado;

        db = bancoLogin.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBancoLogin.getEMAIL(), Email);
        valores.put(CriarBancoLogin.getSenha(), Senha);

        resultado = db.insert(CriarBancoLogin.getTABELA_LOGIN(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Cadastro já existe, tente um novo e-mail";
        else
            return "Cadastro efetuado com sucesso!";

    }

    public Cursor carregaDadoByEmail(String Email){
        Cursor cursor;
        String[] campos = {CriarBancoLogin.getEMAIL(),CriarBancoLogin.getSenha()};
        String where = CriarBancoLogin.getEMAIL() + "=" + Email;
        db = bancoLogin.getReadableDatabase();
        cursor = db.query(CriarBancoLogin.getTABELA_LOGIN(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}



