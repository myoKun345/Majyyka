/**
 * Majyyka
 *
 * ConfigHandler.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import java.io.File
import majyyka.core.MajyykaIDs._
import net.minecraftforge.common.Configuration

object ConfigHandler {
    
    def main(file:File) {
        
        val config:Configuration = new Configuration(file)
        
        config.load
        
        majyykFlowerID = config.getBlock(blockCategory, majyykFlowerKey, majyykFlowerDefault).getInt
        
        majyykInkID = config.getItem(itemCategory, majyykInkKey, majyykInkDefault).getInt
        majyykBookID = config.getItem(itemCategory, majyykBookKey, majyykBookDefault).getInt
        
        config.save
        
    }

}