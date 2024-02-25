package net.iessochoa.carlosayalasarrio.prctica6.ui.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.iessochoa.carlosayalasarrio.prctica6.network.NetworkService

object Repository {
    //necesitaremos el context en las capas inferiores
    private lateinit var application: Application
    //iniciamos la instancia
    operator fun invoke(context: Context) {
        this.application = context.applicationContext as Application
        NetworkService(application)
    }
    suspend fun getNextPersonajes()=NetworkService.getNextPersonajes()
    fun getLiveDataListaPersonajes ()=NetworkService.getLiveDataListaPersonajes()
}