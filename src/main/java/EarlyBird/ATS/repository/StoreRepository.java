package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;

public interface StoreRepository {

    String save(Store store) throws Exception;
}