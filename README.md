# NoFakeHitEffects

NoFakeHitEffects is a client-side Fabric mod that suppresses locally predicted critical-hit and enchanted-hit particles against remote players on multiplayer servers.

Vanilla can render those particles before the server validates the attack. If the target moved, teleported, or the server otherwise rejects the hit, the attacker can see particles for damage that never happened. This mod leaves server-confirmed particles intact and only removes the early local prediction path.

## Requirements

- Minecraft 26.1.x
- Fabric Loader 0.19.2 or newer

## Behavior

- Suppresses predicted critical-hit particles from `LocalPlayer.crit`.
- Suppresses predicted enchanted-hit particles from `LocalPlayer.magicCrit`.
- Still renders server-confirmed hit effects from vanilla animation packets.
