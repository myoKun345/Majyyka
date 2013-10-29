/**
 * Majyyka
 *
 * GUIHandler.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core.gui

import cpw.mods.fml.common.network.IGuiHandler
import cpw.mods.fml.common.network.NetworkRegistry
import myokun.mods.majyyka.Majyyka
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import myokun.mods.majyyka.core.LogHelper
import java.util.logging.Level

object GUIHandler extends IGuiHandler {
    
    NetworkRegistry.instance.registerGuiHandler(Majyyka, this)
    
    override def getServerGuiElement(id:Int, player:EntityPlayer, world:World, x:Int, y:Int, z:Int):Object = {
        
        return null
        
    }
    
    override def getClientGuiElement(id:Int, player:EntityPlayer, world:World, x:Int, y:Int, z:Int):Object = {
        
        id match {
            case 0 =>
                //return new GUIMajyykBook(player)
                LogHelper.log(Level.INFO, "Majyyk Book GUI NYI")
                return null
        }
        
        return null
        
    }
    
}