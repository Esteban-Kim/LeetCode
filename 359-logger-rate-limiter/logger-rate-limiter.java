class Logger {
    private Map<String, Integer> logs;

    public Logger() {
        this.logs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int previousTimestamp = logs.getOrDefault(message, Integer.MIN_VALUE);

        if (previousTimestamp+10 <= timestamp) {
            logs.put(message, timestamp);
            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */