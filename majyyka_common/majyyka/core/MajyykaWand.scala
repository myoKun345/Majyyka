/**
 * Majyyka
 *
 * MajyykaWand.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import majyyka.api.WandHandle
import net.minecraft.item.ItemStack
import majyyka.item.Handle
import majyyka.api.WandCore
import majyyka.item.MajyykaStick
import majyyka.item.Core

object WandCoreOak extends WandCore(4.0F, new ItemStack(MajyykaStick, 1, 0))
object WandCoreBirch extends WandCore(4.5F, new ItemStack(MajyykaStick, 1, 1))
object WandCoreSpruce extends WandCore(3.75F, new ItemStack(MajyykaStick, 1, 2))
object WandCoreJungle extends WandCore(4.0F, new ItemStack(MajyykaStick, 1, 3))
object WandCoreIron extends WandCore(2.0F, new ItemStack(Core, 1, 0))
object WandCoreGold extends WandCore(2.5F, new ItemStack(Core, 1, 1))
object WandCoreEmerald extends WandCore(4.0F, new ItemStack(Core, 1, 2))
object WandCoreDiamond extends WandCore(5.0F, new ItemStack(Core, 1, 3))

object WandHandleLeather extends WandHandle(0.0F, new ItemStack(Handle, 1, 0))
object WandHandleOak extends WandHandle(1.0F, new ItemStack(Handle, 1, 1))
object WandHandleBirch extends WandHandle(0.9F, new ItemStack(Handle, 1, 2))
object WandHandleSpruce extends WandHandle(1.1F, new ItemStack(Handle, 1, 3))
object WandHandleJungle extends WandHandle(1.0F, new ItemStack(Handle, 1, 4))
object WandHandleIron extends WandHandle(2.0F, new ItemStack(Handle, 1, 5))
object WandHandleGold extends WandHandle(2.5F, new ItemStack(Handle, 1, 6))
object WandHandleEmerald extends WandHandle(3.0F, new ItemStack(Handle, 1, 7))
object WandHandleDiamond extends WandHandle(4.5F, new ItemStack(Handle, 1, 8))
