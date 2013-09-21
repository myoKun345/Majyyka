/**
 * Majyyka
 *
 * MajyykaWand.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import majyyka.api.WandCore
import majyyka.api.WandHandle
import majyyka.api.AspectAnimal
import majyyka.api.AspectCrystal
import majyyka.api.AspectElectric
import majyyka.api.AspectFire
import majyyka.api.AspectPlant
import majyyka.api.AspectSpace
import majyyka.api.AspectStone
import majyyka.api.AspectTime
import majyyka.api.AspectWater
import majyyka.item.Core
import majyyka.item.Handle
import majyyka.item.MajyykaStick
import net.minecraft.item.ItemStack

object WandCoreOak extends WandCore(4.0F, new ItemStack(MajyykaStick, 1, 0), Array(AspectPlant, AspectTime))
object WandCoreBirch extends WandCore(4.5F, new ItemStack(MajyykaStick, 1, 1), Array(AspectPlant, AspectFire))
object WandCoreSpruce extends WandCore(3.75F, new ItemStack(MajyykaStick, 1, 2), Array(AspectPlant, AspectWater))
object WandCoreJungle extends WandCore(4.0F, new ItemStack(MajyykaStick, 1, 3), Array(AspectPlant, AspectSpace))
object WandCoreIron extends WandCore(2.0F, new ItemStack(Core, 1, 0), Array(AspectStone, AspectFire))
object WandCoreGold extends WandCore(2.5F, new ItemStack(Core, 1, 1), Array(AspectStone, AspectFire))
object WandCoreEmerald extends WandCore(4.0F, new ItemStack(Core, 1, 2), Array(AspectCrystal, AspectPlant))
object WandCoreDiamond extends WandCore(5.0F, new ItemStack(Core, 1, 3), Array(AspectCrystal, AspectWater))
object WandCoreRedstone extends WandCore(5.0F, new ItemStack(Core, 1, 4), Array(AspectStone, AspectElectric))
object WandCoreLapis extends WandCore(3.0F, new ItemStack(Core, 1, 5), Array(AspectStone, AspectWater))
object WandCoreObsidian extends WandCore(6.0F, new ItemStack(Core, 1, 6), Array(AspectStone, AspectCrystal))

object WandHandleLeather extends WandHandle(0.0F, new ItemStack(Handle, 1, 0), Array(AspectAnimal))
object WandHandleOak extends WandHandle(1.0F, new ItemStack(Handle, 1, 1), Array(AspectPlant, AspectTime))
object WandHandleBirch extends WandHandle(0.9F, new ItemStack(Handle, 1, 2), Array(AspectPlant, AspectFire))
object WandHandleSpruce extends WandHandle(1.1F, new ItemStack(Handle, 1, 3), Array(AspectPlant, AspectWater))
object WandHandleJungle extends WandHandle(1.0F, new ItemStack(Handle, 1, 4), Array(AspectPlant, AspectSpace))
object WandHandleIron extends WandHandle(2.0F, new ItemStack(Handle, 1, 5), Array(AspectStone, AspectFire))
object WandHandleGold extends WandHandle(2.5F, new ItemStack(Handle, 1, 6), Array(AspectStone, AspectFire))
object WandHandleEmerald extends WandHandle(3.0F, new ItemStack(Handle, 1, 7), Array(AspectCrystal, AspectPlant))
object WandHandleDiamond extends WandHandle(4.5F, new ItemStack(Handle, 1, 8), Array(AspectCrystal, AspectWater))
object WandHandleRedstone extends WandHandle(5.0F, new ItemStack(Handle, 1, 9), Array(AspectStone, AspectElectric))
object WandHandleLapis extends WandHandle(3.0F, new ItemStack(Handle, 1, 10), Array(AspectStone, AspectWater))
object WandHandleObsidian extends WandHandle(4.0F, new ItemStack(Handle, 1, 11), Array(AspectStone, AspectCrystal))
