package ch.martinelli.demo.views.helloworld;

import ch.martinelli.demo.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@UIScope
@SpringComponent
@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldView.class);

    private UUID uuid = UUID.randomUUID();

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("postConstruct {}", uuid);
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("preDestroy  {}", uuid);
    }

    public HelloWorldView() {
        TextField name = new TextField("Your name");
        Button sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

}
