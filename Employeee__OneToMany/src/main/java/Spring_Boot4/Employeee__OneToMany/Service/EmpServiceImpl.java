package Spring_Boot4.Employeee__OneToMany.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Spring_Boot4.Employeee__OneToMany.DTO.Mapper;
import Spring_Boot4.Employeee__OneToMany.DTO.Request.EmployeeRequestDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.EmployeeResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Department;
import Spring_Boot4.Employeee__OneToMany.Entities.Employee;
import Spring_Boot4.Employeee__OneToMany.Repositories.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService{

	private final EmpRepo rep;
	private final DeptService ser;
	@Autowired
	public EmpServiceImpl(EmpRepo rep, DeptService ser) {
		this.rep = rep;
		this.ser = ser;
	}
	
	@Transactional
	@Override
	public EmployeeResponseDTO addEmployee(EmployeeRequestDTO EmpRequestDto) {
		// TODO Auto-generated method stub
		 Employee emp = new Employee();
	        emp.setEmpName(EmpRequestDto.getName());
	        
	        //if (EmpRequestDto.getDeptId() == null) {
	          //  throw new IllegalArgumentException("book atleast on category");
	        //}
	        Department dept = ser.getDepartment(EmpRequestDto.getDeptId());
	        emp.setDept(dept);

	        Employee emp1 = rep.save(emp);
	        return Mapper.bookToBookResponseDto(emp1);
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		Employee emp = getEmp(empId);
        return Mapper.bookToBookResponseDto(emp);
	}

	@Override
	public Employee getEmp(Long empId) {
		// TODO Auto-generated method stub
		Employee emp = rep.findById(empId).orElseThrow(() ->
        new IllegalArgumentException("cannot find book with id: " + empId));
		return emp;
	}

	@Override
	public List<EmployeeResponseDTO> getEmps() {
		// TODO Auto-generated method stub
		 List<Employee> emps = StreamSupport
	                .stream(rep.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	        return Mapper.booksToBookResponseDtos(emps);
	}

	@Override
	public EmployeeResponseDTO deleteEmp(Long empId) {
		// TODO Auto-generated method stub
		Employee emp = getEmp(empId);
        rep.delete(emp);
        return Mapper.bookToBookResponseDto(emp);
	}

	@Override
	public EmployeeResponseDTO editEmp(Long empId, EmployeeRequestDTO EmpRequestDto) {
		// TODO Auto-generated method stub
		Employee empToEdit = getEmp(empId);
        empToEdit.setEmpName(EmpRequestDto.getName());
        //if (EmpRequestDto.getDeptId() != null) {
            Department dept = ser.getDepartment(EmpRequestDto.getDeptId());
            empToEdit.setDept(dept);
        //}
        return Mapper.bookToBookResponseDto(empToEdit);
	}

	@Override
	public EmployeeResponseDTO addEmployeeToDepartment(Long empId, Long departmentId) {
		// TODO Auto-generated method stub
		Employee emp = getEmp(empId);
        Department dept = ser.getDepartment(departmentId);
        if (Objects.nonNull(emp.getDept())){
            throw new IllegalArgumentException("book already has a catogory");
        }
        emp.setDept(dept);
        dept.addBook(emp);
        return Mapper.bookToBookResponseDto(emp);
	}

	@Override
	public EmployeeResponseDTO removeDepartmentFromEmployee(Long empId, Long departmentId) {
		// TODO Auto-generated method stub
		Employee emp = getEmp(empId);
        Department dept = ser.getDepartment(departmentId);
        if (!(Objects.nonNull(emp.getDept()))){
            throw new IllegalArgumentException("book does not have a category to delete");
        }
        emp.setDept(null);
        dept.removeBook(emp);
        return Mapper.bookToBookResponseDto(emp);
	}

	@Override
	public List<Employee> findAllSorting(String empName) {
		// TODO Auto-generated method stub
		Pageable sortByName = PageRequest.of(0, 20, Sort.by("empName"));
		Pageable sortByCreditAsc = PageRequest.of(0, 20, Sort.by("credit").ascending());
		Pageable sortByNameAndCreditAsc = PageRequest.of(0, 20,Sort.by("empName").ascending().and(Sort.by("credit")));
		//List<StuEntity> stu = rep.findAll(sortByName).getContent();
		return rep.findAll(sortByName).getContent();
	}
}
