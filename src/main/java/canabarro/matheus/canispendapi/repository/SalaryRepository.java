package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.SalaryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends PagingAndSortingRepository<SalaryEntity, Long> {
}
