package cs.pacificu.mypace;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class Settings extends PreferenceActivity
{

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		/*final String[] SETTINGS = new String[] {"Equalizer",
			"GPS Tracking", "Pace Threshold", "USB Sync", "Scan Media", "About"};*/
		
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.settings);
	}
}

