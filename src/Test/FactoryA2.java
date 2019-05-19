package Test;


import ServiceLocator2.*;

public class FactoryA2 implements Factory<InterfaceA> {

    //private ServiceLocator serviceLocator;

    @Override
    public InterfaceA create(ServiceLocator s1) throws LocatorErrors {

        try {
            InterfaceB b = s1.getObject(InterfaceB.class);
            InterfaceC c = s1.getObject(InterfaceC.class);

            return new ImplementationA1(b, c);
        }
        catch (ClassCastException e) {
            throw new LocatorErrors("Dependencies not found for ImplA");
        }

    }
}
