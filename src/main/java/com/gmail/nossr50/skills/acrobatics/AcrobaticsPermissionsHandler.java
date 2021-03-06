package com.gmail.nossr50.skills.acrobatics;

import org.bukkit.entity.Player;

import com.gmail.nossr50.util.Permissions;

public class AcrobaticsPermissionsHandler {
    private Permissions permInstance = Permissions.getInstance();

    private boolean canDodge;
    private boolean canGracefulRoll;
    private boolean canRoll;

    protected AcrobaticsPermissionsHandler (Player player) {
        this.canDodge = permInstance.dodge(player);
        this.canGracefulRoll = permInstance.gracefulRoll(player);
        this.canRoll = permInstance.roll(player);
    }

    protected boolean canDodge() {
        return canDodge;
    }

    protected boolean canGracefulRoll() {
        return canGracefulRoll;
    }

    protected boolean canRoll() {
        return canRoll;
    }

    protected boolean hasRollPermissions() {
        return (canRoll || canGracefulRoll);
    }
}
