package minispring.aop;


import com.demoApp.controller.HeadLineOperationController;
import com.minispring.aop.AspectWeaver;
import com.minispring.core.BeanContainer;
import com.minispring.inject.DependencyInjector;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class AspectWeaverTesT {
    @Test
    public void doAopTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        //加载了所有类
        beanContainer.loadBeans("com.demoApp");
        //AOP
        new AspectWeaver().doAopByAspectJ();
        // ioc
        new DependencyInjector().doIoc();
        //测试一个controller
        HeadLineOperationController controller = (HeadLineOperationController) beanContainer.getBean(HeadLineOperationController.class);

    }
}