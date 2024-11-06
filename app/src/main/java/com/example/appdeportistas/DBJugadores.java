package com.example.appdeportistas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBJugadores extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "jugadores.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "jugadores";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_TELEFONO = "telefono";
    private static final String COLUMN_CLUB = "club";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_POSICION = "posicion";
    private static final String COLUMN_IMAGENID = "imagenid";

    public DBJugadores(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NOMBRE + " TEXT NOT NULL,"
                + COLUMN_TELEFONO + " TEXT NOT NULL,"
                + COLUMN_CLUB + " TEXT NOT NULL,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_POSICION + " TEXT,"
                + COLUMN_IMAGENID + " INT);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertarJugador(Jugador jugador) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, jugador.getNombre());
        values.put(COLUMN_TELEFONO, jugador.getTelefono());
        values.put(COLUMN_CLUB, jugador.getClub());
        values.put(COLUMN_EMAIL, jugador.getEmail());
        values.put(COLUMN_POSICION, jugador.getPosicion());
        values.put(COLUMN_IMAGENID, jugador.getImagenId());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Jugador> mostrarJugadores() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                Jugador jugador = new Jugador();
                jugador.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                jugador.setNombre(cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE)));
                jugador.setTelefono(cursor.getString(cursor.getColumnIndex(COLUMN_TELEFONO)));
                jugador.setClub(cursor.getString(cursor.getColumnIndex(COLUMN_CLUB)));
                jugador.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                jugador.setPosicion(cursor.getString(cursor.getColumnIndex(COLUMN_POSICION)));
                jugador.setImagenId(cursor.getInt(cursor.getColumnIndex(COLUMN_IMAGENID)));
                listaJugadores.add(jugador);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaJugadores;
    }

    public Jugador verJugador(int id) {
        Jugador jugador = new Jugador();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            jugador.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
            jugador.setNombre(cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE)));
            jugador.setTelefono(cursor.getString(cursor.getColumnIndex(COLUMN_TELEFONO)));
            jugador.setClub(cursor.getString(cursor.getColumnIndex(COLUMN_CLUB)));
            jugador.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
            jugador.setPosicion(cursor.getString(cursor.getColumnIndex(COLUMN_POSICION)));
            jugador.setImagenId(cursor.getInt(cursor.getColumnIndex(COLUMN_IMAGENID)));
            cursor.close();
        }

        db.close();
        return jugador;
    }

    public void editarJugador(Jugador jugador) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, jugador.getNombre());
        values.put(COLUMN_TELEFONO, jugador.getTelefono());
        values.put(COLUMN_CLUB, jugador.getClub());
        values.put(COLUMN_EMAIL, jugador.getEmail());
        values.put(COLUMN_POSICION, jugador.getPosicion());
        values.put(COLUMN_IMAGENID, jugador.getImagenId());
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(jugador.getId())});
        db.close();
    }

    public void eliminarJugador(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}

