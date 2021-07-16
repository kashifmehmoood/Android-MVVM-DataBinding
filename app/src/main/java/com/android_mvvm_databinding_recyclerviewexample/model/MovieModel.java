
package com.android_mvvm_databinding_recyclerviewexample.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import java.util.List;

import com.android_mvvm_databinding_recyclerviewexample.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("dates")
    private Dates dates;
    @SerializedName("page")
    private Integer page;
    @SerializedName("results")
    private List<Result> results = null;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("total_results")
    private Integer totalResults;

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public class Dates {

        @SerializedName("maximum")
        private String maximum;
        @SerializedName("minimum")
        private String minimum;

        public String getMaximum() {
            return maximum;
        }

        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

    }

    public static class Result {

        @SerializedName("adult")
        private Boolean adult;
        @SerializedName("backdrop_path")
        private String backdropPath;
        @SerializedName("genre_ids")
        private List<Integer> genreIds = null;
        @SerializedName("id")

        private Integer id;
        @SerializedName("original_language")

        private String originalLanguage;
        @SerializedName("original_title")

        private String originalTitle;
        @SerializedName("overview")

        private String overview;
        @SerializedName("popularity")

        private Double popularity;
        @SerializedName("poster_path")

        private String posterPath;
        @SerializedName("release_date")

        private String releaseDate;
        @SerializedName("title")

        private String title;
        @SerializedName("video")
        private Boolean video;
        @SerializedName("vote_average")

        private float voteAverage;
        @SerializedName("vote_count")
        private Integer voteCount;
        @BindingAdapter({"avatar"})
        public static void loadImage(ImageView imageView, String imageURL) {
            Glide.with(imageView.getContext())
                    .setDefaultRequestOptions(new RequestOptions()
                            .circleCrop())
                    .load("https://image.tmdb.org/t/p/w500"+imageURL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView);
        }

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        public float getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(float voteAverage) {
            this.voteAverage = voteAverage;
        }

        public Integer getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }
    }
}
