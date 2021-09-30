package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShoeListViewModel() : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    private val _shoeList = mutableListOf<Shoe>()

    init {
        _shoes.value = _shoeList
    }

    fun add(name: String, company: String, size: Double, description: String) {
        _shoeList.add(Shoe(name = name, company = company, size = size, description = description))
        _shoes.value = _shoeList
    }

    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.newInstance();
        }
    }
}