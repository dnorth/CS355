/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs355.solution;

import cs355.GUIFunctions;
import cs355.controller.MainController;
import cs355.model.Model;
import cs355.view.MainView;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny North
 */
public class CS355 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	// Fill in the parameters below with your controller, view, 
    	//   mouse listener, and mouse motion listener
    	
    	Model model = new Model();
    	MainController controller = new MainController(model);
    	MainView view = new MainView(model);
        GUIFunctions.createCS355Frame(controller,view,controller,controller);
        
        GUIFunctions.refresh();        
    }
}