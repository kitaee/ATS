package EarlyBird.ATS.service;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;
import EarlyBird.ATS.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public String register(Store store) throws Exception{
        storeRepository.save(store);
        return store.getBusinessName();
    }

    public Optional<Store> findStore(String id) throws Exception{
        Store store = new Store();
        store = storeRepository.getDetailStore(id).get();
        return Optional.ofNullable(store);
    }
}