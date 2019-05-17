package Test;

import org.junit.Test;
import ServiceLocator.*;
import static org.junit.Assert.*;

public class SimpleServiceLocatorTest {

    private SimpleServiceLocator service;

    private static Factory fa1=new FactoryA1();
    private static Factory fb1= new FactoryB1();
    private static Factory fc1 = new FactoryC1();
    private static Factory fd1= new FactoryD1();

    private InterfaceC c;
    private InterfaceB b;
    private InterfaceD d;
    private String s = "Hola";
    private int i = 3;


    @Test
    public void checkSimpleServiceLocatorMethods() throws LocatorErrors
    {
        service = new SimpleServiceLocator();
        service.setService("FA",fa1);
        service.setService("FB",fb1);
        service.setService("FC",fc1);
        service.setService("FD",fd1);
        service.setConstant("B",b);
        service.setConstant("C",c);
        service.setConstant("D",d);
        service.setConstant("S",s);
        service.setConstant("I",i);


        assertTrue(service.getObject("FA") instanceof ImplementationA1);
        assertTrue(service.getObject("FB") instanceof ImplementationB1);
        assertTrue(service.getObject("FC") instanceof ImplementationC1);
        assertTrue(service.getObject("FD") instanceof ImplementationD1);

    }

    @Test(expected = LocatorErrors.class)
    public void notEnoughtConstantsForCreateFactory() throws LocatorErrors
    {
        service = new SimpleServiceLocator();

        service.setService("FA",fa1);
        service.setConstant("B",b);
        service.getObject("FA");



    }



}