/**
 * Majyyka
 *
 * ConfigHandler.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core

import java.io.File
import myokun.mods.majyyka.core.MajyykaIDs._
import net.minecraftforge.common.Configuration

object ConfigHandler {
    
    def main(file:File) {
        
        val config:Configuration = new Configuration(file)
        
        config.load
        
        majyykFlowerID = config.getBlock(blockCategory, majyykFlowerKey, majyykFlowerDefault).getInt
        majyykDirtID = config.getBlock(blockCategory, majyykDirtKey, majyykDirtDefault).getInt
        
        majyykInkID = config.getItem(itemCategory, majyykInkKey, majyykInkDefault).getInt
        majyykBookID = config.getItem(itemCategory, majyykBookKey, majyykBookDefault).getInt
        stickID = config.getItem(itemCategory, stickKey, stickDefault).getInt
        wandCoreID = config.getItem(itemCategory, wandCoreKey, wandCoreDefault).getInt
        wandHandleID = config.getItem(itemCategory, wandHandleKey, wandHandleDefault).getInt
        wandID = config.getItem(itemCategory, wandKey, wandDefault).getInt
        clawID = config.getItem(itemCategory, clawKey, clawDefault).getInt
        
        config.save
        
    }
    
    def worldGen(file:File) {
        
        val config:Configuration = new Configuration(file)
        
        config.load
        
        majyykFlowerGen = config.get(worldgenCategory, majyykFlowerGenKey, true).getBoolean(true)
        
        config.save
        
    }

}