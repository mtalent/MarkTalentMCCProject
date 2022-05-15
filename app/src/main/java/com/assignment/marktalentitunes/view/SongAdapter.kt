package com.assignment.marktalentitunes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.marktalentitunes.R
import com.assignment.marktalentitunes.model.SongListing
import com.squareup.picasso.Picasso

class SongAdapter(private val list: List<SongListing>)
    : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    inner class SongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(songListing: SongListing) {

            val ivArtistThumbNail : ImageView = itemView.findViewById<ImageView>(R.id.iv_artist_thumbnail)
            val tvAlbumName : TextView = itemView.findViewById(R.id.tv_album_name)
            val tvArtistName : TextView = itemView.findViewById(R.id.tv_artist_name)
            val tvPrice : TextView = itemView.findViewById(R.id.tv_price)

            tvAlbumName.text = songListing.collectionName
            tvArtistName.text = songListing.artistName
            tvPrice.text = songListing.trackPrice

            Picasso.get()
                .load(songListing.artworkUrl60)
                .placeholder(R.drawable.ic_launcher_foreground)
                .fit()
                .into(ivArtistThumbNail)


        }
    }







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.SongViewHolder {
        val listItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_list_item, parent, false)
        return SongViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: SongAdapter.SongViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}