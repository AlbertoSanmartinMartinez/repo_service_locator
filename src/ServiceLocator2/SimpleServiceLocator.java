package ServiceLocator2;
import java.util.HashMap;
import java.util.Map;

public class SimpleServiceLocator2 implements ServiceLocator {



    private final  Map<String, ? super Object> gservice;

    public SimpleServiceLocator2 (){

        this.gservice=new HashMap<>();
    }


    @Override
    public <T> void setService(Class<T> name, Factory<T> factory) throws LocatorErrors {
        if (gservice.containsKey(name)) { // revisar si lo crea o no antes de la excepcion
            throw new LocatorErrors();
        }
        else {
            //this.factory = new Impl1Factory();
            this.gservice.put(name.toString(), factory);
        }
    }

    @Override
    public <T> void setConstant(Class<T> name, T object) throws LocatorErrors {

        if (gservice.containsKey(name)) {
            throw new LocatorErrors();
        }
        else {
            //this.factory = new Impl1Factory();
            this.gservice.put(name.toString(),object );
        }
    }

    @Override
    public <T> T getObject(Class<T> name) throws LocatorErrors {
        return (T) gservice.get(name);
    }
}
