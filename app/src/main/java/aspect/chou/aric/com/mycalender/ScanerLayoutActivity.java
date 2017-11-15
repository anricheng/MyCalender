package aspect.chou.aric.com.mycalender;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

public class ScanerLayoutActivity extends BaseActivity  {
    private static final String TAG = "ScanerLayoutActivity";

    private CompoundBarcodeView barcodeScanner;

    public static final String SCAN_RESULT="scan_result";

    private TextView mTextView;

    private String mScannerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaner_layout);

        mScannerResult=null;

        mTextView = (TextView) findViewById(R.id.scannerResult);

        if(mTextView!=null){
            mTextView.setText( MyApplication.vinResult);
        }








        barcodeScanner = (CompoundBarcodeView) findViewById(R.id.barcode_scanner);

        barcodeScanner.decodeContinuous(callback);
        barcodeScanner.setStatusText(null);

        Log.e(TAG, "onCreate: " +MyApplication.vinResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " +MyApplication.vinResult);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
            outState.putCharSequence(SCAN_RESULT,mScannerResult);
        Log.e(TAG, "onSaveInstanceState: " +mScannerResult);
    }


    public void switchButton(View view){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " +MyApplication.vinResult);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);




        Log.e(TAG, "onRestoreInstanceState: " +MyApplication.vinResult);

    }



    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            String vinStr = result.getText();
            mScannerResult=vinStr;
            MyApplication.vinResult=vinStr;

            if (mTextView!=null){
                mTextView.setText(vinStr);
            }

            if(ScanerLayoutActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            }else{

            }

        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    public void onBackPressed() {
        if(ScanerLayoutActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void onResume() {
        barcodeScanner.resume();

        Log.e(TAG, "onResume: " +MyApplication.vinResult);

        super.onResume();
    }

    @Override
    public void onPause() {
        barcodeScanner.pause();
        super.onPause();
        Log.e(TAG, "onPause: " +MyApplication.vinResult);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " +MyApplication.vinResult);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " +MyApplication.vinResult);
    }
}
