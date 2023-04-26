package dao;

import controller.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Animais;

public class AnimaisDAO {
    public void inserirNomeAnimal(String nome) {
        // aqui você fará a conexão com o banco usando a classe FabricaConexao
        Animais animal = new Animais();
        animal.setNome("Mel");
        animal.setEspecie("Puddle");
        animal.setRaca("Vira-lata");
        animal.setDataNascimento("22/07/2015");
        
        try {
            Connection conexao = FabricaConexao.criaConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO animais (nome, raca, especie, data_nascimento) VALUES (?, ?, ?, ?)");
            ps.setString(1, animal.getNome());
            ps.setString(2, animal.getRaca());
            ps.setString(3, animal.getEspecie());
            ps.setString(4, animal.getDataNascimento());
              
            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
