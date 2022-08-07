package com.vont

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // an array that holds some anime titles, and can be added to
        val animeList = arrayListOf("Attack on Titan","Dragon Ball Z","One Piece","Naruto","Fairy Tale","Fullmetal Alchemist","Death Note","Dr. Stone","No Game No Life","Senko")


        // when the decide button is clicked, this will cause the button to listen for that click
        // and randomly display a random anime name from the array list
        // also save the index value after each click
        var index = 0
        decideButton.setOnClickListener{
            println("The decide button has been clicked :3")
            val lol = Random()
            val randomAnime = lol.nextInt(animeList.size)
            index = randomAnime
            selectedAnimeText.text = animeList.get(randomAnime)
            appDescription.text = ""
        }

        // when the add button is clicked, this will cause the button to listen for that click
        // and add whatever is in the animeAddTextBox
        addAnimeButton.setOnClickListener{
            println("The add button has been clicked :3")
            val newAnime: String = addAnimeTextBox.text.toString()
            if(newAnime != "") {
                animeList.add(newAnime)
                addAnimeTextBox.text.clear()
                appDescription.text = "$newAnime was added!"
            }
            println(animeList)
        }

        // when the remove button is clicked, remove the anime name that is being displayed
        // then display a random other one
        removeAnimeButton.setOnClickListener{
            println("The remove button has been clicked :3")
            if(animeList.size != 1) {
                appDescription.text = "${animeList.get(index)} was removed!"
                animeList.removeAt(index)
                val random = Random()
                val randomAnime = random.nextInt(animeList.size)
                selectedAnimeText.text = animeList.get(randomAnime)
                index = randomAnime
            } else {
              appDescription.text = "Can't remove anymore!"
            }
            println(animeList)
        }

    }
}
