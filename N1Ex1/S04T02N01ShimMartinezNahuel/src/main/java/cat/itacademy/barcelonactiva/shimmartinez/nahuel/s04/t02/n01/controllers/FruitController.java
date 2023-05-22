package cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n01.model.services.FruitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/fruita")
public class FruitController {

    @Autowired
    FruitServices fruitServices;

    @PostMapping("/add")
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit) {
        try {
            Fruit myFruit = fruitServices.add(fruit);
            return new ResponseEntity<>(myFruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> update(@PathVariable("id") int id, @RequestBody Fruit fruit) {
        Fruit fruitUpdate = fruitServices.update(id, fruit);
        if (fruitUpdate != null) {
            return new ResponseEntity<>(fruitUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruit> delete(@PathVariable("id") int id) {
        try {
            Fruit removedFruit = fruitServices.delete(id);
            return new ResponseEntity<>(removedFruit,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable("id") int id) {
        Optional<Fruit> fruitaData = fruitServices.getOne(id);

        if (fruitaData.isPresent()) {
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll() {
        try {
            List<Fruit> fruitList = fruitServices.getAll();

            if (fruitList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(fruitList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}