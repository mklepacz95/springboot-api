package pl.mklepacz.sample.springbootapi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("guiAdd")
public class AnimalGui extends VerticalLayout {

    private AnimalRepo animalRepo;

    private TextField animalName = new TextField("Podaj imie zwierzaka");
    private NumberField animalAge = new NumberField("Podaj wiek zwierzaka");
    private Button btn = new Button("OK");
    private Label label = new Label();

    @Autowired
    public AnimalGui(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
        add(animalName);
        add(animalAge);
        add(btn);

        btn.addClickListener(buttonClickEvent -> dodajZwierzaka(animalName.getValue(), animalAge.getValue().intValue()));
    }


    private void dodajZwierzaka(String name, Integer age) {
        Animal animal = new Animal();
        animal.setAge(age);
        animal.setName(name);
        label.setText(animal.toString());
        animalRepo.save(animal);
    }


}
