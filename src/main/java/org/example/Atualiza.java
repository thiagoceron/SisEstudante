package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Atualiza {
    public static void main(String[] args) {
        // URL de conexão com o banco
        String url = "jdbc:postgresql://localhost:5432/curso";


        // Usuário do banco de dados
        String usuario = "postgres";


        // Senha do banco de dados
        String senha = "postgres";


        try {
            // Conectar ao banco de dados
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");


            // Define o comando SQL para atualizar nome e idade do estudante
            String sql = "UPDATE estudante SET nome = ?, idade = ? WHERE estudante_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);


            // Define os valores para nome, idade e estudante_id
            stmt.setString(1, "Thiago Ceron");
            stmt.setInt(2, 25);  // Atualizando a idade para 25
            stmt.setInt(3, 1);   // Atualizando o estudante com ID 1


            // Executa o comando no banco de dados
            stmt.executeUpdate();


            // Fecha a conexão
            stmt.close();
            connection.close();
            System.out.println("Atualização do estudante realizada com sucesso!");


        } catch (SQLException erro) {
            System.out.println("Problemas na conexão com o banco de dados: " + erro.toString());
        }
    }
}
