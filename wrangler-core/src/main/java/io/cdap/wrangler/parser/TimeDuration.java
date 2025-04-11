public class TimeDuration extends Token {
    private long milliseconds;

    public TimeDuration(String value) {
        super(value);
        this.milliseconds = parseToMillis(value);
    }

    private long parseToMillis(String value) {
        String unit = value.replaceAll("[0-9.]", "").toLowerCase();
        double number = Double.parseDouble(value.replaceAll("[^0-9.]", ""));
        switch(unit) {
            case "s": return (long)(number * 1000);
            case "m": return (long)(number * 60 * 1000);
            case "h": return (long)(number * 60 * 60 * 1000);
            case "ms": default: return (long)(number);
        }
    }

    public long getMilliseconds() {
        return milliseconds;
    }
}
