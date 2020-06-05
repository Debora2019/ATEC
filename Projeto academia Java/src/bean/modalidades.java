/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Débora
 */
public class modalidades {
 private int mod_id;
 private String mod_descricao;
 private int mod_func_id;
 private String mod_horario;
 private String mod_preco;
 private String mod_instrutor;

    public String getMod_instrutor() {
        return mod_instrutor;
    }

    public void setMod_instrutor(String mod_instrutor) {
        this.mod_instrutor = mod_instrutor;
    }

    public String getMod_horario() {
        return mod_horario;
    }

    public void setMod_horario(String mod_horario) {
        this.mod_horario = mod_horario;
    }

    public String getMod_preco() {
        return mod_preco;
    }

    public void setMod_preco(String mod_preco) {
        this.mod_preco = mod_preco;
    }

    public int getMod_id() {
        return mod_id;
    }

    public void setMod_id(int mod_id) {
        this.mod_id = mod_id;
    }

    public String getMod_descricao() {
        return mod_descricao;
    }

    public void setMod_descricao(String mod_descricao) {
        this.mod_descricao = mod_descricao;
    }

    public int getMod_func_id() {
        return mod_func_id;
    }

    public void setMod_func_id(int mod_func_id) {
        this.mod_func_id = mod_func_id;
    }
    
    
}
