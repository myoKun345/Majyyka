/**
 * Majyyka
 *
 * MajyykDebugCommand.scala
 *
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
package majyyka.core.player

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import java.util.List
import java.util.LinkedList
import majyyka.core.LogHelper
import java.util.logging.Level
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.command.WrongUsageException

object MajyykDebugCommand extends CommandBase {
    
    override def getCommandName:String = {
        return "majyykdebug"
    }
    
    override def getRequiredPermissionLevel:Int = {
        return 2
    }
    
    override def getCommandAliases:List[_] = {
        var list:List[String] = new LinkedList[String]
        list.add("mjykdbg")
        list.add("majyykadebug")
        
        return list
    }
    
    override def getCommandUsage(sender:ICommandSender):String = {
        return "command.majyykaDebug"
    }
    
    override def processCommand(sender:ICommandSender, args:Array[String]) {
        if (args.length > 0) {
            var name:String = args(0)
            
            if (name.equalsIgnoreCase("majyyk") || name.equalsIgnoreCase("mjyk")) {
                if (args.length > 1) {
                    var op:String = args(1)
                    if (args.length > 2) {
                        var playername:String = args(2)
                		var player:EntityPlayerMP = CommandBase.getPlayer(sender, playername)
                        var mjyk:MajyykDataHandler = MajyykDataHandler.forPlayer(player)
                		
                        if (op.equalsIgnoreCase("set")) {
                            if (args.length > 3) {
                                var ny:Double = CommandBase.parseDouble(sender, args(3))
                                
                                mjyk.setMajyyk(ny)
                            }
                            else {
                                throw new WrongUsageException("The set operation requires a value!")
                            }
                        }
                        else if (op.equalsIgnoreCase("inc") || op.equalsIgnoreCase("increment")) {
                            if (args.length > 3) {
                                var amt:Double = CommandBase.parseDouble(sender, args(3))
                                
                                mjyk.incrementMajyyk(amt)
                            }
                            else {
                                throw new WrongUsageException("The increment operation requires a value!")
                            }
                        }
                        else if (op.equalsIgnoreCase("dec") || op.equalsIgnoreCase("decrement")) {
                            if (args.length > 3) {
                                var amt:Double = CommandBase.parseDouble(sender, args(3))
                                
                                mjyk.decrementMajyyk(amt)
                            }
                            else {
                                throw new WrongUsageException("The decrement operation requires a value!")
                            }
                        }
                    }
                    else {
                        throw new WrongUsageException("The majyyk operations require a player!")
                    }
                }
                else {
                    throw new WrongUsageException("The majyyk command requires an operation argument!")
                }
            }
            else if (name.equalsIgnoreCase("level") || name.equalsIgnoreCase("lvl")) {
                if (args.length > 1) {
                    var op:String = args(1)
                    if (args.length > 2) {
                        var playername:String = args(2)
                		var player:EntityPlayerMP = CommandBase.getPlayer(sender, playername)
                        var mjyk:MajyykDataHandler = MajyykDataHandler.forPlayer(player)
                		
                        if (op.equalsIgnoreCase("set")) {
                            if (args.length > 3) {
                                var ny:Int = CommandBase.parseInt(sender, args(3))
                                
                                mjyk.setLevel(ny)
                            }
                            else {
                                throw new WrongUsageException("The set operation requires a value!")
                            }
                        }
                        else if (op.equalsIgnoreCase("inc") || op.equalsIgnoreCase("increment")) {
                            if (args.length > 3) {
                                var amt:Int = CommandBase.parseInt(sender, args(3))
                                
                                mjyk.incrementLevel(amt)
                            }
                            else {
                                throw new WrongUsageException("The increment operation requires a value!")
                            }
                        }
                        else if (op.equalsIgnoreCase("dec") || op.equalsIgnoreCase("decrement")) {
                            if (args.length > 3) {
                                var amt:Int = CommandBase.parseInt(sender, args(3))
                                
                                mjyk.decrementLevel(amt)
                            }
                            else {
                                throw new WrongUsageException("The decrement operation requires a value!")
                            }
                        }
                    }
                    else {
                        throw new WrongUsageException("The level operations require a player!")
                    }
                }
                else {
                    throw new WrongUsageException("The level command requires an operation argument!")
                }
            }
            else {
                throw new WrongUsageException("'" + args(0) + "' is not a valid argument!")
            }
        }
        else {
            throw new WrongUsageException("The Majyyka debug command requires arguments!")
        }
    }
    
}