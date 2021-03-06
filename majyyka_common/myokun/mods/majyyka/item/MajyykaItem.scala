/**
 * Majyyka
 *
 * MajyykaItem.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.item

import myokun.mods.majyyka.Majyyka
import myokun.mods.majyyka.Majyyka._
import myokun.mods.majyyka.core.MajyykaIDs._
import myokun.mods.majyyka.core.lib.MajyykaReference._
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
import myokun.mods.majyyka.api.Wand
import java.util.LinkedList
import net.minecraft.nbt.NBTTagCompound
import myokun.lib.util.StringUtilities
import myokun.mods.majyyka.api.MajyykaAPI
import net.minecraft.entity.EntityLivingBase
import net.minecraft.util.DamageSource
import java.util.Random
import net.minecraft.potion.PotionEffect
import net.minecraft.potion.PotionHelper
import myokun.mods.majyyka.potion.PotionBleed
import myokun.mods.majyyka.core.LogHelper
import java.util.logging.Level
import net.minecraft.potion.Potion

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
    override def getIconFromDamage(dmg:Int):Icon = {
        
        return icons(dmg)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getSubItems(id:Int, tab:CreativeTabs, list:List[_]) {
        
        for (i <- 0 until stickUnloc.length) {
            list.asInstanceOf[List[ItemStack]].add(new ItemStack(id, 1, i))
        }
        
    }
    
}

object Handle extends MajyykaItem(wandHandleID) {
    
    setHasSubtypes(true)
    
    private var icons:Array[Icon] = new Array[Icon](0)
    
    override def getUnlocalizedName(stack:ItemStack):String = {
        
        return "item." + handleUnloc(stack.getItemDamage)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        icons = new Array[Icon](handleUnloc.length)
        for (i <- 0 until handleUnloc.length) {
            icons(i) = register.registerIcon(MOD_ID + ":" + handleUnloc(i))
        }
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getIconFromDamage(dmg:Int):Icon = {
        
        return icons(dmg)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getSubItems(id:Int, tab:CreativeTabs, list:List[_]) {
        
        for (i <- 0 until handleUnloc.length) {
            list.asInstanceOf[List[ItemStack]].add(new ItemStack(id, 1, i))
        }
        
    }
    
}

object Core extends MajyykaItem(wandCoreID) {
    
    setHasSubtypes(true)
    
    private var icons:Array[Icon] = new Array[Icon](0)
    
    override def getUnlocalizedName(stack:ItemStack):String = {
        
        return "item." + coreUnloc(stack.getItemDamage)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        icons = new Array[Icon](coreUnloc.length)
        for (i <- 0 until coreUnloc.length) {
            icons(i) = register.registerIcon(MOD_ID + ":" + coreUnloc(i))
        }
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getIconFromDamage(dmg:Int):Icon = {
        
        return icons(dmg)
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getSubItems(id:Int, tab:CreativeTabs, list:List[_]) {
        
        for (i <- 0 until coreUnloc.length) {
            list.asInstanceOf[List[ItemStack]].add(new ItemStack(id, 1, i))
        }
        
    }
    
}

object MajyykWand extends MajyykaItem(wandID) {
    
    private var coreTypes:LinkedList[String] = new LinkedList[String](MajyykaAPI.coreMapKeys)
    private var handleTypes:LinkedList[String] = new LinkedList[String](MajyykaAPI.handleMapKeys)
    val bevelNames:Array[String] = Array("Black", "Blue", "Brown", "Cyan", "Gray", 
    		"Green", "LightBlue", "LightGray", "Lime", "Magenta", 
    		"Orange", "Pink", "Purple", "Red", "White",
    		"Yellow")
    private var icons:Array[Icon] = new Array[Icon](0)
    
    override def getUnlocalizedName(stack:ItemStack):String = {
        
        return "item.majyykWand"
        
    }
    
    override def getRarity(stack:ItemStack):EnumRarity = {
        
        return EnumRarity.rare
        
    }
    
    /*@SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        icons = new Array[Icon](wandTypes.size())
        for (i <- 0 until wandTypes.size()) {
            icons(i) = register.registerIcon(MOD_ID + ":wand" + wandTypes.get(i).capitalize)
        }
        
    }
    
    @SideOnly(Side.CLIENT)
    override def getIcon(stack:ItemStack, pass:Int):Icon = {
        
        if (stack.hasTagCompound()) {
            return icons(stack.stackTagCompound.getInteger("WandTypeIndex"))
        }
        return null
        
    }*/
    
    @SideOnly(Side.CLIENT)
    override def getSubItems(id:Int, tab:CreativeTabs, list:List[_]) {
        
        for (i <- 0 until coreTypes.size()) {
            for (j <- 0 until handleTypes.size()) {
                var stack:ItemStack = new ItemStack(id, 1, 0)
	            stack.stackTagCompound = new NBTTagCompound()
	            stack.stackTagCompound.setString("Core", coreTypes.get(i))
	            stack.stackTagCompound.setString("Handle", handleTypes.get(j))
	            stack.stackTagCompound.setString("Bevel", bevelNames(0))
	        	list.asInstanceOf[List[ItemStack]].add(stack)
            }
        }
        
    }
    
    @SideOnly(Side.CLIENT)
    override def addInformation(stack:ItemStack, player:EntityPlayer, list:List[_], useExtra:Boolean) {
        
        if (stack.hasTagCompound()) {
        	list.asInstanceOf[List[String]].add("Core: " + stack.stackTagCompound.getString("Core").capitalize)
        	list.asInstanceOf[List[String]].add("Handle: " + stack.stackTagCompound.getString("Handle").capitalize)
        }
        else {
            list.asInstanceOf[List[String]].add("This wand doesn't have NBT.")
            list.asInstanceOf[List[String]].add("You will need to make a new one.")
        }
        
    }
    
}

object Madclaw extends MajyykaItem(clawID) {
    
    val rand:Random = new Random
    
    val dmgVsEnt:Float = 6.0F
    
    setMaxDamage(450)
    
    override def hitEntity(stack:ItemStack, perpetrator:EntityLivingBase, target:EntityLivingBase):Boolean = {
        if (perpetrator.attackEntityFrom(DamageSource.causeMobDamage(target), dmgVsEnt)) {
            stack.damageItem(1, target)
            perpetrator.addPotionEffect(new PotionEffect(PotionBleed.getId(), 1200, 0))
        }
        
        return true
    }
    
}
