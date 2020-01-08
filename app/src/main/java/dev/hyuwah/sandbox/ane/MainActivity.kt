package dev.hyuwah.sandbox.ane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.hyuwah.sandbox.ane.common.start
import dev.hyuwah.sandbox.ane.damnsimple.DamnSimpleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_damn_simple.setOnClickListener { start<DamnSimpleActivity>() }
    }
}
