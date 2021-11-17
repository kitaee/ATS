package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import EarlyBird.ATS.domain.Store;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;


public class MemoryStoreRepository implements StoreRepository {

    Long index = 0L;
    private final EntityManager em;


    public MemoryStoreRepository(EntityManager em) {
        this.em = em;
    }

    public static final String Collection_member = "store";

    @Override
    public String save(Store store) throws Exception {
        Firestore dbFiresotre = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                dbFiresotre.collection(Collection_member).document(store.getId()).set(store);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    @Override
    public Optional<Store> getDetailStore(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(Collection_member).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        return Optional.ofNullable(documentSnapshot.toObject(Store.class));
    }
}
