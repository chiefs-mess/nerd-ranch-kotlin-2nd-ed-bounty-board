const val HERO_NAME = "Madrigal"
var playerLevel = 5

fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)
    println(playerLevel)

    readBountyBoard()

    println("Time passes...")
    println("The hero returns from her quest.")

    playerLevel += 1
    println(playerLevel)
    readBountyBoard()
}

private fun readBountyBoard() {
    println("The hero approaches the bounty board. It reads:")
    println(
        obtainQuest(
            playerLevel = playerLevel,
        )
    )
}


private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "paladin",
    hasBefriendedBarbarians: Boolean = true,
    hasAngeredBarbarians: Boolean = false,
): String =
    when (playerLevel) {
        1 -> "Meet Mr. Bubbles in the land of soft things."
        in 2..5 -> {
            // Check whether diplomacy is an option
            val canTalkToBarbarians = !hasAngeredBarbarians &&
                    (hasBefriendedBarbarians || playerClass == "barbarian")

            if (canTalkToBarbarians) {
                "Convince the barbarians to call off their invasion."
            } else {
                "Save the town from the barbarian invasions."
            }
        }

        6 -> "Locate the enchanted sword."
        7 -> "Recover the long-lost artifact of creation."
        8 -> "Defeat Nogartse, bringer of death and eater of worlds."
        else -> "There are no quests right now."
    }

