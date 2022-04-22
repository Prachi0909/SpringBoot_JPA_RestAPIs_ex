package Spring_Boot4.Employeee__OneToMany.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Spring_Boot4.Employeee__OneToMany.DTO.Mapper;
import Spring_Boot4.Employeee__OneToMany.DTO.Request.DepartmentRequestDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.DepartmentResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Department;
import Spring_Boot4.Employeee__OneToMany.Exception.IdException;
import Spring_Boot4.Employeee__OneToMany.Repositories.DeptRepo;

@Service
public class DeptServiceImpl implements DeptService{

	private final DeptRepo rep;
	
	@Autowired
	public DeptServiceImpl(DeptRepo rep) {
		this.rep = rep;
	}
	
	@Override
	public Department getDepartment(Long deptId) {
		// TODO Auto-generated method stub
		 return rep.findById(deptId).orElseThrow(() ->
         new IllegalArgumentException("could not find category with id: " + deptId));
	}

	@Override
	public DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequest) throws IdException {
		// TODO Auto-generated method stub
		Department dept = new Department();
		for(Department e: rep.findAll()) {
			if(e.getDeptId() == dept.getDeptId() ) {
				throw new IdException("Your Id is already exists");
			}
		}
		//Department dept = new Department();
        dept.setDeptName(departmentRequest.getName());
        rep.save(dept);
        return Mapper.categoryToCategoryResponseDto(dept);
	}

	@Override
	public DepartmentResponseDTO getDepartmentById(Long deptId) {
		// TODO Auto-generated method stub
		Department dept = getDepartment(deptId);
        return Mapper.categoryToCategoryResponseDto(dept);
	}

	@Override
	public List<DepartmentResponseDTO> getDepartments() {
		// TODO Auto-generated method stub
		List<Department> depts = StreamSupport
                .stream(rep.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.categoriesToCategoryResponseDtos(depts);
	}

	@Override
	public DepartmentResponseDTO deleteDepartment(Long deptId) {
		// TODO Auto-generated method stub
		Department dept = getDepartment(deptId);
        rep.delete(dept);
        return Mapper.categoryToCategoryResponseDto(dept);
	}

	@Transactional
	@Override
	public DepartmentResponseDTO editDepartment(Long deptId, DepartmentRequestDTO departmentRequest) {
		// TODO Auto-generated method stub
		Department departmentToEdit = getDepartment(deptId);
        departmentToEdit.setDeptName(departmentRequest.getName());
        return Mapper.categoryToCategoryResponseDto(departmentToEdit);
	}
	
	public List<Department> findAllSorting(String name) {
		// TODO Auto-generated method stub
		Pageable sortByName = PageRequest.of(0, 20, Sort.by("deptName"));
		Pageable sortByCreditAsc = PageRequest.of(0, 20, Sort.by("credit").ascending());
	
		Pageable sortByNameAndCreditAsc = PageRequest.of(0, 20,Sort.by("empName").ascending().and(Sort.by("credit")));
	
		//List<StuEntity> stu = rep.findAll(sortByName).getContent();
		return rep.findAll(sortByName).getContent();
	}

}
