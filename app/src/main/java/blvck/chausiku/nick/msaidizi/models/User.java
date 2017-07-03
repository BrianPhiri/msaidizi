package blvck.chausiku.nick.msaidizi.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

// [START blog_user_class]
@IgnoreExtraProperties
/*public class User {

    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}*/
// [END blog_user_class]

public class User {

    private String fullName;
    private String photo;
    private String email;
    private HashMap<String,Object> timestampJoined;
    /**
     * Use this constructor to create new User.
     * Takes user name, email and timestampJoined as params
     *
     * @param timestampJoined
     */
public User(String mFullName, String mPhoneNo, String mEmail, HashMap<String, Object> timestampJoined) {
    this.fullName = mFullName;
    this.photo = mPhoneNo;
    this.email = mEmail;
    this.timestampJoined = timestampJoined;
}


    public String getFullName() {
        return fullName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }

    public HashMap<String, Object> getTimestampJoined() {
        return timestampJoined;
    }
}