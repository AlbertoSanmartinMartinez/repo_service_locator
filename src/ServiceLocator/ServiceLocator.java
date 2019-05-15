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
public interface ServiceLocator {
    
    /*
    Instala una factoria dandole un nombre y lanza la excepcion si el nombre ya esta registrado
    */
    void setService(String name, Factory factory) throws LocatorErrors;
    
    /*
    
    */
    void setConstant(String name, Object object) throws LocatorErrors;
    
    /*
    
    */
    Object getObject(String name) throws LocatorErrors;
}
