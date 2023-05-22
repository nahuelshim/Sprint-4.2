package cat.itacademy.barcelonactiva.shimmartinez.nahuel.s04.t02.n03.model.domain;

import jakarta.persistence.*;
import org.bson.types.ObjectId;

@Entity
    @Table(name = "fruits")

    public class Fruit {

        @Id
        @GeneratedValue
        private ObjectId id;

        @Column(name = "name")
        private String name;

        @Column(name = "quantity")
        private int quantity;

        public Fruit(ObjectId id, String name, int quantity) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        }

        public Fruit(){}

        public ObjectId getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

