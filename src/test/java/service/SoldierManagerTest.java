package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Soldier;

import service.SoldierManager;


public class SoldierManagerTest {

	SoldierManager SoldierManager = new SoldierManager();
	private final static String name_1 = "Zenek";
	private final static String rank_1 = "General";
	private final static int yearOfService_1 = 3;
	
	@Test
	public void checkConnection(){
		assertNotNull(SoldierManager.getConnection());
	}
	@Test
	public void checkAdding(){
		
		Soldier soldier = new Soldier(name_1, rank_1, yearOfService_1);
		
		SoldierManager.clearSoldier();
		assertEquals(1,SoldierManager.addSoldier(soldier));
		
		List<Soldier> soldiers = SoldierManager.getAllSoldier();
		Soldier soldierRetrieved = soldiers.get(0);
		
		assertEquals(name_1, soldierRetrieved.getName());
		assertEquals(rank_1, soldierRetrieved.getRank());
		assertEquals(yearOfService_1, soldierRetrieved.getyearOfService());
		
	}
	@Test
	public void checkUpdatingSoldier()
	{
	SoldierManager.clearSoldier();
	SoldierManager.addSoldier(new Soldier("Grzes", "Kapitan", 12));
	Soldier soldier = SoldierManager.getAllSoldier().get(0);
	soldier.setName("Krzys");
	soldier.setRank("Szeregowy");
	soldier.setyearOfService(31);
	assertEquals(SoldierManager.updateSoldier(soldier), 1);
	assertEquals(SoldierManager.getAllSoldier().get(0).getName(), "Krzys");
	assertEquals(SoldierManager.getAllSoldier().get(0).getRank(), "Szeregowy");
	assertEquals(SoldierManager.getAllSoldier().get(0).getyearOfService(), 31);
	}
}
