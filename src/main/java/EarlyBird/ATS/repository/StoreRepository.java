package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;

import java.util.Optional;

public interface StoreRepository {

    String save(Store store) throws Exception;
    Optional<Store> getDetailStore(String id) throws Exception;
}