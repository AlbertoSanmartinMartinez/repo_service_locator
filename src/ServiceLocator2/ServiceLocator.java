/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator2;

/**
 *
 * @author albertosanmartinmartinez
 */
public interface ServiceLocator {
    
    /*
    Instala una factoria dandole un nombre y lanza la excepcion si el nombre ya esta registrado
    */
    <T> void setService(Class<T> name, Factory<T> factory) throws LocatorErrors;
    
    /*
    
    */
    <T> void setConstant(Class<T> name, T object) throws LocatorErrors;
    
    /*
    
    */
    <T> T getObject(Class<T> name) throws LocatorErrors;
}
