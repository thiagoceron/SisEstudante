package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Exclui {
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


            // Define o comando SQL para excluir o estudante
            String sql = "DELETE FROM estudante WHERE estudante_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 1); // Exclui o estudante com ID 1


            // Executa o comando no banco de dados
            int linhasAfetadas = stmt.executeUpdate();


            // Fecha o PreparedStatement e a conexão
            stmt.close();
            connection.close();


            if (linhasAfetadas > 0) {
                System.out.println("Exclusão do estudante realizada com sucesso.");
            } else {
                System.out.println("Nenhum estudante encontrado com o ID especificado.");
            }


        } catch (SQLException erro) {
            System.out.println("Problemas na conexão com o banco de dados: " + erro.toString());
        }
    }
}
