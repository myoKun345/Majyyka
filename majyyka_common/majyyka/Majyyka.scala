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

@Mod(modid="Majyyka", name="Majyyka", version="0.0.01.@@BUILD@@", modLanguage="scala")
@NetworkMod(channels=Array("majyyka"), clientSideRequired=true, serverSideRequired=false, packetHandler=classOf[PacketHandler])
object Majyyka {
    
    @SidedProxy(clientSide="majyyka.core.proxy.ClientProxy", serverSide="majyyka.core.proxy.CommonProxy")
    var proxy:CommonProxy = null
    
    @EventHandler
    def preInit(event:FMLPreInitializationEvent) {
        
        
        
    }
    
    @EventHandler
    def init(event:FMLInitializationEvent) {
        
        
        
    }
    
    @EventHandler
    def postInit(event:FMLPostInitializationEvent) {
        
        
        
    }
    
}