/*
 * Displays a list.
 * Used following URL for tutorial
 * 
 * http://www.mkyong.com/android/android-listview-example/
 * 
 * Brandon Schlack. 04/02/2013 03:46am
 */
package cs.pacificu.mypace;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Playlist extends SherlockActivity
{
	static final String[] PLAYLISTS = new String[] {"Best Running Songs", 
		"Best Walking Songs", "Personal Playlist"};
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		/*SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
		if (settings.getString("skins", "") == "@string/skin_name_Light")
		{
			setTheme(Theme.Sherlock.Light);
		};*/
		
		SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
		/*String skinValue = settings.getString("skins", "");
		
		if (skinValue == "Dark")
		{
			//setTheme(R.style.Dark);
			setTheme(R.style.Dark);
		}
			else if (skinValue == "Light")
		{
			//setTheme(R.style.Light);
			setTheme(R.style.Light);
		}
			else if(skinValue == "Default")
		{
			setTheme(R.style.AppBaseTheme);
		}*/
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.playlist);
		ListView listView = (ListView) findViewById (R.id.playlists);
		listView.setAdapter(new ArrayAdapter<String>(this,R.layout.single_list_item,PLAYLISTS));	
		//ListView listView = getView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
			    // When clicked, show a toast with the TextView text
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	@Override
		public boolean onCreateOptionsMenu(Menu menu) 
		{
			//Inflate the menu; this adds items to the action bar if it is present.
	        getSupportMenuInflater().inflate(R.menu.main, menu);
			
			/*menu.add("Settings")
	        	.setIcon(R.drawable.gear)
	        	.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);*/
	        return true;
		}
	    
	    public boolean onOptionsItemSelected (MenuItem item)
	    {
	    	switch (item.getItemId()) {
	        case R.id.action_settings:
	            settingsList();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    	}
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