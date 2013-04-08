MyPace ReadMe

- Out app is not fully functional right now. We do not have different skins drawn out to change to and do not have music fully functioning yet.

- In orer to test the app on an emulator you need to install the .apk file

- To run the application on your phone install the application

Installation Instructions (Borrowed from HAZD)
1. Extract our .apk from the zip
2. Start up Eclipse
3. If not installed, install all android functionality into eclipse. Instructions can be found here: http://zeus.cs.pacificu.edu/ryand/cs260/2011/Lectures/AndroidInstall.pdf
4. Start an Android emulator of at least 2.3.3 (Window->Android Virtual Device Manager)
5. Open up a command window (winkey, type cmd, hit enter)
6. Enter the following command: cd C:\PROGRA~2\Android\android-sdk\platform-tools
7. The next is the tricky bit: Enter “adb -s emulator-(your emulator’s id #, found at top of emulator window, looks like 5556 or 5554) install (direct path to our .apk)
8. Should run for a bit, then give you a success message. If that didn’t work, feel free to email Ryan Newman at newm4205@pacificu.edu