/**
 * Majyyka
 *
 * StringUtils.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core.util

object StringUtils {
    
    def firstIndexOfUppercase(string:String):Int = {
        
        for (i <- 0 until string.length()) {
            if (Character.isUpperCase(string.charAt(i))) {
                return i
            }
        }
        return -1
        
    }
    
}