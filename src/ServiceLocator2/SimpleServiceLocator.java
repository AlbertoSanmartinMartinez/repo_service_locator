package ServiceLocator2;
import java.util.HashMap;
import java.util.Map;

public class SimpleServiceLocator implements ServiceLocator {



    private final  Map<? super Object, ? super Object> gservice;

    public SimpleServiceLocator(){

        this.gservice=new HashMap<>();
    }


    @Override
    public <T> void setService(Class<T> name, Factory<T> factory) throws LocatorErrors {
        if (gservice.containsKey(name)) { // revisar si lo crea o no antes de la excepcion
            throw new LocatorErrors("Key had been assigned");
        }
        else {
            //this.factory = new Impl1Factory();
            this.gservice.put(name, factory);
        }
    }

    @Override
    public <T> void setConstant(Class<T> name, T object) throws LocatorErrors {

        if (gservice.containsKey(name)) {
            throw new LocatorErrors("Key had been assigned");
        }
        else {
            //this.factory = new Impl1Factory();
            this.gservice.put(name,object);
        }
    }

    @Override
    public <T> T getObject(Class<T> name) throws LocatorErrors {
    //    return (T) gservice.get(name);

        if (gservice.containsKey(name.toString())) {
            if (gservice.get(name.toString()) instanceof Factory) {
                Factory f = (Factory)gservice.get(name);
                return (T) f.create(
                        this);
            }


            return (T) gservice.get(name);

        }
        throw new LocatorErrors("Wrong Key or missing dependencies");
    }
}


