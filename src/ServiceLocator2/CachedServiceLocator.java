/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author albertosanmartinmartinez
 */
public class CachedServiceLocator implements ServiceLocator {

    private final Map<? super Object, ? super Object> gservice;

    public CachedServiceLocator () {

        this.gservice = new HashMap<>();
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
            this.gservice.put(name,object );
        }
    }

    @Override
    public <T> T getObject(Class<T> name) throws LocatorErrors {

        if (gservice.containsKey(name)) {
            if(gservice.get(name) instanceof Factory){

                Factory<T> f;
                f = (Factory<T>) gservice.get(name);
                T ob = f.create(this);

                gservice.put(name,ob);
                return ob;
            }
            return (T) gservice.get(name);
        }
        throw new LocatorErrors("Wrong Key or missing dependencies");
    }


}

