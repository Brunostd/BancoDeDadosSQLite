package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app",MODE_PRIVATE , null);

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nome VARCHAR, idade INT(3))");
            //bancoDados.execSQL("DROP TABLE pessoas");

            //Inserir valores
            /*bancoDados.execSQL("INSERT INTO pessoas (nome, idade) values ('Bruno', 22)");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) values ('Bruna', 18)");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) values ('Lucas', 14)");*/

            //ATUALIZAR DADOS
            //bancoDados.execSQL("UPDATE pessoas SET idade=23, nome = 'Brunao' WHERE id = 1 ");

            //RECUPERAR PESSOAS
            String filtro = "br";
            /*String consulta = "SELECT nome, idade FROM pessoas";*/

            //AQUI SELECIONAR TUDO DEPOIS DE BR
            /*String consulta = "SELECT nome, idade FROM pessoas" +
                            " WHERE nome LIKE '%"+filtro+"%' ";*/

            //UTILIZANDO ORDER BY
            /*String consulta = "SELECT nome, idade FROM pessoas" +
                            " WHERE 1=1 ORDER BY idade DESC LIMIT 3 ";*/


            String consulta = "SELECT id, nome, idade FROM pessoas" +
                            " WHERE 1=1 ";
            Cursor cursor = bancoDados.rawQuery(consulta, null);
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor!= null){
                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                Log.i("RESULTADO - id: ", id+" / nome: "+nome+" / idade: "+idade );
                cursor.moveToNext();
            }

        } catch (Exception e){

        }
    }
}