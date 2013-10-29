/**
 * Majyyka
 *
 * ClientProxy.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core.proxy

import myokun.mods.majyyka.core.MajyykaIDs._
import net.minecraftforge.client.MinecraftForgeClient
import myokun.mods.majyyka.client.ItemWandRenderer

class ClientProxy extends CommonProxy {
    
    override def initRendering {
        MinecraftForgeClient.registerItemRenderer(wandID, new ItemWandRenderer)
    }
    
}