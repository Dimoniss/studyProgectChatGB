package chat;

import java.util.HashMap;
import java.util.Map;

public class BaseAuthService implements AuthService {
    Map<String, User> users;
    @Override
    public void start() {

        //TODO get data from Firebase
        users = new HashMap<>();
        users.put("l@gmail.com", new User("l@gmail.com", "123456", "Lee"));
        users.put("b@gmail.com", new User("b@gmail.com", "123456", "Ben"));
        users.put("a@gmail.com", new User("a@gmail.com", "123456","Agent007"));
    }

    @Override
    public String getEmailByEmailPassword(String email, String password) {
        User user = users.get(email);
        if (user != null &&  user.getPass().equals(password)) {
            return user.getEmail();
        }
        return null;
    }

    @Override
    public String getLastnameByEmail(String email) {
        User user = users.get(email);
        if (user != null) {
            System.out.println("get last name :" + user.getLastname());
            return user.getLastname();

        }
        return null;
    }

    @Override
    public void stop() {
        System.out.println("service stopped");
    }
}
