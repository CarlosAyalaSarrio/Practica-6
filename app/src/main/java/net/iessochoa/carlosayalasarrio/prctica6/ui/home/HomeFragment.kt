package net.iessochoa.carlosayalasarrio.prctica6.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import net.iessochoa.carlosayalasarrio.prctica6.databinding.FragmentHomeBinding
import net.iessochoa.carlosayalasarrio.prctica6.utils.cargaImagen

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.personajesLiveData
            .observe(viewLifecycleOwner) {
                val text=StringBuilder()
                //it es la lista de personajes actualizada
                for(personaje in it)
                    text.append(personaje.name).append("\n")
                textView.text = text
            }
        return root
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}