package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.BillEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends PagingAndSortingRepository<BillEntity, Long> {
}
