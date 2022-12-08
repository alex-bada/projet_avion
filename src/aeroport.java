public class aeroport {
    private final String IATA;    //attribut
    private final String Name;
    private final String country;
    double latitude = 0;    // verify impossible coordinate
    double longitude = 0;

    public aeroport(String iata, String name, String country, double latitude, double longitude) { //constructeur
        this.IATA = iata;
        this.Name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

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
        //return super.toString();
        return "Aeroport " + Name+ " IATA " + IATA + " Lat " + latitude
                + " Long " + longitude;
    }

    public static void main(String args[]) {
        aeroport a1= new aeroport("CGY", "Cergy", "France", 50, 50.5);
        System.out.println(a1.toString());
    }

}
