package de.deaddoctor

// Notes: Game #247 crashed and simon as survivor might have been counted as a win

// Ideas:
//  - All statistics per game played (e.g. voted out count)
//  - Probability of vote out after self report
//  - Change in probabilities after self report

fun main() {
    val games = parseGames()

    val player = "Ethan"
    val wonGames = games.filter { it.played(player) && it.won(player) }
    val lostGames = games.filter { it.played(player) && !it.won(player) }
    println(wonGames.size)
    println(wonGames.filter { it.getRole(player) != Role.CREWMATE || it.winner != Team.CREWMATE }.filter { it.getRole(player) != Role.IMPOSTER || it.winner != Team.IMPOSTER }.joinToString("\n") { "[${it.id}] ${it.getRole(player)} -> ${it.winner} (${it.link})" })
    println(lostGames.size)
    println(lostGames.filter { it.getRole(player) != Role.CREWMATE || it.winner != Team.IMPOSTER }.filter { it.getRole(player) != Role.IMPOSTER || it.winner != Team.CREWMATE }.joinToString("\n") { "[${it.id}] ${it.getRole(player)} -x ${it.winner} (${it.link})" })
}