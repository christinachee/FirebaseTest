package com.example.firebasetest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasetest.data.Repository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val user = FirebaseAuth.getInstance().currentUser

    private val _navigateToItemDetail = MutableLiveData<Boolean>()
    val navigateToItemDetail: LiveData<Boolean>
        get() = _navigateToItemDetail

    fun onClickAdd() {
        _navigateToItemDetail.value = true
    }

    fun onCompleteNavigation() {
        _navigateToItemDetail.value = false
    }

    fun onStart() {
        viewModelScope.launch {
            val entries = repository.getItemListByUser(user!!.uid)
            entries.forEach {
                Timber.i( it.item_name )
            }
        }
    }
}