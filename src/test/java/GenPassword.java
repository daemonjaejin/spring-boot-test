import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by jin on 17. 10. 10.
 */
public class GenPassword {
    public static void main(String [] args){
        System.out.println(new BCryptPasswordEncoder().encode("demo"));
    }
}
