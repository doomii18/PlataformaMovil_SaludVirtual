package com.example.plataformasalud_virtual

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TableroViewModel(app: Application) : AndroidViewModel(app) {
    private val api = ApiClient.create(app)

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _tableroItems = MutableLiveData<List<TableroItem>>(emptyList())
    val tableroItems: LiveData<List<TableroItem>> = _tableroItems

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    fun loadTableroItems() {
        if (_loading.value == true) return
        _loading.value = true
        _error.value = null
        viewModelScope.launch {
            try {
                _tableroItems.value = api.getTableroGestion()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}