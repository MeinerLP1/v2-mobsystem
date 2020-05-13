package eu.cloudservice.cloudmob.in;

import de.dytanic.cloudnet.lib.network.protocol.packet.Packet;
import de.dytanic.cloudnet.lib.network.protocol.packet.PacketInHandler;
import de.dytanic.cloudnet.lib.network.protocol.packet.PacketSender;
import de.dytanic.cloudnet.lib.utility.document.Document;
import de.dytanic.cloudnetcore.CloudNet;
import eu.cloudnetservice.cloudmob.ServerMob;
import eu.cloudservice.cloudmob.MobModule;

public class PacketInRemoveMob extends PacketInHandler {

    public void handleInput(Document packet, PacketSender packetSender) {
        ServerMob serverMob = packet.getObject("mob", ServerMob.TYPE);
        MobModule.getInstance().getMobDatabase().remove(serverMob);
        CloudNet.getInstance().getNetworkManager().reload();
        CloudNet.getInstance().getNetworkManager().updateAll();
    }
}