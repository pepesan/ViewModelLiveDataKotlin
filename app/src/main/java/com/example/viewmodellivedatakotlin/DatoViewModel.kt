package com.example.viewmodellivedatakotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DatoViewModel: ViewModel() {

    val datoObservable = MutableLiveData<String>()

    init {
        datoObservable.value = "Dato inicial"
    }

}