/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/**
 * @author gabri
 */
public class LivroDTO {
    private String nome_livro, autor_livro, secao_livro;
    private int id_livro, quantidade_livro;
    
    //Encapsulamento  livro
    public String getNome_livro() {
        return nome_livro;
    }
    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }
    
    //Encapsulamento  autor
    public String getAutor_livro() {
        return autor_livro;
    }
    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }
    
    //Encapsulamento  secao
    public String getSecao_livro() {
        return secao_livro;
    }
    public void setSecao_livro(String secao_livro) {
        this.secao_livro = secao_livro;
    }
    
    //Encapsulamento  id
    public int getId_livro() {
        return id_livro;
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    
    //Encapsulamento  quantidade
    public int getQuantidade_livro() {
        return quantidade_livro;
    }
    public void setQuantidade(int quantidade_livro) {
        this.quantidade_livro = quantidade_livro;
    }
}
