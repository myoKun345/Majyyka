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

@Mod(modid="Majyyka", name="Majyyka", version="0.0.01.@@BUILD@@", modLanguage="scala")
@NetworkMod(channels=Array("majyyka"), clientSideRequired=true, serverSideRequired=false, packetHandler=classOf[PacketHandler])
object Majyyka {
    
    @SidedProxy(clientSide="majyyka.core.proxy.ClientProxy", serverSide="majyyka.core.proxy.CommonProxy")
    var proxy:CommonProxy = null
    
    val majyykaTab:CreativeTabs = new CreativeTabs("Majyyka")
    
    @EventHandler
    def preInit(event:FMLPreInitializationEvent) {
        
        ConfigHandler.main(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + MOD_ID.toLowerCase() + File.separator + MOD_ID + ".cfg"))
        
        MajyykaStuff.addBlocks
        
    }
    
    @EventHandler
    def init(event:FMLInitializationEvent) {
        
        
        
    }
    
    @EventHandler
    def postInit(event:FMLPostInitializationEvent) {
        
        
        
    }
    
}