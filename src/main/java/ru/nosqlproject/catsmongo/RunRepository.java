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
        /*CatBreed breed1 = CatBreed.builder()
                .name("Сибирская")
                .origin("Россия, Сибирь")
                .length(Map.of("from", 20, "to", 30))
                .weight(Map.of("from", 3, "to", 15))
                .characteristics(Map.of(
                        "gentleness", 5,
                        "immunity", 6,
                        "playfulness", 5,
                        "molt", 7,
                        "care", 5,
                        "intelligence", 4,
                        "childFriendliness", 7,
                        "petFriendliness", 6
                ))
                .description("Очень крутая порода")
                .images(List.of("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.proplan.ru%2Fcat%2Farticle%2Fsibirskaya-koshka%2F&psig=AOvVaw2LsjAvG9dsdK9mtZ31eQjk&ust=1635078597624000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPjUu8zE4PMCFQAAAAAdAAAAABAD",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/%D0%92%D0%B5%D1%82%D0%B5%D1%80%D0%BE%D0%BA_%D0%A1%D0%B8%D0%B1%D0%B5%D1%80%D0%B8%D1%8F.jpg/1200px-%D0%92%D0%B5%D1%82%D0%B5%D1%80%D0%BE%D0%BA_%D0%A1%D0%B8%D0%B1%D0%B5%D1%80%D0%B8%D1%8F.jpg"
                ))
                .build();

        CatBreed saved = catBreadRepository.save(breed1);

        System.out.println(saved);
        System.out.println("pppppppp");*/

        System.out.println(catBreedRepository.findAll());
    }
}
