package br.com.usjt.servicedesk;

import java.io.Serializable;
import java.util.List;

public class Fila implements Serializable {
    private String nome;
    private int iconId;
    private List<Chamado> chamados;

    public Fila (String nome, int iconId){
        setNome(nome);
        setIconId(iconId);
    }
    public List<Chamado> getChamados() {
        return chamados;
    }
    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIconId() {
        return iconId;
    }
    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

}