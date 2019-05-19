package Test;
import ServiceLocator2.*;
import org.junit.Test;

public class ServiceLocator2Tests {
    //Two types of Generic ServiceLocator for testing them
    private SimpleServiceLocator gservice;
    private CachedServiceLocator gcache;

    private Integer in= new Integer(3);
    private String s = new String("FA");
    private int i= 2;

    //4 facotries for tests
    private Factory A2=new FactoryA2();
    private Factory B2= new FactoryB2();
    private Factory C2 = new FactoryC2();
    private Factory D2= new FactoryD2();

    //Interfaces needed for implementations in the tests
    private  InterfaceC c;
    private  InterfaceB b;
    private  InterfaceD d;


    @Test (expected = LocatorErrors.class)
    public void notCreatFactoryTest () throws LocatorErrors
    {
        gservice=new SimpleServiceLocator();


        gservice.setService("FA2".getClass(),A2);
        gservice.setService(Integer.class,B2); //Fique que ha estat asignada perque indica que la clauString ho ha estat
        gservice.getObject("FA2".getClass());
        gservice.getObject("FB2".getClass());

    }}
    /* @Test
    public void simpleServiceLocator2MethodsTest () throws LocatorErrors
    {
        gservice=new SimpleServiceLocator();


        gservice.setService("FabricaA2".getClass(),A2);
        gservice.setConstant(b.getClass(),b);
        gservice.setConstant(c.getClass(),c);
        gservice.setConstant(d.getClass(),d);
        gservice.setConstant(i.class,i);
        gservice.setConstant(s.getClass(),s);
        gservice.setService("FabricaB2".getClass(),B2);

        gservice.getObject("FabricaA2".getClass());
        gservice.getObject("FabricaB2".getClass());

    }

    @Test
    public void cachedServiceLocator2MethodsTest () throws LocatorErrors
    {
        gcache=new CachedServiceLocator();

    }
}*/
