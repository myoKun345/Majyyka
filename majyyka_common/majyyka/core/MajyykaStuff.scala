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
import net.minecraftforge.oredict.OreDictionary
import net.minecraftforge.fluids.FluidRegistry
import majyyka.api.MajyykaAPI
import majyyka.item.MajyykWand
import majyyka.item.Core
import majyyka.item.Handle

object MajyykaStuff {
    
    def addBlocks {
        
        GameRegistry.registerBlock(MajyykFlower, "majyykFlower")
        GameRegistry.registerBlock(MajyykImbuedDirt, classOf[ItemMajyykDirt], "majyykDirt")
        //GameRegistry.registerBlock(MajyykEssenceBlock, "majyykEssence")
        
    }
    
    def addItems {
        
        GameRegistry.registerItem(MajyykInk, "majyykInk")
        GameRegistry.registerItem(MajyykBook, "majyykBook")
        GameRegistry.registerItem(MajyykaStick, "majyykaStick")
        GameRegistry.registerItem(Core, "majyykWandCore")
        GameRegistry.registerItem(Handle, "majyykWandHandle")
        GameRegistry.registerItem(MajyykWand, "majyykWand")
        
    }
    
    def addFluids {
        
    }
    
    def addWands {
        
        MajyykaAPI.addWandCore("oak", WandCoreOak)
        MajyykaAPI.addWandCore("birch", WandCoreBirch)
        MajyykaAPI.addWandCore("spruce", WandCoreSpruce)
        MajyykaAPI.addWandCore("jungle", WandCoreJungle)
        MajyykaAPI.addWandCore("iron", WandCoreIron)
        MajyykaAPI.addWandCore("gold", WandCoreGold)
        MajyykaAPI.addWandCore("emerald", WandCoreEmerald)
        MajyykaAPI.addWandCore("diamond", WandCoreDiamond)
        MajyykaAPI.addWandCore("redstone", WandCoreRedstone)
        
        MajyykaAPI.addWandHandle("leather", WandHandleLeather)
        MajyykaAPI.addWandHandle("oak", WandHandleOak)
        MajyykaAPI.addWandHandle("birch", WandHandleBirch)
        MajyykaAPI.addWandHandle("spruce", WandHandleSpruce)
        MajyykaAPI.addWandHandle("jungle", WandHandleJungle)
        MajyykaAPI.addWandHandle("iron", WandHandleIron)
        MajyykaAPI.addWandHandle("gold", WandHandleGold)
        MajyykaAPI.addWandHandle("emerald", WandHandleEmerald)
        MajyykaAPI.addWandHandle("diamond", WandHandleDiamond)
        MajyykaAPI.addWandHandle("redstone", WandHandleRedstone)
        
    }
    
    def addCrafting {
        
        //GameRegistry.addShapedRecipe(new ItemStack(MajyykaStick, 2, 0), (" X ".toString(), "X  ".toString(), 'X'.toChar, new ItemStack(Block.planks, 1, 2)))
        CraftingRecipeHandler.addShapedRecipe(new ItemStack(MajyykaStick, 4, 0), " X", "X ", null, Array(new ItemStack(Block.planks, 1, 0)), Array('X'))
        CraftingRecipeHandler.addShapedRecipe(new ItemStack(MajyykaStick, 4, 1), " X", "X ", null, Array(new ItemStack(Block.planks, 1, 2)), Array('X'))
        CraftingRecipeHandler.addShapedRecipe(new ItemStack(MajyykaStick, 4, 2), " X", "X ", null, Array(new ItemStack(Block.planks, 1, 1)), Array('X'))
        CraftingRecipeHandler.addShapedRecipe(new ItemStack(MajyykaStick, 4, 3), " X", "X ", null, Array(new ItemStack(Block.planks, 1, 3)), Array('X'))
        
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykInk, 2), new ItemStack(MajyykFlower, 1))
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykInk, 3), new ItemStack(MajyykFlower, 1), new ItemStack(Item.dyePowder, 1, 12))
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykBook, 1), new ItemStack(Item.book, 1), new ItemStack(MajyykInk, 1))
        GameRegistry.addShapelessRecipe(new ItemStack(MajyykImbuedDirt, 1), new ItemStack(MajyykInk, 1), new ItemStack(Block.dirt, 1))
        
    }
    
    def addOreDict {
        
        OreDictionary.registerOre("stickWood", new ItemStack(MajyykaStick, 1, 0))
        OreDictionary.registerOre("stickWood", new ItemStack(MajyykaStick, 1, 1))
        OreDictionary.registerOre("stickWood", new ItemStack(MajyykaStick, 1, 2))
        OreDictionary.registerOre("stickWood", new ItemStack(MajyykaStick, 1, 3))
        OreDictionary.registerOre("stickOak", new ItemStack(MajyykaStick, 1, 0))
        OreDictionary.registerOre("stickBirch", new ItemStack(MajyykaStick, 1, 1))
        OreDictionary.registerOre("stickSpruce", new ItemStack(MajyykaStick, 1, 2))
        OreDictionary.registerOre("stickJungle", new ItemStack(MajyykaStick, 1, 3))
        
    }

}