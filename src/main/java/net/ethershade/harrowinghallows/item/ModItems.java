package net.ethershade.harrowinghallows.item;

import net.ethershade.harrowinghallows.HarrowingHallows;
import net.ethershade.harrowinghallows.block.ModBlocks;
import net.ethershade.harrowinghallows.entity.custom.ModBoatEntity;
import net.ethershade.harrowinghallows.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HarrowingHallows.MOD_ID);

    public static final RegistryObject<Item> STYXITE_INGOT = ITEMS.register("styxite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_NUGGET = ITEMS.register("styxite_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_STYXITE = ITEMS.register("raw_styxite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STYXITE_SWORD = ITEMS.register("styxite_sword",
            () -> new SwordItem(ModToolTiers.STYXITE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_PICKAXE = ITEMS.register("styxite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STYXITE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_AXE = ITEMS.register("styxite_axe",
            () -> new AxeItem(ModToolTiers.STYXITE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_SHOVEL = ITEMS.register("styxite_shovel",
            () -> new ShovelItem(ModToolTiers.STYXITE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_HOE = ITEMS.register("styxite_hoe",
            () -> new HoeItem(ModToolTiers.STYXITE, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> STYXITE_HELMET = ITEMS.register("styxite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.STYXITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_CHESTPLATE = ITEMS.register("styxite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STYXITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_LEGGINGS = ITEMS.register("styxite_leggings",
            () -> new ArmorItem(ModArmorMaterials.STYXITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STYXITE_BOOTS = ITEMS.register("styxite_boots",
            () -> new ArmorItem(ModArmorMaterials.STYXITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> HALLOWED_SIGN = ITEMS.register("hallowed_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HALLOWED_SIGN.get(), ModBlocks.HALLOWED_WALL_SIGN.get()));
    public static final RegistryObject<Item> HALLOWED_HANGING_SIGN = ITEMS.register("hallowed_hanging_sign",
            () -> new HangingSignItem(ModBlocks.HALLOWED_HANGING_SIGN.get(), ModBlocks.HALLOWED_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> HALLOWED_BOAT = ITEMS.register("hallowed_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.HALLOWED, new Item.Properties()));
    public static final RegistryObject<Item> HALLOWED_CHEST_BOAT = ITEMS.register("hallowed_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.HALLOWED, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
