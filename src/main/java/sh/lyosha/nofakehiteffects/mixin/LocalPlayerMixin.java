package sh.lyosha.nofakehiteffects.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {

    @Inject(method = "crit", at = @At("HEAD"), cancellable = true)
    private void nofakehiteffects$suppressPredictedCrit(Entity entity, CallbackInfo callbackInfo) {
        if (nofakehiteffects$shouldSuppressPredictedHitEffect(entity)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method = "magicCrit", at = @At("HEAD"), cancellable = true)
    private void nofakehiteffects$suppressPredictedEnchantedHit(Entity entity, CallbackInfo callbackInfo) {
        if (nofakehiteffects$shouldSuppressPredictedHitEffect(entity)) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private static boolean nofakehiteffects$shouldSuppressPredictedHitEffect(Entity entity) {
        if (!(entity instanceof RemotePlayer)) {
            return false;
        }

        Minecraft minecraft = Minecraft.getInstance();
        ClientPacketListener connection = minecraft.getConnection();
        ServerData server = minecraft.getCurrentServer();
        return connection != null && server != null && !server.isLan();
    }
}
