/**
 * Majyyka
 *
 * MajyykaDamageSource.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core.player

import net.minecraft.util.DamageSource

object ClawDamageSource extends DamageSource("claw")

object BleedingDamageSource extends DamageSource("bleed") {
    
    setDamageBypassesArmor()
    
}