/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Carolina
 */
public class Atendimento {
    
    private int id;
    private String nome;
    private Date dataSenha;
    private Date dataAtendimento;
    private int status;

    public Atendimento(int id, String nome, Date dataSenha, Date dataAtendimento, int status) {
        this.id = id;
        this.nome = nome;
        this.dataSenha = dataSenha;
        this.dataAtendimento = dataAtendimento;
        this.status = status;
    }

    public Atendimento() {
        this.dataSenha = new Date();
        this.dataAtendimento = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataSenha() {
        return dataSenha;
    }

    public void setDataSenha(Date dataSenha) {
        this.dataSenha = dataSenha;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", nome=" + nome + ", dataSenha=" + dataSenha + ", dataAtendimento=" + dataAtendimento + ", status=" + status + '}';
    }

}
    