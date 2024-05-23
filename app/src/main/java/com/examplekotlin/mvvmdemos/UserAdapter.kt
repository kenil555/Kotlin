package com.examplekotlin.mvvmdemos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users: List<User> = emptyList()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val uname: TextView = itemView.findViewById(R.id.uname)
        val email: TextView = itemView.findViewById(R.id.email)
        val phone: TextView = itemView.findViewById(R.id.phone)
        val website: TextView = itemView.findViewById(R.id.website)
        val address: TextView = itemView.findViewById(R.id.address)
        val geo: TextView = itemView.findViewById(R.id.geo)
        val company: TextView = itemView.findViewById(R.id.company)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]

        holder.name.text = "Name : " + user.name
        holder.uname.text = "User Name : " + user.username
        holder.email.text = "Email : " + user.email
        holder.phone.text = "Phone : " + user.phone
        holder.website.text = "Website : " + user.website
        holder.address.text = "Address :-- " +
                "\n     ${"Street : " + user.address.street}," +
                "\n     ${"Suite : " + user.address.suite}," +
                "\n     " + "${"City : " + user.address.city}, " +
                "\n     " + "${"Zipcode : " + user.address.zipcode}"
        holder.geo.text = "Geo :-- " +
                "\n     ${"Latitute : " + user.address.geo.lat}, " +
                "\n     ${"Long Latitute : " + user.address.geo.lng}"
        holder.company.text = "Company Name :-- " +
                "\n     ${"Company Name : " + user.company.name}, " +
                "\n     ${"Catchphrase : " + user.company.catchPhrase} , " +
                "\n     " + "${"BS : " + user.company.bs}"
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

}
