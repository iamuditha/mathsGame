package com.example.mathsgame.addition

class AdditionRepositary2 {

    fun fetchAdditionQuiz() : List<Quiz2>{
        return listOf(
            Quiz2(1, "2", "2", "+","5","4"),
            Quiz2(2, "4", "1", "+","2","1"),
            Quiz2(3, "5", "2", "+","4","4"),
            Quiz2(4, "3", "1", "+","1","1")

            )
    }
}