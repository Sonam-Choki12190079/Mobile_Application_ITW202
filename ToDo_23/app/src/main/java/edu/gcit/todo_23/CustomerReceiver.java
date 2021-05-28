package edu.gcit.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomerReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST= BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {

        String intentAction = intent.getAction();
        if(intentAction !=null){
            String toastMessage ="unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage="Power connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage="Power Disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage="custom BroadCast Receiver";
                    break;

            }
            Toast.makeText(context,toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}