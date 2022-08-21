package minispring.aop;

import com.demoApp.controller.TestAopController;
import com.minispring.aop.AspectWeaver;
import com.minispring.core.BeanContainer;
import com.minispring.inject.DependencyInjector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestAop {
    @Test
    public void testAopOne(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.demoApp");
        new AspectWeaver().doAopByAspectJ();
        new DependencyInjector().doIoc();
        TestAopController controller = (TestAopController) beanContainer.getBean(TestAopController.class);
        int say = controller.say();
        System.out.println(say);
    }
}