package dev.hyuwah.sandbox.ane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.hyuwah.sandbox.ane.advanced.coroutine.presentation.RetrofitCoroutineActivity
import dev.hyuwah.sandbox.ane.simple.asynchttp.SimpleAsyncHttpActivity
import dev.hyuwah.sandbox.ane.common.start
import dev.hyuwah.sandbox.ane.advanced.pepe.presentation.ExampleActivity
import dev.hyuwah.sandbox.ane.simple.url.coroutine.SimpleUrlCoroutineActivity
import dev.hyuwah.sandbox.ane.simple.retrofit.callback.SimpleRetrofitCallbackActivity
import dev.hyuwah.sandbox.ane.simple.retrofit.coroutine.SimpleRetrofitCoroutineActivity
import dev.hyuwah.sandbox.ane.simple.retrofit.rxjava.SimpleRetrofitRxJavaActivity
import dev.hyuwah.sandbox.ane.simple.url.asynctask.SimpleUrlAsyncTaskActivity
import dev.hyuwah.sandbox.ane.standard.mvp.coroutine.StandardMvpCoroutineActivity
import dev.hyuwah.sandbox.ane.standard.mvp.rxjava.StandardMvpRxjavaActivity
import dev.hyuwah.sandbox.ane.standard.mvvm.coroutine.StandardMvvmCoroutineActivity
import dev.hyuwah.sandbox.ane.standard.mvvm.rxjava.StandardMvvmRxjavaActivity
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
        btn_standard_mvvm_rxjava.setOnClickListener { start<StandardMvvmRxjavaActivity>() }
        btn_standard_mvp_coroutine.setOnClickListener { start<StandardMvpCoroutineActivity>() }
        btn_standard_mvp_rxjava.setOnClickListener { start<StandardMvpRxjavaActivity>() }
    }

    private fun bindAdvancedActivity() {
        btn_advanced_coroutine.setOnClickListener { start<RetrofitCoroutineActivity>() }
        btn_pepe.setOnClickListener { start<ExampleActivity>() }
    }

}
