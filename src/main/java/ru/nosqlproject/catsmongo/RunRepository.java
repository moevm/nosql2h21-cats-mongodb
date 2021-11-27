package ru.nosqlproject.catsmongo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.nosqlproject.catsmongo.repository.CatBreedRepository;

/**
 * @author Kirill Mololkin 16.11.2021
 */
@Component
@RequiredArgsConstructor
public class RunRepository {

    private final CatBreedRepository catBreedRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void testMongoRepository() {

    }
}
