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
import majyyka.core.MajyykaIDs._
import cpw.mods.fml.common.registry.GameRegistry
import majyyka.block.MajyykFlower
import majyyka.block.MajyykImbuedDirt
import majyyka.block.util.ItemMajyykDirt
import majyyka.item.MajyykInk
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import majyyka.item.MajyykBook
import majyyka.item.MajyykaStick

object MajyykaStuff {
    
    def addBlocks() {
        
        GameRegistry.registerBlock(MajyykFlower, "majyykFlower")
        GameRegistry.registerBlock(MajyykImbuedDirt, classOf[ItemMajyykDirt], "majyykDirt")
        
    }
    
    def addItems() {
        
        GameRegistry.registerItem(MajyykInk, "majyykInk")
        GameRegistry.registerItem(MajyykBook, "majyykBook")
        GameRegistry.registerItem(MajyykaStick, "majyykaStick")
        
    }
    
    def addCrafting() {
        
        GameRegistry.addShapedRecipe(new ItemStack(MajyykaStick, 2, 0), (" X ".toString(), "X  ".toString(), 'X'.toChar, new ItemStack(Block.planks, 1, 2)))
        
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykInk, 2), new ItemStack(MajyykFlower, 1))
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykInk, 3), new ItemStack(MajyykFlower, 1), new ItemStack(Item.dyePowder, 1, 12))
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykBook, 1), new ItemStack(Item.book, 1), new ItemStack(MajyykInk, 1))
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykImbuedDirt, 1), new ItemStack(MajyykInk, 1), new ItemStack(Block.dirt, 1))
        
    }

}