package dev.hyuwah.sandbox.ane.simpleurl.asynctask

import android.os.AsyncTask
import com.google.gson.Gson
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import java.net.URL

class GetUsersTask(var onPostExecuteCallback: (result: List<UsersResponse>) -> Unit) :
    AsyncTask<String, Void, List<UsersResponse>>() {

    override fun doInBackground(vararg strings: String?): List<UsersResponse> {
        return try {
            val jsonString = URL(strings.first()).readText()
            Gson().fromJson(jsonString, Array<UsersResponse>::class.java).toList()
        } catch (e: Throwable) {
            listOf()
        }
    }

    override fun onPostExecute(result: List<UsersResponse>) {
        super.onPostExecute(result)
        onPostExecuteCallback(result)
    }

}