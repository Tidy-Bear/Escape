package me.ctidy.mcmod.escape;

import me.ctidy.mcmod.escape.emojiful.EmojiRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Escape.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Escape {

    public static final String MODID = "escape";
    public static final Logger LOGGER = LogManager.getLogger();

    public Escape() { }

    @SubscribeEvent
    public static void onRegistering(RegistryEvent.Register<RecipeSerializer<?>> event) {
        event.getRegistry().register(EmojiRecipeSerializer.INSTANCE);
    }

}
