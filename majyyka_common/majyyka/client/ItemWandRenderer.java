/**
 * Majyyka
 *
 * ItemWandRenderer.java
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.client;

import java.util.LinkedList;
import java.util.logging.Level;

import majyyka.api.Wand;
import majyyka.core.LogHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemWandRenderer implements IItemRenderer {
    
    private ModelWand modelWand;
    public LinkedList<ResourceLocation> wandTextures = new LinkedList<ResourceLocation>();
    public LinkedList<String> wandNames = new LinkedList<String>(Wand.wands().keySet());
    
    public ItemWandRenderer() {
    	
    	modelWand = new ModelWand();
    	
    }
    
    public boolean handleRenderType(ItemStack stack, ItemRenderType renderType) {
        
        return renderType != ItemRenderType.FIRST_PERSON_HOLDING && renderType != ItemRenderType.FIRST_PERSON_MAP;
        
    }
    
    public boolean shouldUseRenderHelper(ItemRenderType renderType, ItemStack stack, ItemRendererHelper helper) {
        
        return true;
        
    }
    
    public void renderItem(ItemRenderType renderType, ItemStack stack, Object... data) {
        
        //LogHelper.log(Level.INFO, renderType.name());
        
        switch (renderType) {
            case ENTITY:
                renderWand(0.25F, 0F, 0F, 0.05F, renderType, stack);
                return;
            case EQUIPPED:
                renderWand(1.8F, 1F, 0F, 0.2F, renderType, stack);
                return;
            case EQUIPPED_FIRST_PERSON:
                renderWand(3F, -2.5F, -3.5F, 0.6F, renderType, stack);
                return;
            case INVENTORY:
                renderWand(0.5F, -0.6F, -0.5F, 0.09F, renderType, stack);
                return;
            default:
                return;
        }
        
    }
    
    private void renderWand(float x, float y, float z, float scale, ItemRenderType renderType, ItemStack stack) {
        
        GL11.glPushMatrix();
        
        GL11.glDisable(GL11.GL_LIGHTING);
        
        if (renderType == ItemRenderType.ENTITY) {
            GL11.glRotatef(-45F, 0F, 0F, 1F);
        }
        if (renderType == ItemRenderType.EQUIPPED) {
            GL11.glRotatef(-45F, 0F, 1F, 0F);
            GL11.glRotatef(-16F, 0F, 0F, 1F);
        }
        if (renderType == ItemRenderType.EQUIPPED_FIRST_PERSON) {
    		GL11.glRotatef(-140F, 0F, 1F, 0F);
    		GL11.glRotatef(-45F, 0F, 0F, 1F);
        }
        if (renderType == ItemRenderType.INVENTORY) {
        	GL11.glRotatef(-25F, 0F, 0F, 1F);
        }
        GL11.glTranslatef(x, y, z);
        GL11.glScalef(scale, scale, scale);
        
        for (int i = 0; i < Wand.wands().size(); i++) {
            wandTextures.add(new ResourceLocation("majyyka", "textures/models/wands/" + wandNames.get(i) + ".png"));
        }
        
        if (stack.hasTagCompound()) {
            
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(wandTextures.get(stack.stackTagCompound.getInteger("WandTypeIndex")));
            
        }
        
        modelWand.render();
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
    }
    
}