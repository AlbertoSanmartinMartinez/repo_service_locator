/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator;

/**
 *
 * @author albertosanmartinmartinez
 */
public class CachedServiceLocator implements ServiceLocator {

    @Override
    public void setService(String name, Factory factory) throws LocatorErrors {
        
    }

    @Override
    public void setConstant(String name, Object object) throws LocatorErrors {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObject(String name) throws LocatorErrors {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
