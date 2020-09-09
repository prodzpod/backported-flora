package azmalent.backportedflora

import net.minecraftforge.common.config.Configuration

object ModConfig {
    object Seaweed {
        private const val NAME = "Seaweed"
        var seagrassEnabled = true
        var kelpEnabled = true
        var kelpGrowthEnabled = true
        var driedKelpEnabled = true
        var kelpSoupEnabled = true
        var seagrassSpawnRate = 1f
        var kelpSpawnRate = 1f

        fun init(cfg: Configuration) {
            cfg.addCustomCategoryComment(NAME, "Features related to kelp.")

            seagrassEnabled = cfg.getBoolean("Seagrass", NAME, seagrassEnabled,
                    "Whether seagrass is registered")
            kelpEnabled = cfg.getBoolean("Kelp", NAME, kelpEnabled,
                    "Whether kelp is registered")
            kelpGrowthEnabled = cfg.getBoolean("Kelp Grows", NAME, kelpGrowthEnabled,
                    "Should kelp grow on its own?")
            driedKelpEnabled = cfg.getBoolean("Dried Kelp", NAME, driedKelpEnabled,
                    "Whether dried kelp is enabled.\n" +
                            "Dried kelp is a food item that can be eaten quickly.\n" +
                            "You can also craft it into blocks that can be used as fuel.")
            kelpSoupEnabled = cfg.getBoolean("Kelp Soup", NAME, kelpSoupEnabled,
                    "Whether kelp can be cooked into delicious soup")
            seagrassSpawnRate = cfg.getFloat("Seagrass Spawn Rate", NAME, seagrassSpawnRate, 0f, 10f,
                    "How much seagrass should spawn underwater.")
            kelpSpawnRate = cfg.getFloat("Kelp Spawn Rate", NAME, kelpSpawnRate, 0f, 10f,
                    "How much kelp should spawn underwater.")
        }
    }

    object Flowers {
        private const val NAME = "Flowers"
        var cornflowerEnabled = true
        var lilyOfTheValleyEnabled = true
        var witherRoseEnabled = true
        var witherRoseCausesWither = true
        var cornflowerSpawnRate = 1f
        var lilyOfTheValleySpawnRate = 1f
        var witherRoseSpawnRate = 1f

        fun init(cfg: Configuration) {
            cfg.addCustomCategoryComment(NAME, "Features related to flowers added by this mod.")

            cornflowerEnabled = cfg.getBoolean("Cornflower", NAME, cornflowerEnabled,
                    "Whether cornflowers are enabled.")

            lilyOfTheValleyEnabled = cfg.getBoolean("Lily of the Valley", NAME, lilyOfTheValleyEnabled,
                    "Whether lilies of the valley are enabled.")

            witherRoseEnabled = cfg.getBoolean("Wither Rose", NAME, witherRoseEnabled,
                    "Whether wither roses are enabled.\n" +
                            "Unlike wither roses in vanilla 1.14, they will spawn on soul sand in the Nether.")
            witherRoseCausesWither = cfg.getBoolean("Wither Roses Cause Wither", NAME, witherRoseCausesWither,
                    "Should wither roses apply wither?")
            cornflowerSpawnRate = cfg.getFloat("Cornflower Spawn Rate", NAME, cornflowerSpawnRate, 0f, 10f,
                    "How much cornflower should spawn on the fields.")
            lilyOfTheValleySpawnRate = cfg.getFloat("Lily of the Valley Spawn Rate", NAME, lilyOfTheValleySpawnRate, 0f, 10f,
                    "How much lily of the valley should spawn on the fields.")
            witherRoseSpawnRate = cfg.getFloat("Wither Rose Spawn Rate", NAME, witherRoseSpawnRate, 0f, 10f,
                    "How much wither rose should spawn on the fields.")
        }
    }

    fun sync() {
        val config = BackportedFlora.config

        try {
            config.load()
            Seaweed.init(config)
            Flowers.init(config)
        } catch(e: Exception) {
            BackportedFlora.logger.error("Error: failed to load config!")
        } finally {
            if (config.hasChanged()) {
                config.save()
            }
        }
    }
}
