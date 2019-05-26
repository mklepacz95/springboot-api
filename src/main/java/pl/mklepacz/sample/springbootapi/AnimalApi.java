package pl.mklepacz.sample.springbootapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnimalApi {

    private AnimalRepo animalRepo;


    @Autowired
    public AnimalApi(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @GetMapping("/animal")
    public Iterable<Animal> get() {
        return animalRepo.findAll();
    }

    @PostMapping("/animal")
    public Animal post(@RequestBody Animal animal) {
        return animalRepo.save(animal);
    }

    @DeleteMapping("/animal")
    public void delete(@RequestParam Long id) {
        animalRepo.deleteById(id);
    }

    @PutMapping("/animal")
    public Animal put(@RequestBody Animal animal) {
        return animalRepo.save(animal);
    }


}