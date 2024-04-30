package me.ctidy.mcmod.escape.utils;

import io.netty.handler.codec.DecoderException;
import net.minecraft.network.FriendlyByteBuf;

/**
 * ByteBufUtil
 *
 * @author ctidy
 * @since 2024/4/29
 */
public class ByteBufUtil {

    public static void skipUtf(FriendlyByteBuf buf) {
        skipUtf(buf, 32767);
    }

    public static void skipUtf(FriendlyByteBuf buf, int max) {
        int i = buf.readVarInt();
        if (i > max * 4) {
            throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + i + " > " + max * 4 + ")");
        } else if (i < 0) {
            throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
        }
        buf.readerIndex(buf.readerIndex() + i);
    }

}
