package com.example.a20130111

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class Detail(
    val nickName: String = "",
    val contentImage: Int = 0,
    val playerDescription: String = ""
)

class PlayerDetailViewModel: ViewModel() {

    private val _detail = MutableLiveData(Detail())
    val detail: LiveData<Detail> = _detail

    fun addName(name: String) {
        viewModelScope.launch {
            _detail.value = _detail.value?.copy(
                nickName = name
            )
        }
    }


}