package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
    private static final String user="root";
    private static final String senha="password";
    private static final String url="jdbc:mysql://localhost:3306/veterinario?allowPublicKeyRetrieval=true&useSSL=false";
    
    public static Connection criaConexao() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, senha);
        return conexao;
    }
}
