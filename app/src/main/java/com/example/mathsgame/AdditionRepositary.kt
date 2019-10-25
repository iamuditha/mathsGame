package com.example.mathsgame

class AdditionRepositary {

    fun fetchAdditionQuiz() : List<Quiz>{
        return listOf(
            Quiz(1,"2 + 5"),
            Quiz(1,"4 + 6"),
            Quiz(1,"12 + 5")
            )
    }
}