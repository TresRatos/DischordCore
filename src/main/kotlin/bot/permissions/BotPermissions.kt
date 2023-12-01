package bot.permissions

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions

object BotPermissions {
    val GUILD_OWNER = Permissions(Permission.ManageGuild)
    val STAFF = Permissions(Permission.ManageMessages)
    val EVERYONE = Permissions(Permission.UseApplicationCommands)
}