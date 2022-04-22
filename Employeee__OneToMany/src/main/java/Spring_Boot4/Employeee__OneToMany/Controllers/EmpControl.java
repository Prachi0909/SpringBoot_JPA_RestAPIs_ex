package Spring_Boot4.Employeee__OneToMany.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Spring_Boot4.Employeee__OneToMany.DTO.Request.EmployeeRequestDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.EmployeeResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Employee;
import Spring_Boot4.Employeee__OneToMany.Service.EmpService;


@RestController
@RequestMapping("/employee")
public class EmpControl {
	
	private final EmpService Service;

    @Autowired
    public EmpControl(EmpService Service) {
        this.Service = Service;
    }
    
    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody final EmployeeRequestDTO empRequestDto) {
    	EmployeeResponseDTO empResponseDto = Service.addEmployee(empRequestDto);
        return new ResponseEntity<>(empResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable final Long id) {
    	EmployeeResponseDTO empResponseDto = Service.getEmployeeById(id);
        return new ResponseEntity<>(empResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployee() {
        List<EmployeeResponseDTO> empResponseDtos = Service.getEmps();
        return new ResponseEntity<>(empResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeResponseDTO> deleteBook(@PathVariable final Long id) {
    	EmployeeResponseDTO empResponseDto = Service.deleteEmp(id);
        return new ResponseEntity<>(empResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<EmployeeResponseDTO> editEmp(@RequestBody final EmployeeRequestDTO empRequestDto,
                                                    @PathVariable final Long id) {
    	EmployeeResponseDTO empResponseDto = Service.editEmp(id, empRequestDto);
        return new ResponseEntity<>(empResponseDto, HttpStatus.OK);
    }

    @PostMapping("/addEmployeee/{departmentId}/to/{empId}")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@PathVariable final Long departmentId,
                                                       @PathVariable final Long empId) {
    	EmployeeResponseDTO empResponseDto = Service.addEmployeeToDepartment(departmentId, empId);
        return new ResponseEntity<>(empResponseDto, HttpStatus.OK);
    }

    @PostMapping("/removeEmployee/{departmentId}/from/{empId}")
    public ResponseEntity<EmployeeResponseDTO> removeEmployee(@PathVariable final Long departmentId,
                                                          @PathVariable final Long empId) {
    	EmployeeResponseDTO empResponseDto = Service.removeDepartmentFromEmployee(empId, departmentId);
        return new ResponseEntity<>(empResponseDto, HttpStatus.OK);
    }
	  
    @GetMapping("/sortByName")
   	public List<Employee> findAllNameBySorting( String empName) {
   		return Service.findAllSorting(empName);
   	}
       
}
