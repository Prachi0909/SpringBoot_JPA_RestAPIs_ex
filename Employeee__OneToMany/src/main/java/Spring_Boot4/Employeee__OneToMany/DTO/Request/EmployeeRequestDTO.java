package Spring_Boot4.Employeee__OneToMany.DTO.Request;

public class EmployeeRequestDTO {

	private String name;
	private long deptId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	
}
