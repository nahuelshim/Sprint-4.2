package cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;
public interface IFruitServices {

    Fruit add (Fruit fruit);

    Fruit update (ObjectId id, Fruit fruit);

    Fruit delete (ObjectId id);

    Optional<Fruit> getOne (ObjectId id);
    List<Fruit> getAll ();


}
