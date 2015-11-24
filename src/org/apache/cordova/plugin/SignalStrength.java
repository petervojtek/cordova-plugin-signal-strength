package org.apache.cordova.plugin;

import android.content.Context;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignalStrength extends CordovaPlugin {

@Override
public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("dbm")) {
                ssListener = new SignalStrengthStateListener();
                TelephonyManager tm = (TelephonyManager) cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
                tm.listen(ssListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
                int counter = 0;
                while ( dbm == -1) {
                        try {
                                Thread.sleep(200);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        if (counter++ >= 5)
                        {
                                break;
                        }
                }
                callbackContext.success(dbm);
                return true;
        }

        return false;
}


class SignalStrengthStateListener extends PhoneStateListener {

@Override
public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        int tsNormSignalStrength = signalStrength.getGsmSignalStrength();
        dbm = (2 * tsNormSignalStrength) - 113;     // -> dBm
}

}

SignalStrengthStateListener ssListener;
int dbm = -1;

}
