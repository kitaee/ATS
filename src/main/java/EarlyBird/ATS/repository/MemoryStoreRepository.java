package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


public class MemoryStoreRepository implements StoreRepository{

    Long index=0L;
    private final EntityManager em;


    public MemoryStoreRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Store save(Store store) {
        store.setCount(++index);
        System.out.println(store.getCount());
        em.persist(store);
        return store;
    }
}
