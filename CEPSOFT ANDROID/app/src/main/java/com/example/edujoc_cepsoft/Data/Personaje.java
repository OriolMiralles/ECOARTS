package com.example.edujoc_cepsoft.Data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.Serializable;

public class Personaje implements Serializable {
    private final int VIDA_MAXIMA = 5; //La vida máxima que puede tener.

    private int id;
    private String nombre;
    private String idioma;
    private String rutaImagen;
    private String descripcion;

    private boolean seleccionado;
    private int vida; //La vida actual que tiene.

    public Personaje() {
        this.vida = VIDA_MAXIMA;
        this.seleccionado = false;
    }

    public Personaje(int id, String nombre, String idioma, String rutaImagen, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.idioma = idioma;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
        this.vida = VIDA_MAXIMA;
        this.seleccionado = false;
    }

    public void quitarVida(int i) {
        this.vida -= i;
    }

    //region Setters & Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public int getVida() {
        return vida;
    }

    public int getVIDA_MAXIMA() {
        return this.VIDA_MAXIMA;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    //endregion

    /**
     * Obtener una imagen a partir de una ruta.
     *
     * @param context El activity de donde llama a este método.
     * @return La imagen del personaje en formato Bitmap.
     */
    public Bitmap obtenerImagen(@NotNull Context context) {
        //Obtener la ruta de la imagen del objeto personaje, replazamos el ./ por la ruta files de la app y convertimos todo en minúsculas.
        String rutaAbsolutaPersonaje = this.getRutaImagen().replace(".//", "/");
        rutaAbsolutaPersonaje.replace("//","/");

        //Obtener la imagen de la ruta y crear una imagen Bitmap.
        return BitmapFactory.decodeFile(context.getFilesDir().getAbsolutePath()+File.separator+this.getRutaImagen());
    }
}
