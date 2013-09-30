/**
 * Majyyka
 *
 * MajyykLimitAlgo.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core.player

object MajyykLimitAlgo {
    
    def getMajyykLimitForLevel(level:Int):Double = {
        return (Math.sqrt(level)) * 100
    }
    
}