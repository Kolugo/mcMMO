package com.gmail.nossr50.runnables;

import org.bukkit.scheduler.BukkitScheduler;

import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.datatypes.PlayerProfile;
import com.gmail.nossr50.party.PartyManager;
import com.gmail.nossr50.util.Users;

public class SaveTimer implements Runnable {
    private final mcMMO plugin;

    public SaveTimer(final mcMMO plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        //All player data will be saved periodically through this
        int count = 1;
        BukkitScheduler bukkitScheduler = plugin.getServer().getScheduler();

        for (PlayerProfile playerProfile : Users.getProfiles()) {
            bukkitScheduler.scheduleSyncDelayedTask(plugin, new ProfileSaveTask(playerProfile), count);
            count++;
        }

        PartyManager.getInstance().saveParties();
    }
}
