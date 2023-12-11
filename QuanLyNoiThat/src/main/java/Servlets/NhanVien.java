package Servlets;

public class NhanVien {
	private String ID;
	private String Name;
	private String Age;
	private String Address;
	private String Experience;

	
	public NhanVien() {
		
		
	}


	public NhanVien(String id, String name, String age, String address, String experience) {
		// TODO Auto-generated constructor stub
		super();
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
		this.setExperience(experience);
		
	}


	/**
	 * @return the iD
	 */
	public String getId() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setId(String id) {
		this.ID = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.Name = name;
	}


	/**
	 * @return the age
	 */
	public String getAge() {
		return Age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.Age = age;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.Address = address;
	}


	/**
	 * @return the experience
	 */
	public String getExperience() {
		return Experience;
	}


	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.Experience = experience;
	}

		
}
	
	
