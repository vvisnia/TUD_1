package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Soldier;
import domain.Unit;
import domain.Vehicle;


public class UnitManager {

	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	private String createTableUnit = "CREATE TABLE Unit(id int GENERATED BY DEFAULT AS IDENTITY, idreff_soldier int, idreff_vehicle int, name varchar(20))";
	
    private String addSoldierFK = "ALTER TABLE Unit ADD CONSTRAINT a FOREIGN KEY (idreff_soldier) REFERENCES Soldier (id)";
    private String addVehicleFK = "ALTER TABLE Unit ADD CONSTRAINT b FOREIGN KEY (idreff_vehicle) REFERENCES pracownik (id)";
	
	private Statement statement;
	
	private PreparedStatement updateUnitStmt;
	private PreparedStatement addUnitStmt;
	
	private PreparedStatement deleteUnitByUnitIDStmt;
	private PreparedStatement deleteAllUnitStmt;
	private PreparedStatement deleteUnitBySoldierIDStmt;
	private PreparedStatement deleteUnitByVehicleIDStmt;
	
	private PreparedStatement getAllUnitStmt;
	private PreparedStatement getUnitByUnitIDStmt;
	private PreparedStatement getUnitBySoldierIDStmt;
	private PreparedStatement getUnitByVehicleIDStmt;
	
	public UnitManager(){
	try {
		connection = DriverManager.getConnection(url);
		statement = connection.createStatement();

		ResultSet rs = connection.getMetaData().getTables(null, null, null,
				null);
		boolean tableExists = false;
		while (rs.next()) {
			if ("Unit".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
				tableExists = true;
				break;
			}
		}

		if (!tableExists)
		{
			statement.executeUpdate(createTableUnit);
			statement.executeUpdate(addSoldierFK);
			statement.executeUpdate(addVehicleFK);
			
		}	

		addUnitStmt = connection
				.prepareStatement("INSERT INTO Unit (idreff_soldier, idreff_vehicle, name) VALUES (?, ?, ?)");
		deleteAllUnitStmt = connection
				.prepareStatement("DELETE FROM Unit");
		getAllUnitStmt = connection
				.prepareStatement("SELECT id, idreff_soldier, idreff_vehicle, name FROM Unit");
		updateUnitStmt = connection
				.prepareStatement("UPDATE Unit set idreff_soldier = ?, idreff_vehicle = ?, name = ? WHERE id = ?");

		getUnitByUnitIDStmt = connection.prepareStatement("SELECT * FROM Unit WHERE id = ?");
		
		deleteUnitByUnitIDStmt = connection.prepareStatement("DELETE FROM Unit WHERE id = ?");
		deleteUnitBySoldierIDStmt = connection.prepareStatement("DELETE FROM Unit WHERE idreff_soldier = ?");
		deleteUnitByVehicleIDStmt = connection.prepareStatement("DELETE FROM Unit WHERE idreff_vehicle = ?");
		
		getUnitBySoldierIDStmt = connection.prepareStatement("SELECT * FROM Unit WHERE idreff_soldier = ?");
		getUnitByVehicleIDStmt = connection.prepareStatement("SELECT * FROM Unit WHERE idreff_vehicle = ?");
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	
	
	
	}
}
	Connection getConnection() {
		return connection;
	}
	void clearUnit() {
		try {
			deleteAllUnitStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addUnit(Unit unit) {
		int count = 0;
		try {
			addUnitStmt.setInt(1, unit.getSoldierId());
			addUnitStmt.setInt(2, unit.getVehicleId());
			addUnitStmt.setString(3, unit.getName());
			

			count = addUnitStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public Unit getUnitByUnitID(Unit unit){
		try
		{
			getUnitByUnitIDStmt.setInt(1, unit.getId());
			ResultSet rs = getUnitByUnitIDStmt.executeQuery();
			
			while (rs.next())
			{
				unit = new Unit(rs.getInt("idreff_soldier"), rs.getInt("idreff_vehicle"), rs.getString("name"));
				unit.setId(rs.getInt("id"));
				return unit;
			}
		}
	 catch (SQLException e)
	 {
		 e.printStackTrace();
	 }
	 return null;
	}
	
	public List<Unit> getUnitBySoldierID(Soldier soldier) {
		List<Unit> units = new ArrayList<Unit>();
		try {
		getUnitBySoldierIDStmt.setInt(1, soldier.getId());
		ResultSet rs = getUnitBySoldierIDStmt.executeQuery();
		while (rs.next())
		{
		Unit unit = new Unit();
		unit.setId(rs.getInt("id"));
		unit.setSoldierId(rs.getInt("idreff_soldier"));
		unit.setVehicleId(rs.getInt("idreff_vehicle"));
		unit.setName(rs.getString("name"));
		units.add(unit);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return units;
		}
	
	public List<Unit> getUnitByVehicleID(Vehicle vehicle) {
		List<Unit> units = new ArrayList<Unit>();
		try {
		getUnitByVehicleIDStmt.setInt(1, vehicle.getId());
		ResultSet rs = getUnitByVehicleIDStmt.executeQuery();
		while (rs.next())
		{
		Unit unit = new Unit();
		unit.setId(rs.getInt("id"));
		unit.setSoldierId(rs.getInt("idreff_soldier"));
		unit.setVehicleId(rs.getInt("idreff_vehicle"));
		unit.setName(rs.getString("name"));
		units.add(unit);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return units;
		}
	
	
	
	public int deleteUnitByUnitID(Unit unit)
	{
	int count = 0;
	try
	{
	deleteUnitByUnitIDStmt.setInt(1, unit.getId());
	count = deleteUnitByUnitIDStmt.executeUpdate();
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	return count;
	}
	
	public int deleteUnitBySoldierID(Soldier soldier)
	{
	int count = 0;
	try
	{
	deleteUnitBySoldierIDStmt.setInt(1, soldier.getId());
	count = deleteUnitBySoldierIDStmt.executeUpdate();
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	return count;
	}
	
	public int deleteUnitByVehiclerID(Vehicle vehicle)
	{
	int count = 0;
	try
	{
	deleteUnitByVehicleIDStmt.setInt(1, vehicle.getId());
	count = deleteUnitByVehicleIDStmt.executeUpdate();
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	return count;
	}
	
	public int updateUnit(Unit unit)
	{
	int count = 0;
	try
	{
		updateUnitStmt.setInt(1, unit.getSoldierId());
		updateUnitStmt.setInt(2, unit.getVehicleId());
		updateUnitStmt.setString(3, unit.getName());
		updateUnitStmt.setInt(4, unit.getId());
		count = updateUnitStmt.executeUpdate();
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	return count;
	}
	
	
	
	public List<Unit> getAllUnit() {
		List<Unit> unit = new ArrayList<Unit>();

		try {
			ResultSet rs = getAllUnitStmt.executeQuery();

			while (rs.next()) {
				Unit p = new Unit();
				p.setId(rs.getInt("id"));
				p.setSoldierId(rs.getInt("idreff_soldier"));
				p.setVehicleId(rs.getInt("idreff_vehicle"));
				p.setName(rs.getString("name"));
				unit.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unit;
	}
	
}