package br.usjt.deswebmob.servicedesk;

import java.io.Serializable;

/**
 * Created by arqdsis on 21/03/2018.
 */

public class Fila implements Serializable{
    private int id;
    private String icone;
    private String nome;

    public Fila (int id, String icone, String nome){
        this.id = id;
        this.icone = icone;
        this.nome = nome;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
}
