/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceLocator;

import Base.*;

/**
 *
 * @author albertosanmartinmartinez
 */

public class FactoryA1 implements Factory {

    //private ServiceLocator serviceLocator;
    
    @Override
    public InterfaceA create(ServiceLocator s1) throws LocatorErrors {
        
        try {
            InterfaceB b = (InterfaceB) s1.getObject("B");
            InterfaceC c = (InterfaceC) s1.getObject("C");
            
            return new ImplementationA1(b, c);
        }
        catch (ClassCastException e) {
            throw new LocatorErrors();
        }
    }
}
