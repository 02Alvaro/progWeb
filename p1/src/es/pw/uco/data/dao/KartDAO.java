package es.pw.uco.data.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import es.pw.uco.business.circuit.dto.*;
import es.pw.uco.data.common.Conexion;

public class KartDAO implements DAO<KartDTO,Integer>{

	@Override
	public boolean insert(KartDTO a) {
		Conexion conexController=Conexion.getInstance();
		Connection conex=conexController.getConnection();
		String query=conexController.getSql().getProperty("INSERT_KART");
		try{
			PreparedStatement st = conex.prepareStatement(query);
			st.setInt(1, a.getIsAdult());
			st.setString(2,a.getState());
			
			return st.executeUpdate()==1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(KartDTO a) {
		Conexion conexController=Conexion.getInstance();
		Connection conex=conexController.getConnection();
		String query=conexController.getSql().getProperty("UPDATE_KART");
		try{
			PreparedStatement st = conex.prepareStatement(query);
			st.setInt(1, a.getIsAdult());
			st.setString(2,a.getState());
			st.setInt(3,a.getId());
			return st.executeUpdate()==1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id){
		Conexion conexController=Conexion.getInstance();
		Connection conex=conexController.getConnection();
		String query=conexController.getSql().getProperty("DELETE_KART");
		try{
			PreparedStatement st = conex.prepareStatement(query);
			st.setInt(1,id);
			
			return st.executeUpdate()==1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<KartDTO> getAll(){
		Conexion conexController=Conexion.getInstance();
		Connection conex=conexController.getConnection();
		String query=conexController.getSql().getProperty("SELECT_ALL_KART");
		try {
			PreparedStatement st = conex.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			ArrayList<KartDTO> users=new ArrayList<KartDTO>();
			while(rs.next()) {
				users.add(new KartDTO(rs.getInt("id"),rs.getInt("esAdulto"), rs.getString("estado")));
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public KartDTO get(Integer id){
		Conexion conexController=Conexion.getInstance();
		Connection conex=conexController.getConnection();
		String query=conexController.getSql().getProperty("SELECT_ID_KART");
		try{
			PreparedStatement st = conex.prepareStatement(query);
			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			if(rs.next()) return new KartDTO(rs.getInt("id"),rs.getInt("esAdulto"), rs.getString("estado")));

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
