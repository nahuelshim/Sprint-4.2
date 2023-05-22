package cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository  extends MongoRepository <Fruit, ObjectId> {
}
