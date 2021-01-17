package jeep.entity;

public class Jeep {
	private long jeepId;
	private String name;
	
	public Jeep(long jeepId, String name) {
		this.jeepId = jeepId;
		this.name = name;
	}



	public long getJeepId() {
		return jeepId;
	}

	public String getName() {
		return name;
	}
}
