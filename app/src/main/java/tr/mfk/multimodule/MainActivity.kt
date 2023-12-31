package tr.mfk.multimodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import tr.mfk.app.databinding.ActivityMainBinding
import tr.mfk.common.startNewActivity
import tr.mfk.ecommerce.ui.view.ECommerceActivity
import tr.mfk.noteapp.view.NoteActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClickEvents()

    }

    private fun handleClickEvents() {
        binding.apply {
            firstModule.setOnClickListener {
                startNewActivity(ECommerceActivity::class.java)
            }
            secondModule.setOnClickListener {
                startNewActivity(NoteActivity::class.java)
            }
        }
    }
}