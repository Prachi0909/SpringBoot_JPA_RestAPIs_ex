package Spring_Boot4.Employeee__OneToMany.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import Spring_Boot4.Employeee__OneToMany.DTO.Request.EmployeeRequestDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.EmployeeResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Employee;

@Service
public interface EmpService {

	public EmployeeResponseDTO addEmployee(EmployeeRequestDTO EmpRequestDto);
    public EmployeeResponseDTO getEmployeeById(Long empId);
    public Employee getEmp(Long empId);
    public List<EmployeeResponseDTO> getEmps();
    public EmployeeResponseDTO deleteEmp(Long empId);
    public EmployeeResponseDTO editEmp(Long empId, EmployeeRequestDTO EmpRequestDto);
    public EmployeeResponseDTO addEmployeeToDepartment(Long bookId, Long categoryId);
    public EmployeeResponseDTO removeDepartmentFromEmployee(Long bookId, Long categoryId);
	public List<Employee> findAllSorting(String empName);
}
