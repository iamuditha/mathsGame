package com.example.mathsgame

class AdditionRepositary {

    fun fetchAdditionQuiz() : List<Quiz>{
        return listOf(
            Quiz(1,"2","+","3"),
            Quiz(2,"5","+","4"),
            Quiz(3,"1","+","5"),
            Quiz(4,"6","+","2"),
            Quiz(5,"3","+","3"),
            Quiz(6,"5","+","1")
        )
    }
}