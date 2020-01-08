package dev.hyuwah.sandbox.ane.common.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hyuwah.sandbox.ane.R
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import kotlinx.android.synthetic.main.row_item_user.view.*

class UserAdapter(
    private val onItemClick: (user: UsersResponse) -> Unit = {}
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    val userList = mutableListOf<UsersResponse>()

    fun setData(newUserList: List<UsersResponse>){
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_user, parent, false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position], onItemClick)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: UsersResponse, onItemClick: (user: UsersResponse) -> Unit) = with(itemView) {
            setOnClickListener { onItemClick(user) }
            text_name.text = "Name: ${user.name}"
            text_phone.text = "Phone: ${user.phone}"
            text_email.text = "Email: ${user.email}"
        }

    }
}