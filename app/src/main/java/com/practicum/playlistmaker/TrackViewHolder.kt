package com.practicum.playlistmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class TrackViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    private val trackName: TextView = itemView.findViewById(R.id.track_title)
    private val trackAuthor: TextView = itemView.findViewById(R.id.track_author)
    private val trackImage: ImageView = itemView.findViewById(R.id.track_image)
    private val trackDuration: TextView = itemView.findViewById(R.id.track_duration_time)
    private val trackArrow: ImageView = itemView.findViewById(R.id.track_arrow)

    fun bind(model: Track){
        trackName.text = model.trackName
        trackDuration.text = model.trackTime
        trackAuthor.text = model.artistName
       Glide.with(itemView)
           .load(model.artworkUrl100)
           .centerCrop()
           .placeholder(R.drawable.placeholder_track)
           .error(R.drawable.placeholder_track)
           .transform(RoundedCorners(10))
           .into(trackImage)
    }
    companion object{
        fun from(parent: ViewGroup): TrackViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.search_list_block, parent, false)
            return TrackViewHolder(view)
        }
    }
}