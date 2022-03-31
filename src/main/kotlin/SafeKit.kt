import org.bukkit.Material
import org.bukkit.entity.Player
import java.util.UUID

abstract class SafeKit(val kitName: String, val kitIcon: Material, val configManager: SafeConfigManager): ISafeKit {
    private val players: HashSet<UUID> = HashSet()

    override fun isBeingUsed(): Boolean {
        return players.isNotEmpty()
    }

    override fun hasKit(player: Player): Boolean {
        return players.contains(player.uniqueId)
    }

    override fun addPlayer(player: Player) {
        players.add(player.uniqueId)
    }

    override fun reloadConfig() {
        loadConfig()
    }
}