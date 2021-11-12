package EarlyBird.ATS.config;

import EarlyBird.ATS.repository.MemberRepository;
import EarlyBird.ATS.repository.MemoryMemberRepository;
import EarlyBird.ATS.repository.MemoryStoreRepository;
import EarlyBird.ATS.repository.StoreRepository;
import EarlyBird.ATS.service.MemberService;
import EarlyBird.ATS.service.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class StoreConfig {

    DataSource dataSource;
    EntityManager em;


    public StoreConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public StoreService storeService(){
        return new StoreService(storeRepository());
    }

    @Bean
    public StoreRepository storeRepository(){
        return new MemoryStoreRepository(em);
    }
}
