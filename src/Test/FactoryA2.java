package Test;


import ServiceLocator2.*;

public class FactoryA2 implements Factory<InterfaceA> {

    //private ServiceLocator serviceLocator;

    @Override
    public ImplementationA1 create(ServiceLocator s1) throws LocatorErrors {

        try {
            InterfaceB b = s1.getObject(InterfaceB.class);
            InterfaceC c = (InterfaceC) s1.getObject(InterfaceC.class);

            return new ImplementationA1(b, c);
        } catch (ClassCastException e) {
            throw new LocatorErrors();
        }

    }
}
