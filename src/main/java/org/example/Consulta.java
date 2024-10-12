package org.example;
import java.sql.*;


public class Consulta {
    public static void main(String[] args) {
// url de conexão com o banco de dados
        String url = "jdbc:postgresql://localhost:5432/curso";

// usuario do banco de dados postgresql
        String usuario = "postgres";

// senha do banco de dados postgresql
        String senha = "postgres";
        try {
            Connection connection =     DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexao realizada com sucesso!");
// Define o comando SQL.
            String sql = "SELECT * FROM estudante WHERE estudante_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
// parâmetro 1 indicando que é a coluna 1 cujo conteúdo é 1
            stmt.setInt(1,1);
            ResultSet result = stmt.executeQuery();
            System.out.println("COD NOME ");
            System.out.println("------ -------");
            if (result.next()) {
//getInt obtém o valor de uma coluna específicado ResultSet
//estudanteID refere-se ao nome da coluna natabela do Banco de Dados
                int codigo = result.getInt("estudante_id");
                String nome = result.getString("nome");
                System.out.println(codigo + "\t" + nome);
            }
            stmt.executeUpdate();
            connection.close();
            System.out.println("Exclusao de estudante realizada com sucesso");
        } catch (SQLException erro) {
            System.out.println("Problemas na conexao com o banco de dados" + erro.toString());
        }
    }
}
