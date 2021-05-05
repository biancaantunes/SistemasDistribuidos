package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Livro {

    @Id
    private String _id;
    private String Titulo;
    private String Autor;
    private String Editora;
    private String DatadeLancamento;
    private String Preco;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String editora) {
        Editora = editora;
    }

    public String getDatadeLancamento() {
        return DatadeLancamento;
    }

    public void setDatadeLancamento(String datadeLancamento) {
        DatadeLancamento = datadeLancamento;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String preco) {
        Preco = preco;
    }
}