/**
 * Majyyka
 *
 * MajyykaItem.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.item

import majyyka.Majyyka
import majyyka.Majyyka._
import majyyka.core.MajyykaIDs._
import majyyka.core.lib.MajyykaReference._
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.entity.player.EntityPlayer
import java.util.List
import net.minecraft.world.World
import cpw.mods.fml.common.network.FMLNetworkHandler
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraft.item.EnumRarity
import net.minecraft.util.Icon
import net.minecraft.creativetab.CreativeTabs

class MajyykaItem(arg:Int) extends Item(arg - ITEM_ID_CORRECTION) {
    
    setCreativeTab(majyykaTab)
    
}

object MajyykInk extends MajyykaItem(majyykInkID) {
    
    setUnlocalizedName(majyykInkUnloc)
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        itemIcon = register.registerIcon(MOD_ID + ":" + majyykInkUnloc)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def addInformation(stack:ItemStack, player:EntityPlayer, info:List[_], useExtra:Boolean) {
        info.asInstanceOf[List[String]].add("Some glowing blue ink.")
        info.asInstanceOf[List[String]].add("You think it might be a")
        info.asInstanceOf[List[String]].add("good idea to smash it against")
        info.asInstanceOf[List[String]].add("a book with no apparent")
        info.asInstanceOf[List[String]].add("self-control.")
    }
    
}

object MajyykBook extends MajyykaItem(majyykBookID) {
    
    setUnlocalizedName(majyykBookUnloc)
    setMaxStackSize(1)
    
    override def getRarity(stack:ItemStack):EnumRarity = {
        
        return EnumRarity.epic
        
    }
    
    override def onItemRightClick(stack:ItemStack, world:World, player:EntityPlayer):ItemStack = {
        
        FMLNetworkHandler.openGui(player, Majyyka, 0, world, player.posX.round.asInstanceOf[Int], player.posY.round.asInstanceOf[Int], player.posZ.round.asInstanceOf[Int])
        return stack
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        itemIcon = register.registerIcon(MOD_ID + ":" + majyykBookUnloc)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def addInformation(stack:ItemStack, player:EntityPlayer, info:List[_], useExtra:Boolean) {
        info.asInstanceOf[List[String]].add("A book of ye olde majyyks.")
    }
    
}

object MajyykaStick extends MajyykaItem(stickID) {
    
    setHasSubtypes(true)
    
    private var icons:Array[Icon] = new Array[Icon](0)
    
    override def getUnlocalizedName(stack:ItemStack):String = {
        
        return "item." + stickUnloc(stack.getItemDamage())
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        icons = new Array[Icon](stickUnloc.length)
        for (i <- 0 until stickUnloc.length) {
            icons(i) = register.registerIcon(MOD_ID + ":" + stickUnloc(i))
        }
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getSubItems(id:Int, tab:CreativeTabs, list:List[_]) {
        
        for (i <- 0 until stickUnloc.length) {
            list.asInstanceOf[List[ItemStack]].add(new ItemStack(id, 1, i))
        }
        
    }
    
}
