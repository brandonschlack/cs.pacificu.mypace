package cs.pacificu.mypace;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;



public class Settings extends PreferenceActivity
{

	private OnSharedPreferenceChangeListener ToastListener;
	private OnSharedPreferenceChangeListener SkinListener;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.settings);
		PreferenceManager.setDefaultValues(Settings.this, R.layout.settings, false);
		
		final SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
		final SharedPreferences.Editor editor = settings.edit();
		
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
				
				//SharedPreferences settings = getSharedPreferences("settings",MODE_PRIVATE);
				//final SharedPreferences.Editor editor = settings.edit();
				
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
		        		//editor.commit();
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
				    	  editor.commit();
				       //here you can add functions
				 
				    } });
				paceDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
				      public void onClick(DialogInterface dialog, int which) {
				       //here you can add functions
				 
				    } });
		        
				paceDialog.show();
			
				
				return false;
			}
			
			
		});
		

		ListPreference skinPref = (ListPreference) findPreference ("skins");
		skinPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener () {
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				String listValue = (String) newValue;
				
				ListPreference skinPref = (ListPreference) findPreference ("skins");
				skinPref.setValue(listValue);
				
				editor.putString("skins", skinPref.getValue());
				editor.commit();
				
				return true;
		    }
		});
		
		ToastListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
			  public void onSharedPreferenceChanged(SharedPreferences settings, String key) {
				String ToastText = settings.getString("skins", "@string/skin_name_Default");
				Intent intent = new Intent(getBaseContext(),Playlist.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			    Toast.makeText(getApplicationContext(), ToastText, Toast.LENGTH_SHORT).show();
			  }
			};
			
		SkinListener= new SharedPreferences.OnSharedPreferenceChangeListener() {
			  public void onSharedPreferenceChanged(SharedPreferences settings, String key) {
				String skinValue = settings.getString("skins", "Default");
				if (skinValue == "Default")
				{
					setTheme(R.style.AppBaseTheme);
				}
				else if (skinValue == "Light")
				{
					setTheme(R.style.Light);
				}
				else if (skinValue == "Dark")
				{
					setTheme(R.style.Dark);
				}
				Intent intent = new Intent(getBaseContext(),Playlist.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			  }
			};
		settings.registerOnSharedPreferenceChangeListener(ToastListener);
		
	}
}

