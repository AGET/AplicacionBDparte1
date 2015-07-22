package aget.aget.workstation.aplicacionbd1;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView lstv;

    SQLHelper sqlhelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstv = (ListView) findViewById(R.id.lista);

        actualiza();
    }


    protected void actualiza(){
        sqlhelper = new SQLHelper (this);
        db = sqlhelper.getWritableDatabase();

//Consulta de dos tablas (inner join)
        Cursor c = db.rawQuery(
                "select "
                        + "c.id, "
                        + "c.nombre, "
                        + "c.telefono, "
                        + "c.correo, "
                        + "p.nombre "
                        + " from contacto c "
                        + " inner join pais p "
                        + " on c.pais=p.id",null);

//		Cursor c = db.rawQuery("select c.id, c.nombre, c.telefono, c.correo, c.pais from contacto c",null);

        //Mostrando los datos en una lista
        if (c.moveToFirst()){
            ArrayList<String> arreglo =
                    new ArrayList<String>(c.getCount());
            do{
                String id = c.getString(0);
                String nom = c.getString(1);
                String tel = c.getString(2);
                String mail = c.getString(3);
                String pais = c.getString(4);
                arreglo.add(id+"-"+nom+"-"+tel+"-"+mail+"-"+pais);
            }while(c.moveToNext());

            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(
                            this,
                            android.R.layout.simple_list_item_1,
                            arreglo);
            lstv.setAdapter(adapter);
        }else{
            ArrayList<String> arreglo = new ArrayList<String>(1);
            arreglo.add("Sin Datos");
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(
                            this,
                            android.R.layout.simple_list_item_1,
                            arreglo
                    );
            lstv.setAdapter(adapter);
        } // if

        db.close();
    }
}