/**
 * Majyyka
 *
 * MajyykaTab.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core

import net.minecraft.creativetab.CreativeTabs

object MajyykaTab extends CreativeTabs("Majyyka") {
    
    override def getTabIconItemIndex():Int = {
        
        return MajyykaIDs.majyykBookID
        
    }
    
}