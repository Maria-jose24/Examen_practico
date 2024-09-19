package com.example.task.Model;

public class Respuesta {
	private String estado;
    private String respuesta;

    // Constructor sin argumentos
    public Respuesta() {
    }

    // Constructor con parámetros
    public Respuesta(String estado, String respuesta) {
        this.estado = estado;
        this.respuesta = respuesta;
    }

    // Getters y Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "estado='" + estado + '\'' +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}