package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
