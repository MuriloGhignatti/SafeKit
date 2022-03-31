import org.bukkit.entity.Player

interface ISafeKit {
    fun isBeingUsed(): Boolean
    fun hasKit(player: Player): Boolean
    fun addPlayer(player: Player)
    fun loadConfig()
    fun reloadConfig()
}