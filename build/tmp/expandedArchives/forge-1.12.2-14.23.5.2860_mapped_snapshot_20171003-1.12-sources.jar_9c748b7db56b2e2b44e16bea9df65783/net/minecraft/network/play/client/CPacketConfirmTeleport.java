package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CPacketConfirmTeleport implements Packet<INetHandlerPlayServer>
{
    private int telportId;

    public CPacketConfirmTeleport()
    {
    }

    @SideOnly(Side.CLIENT)
    public CPacketConfirmTeleport(int teleportIdIn)
    {
        this.telportId = teleportIdIn;
    }

    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.telportId = buf.readVarInt();
    }

    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeVarInt(this.telportId);
    }

    public void processPacket(INetHandlerPlayServer handler)
    {
        handler.processConfirmTeleport(this);
    }

    public int getTeleportId()
    {
        return this.telportId;
    }
}
