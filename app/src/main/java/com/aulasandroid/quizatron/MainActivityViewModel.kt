package com.aulasandroid.quizatron

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainActivityViewModel {
    private var _pontos = MutableLiveData<Int>()

    var pontos: LiveData<Int> = _pontos

    fun incrementarPontos(){
        _pontos.value = _pontos.value!! + 1
    }

    fun resetarPontos(){
        _pontos.value = 0
    }
}