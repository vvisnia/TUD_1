package domain;

public class Soldier {
	private static int SoldierID = 0;
	private int id;
	private String rank;
	private String name;
	private int yearOfService;
	
	public Soldier(){
		super();
	}
	public Soldier(String name, String rank, int yearOfService){
		super();
		this.id = ++SoldierID;
		this.name = name;
		this.rank = rank;
		this.yearOfService = yearOfService;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getyearOfService() {
		return yearOfService;
	}
	public void setyearOfService(int yearOfService) {
		this.yearOfService = yearOfService;
	}
	
}
