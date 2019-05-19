package Test;
import ServiceLocator2.*;

public class FactoryB2 implements Factory<InterfaceB>{

    @Override
    public InterfaceB create(ServiceLocator s1) throws LocatorErrors {

        try {
            InterfaceD d = s1.getObject(InterfaceD.class);

            return new ImplementationB1(d);
        }
        catch (ClassCastException e) {
            throw new LocatorErrors("Dependencies not found for ImplB");
        }
    }
}


