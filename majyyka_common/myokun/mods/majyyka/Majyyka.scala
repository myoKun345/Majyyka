/**
 * Majyyka
 *
 * Majyyka.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod
import myokun.mods.majyyka.core.network.PacketHandler
import cpw.mods.fml.common.Mod.Instance
import myokun.mods.majyyka.core.proxy.CommonProxy
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import net.minecraft.creativetab.CreativeTabs
import myokun.mods.majyyka.core.MajyykaStuff
import myokun.mods.majyyka.core.lib.MajyykaReference._
import myokun.mods.majyyka.core.ConfigHandler
import java.io.File
import myokun.mods.majyyka.core.MajyykaTab
import myokun.mods.majyyka.core.gui.GUIHandler
import myokun.mods.majyyka.core.LogHelper
import cpw.mods.fml.common.registry.GameRegistry
import myokun.mods.majyyka.core.MajyykaWorldGen
import java.util.logging.Level
import myokun.mods.majyyka.api.Wand
import net.minecraftforge.common.MinecraftForge
import myokun.mods.majyyka.core.player.PlayerTracker
import cpw.mods.fml.common.event.FMLServerStartingEvent
import myokun.mods.majyyka.core.MajyykaEventHooks
import net.minecraft.potion.Potion

@Mod(modid="Majyyka", name="Majyyka", version="0.0.01.@@BUILD@@", modLanguage="scala")
@NetworkMod(channels=Array("majyyka"), clientSideRequired=true, serverSideRequired=false, packetHandler=classOf[PacketHandler])
object Majyyka {
    
    @SidedProxy(clientSide="majyyka.core.proxy.ClientProxy", serverSide="majyyka.core.proxy.CommonProxy")
    var proxy:CommonProxy = null
    
    val majyykaTab:CreativeTabs = MajyykaTab
    
    @EventHandler
    def preInit(event:FMLPreInitializationEvent) {
        
        LogHelper.init
        
        ConfigHandler.main(new File(event.getModConfigurationDirectory.getAbsolutePath + File.separator + MOD_ID.toLowerCase() + File.separator + MOD_ID + ".cfg"))
        ConfigHandler.worldGen(new File(event.getModConfigurationDirectory.getAbsolutePath + File.separator + MOD_ID.toLowerCase() + File.separator + "WorldGen.cfg"))
        
        MajyykaStuff.addWands
        
        MajyykaStuff.addAspects
        
        MajyykaStuff.addBlocks
        
        MajyykaStuff.addFluids
        
        MajyykaStuff.reflectPotion
        
        MinecraftForge.EVENT_BUS.register(MajyykaEventHooks)
        
        LogHelper.log(Level.INFO, "Wands registered: " + Wand.wands.size())
        LogHelper.log(Level.INFO, "Wand combinations: " + Wand.wands.keySet())
        
    }
    
    @EventHandler
    def init(event:FMLInitializationEvent) {
        
        GUIHandler
        
        MajyykaStuff.addItems
        
        MajyykaStuff.addCrafting
        
        MajyykaStuff.addOreDict
        
        MajyykaStuff.addTCResearch
        
        MajyykaStuff.addPotions
        
        LogHelper.log(Level.INFO, Potion.potionTypes(310).getName())
        
        MinecraftForge.EVENT_BUS.register(PlayerTracker)
        GameRegistry.registerPlayerTracker(PlayerTracker)
        
        GameRegistry.registerWorldGenerator(MajyykaWorldGen)
        
        proxy.initRendering
        
    }
    
    @EventHandler
    def postInit(event:FMLPostInitializationEvent) {
        
        MajyykaStuff.addWandCrafting
        
    }
    
    @EventHandler
    def serverStart(event:FMLServerStartingEvent) {
        
        MajyykaStuff.addCommands(event)
        
    }
    
}