package de.deaddoctor

import java.io.File

const val prefix = "MoreSidemen Among Us"

fun readTable(table: String) = CSV(File("$prefix - $table.csv").readText())

class CSV(private val text: String) {
    val head: List<String>
    val body: List<List<String>>

    init {
        head = parseLine()
        val lines = mutableListOf<List<String>>()
        while (!finished) {
            lines.add(parseLine())
        }
        body = lines
    }

    private var i = 0

    private val current get() = text[i]
    private fun consume() = text[i++]
    private val finished
        get() = i >= text.length

    private fun parseLine(): List<String> {
        val result = mutableListOf<String>()
        do {
            result.add(parseValue())
        } while (!finished && consume() != '\n')
        return result
    }

    private fun parseValue(): String {
        var result = ""
        var stringLiteral = false
        while (!finished) {
            when {
                current == '"' -> stringLiteral = !stringLiteral
                !stringLiteral && (current == '\n' || current == ',') -> break
            }
            result += consume()
        }
        return result
    }
}

data class PlayerInfo(val players: Map<Player, Role>, val totalTasks: Int?, val completedTasks: Map<Player, Int>)

fun parsePlayerInfo(playersInfoValue: String): PlayerInfo {
    val playersInfo = playersInfoValue.split(',')
    val players = mutableMapOf<Player, Role>()
    var totalTasks: Int? = null
    val completedTasks = mutableMapOf<Player, Int>()
    for (playerInfo in playersInfo) {
        val parts = playerInfo.split(" - ")
        val name = parts[0]
        players[name] = Role.parse(parts[1])
        if (parts.size == 3) {
            val tasks = parts[2].removeSurrounding("(", ")").split("/").map(String::toInt)
            if (totalTasks != null && totalTasks != tasks[1]) throw IllegalArgumentException("Different total task values in a single game: $totalTasks != ${tasks[1]}")
            totalTasks = tasks[1]
            completedTasks[name] = tasks[0]
        }
    }
    return PlayerInfo(players, totalTasks, completedTasks)
}

fun parseGames(): List<Game> {
    val gamesTable = readTable("Games")
    return gamesTable.body.map {
        val playerInfo = parsePlayerInfo(it[4].removeSurrounding("\""))
        Game(it[0].toInt(), it[1], Team.parse(it[2]), it[3], playerInfo.players, playerInfo.totalTasks, playerInfo.completedTasks)
    }
}