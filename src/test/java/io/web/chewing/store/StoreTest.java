package io.web.chewing.store;

import io.web.chewing.Entity.Categories;
import io.web.chewing.Entity.Store;
import io.web.chewing.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class StoreTest {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void StoreInsert(){
        IntStream.rangeClosed(1,5).forEach(i -> {
            Store store = Store.builder()
                    .name("TestStore"+i)
                    .address("TestStore"+i)
                    .file("TestStore"+i)
                    .close_time("TestStore"+i)
                    .open_time("TestStore"+i)
                    .detail("TestStore"+i)
                    .phone("TestStore"+i)
            .build();
            store.addCategories(Categories.Korean);

            storeRepository.save(store);
        } );
    }


}