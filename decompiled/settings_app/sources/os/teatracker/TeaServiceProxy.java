package os.teatracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
class TeaServiceProxy implements ServiceConnection {
    private static final int MAX_RETRY_COUNT = 10;
    private static final long RETRY_DELAY = 1000;
    public static final String TEA_SERVICE_ACTION = "os.teatracker.ACTION_TEA_TRACKER_SERVICE";
    private BindCallback mBindCallback;
    private final AtomicBoolean mConnected;
    private Context mContext;
    private Handler mHandler;
    private Messenger mMessenger;
    private final AtomicInteger mRetryCount;
    private boolean mUnbindMySelf;

    interface BindCallback {
        void onTeaServiceConnected();

        void onTeaServiceDisconnected();
    }

    private static final class InternalHolder {
        public static final TeaServiceProxy sTeaServiceProxy = null;

        private InternalHolder() {
        }

        static {
            sTeaServiceProxy = new TeaServiceProxy(null);
        }
    }

    /* synthetic */ TeaServiceProxy(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$000(TeaServiceProxy r0) {
        return r0.bindTeaService();
    }

    private TeaServiceProxy() {
        this.mConnected = new AtomicBoolean(false);
        this.mRetryCount = new AtomicInteger(0);
        this.mUnbindMySelf = false;
    }

    public boolean bindService(Context context) {
        if (context != null) goto L5;
        return false;
    L5:
        this.mContext = context;
        if (this.mConnected.get() == false) goto L12;
        if (this.mMessenger == null) goto L12;
        notifyBindCallback(true);
        return true;
    L12:
        if (bindTeaService() == false) goto L14;
        return true;
    L14:
        Log.i(TeaConfig.TAG, "Can't connect to service");
        unbindService();
        return false;
    }

    public void setBindCallback(BindCallback callback) {
        this.mBindCallback = callback;
    }

    public boolean isTeaServiceConnected() {
        if (this.mConnected.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mMessenger == null) goto L7;
        return true;
    }

    private boolean bindTeaService() {
        Intent r0 = new Intent(TEA_SERVICE_ACTION);
        PackageManager r1 = this.mContext.getPackageManager();
        if (r1 != null) goto L6;
        Log.e(TeaConfig.TAG, "Can not resolve app! packageManager is null ");
        return false;
    L6:
        List<ResolveInfo> r2 = r1.queryIntentServices(r0, 0);
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r2.isEmpty() == false) goto L14;
        Log.e(TeaConfig.TAG, "Can not resolve app! We got empty list!");
        return false;
    L14:
        if (r2.size() <= 1) goto L17;
        Log.e(TeaConfig.TAG, "can not resolve app! We got several results!");
        return false;
    L17:
        r0.setPackage(r2.get(0).serviceInfo.packageName);
        return this.mContext.bindService(r0, this, 1);
    }

    public void unbindService() {
        this.mUnbindMySelf = true;
        if (isTeaServiceConnected() == false) goto L5;
        this.mContext.unbindService(this);
    L5:
        this.mContext = null;
    }

    public boolean onEvent(List<TeaEvent> teaEvents, boolean isSysEvent) {
    L19:
        e = move-exception;
        Log.e(TeaConfig.TAG, "ServiceProxy onEvent ex: " + e);
        return false;
    L3:
        if (isTeaServiceConnected() == false) goto L28;
        Message r0 = new Message();     // Catch: RemoteException -> L19
        r0.what = 101;     // Catch: RemoteException -> L19
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L19
        r0.setData(r1);     // Catch: RemoteException -> L19
        TeaConfig r2 = TeaHandler.getTeaHandler().getTeaConfig();     // Catch: RemoteException -> L19
        if (isSysEvent == false) goto L7;
        String r9 = TeaConst.SYS_APP_ID;
    L8:
        r1.putString(TeaConst.MESSAGE_KEY_APP_ID, r9);     // Catch: RemoteException -> L19
        ArrayList<? extends Parcelable> r10 = new ArrayList(teaEvents.size());     // Catch: RemoteException -> L19
        Iterator<TeaEvent> r8 = teaEvents.iterator();     // Catch: RemoteException -> L19
    L10:
        if (r8.hasNext() == false) goto L16;
        TeaEvent r3 = r8.next();     // Catch: RemoteException -> L19
        Bundle r4 = new Bundle();     // Catch: RemoteException -> L19
        r4.putString("key_event", r3.getEvent());     // Catch: RemoteException -> L19
        if (r3.getJsonParams() != null) goto L14;
        String r5 = null;
    L15:
        r4.putString("key_params", r5);     // Catch: RemoteException -> L19
        r4.putBoolean("key_instant", r3.isInstant());     // Catch: RemoteException -> L19
        r4.putLong("key_timestamp", r3.getTimestamp());     // Catch: RemoteException -> L19
        r10.add(r4);     // Catch: RemoteException -> L19
        goto L10
    L14:
        r5 = r3.getJsonParams().toString();     // Catch: RemoteException -> L19
        goto L15
    L16:
        r1.putParcelableArrayList("key_data", r10);     // Catch: RemoteException -> L19
        this.mMessenger.send(r0);     // Catch: RemoteException -> L19
        return true;
    L7:
        r9 = r2.getAppId();     // Catch: RemoteException -> L19
        goto L8
    L28:
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.mRetryCount.set(0);
        this.mMessenger = new Messenger(service);
        setAbSdkVersion(TeaHandler.getTeaHandler().getAbSDKVersion());
        Boolean r2 = TeaHandler.getTeaHandler().isPrivacyPolicyConfirmed();
        if (r2 == null) goto L5;
        setPrivacyPolicyConfirmed(r2.booleanValue());
    L5:
        notifyBindCallback(true);
        this.mConnected.set(true);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        this.mConnected.set(false);
        this.mMessenger = null;
        if (this.mUnbindMySelf == true) goto L9;
        Log.i(TeaConfig.TAG, "ServiceProxy retry times: " + this.mRetryCount.get());
        if (this.mRetryCount.getAndIncrement() >= 10) goto L7;
        this.mHandler.postDelayed(new AnonymousClass1(this), 1000);
        return;
    L7:
        Log.e(TeaConfig.TAG, "ServiceProxy connted to tea service error with " + this.mRetryCount.get() + " times retry.");
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName name) {
        onServiceDisconnected(name);
    }

    private void notifyBindCallback(boolean connected) {
        BindCallback r0 = this.mBindCallback;
        if (r0 == null) goto L8;
        if (connected == false) goto L6;
        r0.onTeaServiceConnected();
        return;
    L6:
        r0.onTeaServiceDisconnected();
        return;
    }

    public void setAbSdkVersion(String abSdkVersion) {
        Message r0 = new Message();     // Catch: RemoteException -> L4
        r0.what = 102;     // Catch: RemoteException -> L4
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L4
        r1.putString(TeaConst.MESSAGE_KEY_APP_ID, TeaHandler.getTeaHandler().getTeaConfig().getAppId());     // Catch: RemoteException -> L4
        r1.putString(TeaConst.MESSAGE_KEY_AB_SDK_VERSION, abSdkVersion);     // Catch: RemoteException -> L4
        r0.setData(r1);     // Catch: RemoteException -> L4
        this.mMessenger.send(r0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TeaConfig.TAG, "ServiceProxy setAbSdkVersion ex: " + e);
    }

    public void setPrivacyPolicyConfirmed(boolean confirmed) {
        Message r0 = new Message();     // Catch: RemoteException -> L4
        r0.what = 103;     // Catch: RemoteException -> L4
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L4
        r1.putString(TeaConst.MESSAGE_KEY_APP_ID, TeaHandler.getTeaHandler().getTeaConfig().getAppId());     // Catch: RemoteException -> L4
        r1.putBoolean(TeaConst.MESSAGE_KEY_PRIVACY_POLICY_CONFIRMED, confirmed);     // Catch: RemoteException -> L4
        r0.setData(r1);     // Catch: RemoteException -> L4
        this.mMessenger.send(r0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TeaConfig.TAG, "ServiceProxy setPrivacyPolicyConfirmed ex: " + e);
    }

    public static TeaServiceProxy getTeaServiceProxy(Handler handler) {
        if (InternalHolder.sTeaServiceProxy.mHandler != null) goto L11;
        if (handler == null) goto L9;
        if (handler.getLooper() == Looper.getMainLooper()) goto L9;
        InternalHolder.sTeaServiceProxy.mHandler = handler;
    L9:
        throw new RuntimeException("A handler needed by ServiceProxy and handler should runs in the non-main thread");
    L11:
        return InternalHolder.sTeaServiceProxy;
    }
}
