package BarxDroid.AirView;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

import android.view.MotionEvent;
import android.view.View;

@Version(1.1f)
@ShortName("AirViewListener")
@Author("BarxDroid")
@Events(values={"HoverStart(x as Float, y as Float)", "HoverEnd(x as Float, y as Float)", "HoverMove(x as Float, y as Float)"})


public class AirView {
	
	/**
	 * Initializes a Hover Listener against a given View.
	 * 
	 * View - The View that will react to the Hover event
	 * EventName - The sub that will handle the events
	 * 
	 * Be sure to add the following to the manifest using the Manifest Editor:-
	 * AddActivityText(Main, &lt;intent-filter&gt;
	 * &lt;action android:name=&quot;com.sec.android.airview.HOVER&quot; /&gt;
	 * &lt;/intent-filter&gt;)
	 */
	public void Initialize(final BA ba, final View view, final String Eventname) {
	
		final String mEventname = Eventname.toLowerCase();
		
			try {
				
				view.setOnHoverListener(new View.OnHoverListener() {
	
					@Override
					public boolean onHover(View v, MotionEvent event) {
						switch (event.getAction()) {
				
						case 9 : 
					
							if (ba.subExists(mEventname + "_hoverstart")) {
						
								ba.raiseEvent(view, mEventname + "_hoverstart", new Object[] { event.getX(0),event.getY(0)});
							}
							break;
					
						case 10 : 
							if (ba.subExists(mEventname + "_hoverend")) {
								ba.raiseEvent(view, mEventname + "_hoverend", new Object[] {event.getX(0),event.getY(0)});
							}
							break;
				
						case 7 : 
							if (ba.subExists(mEventname + "_hovermove")) {
								ba.raiseEvent(view, mEventname + "_hovermove", new Object[] { event.getX(0),event.getY(0)});
							}
							break;
						}
				return false;
				
				}
			
			});
		}
		
		catch (NoClassDefFoundError e) {
			BA.Log("***AirView is not supported by this version of Android***");
		}
			
	}
}

