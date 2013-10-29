/**
 * Majyyka
 *
 * MajyykaStuff.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core

import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.logging.Level

import cpw.mods.fml.common.event.FMLServerStartingEvent
import cpw.mods.fml.common.registry.GameRegistry
import myokun.lib.util.CraftingRecipeHandler
import myokun.mods.majyyka.api.AspectCrystal
import myokun.mods.majyyka.api.AspectDark
import myokun.mods.majyyka.api.AspectElectric
import myokun.mods.majyyka.api.AspectFire
import myokun.mods.majyyka.api.AspectLife
import myokun.mods.majyyka.api.AspectLight
import myokun.mods.majyyka.api.AspectPlant
import myokun.mods.majyyka.api.AspectSpace
import myokun.mods.majyyka.api.AspectStone
import myokun.mods.majyyka.api.AspectTime
import myokun.mods.majyyka.api.AspectVoid
import myokun.mods.majyyka.api.AspectWater
import myokun.mods.majyyka.api.MajyykaAPI
import myokun.mods.majyyka.api.WandCore
import myokun.mods.majyyka.api.WandHandle
import myokun.mods.majyyka.block.MajyykFlower
import myokun.mods.majyyka.block.MajyykImbuedDirt
import myokun.mods.majyyka.block.util.ItemMajyykDirt
import myokun.mods.majyyka.core.player.MajyykDebugCommand
import myokun.mods.majyyka.item.Core
import myokun.mods.majyyka.item.Handle
import myokun.mods.majyyka.item.Madclaw
import myokun.mods.majyyka.item.MajyykBook
import myokun.mods.majyyka.item.MajyykInk
import myokun.mods.majyyka.item.MajyykWand
import myokun.mods.majyyka.item.MajyykaStick
import myokun.mods.majyyka.potion.PotionBleed
import myokun.mods.majyyka.wand.WandCoreBirch
import myokun.mods.majyyka.wand.WandCoreDiamond
import myokun.mods.majyyka.wand.WandCoreEmerald
import myokun.mods.majyyka.wand.WandCoreGold
import myokun.mods.majyyka.wand.WandCoreIron
import myokun.mods.majyyka.wand.WandCoreJungle
import myokun.mods.majyyka.wand.WandCoreLapis
import myokun.mods.majyyka.wand.WandCoreOak
import myokun.mods.majyyka.wand.WandCoreObsidian
import myokun.mods.majyyka.wand.WandCoreRedstone
import myokun.mods.majyyka.wand.WandCoreSpruce
import myokun.mods.majyyka.wand.WandHandleBirch
import myokun.mods.majyyka.wand.WandHandleDiamond
import myokun.mods.majyyka.wand.WandHandleEmerald
import myokun.mods.majyyka.wand.WandHandleGold
import myokun.mods.majyyka.wand.WandHandleIron
import myokun.mods.majyyka.wand.WandHandleJungle
import myokun.mods.majyyka.wand.WandHandleLapis
import myokun.mods.majyyka.wand.WandHandleLeather
import myokun.mods.majyyka.wand.WandHandleOak
import myokun.mods.majyyka.wand.WandHandleObsidian
import myokun.mods.majyyka.wand.WandHandleRedstone
import myokun.mods.majyyka.wand.WandHandleSpruce
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.potion.Potion
import net.minecraft.util.ResourceLocation
import net.minecraftforge.oredict.OreDictionary
import thaumcraft.api.research.ResearchCategories

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
        GameRegistry.registerItem(Madclaw, "madclaw")
        
    }
    
    def addFluids {
        
    }
    
    def addWands {
        
        /*
         * TODO Cores and handles I need to add
         * 	Vanilla Minecraft:
         *  	Quartz
         *  	Glass? (Not sure about these two because of the transparent textures)
         *  	Ice?
         * 	Majyyka:
         *  	Zillium
         *  	Majyyk Ink? (really low durability because it is literally liquid?)
         * 	TC4 Compat:
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
    
    def addTCResearch {
        
        ResearchCategories.registerCategory("Majyyka", new ResourceLocation("majyyka", "textures/items/majyykBook.png"), new ResourceLocation("majyyka", "textures/gui/researchBG.png"))
        
    }
    
    def addCommands(event:FMLServerStartingEvent) {
        
        event.registerServerCommand(MajyykDebugCommand)
        
    }
    
    def addPotions {
        
        PotionBleed
        
    }
    
    def reflectPotion {
        
        LogHelper.log(Level.INFO, "reflecting potion")
        
        var potionTypes:Array[Potion] = null
        
        for (f <- classOf[Potion].getDeclaredFields()) {
            f.setAccessible(true)
            try {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
                    var modfield:Field = classOf[Field].getDeclaredField("modifiers")
                    
                    modfield.setAccessible(true)
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL)
                    potionTypes = f.get(null).asInstanceOf[Array[Potion]]
                    var newPotionTypes:Array[Potion] = new Array[Potion](768)
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length)
                    f.set(null, newPotionTypes)
                }
            }
            catch {
                case e:Exception =>
                    e.printStackTrace()
            }
        }
        
    }

}