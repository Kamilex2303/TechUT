package ug.kstasiak.techut.zad02.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ug.kstasiak.techut.zad02.domain.Pen;

public class PenService implements IPenService {

	private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
    private final Connection connection;
    private final Statement statement;
    private final String CREATE_TABLE_SQL = "CREATE TABLE Pen (id bigint GENERATED BY DEFAULT AS IDENTITY, producer VARCHAR(30), size DOUBLE, dateOfProduction DATE, isBlack BOOLEAN)";
    private boolean tableExists = false;
    
    private PreparedStatement addPenStmt;
    private PreparedStatement getAllPensStmt;
    private PreparedStatement getPenByIdStmt;
    private PreparedStatement deleteAllPensStmt;
    private PreparedStatement deletePenByIdStmt;

    public PenService() throws SQLException {
        connection = DriverManager.getConnection(URL);
        statement = connection.createStatement();

        ResultSet rs = connection.getMetaData().getTables(null, null, null, null);

        while (rs.next()) {
            if ("Pen".equalsIgnoreCase(rs.getString("table_name"))) {
                tableExists = true;
                break;
            }
        }

        if (!tableExists) {
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
        
        addPenStmt = connection.prepareStatement("INSERT INTO Pen (producer, size, dateOfProduction, isBlack) VALUES (?,?,?,?)");
        getAllPensStmt = connection.prepareStatement("SELECT * FROM Pen");
        getPenByIdStmt = connection.prepareStatement("SELECT * FROM Pen WHERE ID=?");
        deleteAllPensStmt = connection.prepareStatement("DELETE FROM Pen");
        deletePenByIdStmt = connection.prepareStatement("DELETE FROM Pen WHERE ID=?");
    }
    
    public void addPen(Pen pen) {
    	try {
    		addPenStmt.setString(1, pen.getProducer());
    		addPenStmt.setDouble(2, pen.getSize());
    		addPenStmt.setDate(3, pen.getDataOfProduction());
    		addPenStmt.setBoolean(4, pen.isBlack());
    		addPenStmt.executeUpdate();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public List<Pen> getAllPens() {
    	List<Pen> pens = new ArrayList<Pen>();
    	try {
    		ResultSet rs = getAllPensStmt.executeQuery();
    		
    		while (rs.next() ) {
    			Pen newPen = new Pen(rs.getString("producer"),rs.getDouble("size"), rs.getDate("dateOfProduction"), rs.getBoolean("isBlack"));
    			pens.add(newPen);
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return pens;
    }
    
    public Pen getPenById(int id) {
		Pen newPen = new Pen();
    	try {
    		getPenByIdStmt.setInt(1, id);
    		ResultSet rs = getPenByIdStmt.executeQuery();
    		
    		while (rs.next()) {
    			newPen = new Pen(rs.getString("producer"),
    					rs.getDouble("size"), rs.getDate("dateOfProduction"), rs.getBoolean("isBlack"));
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return newPen;
    }
    
    public void deleteAllPens() {
    	try {
    		deleteAllPensStmt.executeUpdate();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void deletePenById(int id) {
    	try {
    		deletePenByIdStmt.setInt(1, id);
    		deletePenByIdStmt.executeUpdate();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
}
}
