/**
 * Majyyka
 *
 * ClientProxy.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core.proxy

import majyyka.core.MajyykaIDs._
import net.minecraftforge.client.MinecraftForgeClient
import majyyka.client.ItemWandRenderer

class ClientProxy extends CommonProxy {
    
    override def initRendering {
        MinecraftForgeClient.registerItemRenderer(wandID, new ItemWandRenderer)
    }
    
}