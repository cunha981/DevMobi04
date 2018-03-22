package br.usjt.deswebmob.servicedesk;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by arqdsis on 21/03/2018.
 */

public class Chamado implements Serializable{

    private int numero;
    private Date dataAbertura;
    private Date dataFechamento;
    private String status;
    private String descricao;
    private Fila fila;

    public Chamado (int numero, Date dataAbertura, Date dataFechamento, String status, String descricao, Fila fila){
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.fila = fila;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
}
