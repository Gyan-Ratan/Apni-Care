        package com.example.apnicare.ModelResponses.CategoryResponse;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.List;


        public class CategoryResponse {

            @SerializedName("data")
            @Expose
            private List<Datum> data = null;

            public List<Datum> getData() {
                return data;
            }

            public void setData(List<Datum> data) {
                this.data = data;
            }

            public CategoryResponse withData(List<Datum> data) {
                this.data = data;
                return this;
            }

        //    IMAGE LIST
            public class Image {

                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("original_path")
                @Expose
                private String originalPath;
                @SerializedName("thumbnail_path")
                @Expose
                private String thumbnailPath;
                @SerializedName("small_path")
                @Expose
                private String smallPath;
                @SerializedName("medium_path")
                @Expose
                private String mediumPath;
                @SerializedName("large_path")
                @Expose
                private String largePath;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Image withName(String name) {
                    this.name = name;
                    return this;
                }

                public String getOriginalPath() {
                    return originalPath;
                }

                public void setOriginalPath(String originalPath) {
                    this.originalPath = originalPath;
                }

                public Image withOriginalPath(String originalPath) {
                    this.originalPath = originalPath;
                    return this;
                }

                public String getThumbnailPath() {
                    return thumbnailPath;
                }

                public void setThumbnailPath(String thumbnailPath) {
                    this.thumbnailPath = thumbnailPath;
                }

                public Image withThumbnailPath(String thumbnailPath) {
                    this.thumbnailPath = thumbnailPath;
                    return this;
                }

                public String getSmallPath() {
                    return smallPath;
                }

                public void setSmallPath(String smallPath) {
                    this.smallPath = smallPath;
                }

                public Image withSmallPath(String smallPath) {
                    this.smallPath = smallPath;
                    return this;
                }

                public String getMediumPath() {
                    return mediumPath;
                }

                public void setMediumPath(String mediumPath) {
                    this.mediumPath = mediumPath;
                }

                public Image withMediumPath(String mediumPath) {
                    this.mediumPath = mediumPath;
                    return this;
                }

                public String getLargePath() {
                    return largePath;
                }

                public void setLargePath(String largePath) {
                    this.largePath = largePath;
                }

                public Image withLargePath(String largePath) {
                    this.largePath = largePath;
                    return this;
                }

            }



        //    DATA LIST
            public class Datum {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("slug")
                @Expose
                private String slug;
                @SerializedName("image")
                @Expose
                private Image image;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Datum withId(Integer id) {
                    this.id = id;
                    return this;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Datum withName(String name) {
                    this.name = name;
                    return this;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }

                public Datum withSlug(String slug) {
                    this.slug = slug;
                    return this;
                }

                public Image getImage() {
                    return image;
                }

                public void setImage(Image image) {
                    this.image = image;
                }

                public Datum withImage(Image image) {
                    this.image = image;
                    return this;
                }

            }
        }