package canabarro.matheus.canispendapi.service;

import canabarro.matheus.canispendapi.controller.request.CreditRequest;
import canabarro.matheus.canispendapi.controller.response.CreditResponse;
import canabarro.matheus.canispendapi.entity.CreditEntity;
import canabarro.matheus.canispendapi.repository.CreditRepository;
import canabarro.matheus.canispendapi.service.mapper.CreditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;

    public Page<CreditResponse> findAllPageable(int index, int size) {
        Pageable page = PageRequest.of(index, size);
        Page<CreditEntity> creditEntityPage = creditRepository.findAll(page);

        return creditEntityPage.map(CreditMapper::mapperEntityToResponse);
    }

    private void save(CreditRequest request) {

    }
}
