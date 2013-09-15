/**
 * Majyyka
 *
 * MajyykaTab.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import net.minecraft.creativetab.CreativeTabs

object MajyykaTab extends CreativeTabs("Majyyka") {
    
    override def getTabIconItemIndex():Int = {
        
        return MajyykaIDs.majyykFlowerID
        
    }
    
}