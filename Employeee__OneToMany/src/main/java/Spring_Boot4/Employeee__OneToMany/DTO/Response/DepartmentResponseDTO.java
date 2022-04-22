package Spring_Boot4.Employeee__OneToMany.DTO.Response;

import java.util.List;

public class DepartmentResponseDTO {

	private long id;
	private String name;
	private int noofEmp;
	private List<String> empname;
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
	public int getNoofEmp() {
		return noofEmp;
	}
	public void setNoofEmp(int noofEmp) {
		this.noofEmp = noofEmp;
	}
	public List<String> getempname() {
		return empname;
	}
	public void setempname(List<String> empname) {
		this.empname = empname;
	}
}
