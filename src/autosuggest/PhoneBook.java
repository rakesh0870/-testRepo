package autosuggest;

public class PhoneBook {
	
	public PhoneBook(int id, String number, String name) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
	}
	private int id;
	private String number;
	private String name;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
