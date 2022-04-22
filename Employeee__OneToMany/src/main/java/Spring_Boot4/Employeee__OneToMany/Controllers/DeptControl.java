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
import Spring_Boot4.Employeee__OneToMany.DTO.Request.DepartmentRequestDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.DepartmentResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Department;
import Spring_Boot4.Employeee__OneToMany.Exception.IdException;
import Spring_Boot4.Employeee__OneToMany.Service.DeptService;

@RestController
@RequestMapping("/department")
public class DeptControl {
	
	private final DeptService Service;

    @Autowired
    public DeptControl(DeptService Service) {
        this.Service = Service;
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentResponseDTO> addDepartment(
            @RequestBody final DepartmentRequestDTO departmentRequestDto) throws IdException {
    	DepartmentResponseDTO deptResponseDto = Service.addDepartment(departmentRequestDto);
        return new ResponseEntity<>(deptResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartment(@PathVariable final Long id) {
    	DepartmentResponseDTO departmentResponseDto = Service.getDepartmentById(id);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DepartmentResponseDTO>> getDepartments() {
        List<DepartmentResponseDTO> departmentResponseDtos = Service.getDepartments();
        return new ResponseEntity<>(departmentResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DepartmentResponseDTO> deleteDepartment(@PathVariable final Long id) {
    	DepartmentResponseDTO departmentResponseDto = Service.deleteDepartment(id);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<DepartmentResponseDTO> editDepartment(
            @RequestBody final DepartmentRequestDTO departmentRequestDto,
            @PathVariable final Long id) {
    	DepartmentResponseDTO departmentResponseDto = Service.editDepartment(id, departmentRequestDto);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }
    
    @GetMapping("/sortByName")
	public List<Department> findAllNameBySorting( String stuName) {
		return Service.findAllSorting(stuName);
	}
    
    
}
