/**
 * Majyyka
 *
 * MajyykaIDs.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

object MajyykaIDs {
    
    /* Block */
    	/* Config Category */
    	val blockCategory:String = "Block IDs"
		
    	/* Default IDs */
    	val majyykFlowerDefault:Int = 2600
    	val majyykDirtDefault:Int = 2601
    	
    	/* Current IDs */
    	var majyykFlowerID:Int = 0
    	var majyykDirtID:Int = 0
    	
    	/* Config Keys */
    	val majyykFlowerKey:String = "MajyykFlower"
	    val majyykDirtKey:String = "MajyykDirt"
	    
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
        
        /* Current IDs */
        var majyykInkID:Int = 0
        var majyykBookID:Int = 0
        var stickID:Int = 0
        
        /* Config Keys */
        val majyykInkKey:String = "MajyykInk"
        val majyykBookKey:String = "MajyykBook"
        val stickKey:String = "Sticks"
        
        /* Unlocalized Names */
        val majyykInkUnloc:String = "majyykInk"
        val majyykBookUnloc:String = "majyykBook"
        val stickUnloc:Array[String] = Array("stickOak", "stickBirch", "stickSpruce", "stickJungle")

}