package azmalent.backportedflora.common.world

import azmalent.backportedflora.common.block.flower.AbstractFlower
import azmalent.backportedflora.common.block.seaweed.BlockKelp
import azmalent.backportedflora.common.registry.ModBlocks
import azmalent.backportedflora.common.util.WorldGenUtil
import net.minecraft.block.material.Material
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.ChunkPos
import net.minecraft.world.World
import net.minecraft.world.WorldType
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.IChunkGenerator
import net.minecraft.world.gen.feature.WorldGenBush
import net.minecraft.world.gen.feature.WorldGenFlowers
import net.minecraftforge.fml.common.IWorldGenerator
import java.util.*
import kotlin.math.roundToInt

class WorldGenNetherFlowers(private val flower: AbstractFlower, number: Float) : WorldGenCustomFlowers(flower) {
    override fun getGenerationPos(world: World, rand: Random, chunkPos: ChunkPos): BlockPos {
        val x = rand.nextInt(16) + 8
        val z = rand.nextInt(16) + 8
        val y = rand.nextInt(64) + 32

        return chunkPos.getBlock(0, 0, 0).add(x, y, z)
    }

    override val generationChance = 0.5
    override val patchGenerationAttempts = 8
    override val flowerGenerationAttempts = (64 * number).roundToInt()

    override fun canGenerateInWorld(world: World): Boolean {
        return world.provider.dimension == -1
    }
}