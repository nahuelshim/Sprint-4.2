package cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n02.model.domain.Fruit;
import java.util.List;
import java.util.Optional;
public interface IFruitServices {

    Fruit add (Fruit fruit);
    Fruit update (int id, Fruit fruit);
    Fruit delete (int id);
    Optional<Fruit> getOne (int id);
    List<Fruit> getAll ();


}
