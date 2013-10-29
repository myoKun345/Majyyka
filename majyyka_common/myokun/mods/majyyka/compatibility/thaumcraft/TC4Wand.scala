/**
 * Majyyka
 *
 * TC4WandCores.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.compatibility.thaumcraft

import myokun.mods.majyyka.api.WandCore
import thaumcraft.api.ItemApi
import myokun.mods.majyyka.api.AspectPlant
import myokun.mods.majyyka.api.AspectTime
import myokun.mods.majyyka.api.AspectSpace

object WandCoreGreatwood extends WandCore(5.0F, ItemApi.getItem("itemWandRod", 0), Array(AspectPlant, AspectTime, AspectSpace))

object WandCoreSilverwood extends WandCore(5.5F, ItemApi.getItem("itemWandRod", 2), Array(AspectPlant, AspectSpace))