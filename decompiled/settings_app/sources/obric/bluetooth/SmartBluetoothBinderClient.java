package obric.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.cae.libs.bluetooth.CaeBluetoothDeviceManager;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes5.dex */
public class SmartBluetoothBinderClient {
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final int PRODUCT_1 = 365;
    public static final int PRODUCT_2 = 359;
    public static final int PRODUCT_3 = 363;
    public static final int PRODUCT_DORA_G = 4096;
    public static final int PRODUCT_OLA_FRIEND = 1;
    private static final String TAG = "SmartBluetoothBinderCli";
    private final ICaeBluetoothCallbackExporter mCallback;
    private Context mContext;
    private CaeBluetoothDeviceManager mDeviceManager;
    private final CaeBluetoothDeviceManager.CaeBluetoothServiceListener mServiceListener;

    static /* synthetic */ ICaeBluetoothCallbackExporter access$000(SmartBluetoothBinderClient r0) {
        return r0.mCallback;
    }

    static /* synthetic */ CaeBluetoothDeviceManager access$100(SmartBluetoothBinderClient r0) {
        return r0.mDeviceManager;
    }

    public SmartBluetoothBinderClient(Context r2) {
        this.mServiceListener = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        this.mContext = r2;
        doBind();
    }

    public void doBind() {
        CaeBluetoothDeviceManager r0 = CaeBluetoothDeviceManager.getInstance(this.mContext);
        this.mDeviceManager = r0;
        r0.addServiceListener(this.mServiceListener);
        this.mDeviceManager.bindService();
    }

    private void doUnbind() {
        CaeBluetoothDeviceManager r0 = this.mDeviceManager;
        if (r0 == null) goto L6;
        r0.unregisterEventCallback(this.mCallback);
        this.mDeviceManager.unbindService();
        return;
    }

    public void close() {
        OLog.d(TAG, "close");
        doUnbind();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "close: " + e);
    }

    public int getProductId(BluetoothDevice r4) {
        if (r4 == null) goto L12;
        OLog.d(TAG, "getProductId: " + r4);     // Catch: Exception -> L6
        return this.mDeviceManager.getProductId(r4);
    L6:
        e = move-exception;
        OLog.e(TAG, "" + e);
        return -1;
    L12:
        return -1;
    }

    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r4) {
        if (r4 == null) goto L12;
        OLog.d(TAG, "getDeviceType: " + r4);     // Catch: Exception -> L6
        return this.mDeviceManager.getDeviceType(r4);
    L6:
        e = move-exception;
        OLog.e(TAG, "getDeviceType error: " + e.getMessage());
        return null;
    L12:
        return null;
    }
}
