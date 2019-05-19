package Test;
import ServiceLocator2.*;

public class FactoryC2 implements Factory<InterfaceC> {
    @Override
    public InterfaceC create(ServiceLocator s1) throws LocatorErrors {

        try {
            String s = s1.getObject(String.class);
            return new ImplementationC1(s);

        } catch (ClassCastException ex) {
            throw new LocatorErrors("Dependencies not found for ImplC");
        }

    }
}

