/**
 * Majyyka
 *
 * ThaumcraftCompat.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.compatibility.thaumcraft

import cpw.mods.fml.common.FMLLog
import cpw.mods.fml.common.Loader
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.network.NetworkMod
import majyyka.api.MajyykaAPI

@Mod(modid="Majyyka|CompatTC4", name="Majyyka Compat: TC4", version="0.0.01.@@BUILD@@", dependencies="after:Majyyka;after:Thaumcraft", modLanguage="scala")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
object ThaumcraftCompat {
    
    @EventHandler
    def preInit(event:FMLPreInitializationEvent) {
        if (!Loader.isModLoaded("Thaumcraft")) {
            FMLLog.warning("Thaumcraft missing - Majyyka Thaumcraft Compat not loading")
            return
        }
        try {
            
            MajyykaAPI.addWandCore("greatwood", WandCoreGreatwood)
            MajyykaAPI.addWandCore("silverwood", WandCoreSilverwood)
            
        }
        catch {
            case e:Exception =>
                e.printStackTrace()
        }
    }
    
}