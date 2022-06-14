package src;

import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {

    private static Connection conexao;

    @Override
    public Connection connect(String urlConexao) {
        try {
            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection(urlConexao);

        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        } catch (ClassNotFoundException e){
            System.err.println("Ocorreu uma falha ao utilizar o driver: " + e.getMessage());
        }

        return conexao;
    }

    @Override
    public void createTable(String urlConexao) {

        try {
            conexao = connect(urlConexao);
            Statement stm = conexao.createStatement();
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS cliente (" +
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, " +
            "idade INTEGER NOT NULL, " +
            "cpf TEXT NOT NULL, " +
            "rg TEXT NOT NULL)"
            );

            stm.close();
        } catch (SQLException e) {
            System.err.println("Não foi possível criar a tabela: " + e.getMessage());
        }

    }

    @Override
    public void insert(String urlConexao, Cliente cliente) {
        try {
            conexao = connect(urlConexao);
            Statement stm = conexao.createStatement();
            stm.executeUpdate("INSERT INTO cliente VALUES (" +
                    cliente.getId() + ", " +
                    "'" + cliente.getNome() + "', " +
                    cliente.getIdade() + ", " +
                    "'" + cliente.getCpf() + "', " +
                    "'" + cliente.getRg() + "')"
                    );

            stm.close();
        } catch (SQLException e) {
            System.err.println("Não foi possível inserir o cliente: " + e.getMessage());
        }

    }

    @Override
    public void selectAll(String urlConexao) {
        try {
            conexao = connect(urlConexao);
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente");

            while (rs.next()){
                System.out.println("===== DADOS DO CLIENTE =====");
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getInt("idade"));
                System.out.println("Cpf: " + rs.getString("cpf"));
                System.out.println("Rg: " + rs.getString("rg"));
            }

            stm.close();

        } catch (SQLException e) {
            System.err.println("Não foi possível selecionar todos os registros: " + e.getMessage());
        }

    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        try {
            conexao = connect(urlConexao);
            Statement stm = conexao.createStatement();
            stm.executeUpdate("UPDATE cliente SET " +
                    "nome = '" + name + "', " +
                    "idade = " + idade + " " +
                    "WHERE cliente.id = " + id);

            stm.close();

        } catch (SQLException e){
            System.err.println("Não foi possível atualizar o cliente: " + e.getMessage());
        }

    }

    @Override
    public void delete(String urlConexao, int id) {
        try {
            conexao = connect(urlConexao);
            Statement stm = conexao.createStatement();
            stm.executeUpdate("DELETE FROM cliente WHERE cliente.id = " + id);
            stm.close();

        } catch (SQLException e){
            System.err.println("Não foi possível deletar o cliente: " + e.getMessage());
        }

    }
}
