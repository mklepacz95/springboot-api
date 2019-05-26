package pl.mklepacz.sample.springbootapi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("guiAll")
public class AniamalGui2 extends VerticalLayout {

    private AnimalRepo animalRepo;

    private Button btn = new Button("Pokaz wyszstkie");
    private Label label = new Label();

    @Autowired
    public AniamalGui2(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
        add(btn);
        add(label);

        btn.addClickListener(buttonClickEvent -> uzupelnijLabel());
    }

    private void uzupelnijLabel() {
        label.setText(animalRepo.findAll().toString());
    }

}
