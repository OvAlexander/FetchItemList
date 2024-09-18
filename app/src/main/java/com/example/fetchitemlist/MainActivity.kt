package com.example.fetchitemlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONException
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private  lateinit var adapter : ItemAdapter

    private fun extractNumber(str: String?): Int? {
        // Function to extract numbers from a string using regex
        val regex = "\\d+".toRegex()
        val match = regex.find(str.toString())
        return match?.value?.toInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        try {
            // Read JSON file from assets
            val assetManager = assets
            val inputStream = assetManager.open("hiring.json")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val builder = StringBuilder()
            var line: String? = reader.readLine()

            // While the file has readable lines continue to build the string
            while (line != null) {
                builder.append(line)
                line = reader.readLine()

            }

            // Store retrieved JSON Data as a string
            val jsonData = builder.toString()

            // Parse JSON Data using GSON to fit the Item data class format
            val itemList = Gson().fromJson(jsonData, Array<Item>::class.java).toList()

            // Declare sort order of listId
            val listIdOrder = listOf(1,2,3,4)

            // Group JSON Items in descending order by listId while filtering out null or blank names
            val groupedItems = itemList
                .filter { it.name != null && it.name.isNotBlank() }
                .groupBy { it.listId }
                .mapValues { (_, items) -> items.sortedByDescending { it.listId } }

            // Sort groups by listIdOrder then sort by ItemName by looking at the numbers
            val sortedGroups = groupedItems
                .entries
                .sortedBy { listIdOrder.indexOf(it.key) }
                .associate { it.key to it.value }
                .mapValues { (_, items) -> items.sortedBy { extractNumber(it.name) ?: 0 } }

            // Create list of sorted items
            val sortedItems = sortedGroups.values.flatten()
            // Populate recyclerView with sortedItems using ItemAdapter
            adapter = ItemAdapter(sortedItems)
            recyclerView.adapter = adapter
        } catch (e: JSONException){
            e.printStackTrace()
        }
    }
}