package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {

    @Id
    private String _id;
    private String Name;
    private String Telephone;
    private String NumeroCartao;
    private String Validade;
    private String CodSeguranca;
    private String Endereco;
    private String Cidade;
    private String Pais;
    private String CEP;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getNumeroCartao() {
        return NumeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        NumeroCartao = numeroCartao;
    }

    public String getValidade() {
        return Validade;
    }

    public void setValidade(String validade) {
        Validade = validade;
    }

    public String getCodSeguranca() {
        return CodSeguranca;
    }

    public void setCodSeguranca(String codSeguranca) {
        CodSeguranca = codSeguranca;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
