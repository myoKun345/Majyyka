/**
 * Majyyka
 *
 * Majyyka.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.network.NetworkMod
import majyyka.core.network.PacketHandler
import cpw.mods.fml.common.Mod.Instance
import majyyka.core.proxy.CommonProxy
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import net.minecraft.creativetab.CreativeTabs
import majyyka.core.MajyykaStuff
import majyyka.core.lib.MajyykaReference._
import majyyka.core.ConfigHandler
import java.io.File
import majyyka.core.MajyykaTab
import majyyka.core.gui.GUIHandler
import majyyka.core.LogHelper
import cpw.mods.fml.common.registry.GameRegistry
import majyyka.core.MajyykaWorldGen
import java.util.logging.Level
import majyyka.api.Wand
import net.minecraftforge.common.MinecraftForge
import majyyka.core.player.PlayerTracker
import cpw.mods.fml.common.event.FMLServerStartingEvent
import majyyka.core.MajyykaEventHooks
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