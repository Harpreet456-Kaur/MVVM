package com.example.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvm.adapter.NoteAdapter
import com.example.mvvm.databinding.FragmentAddnotesBinding
import com.example.mvvm.model.AddNoteViewModelFactory
import com.example.mvvm.model.Common.checkNameAndNote
import com.example.mvvm.model.NoteEntity
import com.example.mvvm.model.ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [addnotes.newInstance] factory method to
 * create an instance of this fragment.
 */
class addnotes : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentAddnotesBinding
    lateinit var noteAdapter: NoteAdapter
    lateinit var viewModel : ViewModel
    var list = ArrayList<NoteEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddnotesBinding.inflate(layoutInflater)

//        val addNoteViewModelFactory = AddNoteViewModelFactory()
//        viewModel = ViewModelProvider(this, addNoteViewModelFactory)[ViewModel::class.java]
//        binding.addNoteViewModel = notesViewModel
//        binding.lifecycleOwner = this

        binding.saveBtn.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("note_name",binding.name.text.toString())
            bundle.putString("note_note",binding.note.text.toString())

//            Log.d("TAG--->",binding.name.text.toString())
//            Log.d("TAG--->",binding.note.text.toString())

            findNavController().navigate(R.id.notesList,bundle)
            if (checkNameAndNote(
                    this,
                    binding.name.text.toString(),
                    binding.note.text.toString()
                )
            ) {
                createNote(it)
            }
        }
        return binding.root
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//    }

    private fun createNote(view: View) {
        val title = binding.name.text.toString()
        val note = binding.note.text.toString()

        val data = NoteEntity(
            id = 0,
            name = title,
            note = note
        )
      //  userModel.insert(data)
//        toast(this, "Notes Created Successfully")
//        onBackPressed()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment addnotes.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            addnotes().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}