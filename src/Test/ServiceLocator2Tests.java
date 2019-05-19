package Test;
import ServiceLocator2.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ServiceLocator2Tests {
    //Two types of Generic ServiceLocator for testing them
    private SimpleServiceLocator gservice;
    private CachedServiceLocator gcache;

    private Integer in= new Integer(3);
    private String s = new String("FA");
    private int i= 2;

    //4 facotries for tests

    Factory fa2 = new FactoryA2();
    Factory fb2 = new FactoryB2();
    Factory fc2 = new FactoryC2();
    Factory fd2 = new FactoryD2();

    //Interfaces needed for implementations in the tests
    private  InterfaceC c;
    private  InterfaceB b;
    private  InterfaceD d;


    @Test (expected = LocatorErrors.class)
    public void canNotSetSameType2Times () throws LocatorErrors
    {
        gservice=new SimpleServiceLocator();
        Factory fA2=new FactoryA2();

        gservice.setService(fa2.getClass(),fa2);
        gservice.setService(fA2.getClass(),fA2);
    }


    @Test //(expected = LocatorErrors.class)
    public void createSimple2ServiceLocator2() throws LocatorErrors{


        gservice = new SimpleServiceLocator();

        gservice.setService(fa2.getClass(),fa2);
        gservice.setService(fb2.getClass(),fb2);
        gservice.setService(fc2.getClass(),fc2);
        gservice.setService(fd2.getClass(),fd2);

        gservice.setConstant(InterfaceB.class,b);
        gservice.setConstant(InterfaceC.class,c);
        gservice.setConstant(InterfaceD.class,d);
        gservice.setConstant(int.class,i);
        gservice.setConstant(String.class,s);

        Object t1 = gservice.getObject(fa2.getClass());
        Object t2 = gservice.getObject(fb2.getClass());
        Object t3 = gservice.getObject(fc2.getClass());
        Object t4 = gservice.getObject(fd2.getClass());

        assertTrue(t1 instanceof ImplementationA1);
        assertTrue(t2 instanceof ImplementationB1);
        assertTrue(t3 instanceof ImplementationC1);
        assertTrue(t4 instanceof ImplementationD1);
    }

    public void cachedServiceLocatorTest() throws LocatorErrors
    {
        
    }

}
