/*
 * Displays a list.
 * Used following URL for tutorial
 * 
 * http://www.mkyong.com/android/android-listview-example/
 * 
 * Brandon Schlack. 04/02/2013 03:46am
 */
package cs.pacificu.mypace;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Playlist extends ListActivity
{
	static final String[] PLAYLISTS = new String[] {"Best Running Songs", 
		"Best Walking Songs", "Personal Playlist"};
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.playlists);
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.playlists,PLAYLISTS));
		
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
			    // When clicked, show a toast with the TextView text
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}