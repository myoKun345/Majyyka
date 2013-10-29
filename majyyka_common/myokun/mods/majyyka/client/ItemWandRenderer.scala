/**
 * Majyyka
 *
 * ItemWandRenderer.java
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.client

import java.util.HashMap
import java.util.LinkedList
import myokun.mods.majyyka.api.MajyykaAPI
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.IItemRenderer
import org.lwjgl.opengl.GL11
import cpw.mods.fml.client.FMLClientHandler
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper
import net.minecraftforge.client.IItemRenderer.ItemRenderType

class ItemWandRenderer extends IItemRenderer {
    
    private var modelWand:ModelWand = new ModelWand
    
    var coreTextures:HashMap[String, ResourceLocation] = new HashMap[String, ResourceLocation]()
    val coreNames:LinkedList[String] = new LinkedList[String](MajyykaAPI.coreMapKeys)
    
    var handleTextures:HashMap[String, ResourceLocation] = new HashMap[String, ResourceLocation]()
    val handleNames:LinkedList[String] = new LinkedList[String](MajyykaAPI.handleMapKeys)
    
    var bevelTextures:HashMap[String, ResourceLocation] = new HashMap[String, ResourceLocation]()
    val bevelNames:Array[String] = Array("Black", "Blue", "Brown", "Cyan", "Gray", 
    		"Green", "LightBlue", "LightGray", "Lime", "Magenta", 
    		"Orange", "Pink", "Purple", "Red", "White",
    		"Yellow")
    
    def handleRenderType(stack:ItemStack, renderType:ItemRenderType):Boolean = {
        
        return renderType != ItemRenderType.FIRST_PERSON_MAP
        
    }
    
    def shouldUseRenderHelper(renderType:ItemRenderType, stack:ItemStack, helper:ItemRendererHelper):Boolean = {
        
        return true
        
    }
    
    def renderItem(renderType:ItemRenderType, stack:ItemStack, data:Object*) {
        
        renderType match {
            case ItemRenderType.ENTITY =>
                renderWand(0.25F, 0F, 0F, 0.05F, renderType, stack)
                return
            case ItemRenderType.EQUIPPED =>
                renderWand(1.8F, 1F, 0F, 0.2F, renderType, stack)
                return
            case ItemRenderType.EQUIPPED_FIRST_PERSON =>
                renderWand(3F, -2.5F, -3.5F, 0.6F, renderType, stack)
                return
            case ItemRenderType.INVENTORY =>
                renderWand(0.5F, -0.6F, -0.5F, 0.09F, renderType, stack)
                return
        }
        
    }
    
    private def renderWand(x:Float, y:Float, z:Float, scale:Float, renderType:ItemRenderType, stack:ItemStack) {
        
        GL11.glPushMatrix()
        
        GL11.glDisable(GL11.GL_LIGHTING)
        
        if (renderType == ItemRenderType.ENTITY) {
            GL11.glRotatef(-45F, 0F, 0F, 1F)
        }
        if (renderType == ItemRenderType.EQUIPPED) {
            GL11.glRotatef(-45F, 0F, 1F, 0F)
            GL11.glRotatef(-16F, 0F, 0F, 1F)
        }
        if (renderType == ItemRenderType.EQUIPPED_FIRST_PERSON) {
    		GL11.glRotatef(-140F, 0F, 1F, 0F)
    		GL11.glRotatef(-45F, 0F, 0F, 1F)
        }
        if (renderType == ItemRenderType.INVENTORY) {
        	GL11.glRotatef(-25F, 0F, 0F, 1F)
        }
        GL11.glTranslatef(x, y, z)
        GL11.glScalef(scale, scale, scale)
        
        for (i <- 0 until coreNames.size) {
        	coreTextures.put(coreNames.get(i), new ResourceLocation("majyyka", "textures/models/wands/core" + coreNames.get(i).substring(0, 1).toUpperCase() + coreNames.get(i).substring(1) + ".png"))
        }
        
        for (i <- 0 until handleNames.size) {
        	handleTextures.put(handleNames.get(i), new ResourceLocation("majyyka", "textures/models/wands/handle" + handleNames.get(i).substring(0, 1).toUpperCase() + handleNames.get(i).substring(1) + ".png"))
        }
        
        for (i <- 0 until 16) {
        	bevelTextures.put(bevelNames(i), new ResourceLocation("majyyka", "textures/models/wands/bevel" + bevelNames(i) + ".png"))
        }
        
        if (stack.hasTagCompound()) {
        	FMLClientHandler.instance().getClient().renderEngine.bindTexture(coreTextures.get(stack.stackTagCompound.getString("Core")))
        	modelWand.render("Core")
        	FMLClientHandler.instance().getClient().renderEngine.bindTexture(bevelTextures.get(stack.stackTagCompound.getString("Bevel")))
        	modelWand.render("Bevel")
        	FMLClientHandler.instance().getClient().renderEngine.bindTexture(handleTextures.get(stack.stackTagCompound.getString("Handle")))
        	modelWand.render("Handle")
        }
        //modelWand.renderAll()
        
        GL11.glEnable(GL11.GL_LIGHTING)
        GL11.glPopMatrix()
        
    }
    
}