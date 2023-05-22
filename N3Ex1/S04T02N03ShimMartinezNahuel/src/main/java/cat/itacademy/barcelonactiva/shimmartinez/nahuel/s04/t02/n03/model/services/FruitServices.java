package cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.repository.FruitRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FruitServices implements IFruitServices {

    @Autowired
    FruitRepository fruitRepository;

    @Override
    public Fruit add(Fruit fruit) {
        Fruit myFruit = fruitRepository.save(new Fruit(fruit.getId(), fruit.getName(), fruit.getQuantity()));
        return myFruit;
    }

    @Override
    public Fruit update(ObjectId id, Fruit fruit) {
        Optional<Fruit> fruitData = fruitRepository.findById(id);
        Fruit myFruit = null;

        if (fruitData.isPresent()) {
            myFruit = fruitData.get();
            myFruit.setName(fruit.getName());
            myFruit.setQuantity(fruit.getQuantity());
        }
        return myFruit;
    }

    @Override
    public Fruit delete(ObjectId id) {
        Fruit removedFruit = fruitRepository.findById(id).get();
        fruitRepository.delete(removedFruit);
        return removedFruit;
    }

    @Override
    public Optional<Fruit> getOne(ObjectId id) {
        Optional<Fruit> fruitaData = fruitRepository.findById(id);
        return fruitaData;
    }

    @Override
    public List<Fruit> getAll() {
        List<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.addAll(fruitRepository.findAll());
        return fruitList;
    }
}
