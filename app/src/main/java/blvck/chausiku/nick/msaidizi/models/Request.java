package blvck.chausiku.nick.msaidizi.models;

/**
 * Created by brianphiri on 6/30/17.
 */

public class Request {
    public String serviceType, description;

    public Request(String serviceType, String description) {
        this.serviceType = serviceType;
        this.description = description;
    }

    public Request() {
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
