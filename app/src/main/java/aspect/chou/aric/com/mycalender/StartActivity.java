package aspect.chou.aric.com.mycalender;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


public class StartActivity extends BaseActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_layout);

    }



    public void scanner(View view){
        if (Build.VERSION.SDK_INT >= 23 && (!hasPermission(Manifest.permission.CAMERA))) {
            requestPermission(Constants.CAMERA_CODE, Manifest.permission.CAMERA);
        }else {
           NavigatorTo(ScanerLayoutActivity.class);
        }
    }


    @Override
    public void grantCamera(int[] grantResults) {

        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // permission was granted
            startActivity(new Intent(this, ScanerLayoutActivity.class));
        }
    }

}
