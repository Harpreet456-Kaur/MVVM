package com.example.mvvm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.adapter.NoteAdapter
import com.example.mvvm.databinding.FragmentNotesListBinding
import com.example.mvvm.model.NoteEntity
import com.example.mvvm.model.ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotesList.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentNotesListBinding
    lateinit var noteAdapter: NoteAdapter
    var list = ArrayList<NoteEntity>()
//    lateinit var viewModel : ViewModel

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
        binding = FragmentNotesListBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        noteAdapter = NoteAdapter(list, itemListener = this)
        binding.recycler.adapter = noteAdapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        var name = arguments?.getString("note_name").toString()
        var note = arguments?.getString("note_note").toString()

        Log.d("TAG--->",name)
        Log.d("TAG--->",note)

        binding.recycler.adapter = noteAdapter

//        binding.name.setText(name)
//        binding.note.setText(note)

        binding.fBtn.setOnClickListener {
            findNavController().navigate(R.id.addnotes)
        }

        //RoomDatabase
//        viewModel.allNotes.observe(requireActivity()) {
//            //list.clear()
//
            for (i in list.indices) {
                val notesData = NoteEntity()
                notesData.id = list[i].id
                notesData.name = list[i].name
                notesData.note = list[i].note
            }

            noteAdapter.notifyDataSetChanged()
            noteAdapter.setData(list)

            noteAdapter.setOnItemClickListener(object : NoteAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
//                    val intent = Intent(this@AllNotes, EditNotes::class.java)
//                    intent.putExtra("noteId", list[position].id)
//                    intent.putExtra("noteName", list[position].title)
//                    intent.putExtra("noteContent", list[position].note)
//                    startActivity(intent)
                }
            })
        return binding.root
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotesList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotesList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}