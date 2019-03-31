package dev.denisnosoff.newsapp.model.data

data class User(
    val email: String,
    val id: String,
    val username: String,
    val favorite: List<String> = listOf()
) {
}