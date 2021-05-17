package com.gcit.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportAdaptor extends RecyclerView.Adapter<SportAdaptor.ViewHolder>{
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    SportAdaptor(Context mContext, ArrayList<Sport> mSportsData){
        this.mContext= mContext;
        this.mSportsData = mSportsData;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sport currentSport = mSportsData.get(position);
        holder.bindTo((currentSport));


    }

    @Override
    public int getItemCount() {
        return mSportsData.size();

    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;

        ViewHolder(View itemView){
            super(itemView);
            mTitleText=(TextView)itemView.findViewById(R.id.title);
            mInfoText=(TextView)itemView.findViewById(R.id.subTitle);
            mSportsImage =itemView.findViewById(R.id.sportsImage);
        }

        void bindTo(Sport currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
        }
    }
}
