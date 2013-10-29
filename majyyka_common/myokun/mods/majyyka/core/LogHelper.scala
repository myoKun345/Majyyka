/**
 * Majyyka
 *
 * LogHelper.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core

import java.util.logging.Logger
import myokun.mods.majyyka.core.lib.MajyykaReference._
import cpw.mods.fml.common.FMLLog
import java.util.logging.Level

object LogHelper {
    
    private val majyykaLogger:Logger = Logger.getLogger(MOD_ID)
    
    def init {
        
        majyykaLogger.setParent(FMLLog.getLogger)
        
    }
    
    def log(level:Level, msg:String) {
        
        majyykaLogger.log(level, msg)
        
    }

}