package Activity2;
import java.util.LinkedList;

public class Q2 {
    public static void main(String[] args) {
    	
        LinkedList<String> hospitalQueue = new LinkedList<>();

        hospitalQueue.add("PatientA");
        hospitalQueue.add("PatientB");
        hospitalQueue.add("PatientC");
        hospitalQueue.add("PatientD");
        hospitalQueue.add("PatientE");

        System.out.println(hospitalQueue);

        hospitalQueue.addFirst("EmergencyPatient1");

        System.out.println(hospitalQueue);

        hospitalQueue.remove(); 
        hospitalQueue.remove(); 

        System.out.println(hospitalQueue);
    }
}
