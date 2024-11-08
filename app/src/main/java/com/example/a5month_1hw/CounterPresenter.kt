package com.example.a5month_1hw

import android.graphics.Color

class CounterPresenter {

    private val model = CounterModel()
    private var counterView: CounterView? = null

    fun attachCounterView(counterView: CounterView){
        this.counterView = counterView
    }
    fun onIncrementCount(){
        model.incrementCount()
        counterView?.showResult(model.getResult())
        checkCount()
    }

    fun onDecrementCount(){
        model.decrementCount()
        counterView?.showResult(model.getResult())
        checkCount()
    }

    private fun checkCount(){
        if (model.getResult() == 10){
            counterView?.showToast("TEN")
        }
        if (model.getResult() == 15){
            counterView?.textColor(Color.GREEN)
        }else{
            counterView?.textColor(Color.BLACK)
        }
    }

    fun detachCounterView() {
        counterView = null
    }
}