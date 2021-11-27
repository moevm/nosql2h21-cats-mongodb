import {Breed} from './../models/breed.model';
import {BreedsArray} from './../types/breeds-array.type';

function r(from = 1, to = 10): number {
    return Math.round(Math.random() * (to - from) + from);
}

function generateMock(): Breed {
    return {
        name: `cat-${r(1, 10000)}`,
        origin: `City #${r(1, 10000)}`,
        averageLifespan: r(1, 30),
        length: {
            from: r(),
            to: r() + 20,
        },
        weight: {
            from: r(),
            to: r() + 20,
        },
        characteristics: {
            gentleness: r(),
            immunity: r(),
            playfulness: r(),
            molt: r(),
            care: r(),
            intelligence: r(),
            childFriendliness: r(),
            petFriendliness: r(),
        },
        description: ``,
        image: [],
    };
}

export function generateMocks(count = 20): BreedsArray {
    const mock = [];

    for (let i = 0; i < count; i++) {
        mock.push(generateMock());
    }

    return mock;
}
