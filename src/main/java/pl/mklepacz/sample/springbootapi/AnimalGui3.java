package pl.mklepacz.sample.springbootapi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("guiDel")
public class AnimalGui3 extends VerticalLayout {

    private AnimalRepo animalRepo;

    private NumberField id = new NumberField("ID");
    private Button btn = new Button("OK");

    @Autowired
    public AnimalGui3(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;

        add(id);
        add(btn);
        btn.addClickListener(buttonClickEvent -> animalRepo.deleteById(id.getValue().longValue()));

    }
}
