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
import myokun.lib.util.CraftingRecipeHandler

object MajyykaAPI {
    
    var coreMapKeys:LinkedList[String] = new LinkedList[String]
    var handleMapKeys:LinkedList[String] = new LinkedList[String]
    var aspectMapKeys:LinkedList[String] = new LinkedList[String]
    
    // TODO Add a method for cores and handles that are only compatible with certain counterparts
    // TODO Add crafting recipes for the auto-wands - automatically of course
    
    /**
     * Adds a wand core that is able to be mixed-and-matched with all other handles.
     * Do not use this if you want your core to be compatible with only your specified handles!
     * @param name - The name of the core; must be lowercase.
     * @param core - The actual WandCore object.
     */
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
    
    /**
     * Adds a wand handle that is able to be mixed-and-matched with all other cores.
     * Do not use this if you want your handle to be compatible with only your specified cores!
     * @param name - The name of the handle; must be lowercase.
     * @param handle - The actual WandHandle object.
     */
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
    
    def addAspect(name:String, aspect:TAspect) {
        
        if (!AspectRegistry.aspects.containsKey(name)) {
            
            aspectMapKeys.add(name)
            AspectRegistry.aspects.put(name, aspect)
            LogHelper.log(Level.INFO, "Registered majyyk aspect: " + name.capitalize)
            
        }
        else {
            LogHelper.log(Level.SEVERE, "A mod tried to add a majyyk aspect that has already been registered!")
        }
        
    }
    
    // TODO Move wand adding to a private method
    // TODO Add a special public wand adding method, i.e. a wand not craftable with mix-and-match core and handle
    
}