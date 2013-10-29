/**
 * Majyyka
 *
 * PacketHandler.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core.network

import cpw.mods.fml.common.network.IPacketHandler
import net.minecraft.network.packet.Packet250CustomPayload
import net.minecraft.network.INetworkManager
import cpw.mods.fml.common.network.Player

class PacketHandler extends IPacketHandler {
    
    override def onPacketData(manager:INetworkManager, packet:Packet250CustomPayload, player:Player) {
        
    }

}