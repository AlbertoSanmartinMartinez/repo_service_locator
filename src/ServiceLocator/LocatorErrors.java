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
public class LocatorErrors extends Exception {
    private String msg;

    public LocatorErrors(String msg)
    {
        this.msg=msg;
        System.out.println(msg);
    }
}
