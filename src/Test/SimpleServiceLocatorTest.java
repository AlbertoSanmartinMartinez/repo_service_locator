package Test;

import org.junit.Test;
import ServiceLocator.*;
import static org.junit.Assert.*;

public class SimpleServiceLocatorTest {
    public SimpleServiceLocator service = new SimpleServiceLocator();

    @Test
    public void checkSetService() throws LocatorErrors
    {
        Factory fa1;
        InterfaceC c=null;
        InterfaceB b=null;
        InterfaceD d=null;
        String s1 ="Hola";
        ImplementationB1 s= new ImplementationB1(d);
        ImplementationC1 b1= new ImplementationC1("HI");
        //InterfaceC b=null;
        fa1 = new FactoryC1();
        service.setService("A",fa1);
        service.setConstant("B",s);
        service.setConstant("C",b1);
        service.setConstant("S",s1);

        Object ob=service.getObject("A");
        System.out.println(ob.toString());
    }

}