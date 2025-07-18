# Mutations
These things take 1 argument: `ServerPlayerEntity`.
From this, it's escalated into all fancy semi-permanent effects.

They're handled in [Player Tick Handler](../../src/main/java/net/timeworndevs/curiecontent/events/PlayerTickHandler.java) (list on line 184).

Example mutation:
```java
player -> player.setMainArm(player.getMainArm().getOpposite())
```