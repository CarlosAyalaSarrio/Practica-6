package net.iessochoa.carlosayalasarrio.prctica6.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.iessochoa.carlosayalasarrio.prctica6.model.Personaje
import net.iessochoa.carlosayalasarrio.prctica6.repository.Repository

class HomeViewModel (application: Application): AndroidViewModel(application) {
    val personajesLiveData:LiveData<MutableList<Personaje>>
    init {
        //iniciamos el repositorio
        Repository(application)
        //observaremos los cambios en la lista de personajes
        personajesLiveData= Repository.getLiveDataListaPersonajes()
        //carga la primera página de personajes
        getNextPersonajes()
    }
    //lanza en segundo plano la carga de nuevos personajes
    fun getNextPersonajes()=viewModelScope.launch(Dispatchers.IO) {
        Repository.getNextPersonajes()
    }
}
