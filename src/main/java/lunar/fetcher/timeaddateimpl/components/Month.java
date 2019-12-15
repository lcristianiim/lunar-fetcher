package lunar.fetcher.timeaddateimpl.components;

public enum Month {
    MARCH("mar"),
    APRIL("apr");

    private String value;

    Month(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
