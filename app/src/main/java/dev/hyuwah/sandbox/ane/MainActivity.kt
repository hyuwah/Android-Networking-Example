package dev.hyuwah.sandbox.ane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.hyuwah.sandbox.ane.advanced.coroutine.presentation.RetrofitCoroutineActivity
import dev.hyuwah.sandbox.ane.simple.asynchttp.SimpleAsyncHttpActivity
import dev.hyuwah.sandbox.ane.common.start
import dev.hyuwah.sandbox.ane.simple.url.coroutine.SimpleUrlCoroutineActivity
import dev.hyuwah.sandbox.ane.simple.retrofit.callback.SimpleRetrofitCallbackActivity
import dev.hyuwah.sandbox.ane.simple.retrofit.coroutine.SimpleRetrofitCoroutineActivity
import dev.hyuwah.sandbox.ane.simple.retrofit.rxjava.SimpleRetrofitRxJavaActivity
import dev.hyuwah.sandbox.ane.simple.url.asynctask.SimpleUrlAsyncTaskActivity
import dev.hyuwah.sandbox.ane.standard.mvvm.coroutine.StandardMvvmCoroutineActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindSimpleActivity()
        bindStandardActivity()
        bindAdvancedActivity()
    }

    private fun bindSimpleActivity() {
        btn_simple_asynchttp.setOnClickListener { start<SimpleAsyncHttpActivity>() }
        btn_simpleurl_coroutine.setOnClickListener { start<SimpleUrlCoroutineActivity>() }
        btn_simpleurl_asynctask.setOnClickListener { start<SimpleUrlAsyncTaskActivity>() }
        btn_simple_retrofit_callback.setOnClickListener { start<SimpleRetrofitCallbackActivity>() }
        btn_simple_retrofit_coroutine.setOnClickListener { start<SimpleRetrofitCoroutineActivity>() }
        btn_simple_retrofit_rxjava.setOnClickListener { start<SimpleRetrofitRxJavaActivity>() }
    }

    private fun bindStandardActivity() {
        btn_standard_mvvm_coroutine.setOnClickListener { start<StandardMvvmCoroutineActivity>() }
    }

    private fun bindAdvancedActivity() {
        btn_advanced_coroutine.setOnClickListener { start<RetrofitCoroutineActivity>() }
    }

}
