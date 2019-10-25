package com.github.leonchrisdion.avengersEndgame

import timber.log.Timber
import android.app.Application

class MyApplication: Application() {

    data class Scene(
        val title: String,
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"


        // Scenes
        val scenes: List<Scene> = listOf (
            // 0
            Scene (
                "Introduction",
                "You are part of Avengers, the Informatics. " +
                        "Thanos has erased half of the existence",


                    actions = listOf (
                    "Click",
                    "CLICKKKK"

                )
            ),

            // 1
            Scene (
                "Thanos get Infinity Stones",
                "Half of existence erased",
                actions = listOf (
                    "Give up",
                    "Kill Thanos"
                )
            ),

            // 2
            Scene (
                "Kill Thanos",
                "Avengers assemble to kill Thanos in the Garden",
                actions = listOf (
                    "Stones Retrieved",
                    "Stones not retrived"

                )
            ),

            // 3
            Scene (
                "Stones not Retrived",
                "Thanos has used the stones to destroy the stones it self",
                actions = listOf (
                    "Give up",
                    "Create time machine"

                )
            ),

            // 4
            Scene (
                "Create time machine",
                "Scott and Hulk trying to create the time machine",
                actions = listOf (
                    "Time machine completed",
                    "Time machine failed"

                )
            ),

            // 5
            Scene (
                "Time machine completed",
                "Avengers go back to the past and try to retriveing the stons",
                actions = listOf (
                    "Retrived the stones",
                    "Failed retrieved the stones"
                )
            ),

            // 6
            Scene (
                "Retrived the stones",
                "Avengers come back to the present time",
                actions = listOf (
                    "Make all existence back to normal",
                    "Thanos comes"
                )
            ),

            // 7 -- badEnding1
            Scene (
                "Bad Ending: All existence erased",
                "Thanos get the stones and erased all existence",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN

                )
            ),

            // 8
            Scene (
                "Thanos comes",
                "Thanos use nebula time machine to come to the presents time",
                actions = listOf (
                    "Thanos get the stones",
                    "Thanos defeated"

                )
            ),

            // 9
            Scene (
                "Thanos Get the Stones",
                "Thanos will use the stones to erased all existence",
                actions = listOf (
                    "Thanos erased all existence",
                    "Avengers get back the stones",
                    "You spot a radio on him. But you" +
                            " play it smart. You have 2 apples. You give him one while saying 'Get some rest, sir. " +
                            "You need it. I'm going to Wanadu for some water. I'm thirsty.'",
                    ""
                )
            ),


            // 10
            Scene (
                "Normal Ending: Thanos erased half of the existence",
                "Thanos erase all existence and you failed to restore the existence",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN
                )
            ),



            // 11
            Scene (
                "Best Ending: You're a hero, you restore all existence back to normal",
                "Congratulations Avengers",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN
                )
            )

            )

        // Ending flags
        var badEnding = false
        var normalEnding = false
        var bestEnding = false

        // Utils
        lateinit var currentDisplayedEnding: Scene


    }
}