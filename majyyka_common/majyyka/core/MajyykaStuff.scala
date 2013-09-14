/**
 * Majyyka
 *
 * MajyykaStuff.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import net.minecraft.block.Block
import majyyka.block.MajyykaBlockFlower
import majyyka.core.MajyykaIDs._
import cpw.mods.fml.common.registry.GameRegistry

object MajyykaStuff {
    
    var majyykFlower:Block = null
    
    def addBlocks() {
        
        majyykFlower = new MajyykaBlockFlower(majyykFlowerID)
        
        GameRegistry.registerBlock(majyykFlower, "majyykFlower")
        
    }

}