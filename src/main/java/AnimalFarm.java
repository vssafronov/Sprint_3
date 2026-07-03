import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AnimalFarm {
    private ArrayList<String> farmAnimals = new ArrayList<>();

    public AnimalFarm(ArrayList<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public HashMap<Animal, Integer> countedAnimals() {
        HashMap<Animal, Integer> result = new HashMap<>();
        for (String farmAnimal : farmAnimals) {
            String[] split = farmAnimal.split(" ");
            if (Animal.containsAnimal(split[0])) {
                if (result.containsKey(Animal.valueOf(split[0]))) {
                    result.put(Animal.valueOf(split[0]), result.get(Animal.valueOf(split[0])) + 1);
                } else {
                    result.put(Animal.valueOf(split[0]), 1);
                }
            } else {
                throw new IllegalArgumentException(String.format("Please correct string \"%s\". Incorrect input data.", farmAnimal));
            }
        }
        return result;
    }


    public HashSet<String> uniqueNames() {
        HashSet<String> result = new HashSet<>();
        for (String farmAnimal : farmAnimals) {
            String[] split = farmAnimal.split(" ");
            if (split.length < 2) {
                throw new IllegalArgumentException(String.format("Please correct string \"%s\". Incorrect input data.", farmAnimal));
            } else {
                result.add(farmAnimal);
            }
        }
        return result;
    }

    public void addAnimal(Animal animal, String name) {
        farmAnimals.add(String.format("%s %s", animal, name));
    }

    public void addAnimal(Animal animal) {
        farmAnimals.add(String.format("%s %s", animal, "N"));
    }

    public void addAnimal(String name) {
        farmAnimals.add(String.format("%s %s", Animal.NOT_DEFINED, name));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String farmAnimal : farmAnimals) {
            result.append(farmAnimal).append("\n");
        }
        return result.toString();
    }
}
