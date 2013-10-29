/**
 * Majyyka
 *
 * ResearchHandler.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.core.player

import net.minecraftforge.common.IExtendedEntityProperties
import net.minecraft.entity.Entity
import myokun.mods.majyyka.core.lib.MajyykaReference
import net.minecraft.world.World
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.entity.player.EntityPlayer

class MajyykDataHandler(entity:Entity) extends IExtendedEntityProperties {
    
    var dirty:Boolean = true
    
    private var majyyk:Double = 100
    private var level:Int = 1
    
    override def init(entity:Entity, world:World) {
        
    }
    
    override def saveNBTData(compound:NBTTagCompound) {
        var nbt:NBTTagCompound = new NBTTagCompound()
        
        nbt.setDouble("MajyykP", majyyk)
        nbt.setInteger("MajyykL", level)
        compound.setCompoundTag(MajyykaReference.mjykId, nbt)
    }
    
    override def loadNBTData(compound:NBTTagCompound) {
        var nbt:NBTTagCompound = compound.getCompoundTag(MajyykaReference.mjykId)
        
        majyyk = nbt.getDouble("MajyykP")
        level = nbt.getInteger("MajyykL")
    }
    
    def getMajyyk:Double = {
        return this.majyyk
    }
    
    def setMajyyk(ny:Double) {
        if (!(ny > MajyykLimitAlgo.getMajyykLimitForLevel(level))) {
	        if (this.majyyk != ny) {
	            this.majyyk = ny
	            this.setDirty
	        }
        }
        else {
            this.majyyk = MajyykLimitAlgo.getMajyykLimitForLevel(level)
        }
    }
    
    def incrementMajyyk(by:Double) {
        this.majyyk += by
        this.setDirty
        if (this.majyyk > MajyykLimitAlgo.getMajyykLimitForLevel(level)) {
            this.majyyk = MajyykLimitAlgo.getMajyykLimitForLevel(level)
            this.setDirty
        }
    }
    
    def decrementMajyyk(by:Double) {
        this.majyyk -= by
        this.setDirty
        if (this.majyyk < 0) {
            this.majyyk = 0
            this.setDirty
        }
    }
    
    def getLevel:Int = {
        return this.level
    }
    
    def setLevel(ny:Int) {
        if (ny > 0) this.level = ny else this.level = 1
        this.setDirty
    }
    
    def incrementLevel(by:Int) {
        this.level += by
        this.setDirty
    }
    
    def decrementLevel(by:Int) {
        this.level -= by
        this.setDirty
        if (this.level < 1) {
            this.level = 1
            this.setDirty
        }
    }
    
    def setDirty {
        this.dirty = true
    }
    
}
object MajyykDataHandler {
    
    def forPlayer(entity:Entity):MajyykDataHandler = {
        return entity.getExtendedProperties(MajyykaReference.mjykId).asInstanceOf[MajyykDataHandler]
    }
    
}

class ResearchHandler(player:EntityPlayer) extends IExtendedEntityProperties {
    
    var dirty:Boolean = true
    
    override def init(entity:Entity, world:World) {
        
    }
    
    override def saveNBTData(compound:NBTTagCompound) {
        var nbt:NBTTagCompound = new NBTTagCompound()
        
        compound.setCompoundTag(MajyykaReference.rschId, nbt)
    }
    
    override def loadNBTData(compound:NBTTagCompound) {
        var nbt:NBTTagCompound = compound.getCompoundTag(MajyykaReference.rschId)
    }
    
}
object ResearchHandler {
    
    def forPlayer(player:EntityPlayer):ResearchHandler = {
        return player.getExtendedProperties(MajyykaReference.rschId).asInstanceOf[ResearchHandler]
    }
}
