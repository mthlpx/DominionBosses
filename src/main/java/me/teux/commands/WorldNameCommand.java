package me.teux.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class WorldNameCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "worldname";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/worldname";
    }

    @Override
    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
        String worldName = p_71515_1_.getEntityWorld().getWorldInfo().getWorldName();
        p_71515_1_.addChatMessage(new ChatComponentText(worldName));
    }
}
