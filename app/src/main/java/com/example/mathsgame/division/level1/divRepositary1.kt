package com.example.mathsgame.division.level1

import com.example.mathsgame.substraction.substraction.level1.Quiz1

class divRepositary1 {

    fun fetchAdditionQuiz() : List<Quiz1>{
        return listOf(
            Quiz1(
                1,
                "4",
                "/",
                "2"
            ),
            Quiz1(
                2,
                "5",
                "/",
                "1"
            ),
            Quiz1(
                3,
                "6",
                "/",
                "3"
            ),
            Quiz1(
                4,
                "6",
                "/",
                "2"
            ),
            Quiz1(
                5,
                "6",
                "/",
                "3"
            ),
            Quiz1(
                6,
                "5",
                "/",
                "1"
            )
        )
    }
}