package cs.pacificu.mypace;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

//Viewed by Ryan Newman
//Viewed by Brandon Schlack
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void startPlaylists (View view)
    {
    	Intent intentPlaylists = new Intent();
    	intentPlaylists.setClassName("cs.pacificu.mypace", "cs.pacificu.mypace.Playlist");
    	intentPlaylists.setAction("@strings/action_playlists");
    	startActivity(intentPlaylists);
    }
    
}
