/**
 * Majyyka
 *
 * MajyykaIDs.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import scala.collection.mutable.LinkedList

object MajyykaIDs {
    
    /* Block */
    	/* Config Category */
    	val blockCategory:String = "Block IDs"
		
    	/* Default IDs */
    	val majyykFlowerDefault:Int = 2600
    	val majyykDirtDefault:Int = 2601
    	val majyykEssenceDefault:Int = 2602
    	
    	/* Current IDs */
    	var majyykFlowerID:Int = 0
    	var majyykDirtID:Int = 0
    	var majyykEssenceID:Int = 0
    	
    	/* Config Keys */
    	val majyykFlowerKey:String = "MajyykFlower"
	    val majyykDirtKey:String = "MajyykDirt"
        val majyykEssenceKey:String = "MajyykEssence"
	    
	    /* Unlocalized Names */
	    val majyykFlowerUnloc:String = "majyykFlower"
        val majyykDirtUnloc:String = "majyykDirt"
    
    /* Item */
        /* Config Category */
        val itemCategory:String = "Item IDs"
        
        /* Default IDs */
        val majyykInkDefault:Int = 7800
        val majyykBookDefault:Int = 7801
        val stickDefault:Int = 7802
        val wandCoreDefault:Int = 7803
        val wandHandleDefault:Int = 7804
        val wandDefault:Int = 7805
        
        /* Current IDs */
        var majyykInkID:Int = 0
        var majyykBookID:Int = 0
        var stickID:Int = 0
        var wandCoreID:Int = 0
        var wandHandleID:Int = 0
        var wandID:Int = 0
        
        /* Config Keys */
        val majyykInkKey:String = "MajyykInk"
        val majyykBookKey:String = "MajyykBook"
        val stickKey:String = "Sticks"
        val wandCoreKey:String = "WandCores"
        val wandHandleKey:String = "WandHandles"
        val wandKey:String = "Wand"
        
        /* Unlocalized Names */
        val majyykInkUnloc:String = "majyykInk"
        val majyykBookUnloc:String = "majyykBook"
        val stickUnloc:Array[String] = Array("stickOak", "stickBirch", "stickSpruce", "stickJungle")
        val coreUnloc:Array[String] = Array("coreIron", "coreGold", "coreEmerald", "coreDiamond", "coreRedstone")
        val handleUnloc:Array[String] = Array("handleLeather", "handleOak", "handleBirch", "handleSpruce", "handleJungle", "handleIron", "handleGold", "handleEmerald", "handleDiamond", "handleRedstone")
    
    /* Fluid */
        /* Unlocalized Names */
        val majyykEssenceUnloc:String = "majyykEssence"
    
    /* WorldGen */
        /* Config Category */
        val worldgenCategory:String = "World Gen Toggles"
        
        /* Current Setting */
        var majyykFlowerGen:Boolean = true
        
        /* Config Keys */
        val majyykFlowerGenKey:String = "MajyykFlowerGen"
    
}