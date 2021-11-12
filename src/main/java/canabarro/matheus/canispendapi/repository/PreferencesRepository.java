package canabarro.matheus.canispendapi.repository;

import canabarro.matheus.canispendapi.entity.PreferencesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends PagingAndSortingRepository<PreferencesEntity, Long> {
}
