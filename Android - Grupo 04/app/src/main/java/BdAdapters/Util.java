package BdAdapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luiz on 27/05/2015.
 */
public class Util {
    public static void copiaBanco(
            Context ctx, String nomeDB) {
        // Cria o banco vazio
        SQLiteDatabase db = ctx.openOrCreateDatabase(
                nomeDB, Context.MODE_WORLD_WRITEABLE, null);
        db.close();
        try {
            // Abre o arquivo que deve estar na pasta assets
            InputStream is = ctx.getAssets().open(nomeDB);
            // Abre o arquivo do banco vazio ele fica em:
            // /data/data/nome.do.pacote.da.app/databases
            FileOutputStream fos = new FileOutputStream(
                    ctx.getDatabasePath(nomeDB));

            // Copia byte a byte o arquivo do assets para
            // o aparelho/emulador
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) > 0) {
                fos.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}