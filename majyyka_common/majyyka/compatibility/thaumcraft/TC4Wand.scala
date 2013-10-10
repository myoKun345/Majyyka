/**
 * Majyyka
 *
 * TC4WandCores.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.compatibility.thaumcraft

import majyyka.api.WandCore
import thaumcraft.api.ItemApi
import majyyka.api.AspectPlant
import majyyka.api.AspectTime
import majyyka.api.AspectSpace

object WandCoreGreatwood extends WandCore(5.0F, ItemApi.getItem("itemWandRod", 0), Array(AspectPlant, AspectTime, AspectSpace))

object WandCoreSilverwood extends WandCore(5.5F, ItemApi.getItem("itemWandRod", 2), Array(AspectPlant, AspectSpace))