package me.sansserif.originenforcer;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OriginEnforcerMod implements DedicatedServerModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("originenforcer");
	private static final SimpleConfig CONFIG = SimpleConfig.of("originenforcer").request();
	public static final String disconnectmsg = CONFIG.getOrDefault("dmsg", "Your origin has been assigned. Please reconnect to play!");

	@Override
	public void onInitializeServer() {
		PlayerFirstJoinCallback.EVENT.register((connection, player, server) -> {
			String playerorigin = CONFIG.getOrDefault(player.getName().asString(), "none");
			if (!playerorigin.equals("none")) {
				server.getCommandManager().execute(server.getCommandSource(), "origin set " + player.getName().asString() + " origins:origin " + playerorigin);
				player.kill();
				player.requestRespawn();
				connection.disconnect(Text.of(disconnectmsg));
			}
		});
	}
}
