public abstract class Filter {
    private String original;
    private String filtered;

    public abstract String filter();

    public Filter(String original) {
        this.original = original;
        this.filtered = filter();
    }

    public String getOriginal() {
        return original;
    }

    public String getFiltered() {
        return filtered;
    }
}
