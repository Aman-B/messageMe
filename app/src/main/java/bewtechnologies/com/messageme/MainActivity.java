package bewtechnologies.com.messageme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    private static String FIREBASE_URL= "https://messageme-e0090.firebaseio.com/";

    Button sendnotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Previous versions of Firebase
        Firebase.setAndroidContext(this);

        //Newer version of Firebase
        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

        /*change security rules in firebase,afterwards. It works now!*/

      //  FirebaseMessaging.getInstance().subscribeToTopic("user_puff");

//        sendNotificationToUser("puff","Hi, message from yours self!");



    }

    public static void sendNotificationToUser(String user, final String message) {
        Firebase ref = new Firebase(FIREBASE_URL);
        final Firebase notifications = ref.child("test");

        Map notification = new HashMap<>();
        notification.put("username", user);
        notification.put("message", message);

        notifications.push().setValue(notification);
    }
}
