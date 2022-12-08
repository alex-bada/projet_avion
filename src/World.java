import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import static java.lang.Double.parseDouble;

public class World {

    public World (String fileName){
        try {
            BufferedReader buf = new BufferedReader(new FileReader("./Data/airport-codes_no_comma.csv"));
            String s = buf.readLine();
            while(s!=null){
                s=s.replaceAll("\"","");
                //enleve les guillemets
                String fields[]= s.split(",");
                //une bonne idee pr debug
                if (fields[1].equals("large_airport")){
                    //to continue
                    list.add(new Aeroport(fields[9],fields[7],fields[5],parseDouble(fields[12]),parseDouble(fields[11])));
                }
                s = buf.readLine();
            }
        }
        catch (Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size()-1));
            e.printStackTrace();
        }}

        ArrayList<Aeroport> list = new ArrayList<Aeroport>();

        public ArrayList<Aeroport> getList(){
            return list;
        }

        public Aeroport findByCode (String code) {
            for (Aeroport a : list){
                if (a.getIATA().equals(code)) return a;
            }
            return null;
        }
        public Aeroport findNearest(double latitude, double longitude){
            double norme1 =50000;
            Aeroport nearest =  new Aeroport("CGY", "Cergy", "France", 50, 50.5);
            for(Aeroport a : list){
                double norme = Math.pow((a.getLatitude() - latitude),2) +
                        Math.pow((a.getLongitude() - longitude)*Math.cos((a.getLatitude() - latitude)/2),2);
                if(norme <= norme1){
                    norme1 = norme;
                    nearest = a;
                }
                //else System.out.println("Error wrong latitude and longitude");

            }
            return nearest;
        }



    public static void main(String args[]) {
        World w = new World("./Data/airport-codes_no_comma.csv");
        System.out.println("Found "+w.getList().size()+" airports.");
        System.out.println(w.findByCode("CDG"));
        System.out.println("Nearest airport to your position is "+w.findNearest(49.035617,2.060325));

    }

}
