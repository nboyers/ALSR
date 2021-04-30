package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import frent.nobos.stratApex.R;

/**
 * When the app starts
 * this is the Starting UI the
 * user sees
 */
public class MainActivity extends AppCompatActivity {

    public static final String TEXT_TO_SEND = "frent.nobos.stratApex";
    private Button King_btn,Oly_btm,worldEdge_btn;
    private String sendToActivity;


    /**
     *
     * @param savedInstanceState - mapping from String keys to various Parcelable values.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        King_btn = findViewById(R.id.kingsCanyon_button);
        Oly_btm = findViewById(R.id.olympus_Button);
        worldEdge_btn = findViewById(R.id.worldsEdge_Button);

        King_btn.setOnClickListener(v -> {
            sendToActivity = King_btn.getText().toString();
            goToActivity();
        });
        Oly_btm.setOnClickListener(v -> {
            sendToActivity = Oly_btm.getText().toString();
            goToActivity();
        });
        worldEdge_btn.setOnClickListener(v -> {
            sendToActivity = worldEdge_btn.getText().toString();
            goToActivity();
        });
    }

    /**
     * Method that takes the user to the next activity
     * while passing which map they are on
     */
    private void goToActivity() {
        Intent intent = new Intent(this, RouletteGUI.class);
         intent.putExtra(TEXT_TO_SEND, sendToActivity);
         startActivity(intent);
    }
}
