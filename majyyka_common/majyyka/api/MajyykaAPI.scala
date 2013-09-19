/**
 * Majyyka
 *
 * MajyykaAPI.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.api

import majyyka.core.LogHelper
import java.util.logging.Level
import java.util.LinkedList

object MajyykaAPI {
    
    var coreMapKeys:LinkedList[String] = new LinkedList[String]
    var handleMapKeys:LinkedList[String] = new LinkedList[String]
    
    // TODO Add a method for cores and handles that are only compatible with certain counterparts
    // TODO Add crafting recipes for the auto-wands - automatically of course
    
    def addWandCore(name:String, core:WandCore) {
        
        if (!WandCore.cores.containsKey(name)) {
            
            coreMapKeys.add(name)
            WandCore.cores.put(name, core)
            LogHelper.log(Level.INFO, "Registered wand core: " + name.capitalize)
            
            for (i <- 0 until WandHandle.handles.size) {
                
                if (!Wand.wands.containsKey((name + handleMapKeys.get(i).capitalize).capitalize)) {
                    
                    Wand.wands.put((name + handleMapKeys.get(i).capitalize).capitalize, new Wand(core, WandHandle.handles.get(handleMapKeys.get(i))))
                    LogHelper.log(Level.INFO, "Registered wand: " + (name + handleMapKeys.get(i).capitalize).capitalize)
                    
                }
                
            }
            
        }
        else {
            LogHelper.log(Level.SEVERE, "A mod tried to add a wand core that has already been registered!")
        }
        
    }
    
    def addWandHandle(name:String, handle:WandHandle) {
        
        if (!WandHandle.handles.containsKey(name)) {
            
            handleMapKeys.add(name)
            WandHandle.handles.put(name, handle)
            LogHelper.log(Level.INFO, "Registered wand handle: " + name.capitalize)
            
            for (i <- 0 until WandCore.cores.size) {
                
                if (!Wand.wands.containsKey(coreMapKeys.get(i) + name.capitalize)) {
                    
                    Wand.wands.put(coreMapKeys.get(i) + name.capitalize, new Wand(WandCore.cores.get(coreMapKeys.get(i)), handle))
                    LogHelper.log(Level.INFO, "Registered wand: " + (coreMapKeys.get(i) + name.capitalize).capitalize)
                    
                }
                
            }
            
        }
        else {
            LogHelper.log(Level.SEVERE, "A mod tried to add a wand handle that has already been registered!")
        }
        
    }
    
    // TODO Move wand adding to a private method
    // TODO Add a special public wand adding method, i.e. a wand not craftable with mix-and-match core and handle
    
}