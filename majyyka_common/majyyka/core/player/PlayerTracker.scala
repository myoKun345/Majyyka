/**
 * Majyyka
 *
 * PlayerTracker.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core.player

import cpw.mods.fml.common.IPlayerTracker
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing
import net.minecraftforge.event.ForgeSubscribe
import majyyka.entity.EntityMajyyk
import net.minecraft.entity.player.EntityPlayer
import majyyka.core.lib.MajyykaReference
import net.minecraftforge.event.entity.living.LivingEvent
import net.minecraft.entity.EntityLiving
import majyyka.core.LogHelper
import java.util.logging.Level
import net.minecraft.entity.EntityLivingBase

object PlayerTracker extends IPlayerTracker {
    
    @ForgeSubscribe
    def onEntityConstruct(event:EntityConstructing) {
        if (event.entity.isInstanceOf[EntityLivingBase]) {
	        event.entity.registerExtendedProperties(MajyykaReference.mjykId, new MajyykDataHandler(event.entity))
	        if (event.entity.isInstanceOf[EntityPlayer]) {
	            event.entity.registerExtendedProperties(MajyykaReference.rschId, new ResearchHandler(event.entity.asInstanceOf[EntityPlayer]))
	        }
        }
    }
    
    @ForgeSubscribe
    def onStillAlive(event:LivingEvent) {
        if (event.entity.isInstanceOf[EntityLivingBase]) {
            var ent = event.entity
            var mjyk:MajyykDataHandler = MajyykDataHandler.forPlayer(ent)
            
            var majyyk:Double = mjyk.getMajyyk
            var level:Int = mjyk.getLevel
            var limit:Double = MajyykLimitAlgo.getMajyykLimitForLevel(level)
            if (majyyk < limit) {
                var timer = 0
                timer += 1
                if (timer >= 5) {
                    mjyk.incrementMajyyk(1.0D)
                    timer = 0
                }
            }
            if (majyyk > limit) {
                mjyk.setMajyyk(limit)
            }
        }
    }
    
    override def onPlayerChangedDimension(player:EntityPlayer) {
        MajyykDataHandler.forPlayer(player).setDirty
    }
    
    override def onPlayerLogin(player:EntityPlayer) {}
    
    override def onPlayerLogout(player:EntityPlayer) {}
    
    override def onPlayerRespawn(player:EntityPlayer) {
        MajyykDataHandler.forPlayer(player).setDirty
    }
    
}