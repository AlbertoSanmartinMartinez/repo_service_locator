
package Test;

import ServiceLocator.*;


public class FactoryC1 implements Factory{

    @Override
    public InterfaceC create(ServiceLocator s1) throws LocatorErrors {

        try{
            String s = (String) s1.getObject("S");
            return new ImplementationC1(s);
        }catch (ClassCastException ex)
        {
         throw new LocatorErrors("Dependencies not found for ImplC");
        }

    }
}
