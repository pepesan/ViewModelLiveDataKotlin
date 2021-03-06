package com.example.viewmodellivedatakotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var datoViewModel: DatoViewModel? = null
    var vista: TextView? = null
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datoViewModel = ViewModelProvider(requireActivity())
            .get(DatoViewModel::class.java)
        vista = view.findViewById<TextView>(R.id.textview_first)
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        view.findViewById<Button>(R.id.cambia).setOnClickListener{
            datoViewModel?.contador?.value = datoViewModel?.contador?.value?.plus(1)
            datoViewModel?.datoObservable?.value = "Otro valor " + datoViewModel?.contador?.value
        }
        datoViewModel?.datoObservable?.observe(viewLifecycleOwner, Observer {nuevo_valor ->
            Log.d("app:","Valor: $nuevo_valor")
            vista!!.text=nuevo_valor
        })
        vista!!.text = datoViewModel?.datoObservable?.value
    }
}