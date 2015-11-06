package domain;

public class Unit {

	private static int UnitID = 0;
	private int id;
	private int soldierId;
	private int vehicleId;
	private String name;
	
	public Unit(){
		super();
	}
	
	public Unit(int soldierId, int vehicleId, String name){
		this.id = ++UnitID;
		this.soldierId = soldierId;
		this.vehicleId = vehicleId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoldierId() {
		return soldierId;
	}

	public void setSoldierId(int soldierId) {
		this.soldierId = soldierId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
