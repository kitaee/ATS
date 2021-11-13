package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


public class MemoryStoreRepository implements StoreRepository{

    private final EntityManager em;


    public MemoryStoreRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Store save(Store store) {
        long index = em.createQuery("select m from Store m", Store.class)
                .getResultList().size()+1;
        store.setCount(index);
        em.persist(store);
        return store;
    }
}
