package EarlyBird.ATS.repository;

import EarlyBird.ATS.domain.Member;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.Document;
import java.util.List;
import java.util.Optional;


public class MemoryMemberRepository implements MemberRepository{
    private final EntityManager em;
    long sequence = 0L;
    public static final String Collection_member = "member";

    public MemoryMemberRepository(EntityManager em) {
        this.em = em;
    }

//    @Override
//    public Member save(Member member){
////        long index = em.createQuery("select m from Member m",Member.class)
////                .getResultList().size()+1;;
//        em.persist(member);
//        return member;
//
//    }

    @Override
    public String insertMember(Member member) throws Exception{
        Firestore dbFiresotre = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture=
                dbFiresotre.collection(Collection_member).document(member.getId()).set(member);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Optional<Member> getDetailMember(String id) throws Exception{
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(Collection_member).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
//        Member member = null;
//        if(documentSnapshot.exists()){
//            member = documentSnapshot.toObject(Member.class);
//            return Optional.ofNullable(member);
//        }
//        else
//            return null;
        return Optional.ofNullable(documentSnapshot.toObject(Member.class));
    }

//    @Override
//    public Optional<Member> findId(String name) {
//        Member member = em.find(Member.class,name);
//        return Optional.ofNullable(member);
//    }
//
//    @Override
//    public Optional<Member> findPassword(String id) {
//        Member member = em.find(Member.class, id);
//        return Optional.ofNullable(member);
//    }

//    @Override
//    public Optional<Member> findById(String id) {
//        List<Member> result = em.createQuery("select m from Member m where m.id = :id",Member.class)
//                .setParameter("id",id)
//                .getResultList();
//        return result.stream().findAny();
//    }
}