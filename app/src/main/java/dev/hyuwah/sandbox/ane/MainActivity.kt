package dev.hyuwah.sandbox.ane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.hyuwah.sandbox.ane.asynchttp.AsyncHttpActivity
import dev.hyuwah.sandbox.ane.common.start
import dev.hyuwah.sandbox.ane.damnsimple.DamnSimpleActivity
import dev.hyuwah.sandbox.ane.simpleretrofit.callback.SimpleRetrofitCallbackActivity
import dev.hyuwah.sandbox.ane.simpleretrofit.coroutine.SimpleRetrofitCoroutineActivity
import dev.hyuwah.sandbox.ane.simpleretrofit.rxjava.SimpleRetrofitRxJavaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_damn_simple.setOnClickListener { start<DamnSimpleActivity>() }
        btn_asynchttp.setOnClickListener { start<AsyncHttpActivity>() }
        btn_simple_retrofit_callback.setOnClickListener { start<SimpleRetrofitCallbackActivity>() }
        btn_simple_retrofit_coroutine.setOnClickListener { start<SimpleRetrofitCoroutineActivity>() }
        btn_simple_retrofit_rxjava.setOnClickListener { start<SimpleRetrofitRxJavaActivity>() }
    }
}
