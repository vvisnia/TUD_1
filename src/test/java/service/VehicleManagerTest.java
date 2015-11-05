package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Vehicle;

import service.VehicleManager;

public class VehicleManagerTest {






		VehicleManager VehicleManager = new VehicleManager();
		private final static String name_1 = "Maluch";
		private final static String type_1 = "Limuzyna";
		private final static String status_1 = "Niezniszczalny";
		private final static int speed_1 = 900;
		
		Vehicle vehicle;
		
		@Test
		public void checkConnection(){
			assertNotNull(VehicleManager.getConnection());
		}
		@Test
		public void checkAdding(){
			
			Vehicle vehicle = new Vehicle(name_1, type_1, status_1, speed_1);
			
			VehicleManager.clearVehicle();
			assertEquals(1,VehicleManager.addVehicle(vehicle));
			
			List<Vehicle> vehicles = VehicleManager.getAllVehicle();
			Vehicle vehicleRetrieved = vehicles.get(0);
			
			assertEquals(name_1, vehicleRetrieved.getName());
			assertEquals(type_1, vehicleRetrieved.getType());
			assertEquals(status_1, vehicleRetrieved.getStatus());
			assertEquals(speed_1, vehicleRetrieved.getSpeed());
			
		}
		@Test
		public void checkUpdatingVehicle()
		{
		VehicleManager.clearVehicle();
		VehicleManager.addVehicle(new Vehicle("Rudy", "Czolg", "Sprawny", 12));
		Vehicle vehicle = VehicleManager.getAllVehicle().get(0);
		vehicle.setName("Blondyn");
		vehicle.setType("Tankietka");
		vehicle.setStatus("Popsuty");
		vehicle.setSpeed(31);
		assertEquals(VehicleManager.updateVehicle(vehicle), 1);
		assertEquals(VehicleManager.getAllVehicle().get(0).getName(), "Blondyn");
		assertEquals(VehicleManager.getAllVehicle().get(0).getType(), "Tankietka");
		assertEquals(VehicleManager.getAllVehicle().get(0).getStatus(), "Popsuty");
		assertEquals(VehicleManager.getAllVehicle().get(0).getSpeed(), 31);
		}
		
		@Test
		public void checkGettingVehicleByID()
		{
		VehicleManager.clearVehicle();
		Vehicle vehicleRetrieved = null;
		VehicleManager.addVehicle(new Vehicle("Obama", "HMV", "Czarny", 12));
		vehicle = VehicleManager.getAllVehicle().get(0);
		vehicleRetrieved = VehicleManager.getVehicleById(vehicle);
		assertEquals(vehicle.getId(), vehicleRetrieved.getId());
		assertEquals(vehicle.getName(), vehicleRetrieved.getName());
		assertEquals(vehicle.getType(), vehicleRetrieved.getType());
		assertEquals(vehicle.getSpeed(), vehicleRetrieved.getSpeed());
		}
		
		@Test
		public void checkClearingVehicle()
		{
		VehicleManager.clearVehicle();
		assertEquals(VehicleManager.getAllVehicle().size(), 0);
		}
		@Test
		public void checkDeleting()
		{
		assertEquals(VehicleManager.addVehicle(new Vehicle("Opel", "Limuzyna", "Zniszczony", 2)), 1);
		vehicle = VehicleManager.getAllVehicle().get(0);
		assertEquals(VehicleManager.deleteVehicle(vehicle) , 1);
		}
		
	

}
