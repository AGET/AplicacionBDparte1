package aget.aget.workstation.aplicacionbd1;

/**
 * Created by workstation on 18/07/15.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME ="BD_Agenda.db";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }
//Creando la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE IF NOT EXISTS pais ( "
                + " id PRIMARY KEY, "
                + " nombre TEXT )");

        //Insertando datos estaticos
        db.execSQL("insert into pais (id,nombre) values ('11','Mexico')");
        db.execSQL("insert into pais (id,nombre) values ('21','Rusia')");
        db.execSQL("insert into pais (id,nombre) values ('31','Alemania')");
        db.execSQL("insert into pais (id,nombre) values ('41','Japon')");

        db.execSQL("CREATE TABLE IF NOT EXISTS contacto ( "
                + " id PRIMARY KEY, "
                + " nombre TEXT, "
                + " telefono TEXT, "
                + " correo TEXT,"
                + " pais TEXT ) ");

        //Insertando datos estaticos
        db.execSQL("insert into contacto (id,nombre,telefono,correo,pais) values "
                + "('1','Manuel','7471192592','manuel@yahoo.com','31')");
        db.execSQL("insert into contacto (id,nombre,telefono,correo,pais) values "
                + "('2','Pablo','7471192592','pablo@mtzc.com','21')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

}
