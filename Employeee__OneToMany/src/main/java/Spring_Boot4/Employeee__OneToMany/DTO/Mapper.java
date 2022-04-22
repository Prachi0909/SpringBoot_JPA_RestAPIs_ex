package Spring_Boot4.Employeee__OneToMany.DTO;

import java.util.ArrayList;
import java.util.List;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.DepartmentResponseDTO;
import Spring_Boot4.Employeee__OneToMany.DTO.Response.EmployeeResponseDTO;
import Spring_Boot4.Employeee__OneToMany.Entities.Department;
import Spring_Boot4.Employeee__OneToMany.Entities.Employee;

public class Mapper {
	
	public static EmployeeResponseDTO bookToBookResponseDto(Employee emp) {
		EmployeeResponseDTO bookResponseDto = new EmployeeResponseDTO();
        bookResponseDto.setId(emp.getEmpId());
        bookResponseDto.setName(emp.getDept().getDeptName());
        String names = null;
        bookResponseDto.setdepartmentName(names);
        return bookResponseDto;
    }

    public static List<EmployeeResponseDTO> booksToBookResponseDtos(List<Employee> emps) {
        List<EmployeeResponseDTO> bookResponseDtos = new ArrayList<>();
        for (Employee emp: emps) {
            bookResponseDtos.add(bookToBookResponseDto(emp));
        }
        return bookResponseDtos;
    }

	public static DepartmentResponseDTO categoryToCategoryResponseDto(Department category) {
		DepartmentResponseDTO categoryResponseDto = new DepartmentResponseDTO();
        categoryResponseDto.setId(category.getDeptId());
        categoryResponseDto.setName(category.getDeptName());
        List<String> names = new ArrayList<>();
        List<Employee> emps = category.getEmp();
        for (Employee emp : emps) {
            names.add(emp.getEmpName());
        }
        categoryResponseDto.setempname(names);
        return categoryResponseDto;
    }

    public static List<DepartmentResponseDTO> categoriesToCategoryResponseDtos(List<Department> categories) {
        List<DepartmentResponseDTO> categoryResponseDtos = new ArrayList<>();
        for (Department category: categories) {
            categoryResponseDtos.add(categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }
}
