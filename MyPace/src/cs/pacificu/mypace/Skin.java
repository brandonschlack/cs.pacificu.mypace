package cs.pacificu.mypace;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class Skin extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		final String[] SKINS = new String[] {"Default", 
			"HTC", "Aluminum"};
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlist);
		ListView listView = (ListView) findViewById (R.id.playlists);
		
		listView.setAdapter(new ArrayAdapter<String>(this,R.layout.single_list_item,SKINS));
		
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
			    finish();
			}
		});
		
	}
}