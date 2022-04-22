package Spring_Boot4.Employeee__OneToMany.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deptId;
	@Column(name="Departname")
	private String deptName;
	@Column(name="NoOfEmployee")
	private int noOfEmp;
	
	//One To Many Relationship
		@OneToMany( targetEntity=Employee.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn( name = "department_id", referencedColumnName="deptId") 
		private List<Employee> emp = new ArrayList<>();
		

	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getNoOfEmp() {
		return noOfEmp;
	}
	public void setNoOfEmp(int noOfEmp) {
		this.noOfEmp = noOfEmp;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
    public Department(long deptId, String deptName, int noOfEmp) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.noOfEmp = noOfEmp ;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", noOfEmp=" + noOfEmp + "]";
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptId, deptName, noOfEmp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return deptId == other.deptId && Objects.equals(deptName, other.deptName) && noOfEmp == other.noOfEmp;
	}
	public void removeBook(Employee emp1) {
		// TODO Auto-generated method stub
		emp.add(emp1);
	}
	public void addBook(Employee emp2) {
		// TODO Auto-generated method stub
		emp.remove(emp2);
	}
	
}
