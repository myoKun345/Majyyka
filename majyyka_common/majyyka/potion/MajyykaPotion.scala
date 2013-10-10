/**
 * Majyyka
 *
 * MajyykaPotion.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.potion

import net.minecraft.potion.PotionHealth
import majyyka.core.LogHelper
import java.util.logging.Level

object PotionBleed extends PotionHealth(310, true, 0xFF0000) {
    
    setPotionName("Bleeding")
    
}