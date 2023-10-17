package edu.mirea.onebeattrue.instagramcardcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _isFollowing = MutableLiveData<Boolean>()
    val isFollowing: LiveData<Boolean>
        get() = _isFollowing

    fun changeFollowingStatus() {
        val wasFollowing = _isFollowing.value ?: false
        _isFollowing.value = !wasFollowing
    }
}