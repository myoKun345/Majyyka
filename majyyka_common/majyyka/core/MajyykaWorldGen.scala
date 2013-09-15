/**
 * Majyyka
 *
 * MajyykaWorldGen.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core

import cpw.mods.fml.common.IWorldGenerator
import majyyka.core.MajyykaIDs._
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.World
import java.util.Random
import net.minecraft.world.biome.BiomeGenBase
import net.minecraft.world.gen.feature.WorldGenFlowers

object MajyykaWorldGen extends IWorldGenerator {
    
    override def generate(rand:Random, chunkX:Int, chunkZ:Int, world:World, generator:IChunkProvider, provider:IChunkProvider) {
        
        var x:Int = chunkX * 16 + rand.nextInt(16)
        var z:Int = chunkZ * 16 + rand.nextInt(16)
        
        var biome:BiomeGenBase = world.getBiomeGenForCoords(x, z)
        
        if (majyykFlowerGen) {
            
            for (i <- 0 until 16) {
                if (rand.nextInt(6) == 0) {
	                var genX:Int = x - 8 + rand.nextInt(16)
	                var genY:Int = rand.nextInt(128)
	                var genZ:Int = z - 8 + rand.nextInt(16)
	                new WorldGenFlowers(majyykFlowerID).generate(world, rand, genX, genY, genZ)
	            }
            }
            
        }
        
    }
    
}