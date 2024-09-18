package com.example.fetchitemlist
/**
 * Data class for an [Item] with the following properties:
 *
 * @property id Integer unique id of item
 * @property listId Integer id of which list item belongs to
 * @property name String of item name
 */
data class Item(
    val id: Int,
    val listId: Int,
    val name: String
)
