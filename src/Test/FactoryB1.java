
package Test;

import ServiceLocator.*;


public class FactoryB1 implements Factory {

    @Override
    public InterfaceB create(ServiceLocator s1) throws LocatorErrors {

        try {
            InterfaceD d = (InterfaceD) s1.getObject("D");

            return new ImplementationB1(d);
        }
        catch (ClassCastException e) {
            throw new LocatorErrors();
        }
    }
}

