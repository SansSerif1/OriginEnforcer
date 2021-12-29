package me.sansserif.originenforcer.mixin;

import me.sansserif.originenforcer.PlayerFirstJoinCallback;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
    public class PlayerJoinMixin {
        @Inject(at = @At(value = "TAIL"), method = "onPlayerConnect")
        private  void onPlayerJoin(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
            if (player.getStatHandler().getStat(Stats.CUSTOM.getOrCreateStat(Stats.LEAVE_GAME)) < 1) {
                PlayerFirstJoinCallback.EVENT.invoker().joinServerForFirstTime(connection, player, player.getServer());
            }
        }
    }
