package Test;
import ServiceLocator2.*;

public class FactoryD2 implements Factory<InterfaceD> {
    @Override
    public InterfaceD create(ServiceLocator s1) throws LocatorErrors {

        try {
            
            int i =  s1.getObject(int.class);
            return new ImplementationD1(i);

        } catch (ClassCastException ex) {
            throw new LocatorErrors();
        }

    }
}
