/*
 * Displays a list.
 * Used following URL for tutorial
 * 
 * http://www.mkyong.com/android/android-listview-example/
 * 
 * Brandon Schlack. 04/02/2013 03:46am
 */
package cs.pacificu.mypace;

import android.content.Intent;
import android.content.SharedPreferences;
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
		String skinPref = settings.getString("skins", "@string/skin_name_Default");
		
		if (skinPref == "@string/skin_name_Default")
		{
			setTheme(R.style.AppBaseTheme);
		}
		else if (skinPref == "@string/skin_name_Light")
		{
			Playlist.this.setTheme(R.style.Light);
		}
		else if (skinPref == "@string/skin_name_Dark")
		{
			Playlist.this.setTheme(R.style.Dark);
		}
		
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
	public void onResume ()
	{
		super.onResume();
		
		SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
		String skinPref = settings.getString("skins", "@string/skin_name_Default");
		
		if (skinPref == "@string/skin_name_Default")
		{
			Playlist.this.setTheme(R.style.AppBaseTheme);
		}
		else if (skinPref == "@string/skin_name_Light")
		{
			Playlist.this.setTheme(R.style.Light);
		}
		else if (skinPref == "@string/skin_name_Dark")
		{
			Playlist.this.setTheme(R.style.Dark);
		}
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