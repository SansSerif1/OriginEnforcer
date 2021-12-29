package me.sansserif.originenforcer;

import net.fabricmc.api.ClientModInitializer;

public class ClientNotice implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        OriginEnforcerMod.LOGGER.warn("Loaded OriginEnforcer Mod! However, this mod is server-side only, so it wont do anything in this MC instance.");
    }
}
