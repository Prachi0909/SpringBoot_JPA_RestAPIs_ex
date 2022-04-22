package Spring_Boot4.Employeee__OneToMany.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Spring_Boot4.Employeee__OneToMany.Entities.Department;

@Repository
public interface DeptRepo extends JpaRepository<Department, Long>{

	
}
