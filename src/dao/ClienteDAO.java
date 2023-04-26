/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Clientes;

public class ClienteDAO {
        
    public void inserirCliente(Clientes cliente){
        String sql = "INSERT INTO Cliente ( nome, email, telefone, dataNascimento, cpf) VALUES ( ?, ?, ?, ?, ?)";
        
        try{    
            Connection conexao = FabricaConexao.criaConexao();
            PreparedStatement statement = conexao.prepareStatement(sql);
           
           statement.setString(1, cliente.getNome());
           statement.setString(2, cliente.getEmail());
           statement.setString(3, cliente.getTelefone());
           statement.setString(4, cliente.getDataNascimento());
           statement.setString(5, cliente.getCpf());
           
           statement.executeUpdate();
           statement.close();
           conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void alterarCliente(Clientes cliente){             
     String sql= "UPDATE veterinario.Cliente\n" +
                "SET nome=?, cpf=?, email=?, dataNascimento=?, Telefone=?\n" +
                "WHERE idCliente= " + "'" +  cliente.getId() + "'" + ";";
             
             
     
        try {
            Connection conexao = FabricaConexao.criaConexao();
            PreparedStatement statement = conexao.prepareStatement(sql);
                   
            statement.setString(1,cliente.getNome());
            statement.setString(2,cliente.getCpf());
            statement.setString(3,cliente.getEmail());
            statement.setString(4,cliente.getDataNascimento());
            statement.setString(5,cliente.getTelefone());
                 
            statement.execute();
            statement.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }    
    
    public List<Clientes> buscarTodosClientes(){
        List<Clientes> clientes = new ArrayList<>();
    
        String sql= "SELECT idCliente, nome, cpf, email, dataNascimento, Telefone\n" +
                "FROM veterinario.Cliente";  
        
      try (Connection conexao = FabricaConexao.criaConexao();
         PreparedStatement statement = conexao.prepareStatement(sql);
         ResultSet resultado = statement.executeQuery()) {
        
        while (resultado.next()) {
            Clientes cliente = new Clientes();  
            cliente.setId(resultado.getString("idCliente"));
            cliente.setNome(resultado.getString("nome"));
            cliente.setEmail(resultado.getString("email"));
            cliente.setTelefone(resultado.getString("telefone"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setDataNascimento(resultado.getString("dataNascimento"));  
            
            clientes.add(cliente);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }           
      
      return clientes;
    }
    
    public Clientes buscarPorId(Integer id) {
    Clientes cliente = new Clientes();
    String sql = "SELECT idCliente, nome, cpf, email, dataNascimento, Telefone\n" +
                 "FROM veterinario.Cliente where idCliente = '" + id + "'";
    try (Connection conexao = FabricaConexao.criaConexao();
         PreparedStatement statement = conexao.prepareStatement(sql);
         ResultSet resultado = statement.executeQuery()) {

        if (resultado.next()) { 
            cliente.setId(resultado.getString("idCliente"));
            cliente.setNome(resultado.getString("nome"));
            cliente.setEmail(resultado.getString("email"));
            cliente.setTelefone(resultado.getString("telefone"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setDataNascimento(resultado.getString("dataNascimento"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return cliente;
}
    
}
