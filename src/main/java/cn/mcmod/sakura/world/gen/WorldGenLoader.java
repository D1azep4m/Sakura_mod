package cn.mcmod.sakura.world.gen;

import java.util.Random;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.world.biome.SakuraBiomes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenLoader {
	
	public WorldGenLoader() {
		GameRegistry.registerWorldGenerator(new WorldGenBambooShot(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenPepper(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenVanilla(), 1);
	}
	@SubscribeEvent
	public void onOreGen(OreGenEvent.Post event) {
		World worldIn = event.getWorld();
        int genY = 10 + event.getRand().nextInt(24);
		if (worldIn.getBiome(new BlockPos(event.getPos().getX(), 0, event.getPos().getZ())) == SakuraBiomes.BAMBOOFOREST ||
			worldIn.getBiome(new BlockPos(event.getPos().getX(), 0, event.getPos().getZ())) == SakuraBiomes.MAPLEFOREST) {
			BlockPos pos=new BlockPos(event.getPos().getX(),genY, event.getPos().getZ());
                for (int i = 0; i < 2; i++) {
                    new WorldGenMinable(BlockLoader.SAKURA_DIAMOND_ORE.getDefaultState(),3 + event.getRand().nextInt(5)).generate(worldIn, event.getRand(), pos);
                }
        }

	}
	
}
