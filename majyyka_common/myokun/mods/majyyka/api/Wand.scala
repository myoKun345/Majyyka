/**
 * Majyyka
 *
 * Wand.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.api

import net.minecraft.item.ItemStack
import java.util.LinkedHashMap

class Wand(var core:WandCore, var handle:WandHandle) {
    
    var power:Float = core.power + handle.power
    
}
object Wand {
    
    var wands:LinkedHashMap[String, Wand] = new LinkedHashMap[String, Wand]
    
}

class WandCore(var power:Float, var item:ItemStack, var aspects:Array[TAspect])
object WandCore {
    
    var cores:LinkedHashMap[String, WandCore] = new LinkedHashMap[String, WandCore]
    
}

class WandHandle(var power:Float, var item:ItemStack, var aspects:Array[TAspect])
object WandHandle {
    
    var handles:LinkedHashMap[String, WandHandle] = new LinkedHashMap[String, WandHandle]
    
}
