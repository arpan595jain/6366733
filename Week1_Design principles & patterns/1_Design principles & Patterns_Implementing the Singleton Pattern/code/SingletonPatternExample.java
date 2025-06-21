public class SingletonPatternExample {
    static class Logger {
        private static Logger instance;
        private Logger() {
            System.out.println("Logger initialized.");
        }
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting application...");

        Logger logger2 = Logger.getInstance();
        logger2.log("Performing a task...");

        Logger logger3 = Logger.getInstance();
        logger3.log("Finishing application...");
        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("Singleton confirmed: All logger instances are the same.");
        } else {
            System.out.println("Singleton failed: Different logger instances exist.");
        }
    }
}
