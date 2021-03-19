package com.example.firebasetest.data

import com.example.firebasetest.data.models.Entry
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDatabase: FirebaseFirestore) {

    fun addNewUser(name: String, uid: String) {
        val user = hashMapOf(
            "name" to name,
        )
        remoteDatabase.collection("users").document(uid)
                .set(user)
                .addOnFailureListener { e -> Timber.e(e) }
    }

    suspend fun getItemListByUser(uid: String): List<Entry> {
        var items = emptyList<Entry>()

        val docRef = remoteDatabase.collection("users")
                .document(uid)
                .collection("items")

        docRef.get()
                .addOnSuccessListener { result->
                    items = result.map { it.toObject(Entry::class.java) }
                }
                .addOnFailureListener {
                    e -> Timber.e(e)
                }
                .await()
        return items
    }

    fun addItemOfUser(uid: String, item_name: String, item_url: String) {
        val testItem = hashMapOf(
                "item_name" to item_name,
                "item_url" to item_url
        )

        remoteDatabase.collection("users").document(uid)
                .collection("items")
                .add(testItem)
                .addOnSuccessListener {  }
                .addOnFailureListener { e ->
                    Timber.e(e)
                }
    }
}