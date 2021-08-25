package hu.ulyssys.java.course.maven.rest.model;

import java.util.List;

public class FarmerDataModel extends FarmerModel {

    private List<CatModel> cats;
    private List<DogModel> dogs;
    private List<ReindeerModel> reindeers;
    private List<SlugModel> slugs;

    public List<CatModel> getCats() {
        return cats;
    }

    public void setCats(List<CatModel> cats) {
        this.cats = cats;
    }

    public List<DogModel> getDogs() {
        return dogs;
    }

    public void setDogs(List<DogModel> dogs) {
        this.dogs = dogs;
    }

    public List<ReindeerModel> getReindeers() {
        return reindeers;
    }

    public void setReindeers(List<ReindeerModel> reindeers) {
        this.reindeers = reindeers;
    }

    public List<SlugModel> getSlugs() {
        return slugs;
    }

    public void setSlugs(List<SlugModel> slugs) {
        this.slugs = slugs;
    }
}
