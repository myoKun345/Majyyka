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
    
    private var coreMapKeys:LinkedList[String] = new LinkedList[String]
    private var handleMapKeys:LinkedList[String] = new LinkedList[String]
    
    def addWandCore(name:String, core:WandCore) {
        
        if (!WandCore.cores.containsKey(name)) {
            
            coreMapKeys.add(name)
            WandCore.cores.put(name, core)
            
            for (i <- 0 until WandHandle.handles.size) {
                
                if (!Wand.wands.containsKey(name + handleMapKeys.get(i).substring(0, 1).toUpperCase() + handleMapKeys.get(i).substring(1))) {
                    
                    LogHelper.log(Level.INFO, name + handleMapKeys.get(i).substring(0, 1).toUpperCase() + handleMapKeys.get(i).substring(1))
                    Wand.wands.put(name + handleMapKeys.get(i).substring(0, 1).toUpperCase() + handleMapKeys.get(i).substring(1), new Wand(core, WandHandle.handles.get(handleMapKeys.get(i))))
                    
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
            
            for (i <- 0 until WandCore.cores.size) {
                
                if (!Wand.wands.containsKey(coreMapKeys.get(i) + name.substring(0, 1).toUpperCase() + name.substring(1))) {
                    
                    LogHelper.log(Level.INFO, coreMapKeys.get(i) + name.substring(0, 1).toUpperCase() + name.substring(1))
                    Wand.wands.put(coreMapKeys.get(i) + name.substring(0, 1).toUpperCase() + name.substring(1), new Wand(WandCore.cores.get(coreMapKeys.get(i)), handle))
                    
                }
                
            }
            
        }
        else {
            LogHelper.log(Level.SEVERE, "A mod tried to add a wand handle that has already been registered!")
        }
        
    }
    
}