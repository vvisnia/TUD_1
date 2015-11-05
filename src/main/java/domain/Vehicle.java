package domain;

public class Vehicle {
	private static int VehicleID = 0;
	private int id;
	private String name;
	private String type;
	
	private String status;
	private int speed;
	public Vehicle(){
		super();
	}

	public Vehicle(String name, String type, String status, int speed){
		super();
		this.id = ++VehicleID;
		this.name = name;
		this.type = type;
		
		this.status = status;
		this.speed = speed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
