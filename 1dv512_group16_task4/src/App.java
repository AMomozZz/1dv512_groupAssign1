import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1dv512 group16 
 * Li Ang Hu(lh223ng@student.lnu.se) & Long Ma(lm223xe@student.lnu.se)
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        callId();
        callFind();
        callHostname();
    }

    private static void callId() {
        System.out.println("Invoking id: ");
        try {
            Process process = Runtime.getRuntime().exec("id");
            System.out.println(new BufferedReader(new InputStreamReader(process.getInputStream())).readLine());
            int status = process.waitFor();
            System.out.println(" exit code: " + status);
            System.out.println();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void callFind() {
        try {
            System.out.println("Invoking find . -name rc* in dir: /etc/");
            Process process = Runtime.getRuntime().exec("find . -name rc*", null, new File("/etc/"));
            //process = Runtime.getRuntime().exec("find . -name 'rc*'", null, new File("/etc/"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            int status = process.waitFor();
            System.out.println("exit code: " + status);
            System.out.println();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void callHostname() {
        System.out.println("Invoking hostname freebsd-vm-group16-upd: ");
        try {
            Process process = Runtime.getRuntime().exec("hostname freebsd-vm-group16-upd");
            System.out.println(new BufferedReader(new InputStreamReader(process.getInputStream())).readLine());
            int status = process.waitFor();
            System.out.println(" exit code: " + status);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
