package com.example.mathsgame.addition

class AdditionRepositary1 {

    fun fetchAdditionQuiz() : List<Quiz1>{
        return listOf(
            Quiz1(1, "2", "+", "3"),
            Quiz1(2, "5", "+", "4"),
            Quiz1(3, "1", "+", "5"),
            Quiz1(4, "6", "+", "2"),
            Quiz1(5, "3", "+", "3"),
            Quiz1(6, "5", "+", "1")
        )
    }
}