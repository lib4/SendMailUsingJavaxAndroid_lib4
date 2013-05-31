package com.lib4.sendmail;

/**
 * @author AnasAbubacker
 */
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LauncherActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        final Button send = (Button) this.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                
                    new Thread(){
                	public void run(){
                	    try {   
                	    Sender sender = new Sender("youremailId@host.com", "password");
                            sender.sendMail("This is Subject",   
                                    "This is Body",   
                                    "AnasAbubacker",   
                                    "AnasAbubacker");   
                        } catch (Exception e) {   
                            Log.e("SendMail", e.getMessage(), e);   
                        } 
                	}
                    }.start();
                   

            }
        });

    }
}