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
import myokun.lib.util.CraftingRecipeHandler
import majyyka.api.AspectLight
import majyyka.api.AspectDark
import majyyka.api.AspectPlant
import majyyka.api.AspectWater
import majyyka.api.AspectFire
import majyyka.api.AspectStone
import majyyka.api.AspectSpace
import majyyka.api.AspectTime
import majyyka.api.AspectCrystal
import majyyka.api.AspectElectric
import majyyka.api.AspectVoid
import majyyka.api.WandCore
import majyyka.api.WandHandle
import net.minecraft.nbt.NBTTagCompound
import majyyka.api.AspectLife

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
        
        /*
         * TODO Cores and handles I need to add
         * 	Vanilla Minecraft:
         *  	Glass? (Not sure about these two because of the transparent textures)
         *  	Ice?
         * 	Majyyka:
         *  	Zillium
         *  	Majyyk Ink? (really low durability because it is literally liquid?)
         * 	TC4 Compat:
         * 		Greatwood
         * 		Silverwood
         *  	Quicksilver? (if it is still in Thaumcraft, also liquid wands could become a running gag type thing)
         */
        
        MajyykaAPI.addWandCore("oak", WandCoreOak)
        MajyykaAPI.addWandCore("birch", WandCoreBirch)
        MajyykaAPI.addWandCore("spruce", WandCoreSpruce)
        MajyykaAPI.addWandCore("jungle", WandCoreJungle)
        MajyykaAPI.addWandCore("iron", WandCoreIron)
        MajyykaAPI.addWandCore("gold", WandCoreGold)
        MajyykaAPI.addWandCore("emerald", WandCoreEmerald)
        MajyykaAPI.addWandCore("diamond", WandCoreDiamond)
        MajyykaAPI.addWandCore("redstone", WandCoreRedstone)
        MajyykaAPI.addWandCore("lapis", WandCoreLapis)
        MajyykaAPI.addWandCore("obsidian", WandCoreObsidian)
        
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
        MajyykaAPI.addWandHandle("lapis", WandHandleLapis)
        MajyykaAPI.addWandHandle("obsidian", WandHandleObsidian)
        
    }
    
    def addAspects {
        
        MajyykaAPI.addAspect("luce", AspectLight)
        MajyykaAPI.addAspect("tenebre", AspectDark)
        MajyykaAPI.addAspect("vatte", AspectWater)
        MajyykaAPI.addAspect("herbe", AspectPlant)
        MajyykaAPI.addAspect("igne", AspectFire)
        MajyykaAPI.addAspect("petrae", AspectStone)
        MajyykaAPI.addAspect("tempore", AspectTime)
        MajyykaAPI.addAspect("rymme", AspectSpace)
        MajyykaAPI.addAspect("vitre", AspectCrystal)
        MajyykaAPI.addAspect("electricitate", AspectElectric)
        MajyykaAPI.addAspect("vite", AspectLife)
        MajyykaAPI.addAspect("vacue", AspectVoid)
        
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
    
    def addWandCrafting {
        
        val bevelNames:Array[String] = Array("Black", "Red", "Green", "Brown", "Blue", 
    		"Purple", "Cyan", "LightGray", "Gray", "Pink", 
    		"Lime", "Yellow", "LightBlue", "Magenta", "Orange",
    		"White")
        
        for (i <- 0 until WandCore.cores.size()) {
            for (j <- 0 until WandHandle.handles.size()) {
                for (k <- 0 until 16) {
                    var stack:ItemStack = new ItemStack(MajyykWand, 1)
                    stack.stackTagCompound = new NBTTagCompound()
                    stack.stackTagCompound.setString("Core", MajyykaAPI.coreMapKeys.get(i))
                    stack.stackTagCompound.setString("Handle", MajyykaAPI.handleMapKeys.get(j))
                    stack.stackTagCompound.setString("Bevel", bevelNames(k))
                    CraftingRecipeHandler.addShapedRecipe(stack, "AX", "YZ", null, Array(WandCore.cores.get(MajyykaAPI.coreMapKeys.get(i)).item, WandHandle.handles.get(MajyykaAPI.handleMapKeys.get(j)).item, new ItemStack(MajyykInk, 1), new ItemStack(Item.dyePowder, 1, k)), Array('X', 'Y', 'Z', 'A'))
                }
            }
        }
        
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