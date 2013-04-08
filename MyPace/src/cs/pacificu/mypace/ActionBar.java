package cs.pacificu.mypace;

import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class ActionBar extends SherlockActivity 
{
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        //setTheme(SampleList.THEME); //Used for theme switching in samples
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.single_list_item);
	        ((TextView)findViewById(R.id.playlistItem)).setText(R.string.app_name);
	    }
}
