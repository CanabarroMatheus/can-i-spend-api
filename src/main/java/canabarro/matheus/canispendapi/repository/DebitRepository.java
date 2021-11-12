package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.DebitEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends PagingAndSortingRepository<DebitEntity, Long> {
}
