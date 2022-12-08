public class aeroport {
    private String IATA;    //attribut
    private String Name;
    private String country;
    double latitude = 0;    // verify impossible coordinate
    double longitude = 0;

    public double getLatitude() {       //methode
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIATA() {
        return IATA;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
