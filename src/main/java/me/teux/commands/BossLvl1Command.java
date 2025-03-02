package me.teux.commands;

import me.teux.cfg.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import noppes.npcs.api.IWorld;
import noppes.npcs.api.entity.ICustomNpc;
import noppes.npcs.scripted.NpcAPI;

public class BossLvl1Command extends CommandBase {

    @Override
    public String getCommandName() {
        return "bosslvl1";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/bosslvl1 <worldname> <x> <y> <z>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 4) {
            throw new CommandException("Uso correto: " + getCommandUsage(sender));
        }

        String worldName = args[0];
        double x, y, z;

        try {
            x = Double.parseDouble(args[1]);
            y = Double.parseDouble(args[2]);
            z = Double.parseDouble(args[3]);
        } catch (NumberFormatException e) {
            throw new CommandException("As coordenadas x, y e z devem ser números.");
        }

        MinecraftServer server = MinecraftServer.getServer();
        World world = null;

        for (WorldServer worldServer : server.worldServers) {
            if (worldServer.getWorldInfo().getWorldName().equalsIgnoreCase(worldName)) {
                world = worldServer;
                break;
            }
        }

        if (world == null) {
            throw new CommandException("Mundo '" + worldName + "' não encontrado.");
        }

        IWorld iWorld = NpcAPI.Instance().getIWorld(world);
        ICustomNpc bosslvl1 = NpcAPI.Instance().createNPC(iWorld);

        bosslvl1.setName(Config.bossLvl1Name);
        bosslvl1.setFaction(1);
        bosslvl1.setPosition(x, y, z);
        iWorld.spawnEntityInWorld(bosslvl1);

        sender.addChatMessage(new ChatComponentText("Boss Lvl1 spawnado em " + x + ", " + y + ", " + z + " no mundo " + worldName + "."));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2; // Permissão de operador (ou superior)
    }
}