package cs.pacificu.mypace;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;



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
		Preference equalizerPref = (Preference) findPreference ("equalizer");
		equalizerPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick (Preference preference) {
				// TODO: laters
				return false;
			}
			
		});
		Preference pacePref = (Preference) findPreference ("pace");
		pacePref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick (Preference preference) {
				final AlertDialog paceDialog = new AlertDialog.Builder(Settings.this).create();
				
				SharedPreferences settings = getPreferences(MODE_PRIVATE);
				final SharedPreferences.Editor editor = settings.edit();
				
				SeekBar seekBar = new SeekBar(Settings.this);
		        seekBar.setMax(900);

		        seekBar.setProgress(settings.getInt("pace", 450));
		        seekBar.setVisibility(View.VISIBLE);
		        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		        	@Override
		        	public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser)
		        	{
		        		paceDialog.setMessage("Current Pace: " + Integer.toString(progress / 60) + "m " + Integer.toString(progress % 60) + "s");
		        		editor.putInt("pace", progress);
		        		editor.commit();
		        	}
		        	
		        	public void onStopTrackingTouch (SeekBar seekBar)
		        	{
		        		//nothing
		        	}
		        	
		        	public void onStartTrackingTouch (SeekBar seekBar)
		        	{
		        		//nothing
		        	}
		        });
		        
				paceDialog.setTitle(R.string.settings_Pace);
				paceDialog.setMessage("Current Pace: " + Integer.toString(settings.getInt("pace", 450) / 60) + "m " + Integer.toString(settings.getInt("pace", 450) % 60) + "s");
				paceDialog.setView(seekBar);
				paceDialog.setButton("OK", new DialogInterface.OnClickListener() {
				      public void onClick(DialogInterface dialog, int which) {
				 
				       //here you can add functions
				    	 
				 
				    } }); 
				paceDialog.show();
			
				
				return false;
			}
			
		});
	}

}

