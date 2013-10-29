/**
 * Majyyka
 *
 * MajyykaAspect.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.api

object AspectLight extends TAspect {
    
    var name:String = "luce"
    var subAspects:Array[TAspect] = null
    
}
object AspectDark extends TAspect {
    
    var name:String = "tenebre"
    var subAspects:Array[TAspect] = null
    
}
object AspectVoid extends TAspect {
    
    var name:String = "vacue"
    var subAspects:Array[TAspect] = null
    
}
object AspectWater extends TAspect {
    
    var name:String = "vatte"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectFire)
    
}
object AspectPlant extends TAspect {
    
    var name:String = "herbe"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectWater)
    
}
object AspectFire extends TAspect {
    
    var name:String = "igne"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectPlant)
    
}
object AspectStone extends TAspect {
    
    var name:String = "petrae"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectTime, AspectSpace)
    
}
object AspectTime extends TAspect {
    
    var name:String = "tempore"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectSpace)
    
}
object AspectSpace extends TAspect {
    
    var name:String = "rymme"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectTime)
    
}
object AspectCrystal extends TAspect {
    
    var name:String = "vitre"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectStone, AspectFire)
    
}
object AspectElectric extends TAspect {
    
    var name:String = "electricitate"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectFire)
    
}
object AspectLife extends TAspect {
    
    var name:String = "vite"
    var subAspects:Array[TAspect] = Array(AspectLight, AspectDark, AspectVoid, AspectElectric, AspectPlant)
    
}
