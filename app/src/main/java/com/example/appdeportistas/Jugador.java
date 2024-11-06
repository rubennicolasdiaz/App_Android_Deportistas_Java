package com.example.appdeportistas;

public class Jugador {
    private int id;
    private String nombre;
    private String telefono;
    private String club;
    private String email;
    private String posicion;
    private int imagenId;

    public Jugador(){

    }
    public Jugador(int id, String nombre, String telefono, String club, String email, String posicion, int imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.club = club;
        this.email = email;
        this.posicion = posicion;
        this.imagenId = imagenId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
