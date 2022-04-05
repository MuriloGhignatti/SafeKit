import filemanagement.SafeConfigManager
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.Listener
import java.util.UUID

abstract class SafeKit(val kitName: String, val kitIcon: Material, val configManager: SafeConfigManager): ISafeKit, Listener {
    private val eventsListened: LinkedHashSet<Event> = LinkedHashSet()
    private val playersUsingKit: LinkedHashSet<UUID> = LinkedHashSet()

    override fun isBeingUsed(): Boolean {
        return playersUsingKit.isNotEmpty()
    }

    override fun hasKit(player: Player): Boolean {
        return playersUsingKit.contains(player.uniqueId)
    }

    override fun addPlayer(player: Player) {
        playersUsingKit.add(player.uniqueId)
    }

    override fun reloadConfig() {
        loadConfig()
    }
    fun registerEvent(event: Event){
        eventsListened.add(event)
    }

    fun unregisterKit(){
        eventsListened.forEach {
            it.handlers.unregister(this)
        }
    }
}