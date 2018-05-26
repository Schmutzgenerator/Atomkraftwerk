package atom.kraftwerk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static atom.kraftwerk.R.id.navigation_saved;

public class MainActivity extends AppCompatActivity {





    private TextView mTextMessage;





    public void onClickSwitchActivityrysuj(View view) {
        Intent intent = new Intent(this, rysuj.class);

        startActivity(intent);
    }


    public void onCreate(){

     Intent intent1 = new Intent(this, rysuj.class);

     startActivity(intent1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

}
