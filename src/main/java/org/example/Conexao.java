package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static void main(String[] args) {
        // URL de conexão com o banco de dados
        String url = "jdbc:postgresql://localhost:5432/curso";


        // Usuário do banco de dados
        String usuario = "postgres";


        // Senha do banco de dados
        String senha = "postgres";


        try {
            // Conecta ao banco de dados
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");


            // Fecha a conexão
            connection.close();
        } catch (SQLException erro) {
            System.out.println("Problemas na conexão com a fonte de dados: " + erro.getMessage());
        }
    }
}
