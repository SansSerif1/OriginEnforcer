package me.sansserif.originenforcer;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public interface PlayerFirstJoinCallback {
    Event<PlayerFirstJoinCallback> EVENT = EventFactory.createArrayBacked(PlayerFirstJoinCallback.class, (listeners) -> (connection, player, server) -> {
        for (PlayerFirstJoinCallback listener : listeners) {
            listener.joinServerForFirstTime(connection, player, server);
        }
    });

    void joinServerForFirstTime(ClientConnection connection, ServerPlayerEntity player, MinecraftServer server);
}