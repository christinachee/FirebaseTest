package com.example.firebasetest.ui

import androidx.lifecycle.ViewModel
import com.example.firebasetest.data.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val user = FirebaseAuth.getInstance().currentUser

    fun addNewUser(name: String, auth_id: String) {
        repository.addNewUser(name, auth_id)
    }

}