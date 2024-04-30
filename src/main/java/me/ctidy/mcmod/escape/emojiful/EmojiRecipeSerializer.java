package me.ctidy.mcmod.escape.emojiful;

import com.google.gson.JsonObject;
import me.ctidy.mcmod.escape.utils.ByteBufUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class EmojiRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<DummyRecipe>{

    public static final String ID = "emojiful:emoji_recipe";

    public static final EmojiRecipeSerializer INSTANCE = new EmojiRecipeSerializer(ID);

    public static final RecipeType<Recipe<?>> TYPE = RecipeType.register(ID);

    protected EmojiRecipeSerializer(String id) {
        setRegistryName(id);
    }

    @Override
    public DummyRecipe fromJson(ResourceLocation id, JsonObject json) {
        return new DummyRecipe(TYPE, this, id);
    }

    @Override
    public DummyRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
        ByteBufUtil.skipUtf(buffer);
        ByteBufUtil.skipUtf(buffer);
        ByteBufUtil.skipUtf(buffer);
        return new DummyRecipe(TYPE, this, id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, DummyRecipe recipe) {
        // do nothing
    }

}
