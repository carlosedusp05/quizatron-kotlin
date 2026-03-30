package com.aulasandroid.quizatron.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TelaInicialViewModel {
    private var _nome = MutableLiveData<String>()

    var nome: LiveData<String> = _nome

    fun mudarNome(newName: String){
        _nome.value = newName
    }
}