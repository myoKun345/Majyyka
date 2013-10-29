/**
 * Majyyka
 *
 * Aspect.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package myokun.mods.majyyka.api

trait TAspect {
    
    var name:String
    var subAspects:Array[TAspect]
    
}