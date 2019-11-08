package br.com.aps.Br.com.aps.login;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarBancoLogin extends SQLiteOpenHelper {
    private static final String TABELA_LOGIN = "LOGIN";
    private static final String EMAIL = "email";
    private static final String Senha = "senha";
    //private static final String ID = "id";
    private static final int VERSAO = 1;

    public CriarBancoLogin(Context context) {
        //super(context, name, factory, version);
        super(context, getEMAIL(), null, getVERSAO());
    }
    public static String getTABELA_LOGIN() { return TABELA_LOGIN; }
    public static String getEMAIL() {
        return EMAIL;
    }
    public static String getSenha() {
        return Senha;
    }
    public static int getVERSAO()   { return VERSAO;  }
    //public static String getId()   { return ID; }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+ getTABELA_LOGIN() + "("+ EMAIL + " text primary key,"
                 + Senha + " text)";

        sqLiteDatabase.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ getTABELA_LOGIN());
        onCreate(sqLiteDatabase);
    }
}
