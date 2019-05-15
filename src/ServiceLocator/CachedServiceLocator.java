/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author albertosanmartinmartinez
 */
public class CachedServiceLocator implements ServiceLocator {

    private final Map<String, Object> names;

    public CachedServiceLocator () {
        this.names = new HashMap<>();
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorErrors {

        if (names.containsKey(name)) { // revisar si lo crea o no antes de la excepcion
            throw new LocatorErrors();
        }
        else {
            //this.factory = new Impl1Factory();
            //this.names.put(name, factory);
            //
            this.setConstant(name,factory.create(this));
        }
    }

    @Override
    public void setConstant(String name, Object object) throws LocatorErrors {

        if (names.containsKey(name)) {
            throw new LocatorErrors();
        }
        else {
            //this.factory = new Impl1Factory();
            this.names.put(name, object);
        }
    }

    @Override
    public Object getObject(String name) throws LocatorErrors {

        if (names.containsKey(name)) {
            return names.get(name);
        }
        throw new LocatorErrors();
    }

}

