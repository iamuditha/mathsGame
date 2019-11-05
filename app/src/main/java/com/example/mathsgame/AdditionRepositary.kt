package com.example.mathsgame

class AdditionRepositary {

    fun fetchAdditionQuiz() : List<Quiz>{
        return listOf(
            Quiz(1,"2","+","4"),
            Quiz(2,"5","+","3"),
            Quiz(3,"1","+","5")
            )
    }
}