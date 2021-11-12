package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.CreditEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends PagingAndSortingRepository<CreditEntity, Long> {
}
