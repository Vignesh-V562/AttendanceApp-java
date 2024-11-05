

package Attendance;

public class ClassRoom {
	private String id;
	private String Name;
	private String capacity;

	public ClassRoom(String id, String Name ,String capacity) {
		this.id = id;
		this.Name = Name;
		this.capacity = capacity;
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getCapacity() {
		return capacity;
	}
}