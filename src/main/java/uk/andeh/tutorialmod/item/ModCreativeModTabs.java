package uk.andeh.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uk.andeh.tutorialmod.TutorialMod;
import uk.andeh.tutorialmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB =
            CREATIVE_MOD_TABS.register(
                    "tutorial_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                            .title(Component.translatable("creativetab.tutorial_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.SAPPHIRE.get());
                                pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                                // To add a Vanilla Minecraft item:
                                // pOutput.accept(Items.DIAMOND); // .get() not needed for vanilla items

                                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
