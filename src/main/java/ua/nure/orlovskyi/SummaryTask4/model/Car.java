package ua.nure.orlovskyi.SummaryTask4.model;


public class Car {
	private Integer id;
	private Brand brand;
	private CarType carType;
	private String color;
	private Double price;
	private Boolean isAvailable;
	private String photo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", carType=" + carType + ", color=" + color + ", price=" + price
				+ ", isAvailable=" + isAvailable + ", photo=" + photo + "]";
	}
	
	

}
