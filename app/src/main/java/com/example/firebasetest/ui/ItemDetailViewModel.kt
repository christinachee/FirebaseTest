package com.example.firebasetest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasetest.data.Repository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val user = FirebaseAuth.getInstance().currentUser

    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome

    fun onClickAdd(item_name: String, item_url: String) {
        repository.addItemOfUser(user!!.uid, item_name = item_name, item_url = item_url)
        _navigateToHome.value = true
    }

    fun onCompleteNavigation() {
        _navigateToHome.value = false
    }
}