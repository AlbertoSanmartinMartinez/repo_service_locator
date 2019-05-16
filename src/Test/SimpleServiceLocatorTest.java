package Test;

import org.junit.Test;
import ServiceLocator.*;
import static org.junit.Assert.*;

public class SimpleServiceLocatorTest {
    private SimpleServiceLocator service = new SimpleServiceLocator();
    private static Factory fa1;
    private static Factory fb1;
    private static Factory fc1;
    private static Factory fd1;

    private InterfaceC c =null;
    private InterfaceB b =null;
    private InterfaceD d =null;
    private String s = "Hola";
    private int i = 3;

    private final ImplementationA1 ia1= new ImplementationA1(b,c);
    private final ImplementationB1 ib1= new ImplementationB1(d);
    private final ImplementationC1 ic1= new ImplementationC1(s);
    private final ImplementationD1 id1 = new ImplementationD1(i);

    @Test
    public void checkSetServiceMethods() throws LocatorErrors
    {


        fa1 = new FactoryA1();

        service.setService("A",fa1);
        service.setConstant("B",s);
        service.setConstant("C",b);
        service.setConstant("S",s);

        Object ob=service.getObject("A");
        System.out.println(ob.toString());
    }

}