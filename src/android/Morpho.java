package co.pragma.www.plugin.morpho;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;

public class Morpho extends CordovaPlugin {
    
    public Morpho() {
        // TODO Auto-generated constructor stub
    }
    
    public static final String metodo_saludo = "getRegard";
    
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
            callbackContext.error("Invalid action");
            return false;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
        
    }
    
}