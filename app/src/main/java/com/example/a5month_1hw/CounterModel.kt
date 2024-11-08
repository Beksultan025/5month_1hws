package com.example.a5month_1hw

class CounterModel {

    private var count : Int = 0

    fun incrementCount(){
        count++
    }

    fun decrementCount(){
        count--
    }

    fun getResult() = count
}