package Test;

import org.junit.Test;
import ServiceLocator.*;
import static org.junit.Assert.*;

public class ServiceLocatorTest1 {

    private SimpleServiceLocator service;
    private CachedServiceLocator cache;

    private static Factory fa1=new FactoryA1();
    private static Factory fb1= new FactoryB1();
    private static Factory fc1 = new FactoryC1();
    private static Factory fd1= new FactoryD1();

    private InterfaceC c;
    private InterfaceB b;
    private InterfaceD d;
    private String s = "Hola";
    private int i = 3;

    @Test(expected = LocatorErrors.class)
    public void notEnoughtConstantsForCreateFactory() throws LocatorErrors // it must throw the LocatorErrors because we don't have all the dependencies for creat object in FatoryA1
    {
        service = new SimpleServiceLocator();

        service.setService("FA",fa1);
        service.setConstant("B",b);
        service.getObject("FA"); //Constant with name "C" is missing so it will not works

    }
    @Test
    public void checkSimpleServiceLocatorMethods() throws LocatorErrors
    {
        service = new SimpleServiceLocator();
        //proving if all methods works
        service.setService("FA",fa1);
        service.setService("FB",fb1);
        service.setService("FC",fc1);
        service.setService("FD",fd1);
        service.setConstant("B",b);
        service.setConstant("C",c);
        service.setConstant("D",d);
        service.setConstant("S",s);
        service.setConstant("I",i);

    //To see if all factories implements the correct type and if all the dependencies are correctly storadge
        assertTrue(service.getObject("FA") instanceof ImplementationA1);
        assertTrue(service.getObject("FB") instanceof ImplementationB1);
        assertTrue(service.getObject("FC") instanceof ImplementationC1);
        assertTrue(service.getObject("FD") instanceof ImplementationD1);

    }
    @Test
    public void cacheSimpleServicedMethods() throws LocatorErrors //
    {
        cache = new CachedServiceLocator();

        //proving if all methods works

        cache.setService("FA",fa1);
        cache.setConstant("B",b);
        cache.setConstant("C",c);

        Object ob=cache.getObject("FA"); //After that, it have to be always the same object assocaited with "FA" key
       // for(int i=1;i<100;i++) //Always the same, commented in order to have lower cost
        assertSame(ob,cache.getObject("FA")); //We look if always returns the same object
    }


    @Test
    public void notSameTypeFactoryNotSameObject() throws LocatorErrors // it must throw the LocatorErrors because we don't have all the dependencies for creat object in FatoryA1
    {
        cache = new CachedServiceLocator();

        //proving if all methods works

        cache.setService("FA",fa1);
        FactoryA1 fa2= new FactoryA1();
        cache.setService("FA2",fa2);
        cache.setConstant("B",b);
        cache.setConstant("C",c);

        Object ob=cache.getObject("FA");
        Object ob2=cache.getObject("FA2"); //even if both are Factory1 they will not be the same, just the same type

        assertNotSame(ob,ob2);
        assertTrue(ob.getClass()==ob2.getClass()); //TRIEU QUINAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ES LA CORRECTA PUTOOOOOO ALBERT
        assertSame(ob.getClass(),ob2.getClass());
        //assertSame(ob2,cache.getObject("FA2")); //We look if always returns the same object

    }

}