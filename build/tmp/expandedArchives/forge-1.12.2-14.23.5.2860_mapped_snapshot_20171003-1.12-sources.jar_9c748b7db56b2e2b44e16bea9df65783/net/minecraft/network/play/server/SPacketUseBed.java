package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SPacketUseBed implements Packet<INetHandlerPlayClient>
{
    private int playerID;
    private BlockPos bedPos;

    public SPacketUseBed()
    {
    }

    public SPacketUseBed(EntityPlayer player, BlockPos posIn)
    {
        this.playerID = player.getEntityId();
        this.bedPos = posIn;
    }

    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.playerID = buf.readVarInt();
        this.bedPos = buf.readBlockPos();
    }

    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeVarInt(this.playerID);
        buf.writeBlockPos(this.bedPos);
    }

    public void processPacket(INetHandlerPlayClient handler)
    {
        handler.handleUseBed(this);
    }

    @SideOnly(Side.CLIENT)
    public EntityPlayer getPlayer(World worldIn)
    {
        return (EntityPlayer)worldIn.getEntityByID(this.playerID);
    }

    @SideOnly(Side.CLIENT)
    public BlockPos getBedPosition()
    {
        return this.bedPos;
    }
}
