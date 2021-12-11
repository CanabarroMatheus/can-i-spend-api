package canabarro.matheus.canispendapi.service;

import canabarro.matheus.canispendapi.controller.request.CreditRequest;
import canabarro.matheus.canispendapi.controller.response.CreditResponse;
import canabarro.matheus.canispendapi.controller.response.IdResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;
import canabarro.matheus.canispendapi.entity.CreditEntity;
import canabarro.matheus.canispendapi.exception.ExpectedException;
import canabarro.matheus.canispendapi.repository.BalanceRepository;
import canabarro.matheus.canispendapi.repository.CreditRepository;
import canabarro.matheus.canispendapi.service.mapper.CreditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final BalanceRepository balanceRepository;

    public Page<CreditResponse> findAllPageable(int index, int size) {
        Pageable page = PageRequest.of(index, size);
        Page<CreditEntity> creditEntityPage = creditRepository.findAll(page);

        return creditEntityPage.map(CreditMapper::mapperEntityToResponse);
    }

    public CreditResponse getCredit(Long idCredit) throws ExpectedException {
        CreditEntity creditEntity = creditRepository.findById(idCredit)
                .orElseThrow(() -> new ExpectedException("Não há registro com o ID: " + idCredit));

        return CreditMapper.mapperEntityToResponse(creditEntity);
    }

    @Transactional
    public IdResponse save(@Valid CreditRequest request) throws ExpectedException {
        BalanceEntity balance = balanceRepository.findById(request.getIdBalance())
                .orElseThrow(() -> new ExpectedException("Não há registro com o ID: " + request.getIdBalance()));
        CreditEntity creditEntity = CreditMapper.mapperRequestToEntity(request, balance);
        CreditEntity credit = creditRepository.save(creditEntity);
        return IdResponse.builder().id(credit.getId()).build();
    }

    @Transactional
    public void update(@Valid CreditRequest creditRequest, Long idCredit) throws ExpectedException {
        BalanceEntity balance = creditRepository.findById(idCredit)
                .orElseThrow(() -> new ExpectedException("Não há registro com o ID: " + idCredit))
                        .getBalance();
        CreditEntity creditEntity = CreditMapper.mapperRequestToEntity(creditRequest, balance);

        creditRepository.save(creditEntity);
    }

    public void delete(Long idCredit) throws ExpectedException {
        CreditEntity creditEntity = creditRepository.findById(idCredit)
                .orElseThrow(() -> new ExpectedException("Não há registro com o ID: " + idCredit));

        creditRepository.delete(creditEntity);
    }
}
