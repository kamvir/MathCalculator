package cordova-plugin-mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
        else if(action.equals("subtract"))
        {
            this.subtract(args, callbackContext);
            return true;
        }
        return false;
    }
    
    private void add(JSONArray args, CallbackContext callbackContext)
    {
        if(args != null)
        {
            try
            {
                int p1 = Integer.parseInt(args.getJSONObject().getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject().getString("param2"));
                callbackContext.success(""+(p1 + p2));
            }
            catch(Exception e)
            {
                callbackContext.error("Something went wrong: "+e);
            }
        }
        else
        {
            callbackContext.error("Please don't pass null values");
        }
    }


    //Function to subtract 2 nos.

    private void subtract(JSONArray args, CallbackContext callbackContext)
    {
        if(args != null)
        {
            try
            {
                int p1 = Integer.parseInt(args.getJSONObject().getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject().getString("param2"));
                callbackContext.success(""+(p1 - p2));
            }
            catch(Exception e)
            {
                callbackContext.error("Something went wrong: "+e);
            }
        }
        else
        {
            callbackContext.error("Please don't pass null values");
        }
    }
}
