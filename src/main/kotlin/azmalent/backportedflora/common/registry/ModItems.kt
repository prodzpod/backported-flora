package azmalent.backportedflora.common.registry

import azmalent.backportedflora.ModConfig
import azmalent.backportedflora.common.item.ItemDriedKelp
import azmalent.backportedflora.common.item.ItemKelpSoup
import azmalent.backportedflora.common.item.ItemModIcon
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry

object ModItems {
    @GameRegistry.ObjectHolder(ItemModIcon.REGISTRY_NAME)
    lateinit var MOD_ICON: ItemModIcon

    @GameRegistry.ObjectHolder(ItemKelpSoup.REGISTRY_NAME)
    lateinit var KELP_SOUP: ItemKelpSoup

    @GameRegistry.ObjectHolder(ItemDriedKelp.REGISTRY_NAME)
    lateinit var DRIED_KELP: ItemDriedKelp

    fun register(registry: IForgeRegistry<Item>) {
        registry.register(ItemModIcon())

        if (ModConfig.Seaweed.kelpEnabled) {
            if (ModConfig.Seaweed.kelpSoupEnabled) registry.register(ItemKelpSoup())
            if (ModConfig.Seaweed.driedKelpEnabled) registry.register(ItemDriedKelp())
        }
    }

    @SideOnly(Side.CLIENT)
    fun registerModels() {
        MOD_ICON.registerItemModel()

        if (ModConfig.Seaweed.kelpEnabled) {
            if (ModConfig.Seaweed.kelpSoupEnabled) KELP_SOUP.registerItemModel()
            if (ModConfig.Seaweed.driedKelpEnabled) DRIED_KELP.registerItemModel()
        }
    }
}