package Spring_Boot4.Employeee__OneToMany.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import Spring_Boot4.Employeee__OneToMany.DTO.Request.DepartmentRequestDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.DepartmentResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Department;
import Spring_Boot4.Employeee__OneToMany.Exception.IdException;

@Service
public interface DeptService {

	public Department getDepartment(Long deptId);
    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequest) throws IdException;
    public DepartmentResponseDTO getDepartmentById(Long deptId);
    public List<DepartmentResponseDTO> getDepartments();
    public DepartmentResponseDTO deleteDepartment(Long deptId);
    public DepartmentResponseDTO editDepartment(Long deptId, DepartmentRequestDTO departmentRequest);
    public List<Department> findAllSorting(String name);
    
}
