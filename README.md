# NoFakeHitEffects

NoFakeHitEffects suppresses locally predicted critical-hit and enchanted-hit particles against remote players on multiplayer servers. Without NoFakeHitEffects, vanilla can render those particles before the server validates the attack, so a rejected hit can still show hit effects.

## Installation

Install on the client. A server-only install will not affect client-predicted hit effects.

## Behavior

- Suppresses predicted critical-hit particles against remote players.
- Suppresses predicted enchanted-hit particles against remote players.
- Still renders server-confirmed hit effects.

## Versions

- `1.21.x`: Minecraft Java 1.21 through 1.21.11

## Requirements

- Minecraft Java 1.21.x
- Fabric Loader 0.18.2 or newer

## License

Unlicense
