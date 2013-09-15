/**
 * Majyyka
 *
 * MajyykaItemBlock.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.block.util

import java.util.List
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side

class MajyykaItemBlockMeta(arg:Int) extends ItemBlock(arg) {
    
    setHasSubtypes(true)
    
    override def getMetadata(meta:Int):Int = {
        return meta
    }
    
}

class ItemMajyykDirt(id:Int) extends ItemBlock(id) {
    
    @SideOnly(Side.CLIENT)
    override def addInformation(stack:ItemStack, player:EntityPlayer, list:List[_], useExtra:Boolean) {
        
        list.asInstanceOf[List[String]].add("Wow. This stuff is so useless.")
        
    }
    
}