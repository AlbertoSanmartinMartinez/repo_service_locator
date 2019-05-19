
package Test;

import ServiceLocator.*;


public class FactoryD1 implements Factory {

    @Override
    public InterfaceD create(ServiceLocator s1) throws LocatorErrors {

        try {
            int i = (int) s1.getObject("I");
            return new ImplementationD1(i);
        } catch (ClassCastException ex) {
            throw new LocatorErrors("Dependencies not found for ImplC");
        }

    }
}