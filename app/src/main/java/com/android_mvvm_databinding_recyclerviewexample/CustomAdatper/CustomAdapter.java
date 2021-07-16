package com.android_mvvm_databinding_recyclerviewexample.CustomAdatper;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android_mvvm_databinding_recyclerviewexample.R;
import com.android_mvvm_databinding_recyclerviewexample.databinding.SingleLayoutItemBinding;
import com.android_mvvm_databinding_recyclerviewexample.model.MovieModel;

import java.util.ArrayList;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomAdapter.DeveloperViewHolder> {

    private ArrayList<MovieModel.Result> mMovieModelResult;

    @NonNull
    @Override
    public DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SingleLayoutItemBinding mDeveloperListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.single_layout_item, viewGroup, false);

        return new DeveloperViewHolder(mDeveloperListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperViewHolder mDeveloperViewHolder, int i) {
        MovieModel.Result moviemodelResult = mMovieModelResult.get(i);
        mDeveloperViewHolder.mDeveloperListItemBinding.setMovieModelResult(moviemodelResult);
    }

    @Override
    public int getItemCount() {
        if (mMovieModelResult != null) {
            return mMovieModelResult.size();
        } else {
            return 0;
        }
    }

    public void setDeveloperList(ArrayList<MovieModel.Result> mDeveloperModel) {
        this.mMovieModelResult = mDeveloperModel;
        notifyDataSetChanged();
    }

    class DeveloperViewHolder extends RecyclerView.ViewHolder {

        SingleLayoutItemBinding mDeveloperListItemBinding;


        public DeveloperViewHolder(@NonNull SingleLayoutItemBinding mDeveloperListItemBinding) {
            super(mDeveloperListItemBinding.getRoot());

            this.mDeveloperListItemBinding = mDeveloperListItemBinding;
        }
    }
}
