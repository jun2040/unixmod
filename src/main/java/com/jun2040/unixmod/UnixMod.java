package com.jun2040.unixmod;

        import com.jun2040.unixmod.blocks.*;
        import com.jun2040.unixmod.items.AlienFeces;
        import com.jun2040.unixmod.items.ModItems;
        import com.jun2040.unixmod.setup.ClientProxy;
        import com.jun2040.unixmod.setup.IProxy;
        import com.jun2040.unixmod.setup.ModSetup;
        import com.jun2040.unixmod.setup.ServerProxy;
        import net.minecraft.block.Block;

        import net.minecraft.inventory.container.ContainerType;
        import net.minecraft.item.BlockItem;
        import net.minecraft.item.Item;
        import net.minecraft.tileentity.TileEntityType;
        import net.minecraft.util.math.BlockPos;
        import net.minecraftforge.common.MinecraftForge;
        import net.minecraftforge.common.extensions.IForgeContainerType;
        import net.minecraftforge.event.RegistryEvent;
        import net.minecraftforge.eventbus.api.SubscribeEvent;
        import net.minecraftforge.fml.DistExecutor;
        import net.minecraftforge.fml.common.Mod;
        import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
        import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
        import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
        import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
        import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
        import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;

@Mod("unixmod")
public class UnixMod {

    public static final String MODID = "unixmod";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public UnixMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event) {
    }


    private void doClientStuff(final FMLClientSetupEvent event) {

    }


    private void enqueueIMC(final InterModEnqueueEvent event) {
    }


    private void processIMC(final InterModProcessEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new Fabricator());
            event.getRegistry().register(new Bioreactor());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.FABRICATOR, new Item.Properties().group(setup.subnautica)).setRegistryName("fabricator"));
            event.getRegistry().register(new BlockItem(ModBlocks.BIOREACTOR, new Item.Properties().group(setup.subnautica)).setRegistryName("bioreactor"));
            event.getRegistry().register(new AlienFeces());
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(FabricatorTile::new, ModBlocks.FABRICATOR).build(null).setRegistryName("fabricator"));
            event.getRegistry().register(TileEntityType.Builder.create(FabricatorTile::new, ModBlocks.BIOREACTOR).build(null).setRegistryName("bioreactor"));
        }

        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new BioreactorContainer(windowId, UnixMod.proxy.getClientWorld(), pos, inv, UnixMod.proxy.getClientPlayer());
            }).setRegistryName("bioreactor"));
        }

    }

}
