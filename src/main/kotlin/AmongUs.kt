package de.deaddoctor

data class Game(val id: Int, val link: String, val winner: Team, val map: String, private val players: Map<Player, Role>, val totalTasks: Int?, val completedTasks: Map<Player, Int>) {
    fun getPlayers() = players.keys
    fun played(player: Player) = players.containsKey(player)
    fun getRole(player: Player) = players[player]
    fun won(player: Player) = getRole(player)?.won(winner) ?: false
}

enum class Role(private vararg val teams: Team) {
    CREWMATE(Team.CREWMATE),
    IMPOSTER(Team.IMPOSTER),
    ENGINEER(Team.CREWMATE),
    SCIENTIST(Team.CREWMATE),
    SHAPESHIFTER(Team.IMPOSTER),
    JESTER(Team.JESTER),
    SHERIFF(Team.CREWMATE),
    MAYOR(Team.CREWMATE),
    MEDIC(Team.CREWMATE),
    SWAPPER(Team.CREWMATE),
    SWOOPER(Team.IMPOSTER),
    JANITOR(Team.IMPOSTER),
    GIANT_CREWMATE(Team.CREWMATE),
    GIANT_IMPOSTER(Team.IMPOSTER),
    FLASH_IMPOSTER(Team.IMPOSTER),
    FLASH_CREWMATE(Team.CREWMATE),
    GUARDIAN_ANGEL(Team.CREWMATE),
    DETECTIVE(Team.CREWMATE),
    ALTRUIST(Team.CREWMATE),
    TRACKER(Team.CREWMATE),
    MORPHLING(Team.IMPOSTER),
    ESCAPIST(Team.IMPOSTER),
    CREWMATE_LOVER(Team.CREWMATE, Team.LOVER),
    IMPOSTER_LOVER(Team.IMPOSTER, Team.LOVER),
    TRAITOR(Team.IMPOSTER),
    GRENADIER(Team.IMPOSTER),
    SEER(Team.CREWMATE),
    SPY(Team.CREWMATE),
    MYSTIC(Team.CREWMATE),
    TRAPPER(Team.CREWMATE),
    PHANTOM,
    HAUNTER(Team.CREWMATE),
    WEREWOLF,
    AMNESIAC,
    BLACKMAILER(Team.IMPOSTER),
    INVESTIGATOR(Team.CREWMATE),
    SURVIVOR,
    SNITCH(Team.CREWMATE),
    MINER(Team.IMPOSTER),
    GLITCH,
    JUGGERNAUT,
    BOMBER(Team.IMPOSTER),
    CAMOUFLAGER(Team.IMPOSTER),
    BOUNTY_HUNTER(Team.IMPOSTER),
    NINJA(Team.IMPOSTER),
    VAMPIRE(Team.IMPOSTER),
    WARLOCK(Team.IMPOSTER),
    CHAMELEON_CREWMATE(Team.CREWMATE),
    CHAMELEON_IMPOSTER(Team.IMPOSTER),
    BAD_LAWYER(Team.IMPOSTER),
    MEDIUM(Team.CREWMATE),
    SECURITY_GUARD(Team.CREWMATE),
    PORTAL_MAKER(Team.CREWMATE),
    WITCH(Team.IMPOSTER),
    ERASER(Team.IMPOSTER),
    PURSUER,
    DEPUTY(Team.CREWMATE),
    PROSECUTOR(Team.PROSECUTOR),
    CLEANER(Team.IMPOSTER),
    GODFATHER(Team.IMPOSTER),
    MAFIOSO(Team.IMPOSTER),
    BLOODY_VULTURE(Team.VULTURE),
    INVERT_THIEF, // never won
    SUNGLASSES_LIGHTER(Team.CREWMATE),
    VULTURE(Team.VULTURE),
    INVERT_MAYOR(Team.CREWMATE),
    THIEF, // never won
    LIGHTER(Team.CREWMATE),
    BLOODY_BOMBER(Team.IMPOSTER),
    SUNGLASSES_TRAPPER(Team.CREWMATE),
    BLOODY_CREWMATE(Team.CREWMATE),
    INVERT_CREWMATE(Team.CREWMATE),
    MINI_CREWMATE(Team.CREWMATE),
    MINI_IMPOSTER(Team.IMPOSTER),
    INVERT_VULTURE(Team.VULTURE),
    TIME_MASTER(Team.CREWMATE),
    SUNGLASSES_CREWMATE(Team.CREWMATE),
    CHAMELEON_MORPHLING(Team.IMPOSTER),
    SUNGLASSES_TIME_MASTER(Team.CREWMATE),
    ENGINEER_LOVER(Team.CREWMATE, Team.LOVER),
    SUNGLASSES_NICE_GUESSER(Team.CREWMATE),
    BAIT_BOUNTY_HUNTER(Team.IMPOSTER),
    MINI_JESTER(Team.JESTER),
    ANTI_TP_THIEF, // never won
    CHAMELEON_CAMOUFLAGER(Team.IMPOSTER),
    INVERT_JACKAL(Team.JACKAL),
    BLOODY_PURSUER,
    ARSONIST_LOVER(Team.LOVER, Team.ARSONIST),
    SUNGLASSES_MAYOR(Team.CREWMATE),
    INVERT_CAMOUFLAGER(Team.CREWMATE),
    SWAPPER_LOVER(Team.CREWMATE, Team.LOVER),
    BLOODY_BOUNTY_HUNTER(Team.IMPOSTER),
    MINI_ARSONIST(Team.ARSONIST),
    ANTI_TP_JESTER(Team.JESTER),
    CHAMELEON_SPY(Team.CREWMATE),
    BAIT_VULTURE(Team.VULTURE),
    ARSONIST(Team.ARSONIST),
    TIE_BREAKER_ARSONIST(Team.ARSONIST),
    MINI_VULTURE(Team.VULTURE),
    CHAMELEON_JACKAL(Team.JACKAL),
    TRAPPER_LOVER(Team.CREWMATE, Team.LOVER),
    SPY_LOVER(Team.CREWMATE, Team.LOVER),
    VIP_ERASER(Team.IMPOSTER),
    ANTI_TP_MORPHLING(Team.IMPOSTER),
    INVERT_JESTER(Team.JESTER),
    TIE_BREAKER_PURSUER,
    BLOODY_TIME_MASTER(Team.CREWMATE),
    JESTER_LOVER(Team.JESTER, Team.LOVER),
    ANTI_TP_NINJA(Team.IMPOSTER),
    JACKAL_LOVER(Team.JACKAL, Team.LOVER),
    VIP_TRAPPER(Team.CREWMATE),
    MINI_BOUNTY_HUNTER(Team.IMPOSTER),
    SUNGLASSES_ENGINEER(Team.CREWMATE),
    AURIAL(Team.CREWMATE),
    VENERER(Team.IMPOSTER),
    NOISE_MAKER(Team.CREWMATE),
    PHANTOM_IMPOSTER(Team.IMPOSTER),
    VETERAN(Team.CREWMATE),
    EXECUTIONER(Team.EXECUTIONER),
    SHIFTER, //TODO: Role changes later to arbitrary team
    JOKER, // never won
    ORACLE(Team.CREWMATE),
    PLAGUEBEARER, // never won
    DOOMSAYER(Team.DOOMSAYER),
    TIME_LORD(Team.CREWMATE),
    UNDERTAKER(Team.IMPOSTER),
    PELICAN(Team.PELICAN),
    PRIEST, // never won
    IMITATOR(Team.CREWMATE),
    BODYGUARD, // never won
    ASTRAL, // never won
    TRANSPORTER(Team.CREWMATE),
    VIGILANTE(Team.CREWMATE),
    HUNTER(Team.CREWMATE),
    BAIT_CREWMATE(Team.CREWMATE),
    DISEASED_CREWMATE(Team.CREWMATE);

    fun won(winner: Team) = winner in teams

    companion object {
        fun parse(name: String) = parseEnum(name, CREWMATE) { valueOf(it) }
    }
}

enum class Team {
    CREWMATE,
    IMPOSTER,
    JESTER,
    LOVER,
    PROSECUTOR,
    VULTURE,
    ARSONIST,
    JACKAL,
    EXECUTIONER,
    DOOMSAYER,
    PELICAN;

    companion object {
        fun parse(name: String) = parseEnum(name, CREWMATE) { valueOf(it) }
    }
}

private fun <T> parseEnum(name: String, default: T, convert: (String) -> T): T {
    val id = name.uppercase().replace(" ", "_")
    return try {
        convert(id)
    } catch (e: IllegalArgumentException) {
        default
    }
}

typealias Player = String