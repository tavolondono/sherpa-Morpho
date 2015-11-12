package co.pragma.www.plugin.morpho;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import morpho.etis.android.sdk.account.IAccount_Data;
import morpho.etis.android.sdk.ui.common.IDATA_PARAMETERS;

public class Morpho extends CordovaPlugin {
    
    private static int SCAN_CODE = 1;
    public static final String metodo_saludo = "getRegard";
    public static final String TAG = "MORPHO";
    public static final String launchAuthentication = "launchAuthentication";
    public static final String launchRegistry = "launchRegistry";
    // Arbitrary value to store the user account name
    public static final String ACCOUNT_NAME_KEY = "ACCOUNT_NAME";
	
	public Morpho() {
        // TODO Auto-generated constructor stub
    }
	
	
    @Override
    public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) throws JSONException {
        try {
            if (metodo_saludo.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);
                String result = "Hola hombre: " + arg_object.getString("title") ;
                callbackContext.success(result);
                return true;
            }
            if (launchAuthentication.equals(action)) {
                Context appCtx = cordova.getActivity().getApplicationContext();
                Intent authenticationActivity = new Intent(appCtx, AuthenticationActivity.class);
                cordova.startActivityForResult(this, authenticationActivity,1);
                callbackContext.success();
            }
            if (launchRegistry.equals(action)) {
                Context appCtx = cordova.getActivity().getApplicationContext();
                Intent registryIntent = new Intent(appCtx, RegistrationActivity.class);
                cordova.startActivityForResult(this, registryIntent, SCAN_CODE);
                callbackContext.success();
            }


            callbackContext.error("Invalid action");
            return false;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }

    }

}