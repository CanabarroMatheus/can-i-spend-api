package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.BalanceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends CrudRepository<BalanceEntity, Long> {
}
