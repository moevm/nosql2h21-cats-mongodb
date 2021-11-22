export interface Breed {
    name: string;
    origin: string;
    averageLifespan: number;
    length: {
        from: number;
        to: number;
    };
    weight: {
        from: number;
        to: number;
    };
    characteristics: {
        gentleness: number;
        immunity: number;
        playfulness: number;
        molt: number;
        care: number;
        intelligence: number;
        childFriendliness: number;
        petFriendliness: number;
    };
    description: string;
    image: ReadonlyArray<string>;
}
