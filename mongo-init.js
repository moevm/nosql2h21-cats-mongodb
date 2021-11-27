db = db.getSiblingDB('cats');

db.createCollection('CatBreed');

db.CatBreed.insertMany([
  {
    "name": "Сибирская",
    "origin": "Russia, Syber",
    "averageLifespan": 5,
    "length": {
      "from": 20,
      "to": 30
    },
    "weight": {
      "from": 3,
      "to": 10
    },
    "characteristics": {
      "gentleness": 5,
      "immunity": 7,
      "playfulness": 6,
      "molt": 3,
      "care": 8,
      "intelligence": 1,
      "childFriendliness": 10,
      "petFriendliness": 7
    },
    "description": "Very cool",
    "image": "https://avatars.mds.yandex.net/i?id=c781dacfb178232ab2d98cec9af2121e-4591504-images-thumbs&n=13"
  },
  {
    "name": "Chinese1",
    "origin": "Russia, Syber",
    "averageLifespan": 5,
    "length": {
      "from": 20,
      "to": 30
    },
    "weight": {
      "from": 12,
      "to": 20
    },
    "characteristics": {
      "gentleness": 5,
      "immunity": 7,
      "playfulness": 6,
      "molt": 3,
      "care": 8,
      "intelligence": 1,
      "childFriendliness": 10,
      "petFriendliness": 7
    },
    "description": "Very cool",
    "image": "https://avatars.mds.yandex.net/i?id=c781dacfb178232ab2d98cec9af2121e-4591504-images-thumbs&n=13"
  },
  {
    "name": "Chinese2",
    "origin": "Russia, Syber",
    "averageLifespan": 5,
    "length": {
      "from": 20,
      "to": 30
    },
    "weight": {
      "from": 12,
      "to": 20
    },
    "characteristics": {
      "gentleness": 5,
      "immunity": 7,
      "playfulness": 6,
      "molt": 3,
      "care": 8,
      "intelligence": 1,
      "childFriendliness": 10,
      "petFriendliness": 7
    },
    "description": "Very cool",
    "image": "https://avatars.mds.yandex.net/i?id=c781dacfb178232ab2d98cec9af2121e-4591504-images-thumbs&n=13"
  },
  {
    "name": "Chinese3",
    "origin": "Russia, Syber",
    "averageLifespan": 5,
    "length": {
      "from": 20,
      "to": 30
    },
    "weight": {
      "from": 12,
      "to": 20
    },
    "characteristics": {
      "gentleness": 5,
      "immunity": 7,
      "playfulness": 6,
      "molt": 3,
      "care": 8,
      "intelligence": 1,
      "childFriendliness": 10,
      "petFriendliness": 7
    },
    "description": "Very cool",
    "image": "https://avatars.mds.yandex.net/i?id=c781dacfb178232ab2d98cec9af2121e-4591504-images-thumbs&n=13"
  },
  {
    "name": "Chinese4",
    "origin": "Russia, Syber",
    "averageLifespan": 5,
    "length": {
      "from": 20,
      "to": 30
    },
    "weight": {
      "from": 12,
      "to": 20
    },
    "characteristics": {
      "gentleness": 5,
      "immunity": 7,
      "playfulness": 6,
      "molt": 10,
      "care": 8,
      "intelligence": 1,
      "childFriendliness": 10,
      "petFriendliness": 7
    },
    "description": "Very cool",
    "image": "https://avatars.mds.yandex.net/i?id=c781dacfb178232ab2d98cec9af2121e-4591504-images-thumbs&n=13"
  },
  {
    "name": "New1",
    "origin": "UK",
    "averageLifespan": 12,
    "weight": {
      "from": 6,
      "to": 9
    },
    "length": {
      "from": 11,
      "to": 20
    },
    "characteristics": {
      "gentleness": 1,
      "immunity": 1,
      "playfulness": 6,
      "molt": 5,
      "care": 4,
      "intelligence": 2,
      "childFriendliness": 7,
      "petFriendliness": 6
    },
    "description": "cool cat",
    "_class": "ru.nosqlproject.catsmongo.entity.CatBreed"
  },
  {
    "name": "New2",
    "origin": "UKA",
    "averageLifespan": 2,
    "weight": {
      "from": 6,
      "to": 9
    },
    "length": {
      "from": 11,
      "to": 20
    },
    "characteristics": {
      "gentleness": 1,
      "immunity": 1,
      "playfulness": 1,
      "molt": 1,
      "care": 1,
      "intelligence": 1,
      "childFriendliness": 1,
      "petFriendliness": 1
    },
    "description": "not cool cat",
    "_class": "ru.nosqlproject.catsmongo.entity.CatBreed"
  }
]);