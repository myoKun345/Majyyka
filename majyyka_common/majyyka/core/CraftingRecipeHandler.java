/**
 * Majyyka
 *
 * CraftingRecipeHandler.java
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipeHandler {
	
	public static void addShapedRecipe(ItemStack output, String topRow, String midRow, String botRow, ItemStack[] input, char[] define) {
		if (define.length == input.length) {
			if (topRow != null && midRow != null && botRow != null) {
				try {
					switch (define.length) {
					case 1:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0] });
						break;
					case 2:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1] });
						break;
					case 3:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2] });
						break;
					case 4:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3] });
						break;
					case 5:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4] });
						break;
					case 6:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5] });
						break;
					case 7:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6] });
						break;
					case 8:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6],
								define[7], input[7] });
						break;
					case 9:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, botRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6],
								define[7], input[7], define[8], input[8] });
						break;
					}
				} catch (Exception e) {
					throw e;
				}
			}
			if (topRow != null && midRow != null && botRow == null) {
				try {
					switch (define.length) {
					case 1:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0] });
						break;
					case 2:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1] });
						break;
					case 3:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2] });
						break;
					case 4:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3] });
						break;
					case 5:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4] });
						break;
					case 6:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5] });
						break;
					case 7:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6] });
						break;
					case 8:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6],
								define[7], input[7] });
						break;
					case 9:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, midRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6],
								define[7], input[7], define[8], input[8] });
						break;
					}
				} catch (Exception e) {
					throw e;
				}
			}
			if (topRow != null && midRow == null && botRow == null) {
				try {
					switch (define.length) {
					case 1:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0] });
						break;
					case 2:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1] });
						break;
					case 3:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2] });
						break;
					case 4:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3] });
						break;
					case 5:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4] });
						break;
					case 6:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5] });
						break;
					case 7:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6] });
						break;
					case 8:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6],
								define[7], input[7] });
						break;
					case 9:
						GameRegistry.addShapedRecipe(output, new Object[] {
								topRow, define[0], input[0],
								define[1], input[1], define[2], input[2],
								define[3], input[3], define[4], input[4],
								define[5], input[5], define[6], input[6],
								define[7], input[7], define[8], input[8] });
						break;
					}
				} catch (Exception e) {
					throw e;
				}
			}
		}
	}
	
}
