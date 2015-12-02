package biz.cosee.service;

import biz.cosee.entity.Candy;
import biz.cosee.entity.CandyChangeEvent;
import biz.cosee.repository.CandyChangeEventRepository;
import biz.cosee.repository.CandyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@Service
public class CandyService {

    private static Logger LOGGER = LoggerFactory.getLogger(CandyService.class);

    private CandyRepository candyRepository;
    private CandyChangeEventRepository candyChangeEventRepository;

    @Autowired
    public CandyService(CandyRepository candyRepository, CandyChangeEventRepository candyChangeEventRepository) {
        this.candyRepository = candyRepository;
        this.candyChangeEventRepository = candyChangeEventRepository;
    }

    public List<Candy> getAllCandy() {
        return candyRepository.findAll();
    }

    public Candy getCandyById(long candyId) {
        return candyRepository.findOne(candyId);
    }

    @Transactional
    public void updateCandyStockAmount(long candyId, long stockAmount) {
        Candy candy = candyRepository.findOne(candyId);
        candy.setStockAmount(stockAmount);
        candyRepository.save(candy);
        candyChangeEventRepository.save(new CandyChangeEvent(null, candyId, "UPDATED"));
    }
}
