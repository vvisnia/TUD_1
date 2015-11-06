package service;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import domain.Unit;
import domain.Soldier;
import domain.Vehicle;
import service.UnitManager;
import service.SoldierManager;
import service.VehicleManager;
public class UnitManagerTest {
	UnitManager unitManager = new UnitManager();
	SoldierManager soldierManager = new SoldierManager();
	VehicleManager vehicleManager = new VehicleManager();
Unit unit;
List<Unit> units;
@Test
public void checkConnection(){
assertNotNull(unitManager.getConnection());
}
@Test
public void checkClearingUnit()
{
unitManager.clearUnit();
assertEquals(unitManager.getAllUnit().size(), 0);
}

@Test
public void checkAdding()
{
	unitManager.clearUnit();
soldierManager.clearSoldier();
Soldier soldier = new Soldier("Wojtek", "Major", 3);
soldierManager.addSoldier(soldier);
vehicleManager.clearVehicle();
Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
vehicleManager.addVehicle(vehicle);
Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "Grom");
unitManager.addUnit(unit);
assertEquals(soldierManager.getAllSoldier().get(0).getId(), unit.getSoldierId());
assertEquals(vehicleManager.getAllVehicle().get(0).getId(), unit.getVehicleId());
assertEquals("Grom", unit.getName());
}
@Test
public void checkDeletingByUnitID()
{
	unitManager.clearUnit();
	soldierManager.clearSoldier();
	Soldier soldier = new Soldier("Wojtek", "Major", 3);
	soldierManager.addSoldier(soldier);
	vehicleManager.clearVehicle();
	Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
	vehicleManager.addVehicle(vehicle);
	Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
	unitManager.addUnit(unit);
	unitManager.deleteUnitByUnitID(unitManager.getAllUnit().get(0));
	assertEquals(unitManager.getAllUnit().size(), 0);
}

@Test
public void checkUpdatingUnit()
{
	unitManager.clearUnit();
	soldierManager.clearSoldier();
	Soldier soldier = new Soldier("Wojtek", "Major", 3);
	soldierManager.addSoldier(soldier);
	vehicleManager.clearVehicle();
	Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
	vehicleManager.addVehicle(vehicle);
	Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
	unitManager.addUnit(unit);
Unit unit2 = unitManager.getAllUnit().get(0);
unit2.setName("D");
unitManager.updateUnit(unit2);
assertEquals(unitManager.getAllUnit().get(0).getName(), "D");
}


@Test
public void checkGettingUnitByUnitID()
{
Unit unitRetrieved = null;
unitManager.clearUnit();
soldierManager.clearSoldier();
Soldier soldier = new Soldier("Wojtek", "Major", 3);
soldierManager.addSoldier(soldier);
vehicleManager.clearVehicle();
Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
vehicleManager.addVehicle(vehicle);
Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
unitManager.addUnit(unit);
Unit unit2 = unitManager.getAllUnit().get(0);
unitRetrieved = unitManager.getUnitByUnitID(unit2);


assertEquals(unit2.getId(), unitRetrieved.getId());
assertEquals(unit2.getSoldierId(), unitRetrieved.getSoldierId());
assertEquals(unit2.getVehicleId(), unitRetrieved.getVehicleId());
assertEquals(unit2.getName(), unitRetrieved.getName());
}


@Test
public void checkGettingUnitBySoldierID()
{
	unitManager.clearUnit();
	soldierManager.clearSoldier();
	Soldier soldier = new Soldier("Wojtek", "Major", 3);
	soldierManager.addSoldier(soldier);
	vehicleManager.clearVehicle();
	Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
	vehicleManager.addVehicle(vehicle);
	Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
	unitManager.addUnit(unit);

units = unitManager.getUnitBySoldierID(soldierManager.getAllSoldier().get(0));

assertEquals(soldierManager.getAllSoldier().get(0).getId(), units.get(0).getSoldierId());
}


@Test
public void checkGettingUnitByVechicleID()
{
	unitManager.clearUnit();
	soldierManager.clearSoldier();
	Soldier soldier = new Soldier("Wojtek", "Major", 3);
	soldierManager.addSoldier(soldier);
	vehicleManager.clearVehicle();
	Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
	vehicleManager.addVehicle(vehicle);
	Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
	unitManager.addUnit(unit);

units = unitManager.getUnitByVehicleID(vehicleManager.getAllVehicle().get(0));

assertEquals(vehicleManager.getAllVehicle().get(0).getId(), units.get(0).getVehicleId());
}


@Test
public void checkDeletingVehicleBySoldierID()
{
	unitManager.clearUnit();
	soldierManager.clearSoldier();
	Soldier soldier = new Soldier("Wojtek", "Major", 3);
	soldierManager.addSoldier(soldier);
	vehicleManager.clearVehicle();
	Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
	vehicleManager.addVehicle(vehicle);
	Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
	unitManager.addUnit(unit);
	unitManager.deleteUnitBySoldierID(soldierManager.getAllSoldier().get(0));

assertEquals(unitManager.getAllUnit().size(), 0);
}

@Test
public void checkDeletingUnitByVehicleID()
{
	unitManager.clearUnit();
	soldierManager.clearSoldier();
	Soldier soldier = new Soldier("Wojtek", "Major", 3);
	soldierManager.addSoldier(soldier);
	vehicleManager.clearVehicle();
	Vehicle vehicle = new Vehicle("T34", "Czolg", "Popsuty", 3);
	vehicleManager.addVehicle(vehicle);
	Unit unit = new Unit(soldierManager.getAllSoldier().get(0).getId(), vehicleManager.getAllVehicle().get(0).getId(), "C");
	unitManager.addUnit(unit);
unitManager.deleteUnitByVehiclerID(vehicleManager.getAllVehicle().get(0));

assertEquals(unitManager.getAllUnit().size(), 0);
}

}