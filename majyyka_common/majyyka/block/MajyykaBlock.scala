/**
 * Majyyka
 *
 * MajyykaBlock.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.block

import majyyka.Majyyka._
import majyyka.core.MajyykaIDs._
import majyyka.core.lib.MajyykaReference._
import net.minecraft.block.Block
import net.minecraft.block.Block._
import net.minecraft.block.material.Material
import net.minecraftforge.common.IPlantable
import net.minecraft.world.World
import net.minecraftforge.common.EnumPlantType
import java.util.Random
import net.minecraftforge.common.ForgeDirection
import net.minecraft.util.AxisAlignedBB
import net.minecraft.item.ItemStack
import net.minecraft.client.renderer.texture.IconRegister
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraftforge.fluids.BlockFluidClassic
import net.minecraft.util.Icon

class MajyykaBlock(arg:Int, mat:Material) extends Block(arg, mat) {
    
    setCreativeTab(majyykaTab)
    
}

object MajyykFlower extends MajyykaBlock(majyykFlowerID, Material.plants) with IPlantable {
    
    setTickRandomly(true)
    setBlockBounds(0.3F, 0, 0.3F, 0.7F, 0.6F, 0.7F)
    setStepSound(Block.soundGrassFootstep)
    
    override def getUnlocalizedName():String = {
        
        return "tile." + majyykFlowerUnloc
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        blockIcon = register.registerIcon(MOD_ID + ":" + majyykFlowerUnloc)
        
    }
    
    override def canPlaceBlockAt(world:World, x:Int, y:Int, z:Int):Boolean = {
        
        return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z)
        
    }
    
    def canGrow(id:Int):Boolean = {
        
        return id == grass.blockID || id == dirt.blockID || id == tilledField.blockID || id == majyykDirtID
        
    }
    
    override def onNeighborBlockChange(world:World, x:Int, y:Int, z:Int, neighborID:Int) {
        
        super.onNeighborBlockChange(world, x, y, z, neighborID)
        this.checkChange(world, x, y, z)
        
    }
    
    override def updateTick(world:World, x:Int, y:Int, z:Int, rand:Random) {
        
        this.checkChange(world, x, y, z)
        
    }
    
    def checkChange(world:World, x:Int, y:Int, z:Int) {
        
        if (!this.canBlockStay(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0)
            world.setBlock(x, y, z, 0, 0, 2)
        }
        
    }
    
    override def canBlockStay(world:World, x:Int, y:Int, z:Int):Boolean = {
        
        var underneath:Block = blocksList(world.getBlockId(x, y - 1, z))
        return world.canBlockSeeTheSky(x, y, z) && (underneath != null && underneath.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this))
        
    }
    
    override def getCollisionBoundingBoxFromPool(world:World, x:Int, y:Int, z:Int):AxisAlignedBB = null
    
    override def isOpaqueCube():Boolean = false
    
    override def renderAsNormalBlock():Boolean = false
    
    override def getRenderType():Int = 1
    
    override def getPlantType(world:World, x:Int, y:Int, z:Int):EnumPlantType = {
        
        return EnumPlantType.Plains
        
    }
    
    override def getPlantID(world:World, x:Int, y:Int, z:Int):Int = {
        
        return blockID
        
    }
    
    override def getPlantMetadata(world:World, x:Int, y:Int, z:Int):Int = {
        
        return world.getBlockMetadata(x, y, z)
        
    }
    
}

object MajyykImbuedDirt extends MajyykaBlock(majyykDirtID, Material.ground) {
    
    setUnlocalizedName(majyykDirtUnloc)
    setStepSound(Block.soundGravelFootstep)
    
    override def canSustainPlant(world:World, x:Int, y:Int, z:Int, direction:ForgeDirection, plant:IPlantable):Boolean = {
        
        return true
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        blockIcon = register.registerIcon(MOD_ID + ":" + majyykDirtUnloc)
        
    }
    
}

/*object MajyykEssenceBlock extends BlockFluidClassic(majyykEssenceDefault, MajyykEssence, Material.water) {
    
    @SideOnly(Side.CLIENT)
    var flowIcon:Icon = null
    @SideOnly(Side.CLIENT)
    var stillIcon:Icon = null
    
    @SideOnly(Side.CLIENT)
    override def getIcon(side:Int, meta:Int):Icon = {
        
        return flowIcon
        
    }
    
    @SideOnly(Side.CLIENT)
    override def registerIcons(register:IconRegister) {
        
        flowIcon = register.registerIcon(MOD_ID + ":" + majyykEssenceUnloc + "_flow")
        stillIcon = register.registerIcon(MOD_ID + ":" + majyykEssenceUnloc + "_flow")
        
    }
    
}*/
