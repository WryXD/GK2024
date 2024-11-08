package com.example.a20130111

sealed class Data(
    val playedName: String,
    val avatar: Int
) {
    data object Faker: Data(
        playedName = "Faker",
        avatar = R.drawable.faker,
    )

    data object Gumayushi: Data(
        playedName = "Gumayushi",
        avatar = R.drawable.gumayusi,
    )

    data object Keria: Data(
        playedName = "Keria",
        avatar = R.drawable.keria,
    )

    data object Oner: Data(
        playedName = "Oner",
        avatar = R.drawable.oner,
    )

    data object Zues: Data(
        playedName = "Zues",
        avatar = R.drawable.zeus,
    )
}