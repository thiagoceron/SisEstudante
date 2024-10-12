package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insere {
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


            // Define o comando SQL para inserir um novo estudante
            String sql = "INSERT INTO estudante (nome, idade) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);


            // Defina os valores para os campos
            stmt.setString(1    , "Thiago Ceron");
            stmt.setInt(2, 20); // Suponha que idade seja 20, por exemplo


            // Executa o comando no banco de dados
            stmt.executeUpdate();


            // Fecha o PreparedStatement e a conexão
            stmt.close();
            connection.close();
            System.out.println("Inserção do estudante realizada com sucesso");


        } catch (SQLException erro) {
            System.out.println("Problemas na conexão com o banco de dados: " + erro.toString());
        }
    }
}
