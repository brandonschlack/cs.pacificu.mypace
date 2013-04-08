package cs.pacificu.mypace;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
/*import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;*/
import android.view.View;

//Viewed by Ryan Newman
//Viewed by Brandon Schlack
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        startPlaylists(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
    	switch (item.getItemId()) {
        case R.id.skin:
            changeSkin();
            return true;
        case R.id.action_settings:
            settingsList();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    	}
    }
    
    public void startPlaylists (View view)
    {
    	Intent intentPlaylists = new Intent();
    	intentPlaylists.setClassName("cs.pacificu.mypace", "cs.pacificu.mypace.Playlist");
    	intentPlaylists.setAction("@strings/action_playlists");
    	startActivity(intentPlaylists);
    }
    
    public void changeSkin ()
    {
    	Intent intentSkin = new Intent();
    	intentSkin.setClassName("cs.pacificu.mypace", "cs.pacificu.mypace.Skin");
    	intentSkin.setAction("@strings/action_skin");
    	startActivity(intentSkin);
    }
    
    public void settingsList ()
    {
    	Intent intentSettings = new Intent();
    	intentSettings.setClassName("cs.pacificu.mypace", "cs.pacificu.mypace.Settings");
    	intentSettings.setAction("@strings/action_settings");
    	startActivity(intentSettings);
    }
    
}
