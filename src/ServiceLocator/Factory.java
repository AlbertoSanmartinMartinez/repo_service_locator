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
public interface Factory {
    
    Object create(ServiceLocator serviceLocator) throws LocatorErrors;
}
