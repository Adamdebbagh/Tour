package tekwin.org.tour;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;


public class MainActivity extends ActionBarActivity {


    private static final int GPS_ERRORDIALOG_REQUEST = 9001 ;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (serviceOk()){
            Toast.makeText(this,"Ready to Map",Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean serviceOk(){
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS){
            return true;
        }
        else if(GooglePlayServicesUtil.isUserRecoverableError(isAvailable)){
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable,this,GPS_ERRORDIALOG_REQUEST);
            dialog.show();
        }
        else {
            Toast.makeText(this,"Can't connect to Google Play services",Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
