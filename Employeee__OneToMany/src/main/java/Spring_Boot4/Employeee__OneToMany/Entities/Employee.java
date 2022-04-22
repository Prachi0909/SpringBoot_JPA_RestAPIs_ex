package Spring_Boot4.Employeee__OneToMany.Entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	//One department can have many employees
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	@Column(name = "Name")
	private String empName;
	@Column(name = "Salary")
	private int empSalary;
	
	@ManyToOne(targetEntity=Department.class,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="department_id",referencedColumnName="deptId")
	private Department dept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long empId, String empName, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, empSalary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName) && empSalary == other.empSalary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public Employee(String empName) {
		this.empName=empName;
	}
}
