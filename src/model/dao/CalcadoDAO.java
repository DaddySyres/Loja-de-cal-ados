package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Calcado;



public class CalcadoDAO {
	public void create(Calcado c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO `calcado`(`calcadoModelo`, `calcadoMarca`, `calcadoPreço`, `calcadoTamanho`, `calcadoEstoque`) VALUES (?,?,?,?,?)");
			stmt.setString(1,c.getCalcadoModelo());
			stmt.setString(2,c.getCalcadoMarca());
			stmt.setDouble(3,c.getCalcadoPreço());
			stmt.setInt(4,c.getCalcadoTamanho());
			stmt.setBoolean(5,c.isCalcadoEstoque());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro na tabela concluido!");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no salvar no banco: " + e);
			
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
		
}

	public List<Calcado> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		List<Calcado> cs = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM calcado;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Calcado c = new Calcado();
				c.setCalcadoId(rs.getInt("calcadoId"));
				c.setCalcadoModelo(rs.getString("calcadoModelo"));
				c.setCalcadoMarca(rs.getString("calcadoMarca"));
				c.setCalcadoPreço(rs.getDouble("calcadoPreço"));
				c.setCalcadoTamanho(rs.getInt("calcadoTamanho"));
				c.setCalcadoEstoque(rs.getBoolean("calcadoEstoque"));
				cs.add(c);
			}
		}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "erro ao buscar os informaçoes no banco:" + e);
			e.printStackTrace();	
		}
		
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return cs;
	}
	
	
	public Calcado read(int id){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Calcado c = new Calcado();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM calcado WHERE calcadoId=? Limit 1");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				c.setCalcadoId(rs.getInt("calcadoId"));
				c.setCalcadoModelo(rs.getString("calcadoModelo"));
				c.setCalcadoMarca(rs.getString("calcadoMarca"));
				c.setCalcadoPreço(rs.getDouble("calcadoPreço"));
				c.setCalcadoTamanho(rs.getInt("calcadoPreço"));
				c.setCalcadoEstoque(rs.getBoolean("calcadoEstoque"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}

	public void  update(Calcado c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("UPDATE `calcado` SET `calcadoModelo`=?,`calcadoMarca`=?,`calcadoPreço`=?,`calcadoTamanho`=?,`calcadoEstoque`=? WHERE `calcadoId`=? LIMIT 1");
			stmt.setString(1, c.getCalcadoModelo());
			stmt.setString(2, c.getCalcadoMarca());
			stmt.setDouble(3, c.getCalcadoPreço());
			stmt.setInt(4, c.getCalcadoTamanho());
			stmt.setBoolean(5, c.isCalcadoEstoque());
			stmt.setInt(6, c.getCalcadoId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Banco de dado atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Banco de Dados " + e);
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Calcado c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM Calcado WHERE calcadoId =?");
			stmt.setInt(1, c.getCalcadoId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Calcado deletado com sucesso!");
			
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao delatar: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);	
		}
	}
	
}
	
	

 