package br.usjt.deswebmob.servicedesk;

/**
 * Created by arqdsis on 21/03/2018.
 */

public enum FilaId {
    DESKTOP(1000, "Desktop", "desktops"),
    TELEFONIA(1001,"Telefonia", "telefonia");

    int id;
    String descricao, icone;

    FilaId(int id, String descricao, String icone){
        this.id = id;
        this.descricao = descricao;
        this.icone = icone;
    }
}
