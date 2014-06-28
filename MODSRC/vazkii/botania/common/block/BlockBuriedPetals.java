/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jun 28, 2014, 6:43:33 PM (GMT)]
 */
package vazkii.botania.common.block;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import vazkii.botania.client.core.helper.IconHelper;
import vazkii.botania.common.Botania;
import vazkii.botania.common.core.handler.ConfigHandler;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibBlockNames;

public class BlockBuriedPetals extends BlockModFlower {

	public BlockBuriedPetals() {
		super(LibBlockNames.BURIED_PETALS);
		setBlockBounds(0F, 0F, 0F, 1F, 0.1F, 1F);
	}
	
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		float[] color = EntitySheep.fleeceColorTable[meta];

		Botania.proxy.setSparkleFXNoClip(true);
		Botania.proxy.sparkleFX(par1World, par2 + 0.3 + par5Random.nextFloat() * 0.5, par3 + 0.1 + par5Random.nextFloat() * 0.1, par4 + 0.3 + par5Random.nextFloat() * 0.5, color[0], color[1], color[2], par5Random.nextFloat(), 5);
		Botania.proxy.setSparkleFXNoClip(false);
	}
	
	@Override
	boolean registerInCreative() {
		return false;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}
	
	@Override
	public IIcon getIcon(int par1, int par2) {
		return blockIcon;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ModItems.petal;
	}
	
	@Override
	public int getRenderType() {
		return 0;
	}
}