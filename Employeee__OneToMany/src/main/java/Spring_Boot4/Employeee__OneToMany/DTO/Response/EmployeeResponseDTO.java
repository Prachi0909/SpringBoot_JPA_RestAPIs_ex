package Spring_Boot4.Employeee__OneToMany.DTO.Response;

public class EmployeeResponseDTO {
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getdepartmentName() {
		return departmentName;
	}
	public void setdepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	private long id;
	private String name;
	private int salary;
	private String departmentName;
}
