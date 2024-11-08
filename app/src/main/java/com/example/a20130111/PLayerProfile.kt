package com.example.a20130111

sealed class PLayerProfile(
    val playerName: String,
    val contentImage: Int,
    val playerDescription: Int ,
) {
    data object Faker : PLayerProfile(
        playerName = "Faker",
        contentImage = R.drawable.faker,
        playerDescription = R.string.faker_wiki,
    )

    data object Oner : PLayerProfile(
        playerName = "Oner",
        contentImage = R.drawable.oner,
        playerDescription = R.string.oner_wiki,
    )

    data object Gumayushi : PLayerProfile(
        playerName = "Gumayushi",
        contentImage = R.drawable.gumayusi,
        playerDescription = R.string.gumayushi_wiki,
    )

    data object Keria : PLayerProfile(
        playerName = "Keria",
        contentImage = R.drawable.keria,
        playerDescription = R.string.keria_wiki,
    )

    data object Zues : PLayerProfile(
        playerName = "Zues",
        contentImage = R.drawable.zeus,
        playerDescription = R.string.zues_wiki,
    )
}