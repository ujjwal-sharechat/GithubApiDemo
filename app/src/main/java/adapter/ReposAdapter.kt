package adapter

import adapter.ReposAdapter.*
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapidemo.R
import com.example.githubapidemo.model.GithubRepo
import kotlinx.android.synthetic.main.list_item_repo.view.*

class ReposAdapter(var items : List<GithubRepo>) : RecyclerView.Adapter<RepoViewHolder>() {


    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(LayoutInflater.from(parent.context).inflate( R.layout.list_item_repo, parent, false))
    }


    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = items[position]
        holder.itemView.repoName.text= repo.name
        holder.itemView.repoDescription.text=repo.description
        holder.itemView.repoLanguage.text=repo.language

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(items: List<GithubRepo>) {
        this.items = items
        notifyDataSetChanged()
    }


}