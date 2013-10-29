/**
 * Majyyka
 *
 * MajyykaEventHooks.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent
import net.minecraftforge.event.ForgeSubscribe
import myokun.mods.majyyka.potion.PotionBleed
import java.util.Random
import net.minecraft.util.DamageSource
import thaumcraft.common.lib.world.DamageSourceThaumcraft
import myokun.mods.majyyka.core.player.BleedingDamageSource

object MajyykaEventHooks {
    
    var rand:Random = new Random
    
    @ForgeSubscribe
    def onLivingUpdate(event:LivingUpdateEvent) {
        if (event.entityLiving.isPotionActive(PotionBleed)) {
            if (rand.nextInt(15) == 0) {
                event.entityLiving.attackEntityFrom(BleedingDamageSource, 1F)
            }
        }
    }
    
}