package minispring.core;

import com.demoApp.controller.MainPageController;
import com.minispring.core.BeanContainer;
import com.minispring.core.anotation.Controller;
import com.minispring.mvc.DispatcherServlet;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {
    private static BeanContainer beanContainer;
    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }
    @Test
    public void loadBeansTest(){
        Assertions.assertEquals(false,beanContainer.isLoaded());
        beanContainer.loadBeans("com.demoApp");
    }

    @Test
    public void getBeansTest(){
        MainPageController controller = (MainPageController) beanContainer.getBean(MainPageController.class);

        Assertions.assertEquals(true,controller instanceof MainPageController);
        DispatcherServlet dispatcherServlet = (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        Assertions.assertEquals(null,dispatcherServlet);
    }

    @Test
    public void getClassByAnnotationTest(){
        Assertions.assertEquals(true,beanContainer.isLoaded());
        Assertions.assertEquals(3,beanContainer.getClassesByAnnotation(Controller.class).size());
    }

}
