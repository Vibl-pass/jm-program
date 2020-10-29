package model;

public class Cars {
    private long id;

    private String model;

    private String series;

    public Cars(long id, String model, String series){
        this.model = model;
        this.id = id;
        this.series = series;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
