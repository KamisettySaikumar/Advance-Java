package ProductTable;

public class Product {
	private int id;
	private String name;
	private double Prize;
	public Product(int id, String name, double prize) {
		super();
		this.id = id;
		this.name = name;
		Prize = prize;
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
	public double getPrize() {
		return Prize;
	}
	public void setPrize(double prize) {
		Prize = prize;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", Prize=" + Prize + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getPrize()=" + getPrize() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
	
