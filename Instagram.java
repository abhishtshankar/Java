import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.requests.InstagramearchUsernameResult;
import java.io.IOException;
public class Instagram{
    public static void main(String[] args) throws IOException,InterruptedException {
        Instagram4j instagram=
        Instagram4j.builder().username("USERNAME").password("PASSWORD").build();
        instagram.setup();
        instagram.login();
        InstagramearchUsernameResult userResult=instagram.sendRequest(new InstagramearchUsernameRequest("userhandel"));
        System.out.println("ID "+userResult.getUser().getPk());
        System.out.println("Email "+userResult.getUser().getPublic_email());
        System.out.println("Bio "+userResult.getUser().biography);
        System.out.println("Business Contact Method "+userResult.getUser().bussiness_contact_method);
        System.out.println("Profile URL "+userResult.getUser().profile_pic_url);
        System.out.println("Followers "+userResult.getUser().follower_count);
        System.out.println("Following "+userResult.getUser().getfollowing_count());                
    }
}
