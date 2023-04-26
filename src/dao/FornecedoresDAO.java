/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Fornecedores;

public class FornecedoresDAO {
        public void inserirNomeCiente(String nome) {
        // aqui você fará a conexão com o banco usando a classe FabricaConexao
        Fornecedores fornecedor = new Fornecedores();
        fornecedor.setNome("Teste");
        fornecedor.setCnpj("15896324564124589");
        fornecedor.setInscricaoEstadual("56451861321");
        fornecedor.setTelefone("989988998");
        fornecedor.setEmail("teste@gmail.com");
        
        try {
            Connection conexao = FabricaConexao.criaConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO animais (nome, cnpj, incricao_estadual, telefone, email) VALUES (?, ?, ?, ?, ?)");
            
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getCnpj());
            ps.setString(3, fornecedor.getInscricaoEstadual());
            ps.setString(4, fornecedor.getTelefone());
            ps.setString(5, fornecedor.getEmail());
              
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
