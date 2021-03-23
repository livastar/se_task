package core.configs.driver;

public class DriverManagerFactory {


    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
//            case REMOTE:
////                driverManager = new RemoteDriverManager();
//                return null; //should be implemented
//            break;
            case CHROME:
                driverManager = new core.configs.driver.ChromeDriverManager();
                break;
//            case FIREFOX:
//                return null; //should be implemented
//                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}