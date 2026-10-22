package com.bytedanceos.numberassistant;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedanceos.utils.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NumberAssistantProxy {
    private static final String BYTEDANCEOS_NUMBER_ASSISTANT_PACKAGE = "com.obric.numberassistant";
    private static final String BYTEDANCEOS_NUMBER_ASSISTANT_SERVICE_ACTION = "BYTEDANCEOS_NUMBER_ASSISTANT_SERVICE";
    private static final int MAX_RETRY_COUNT = 10;
    private static final long RETRY_DELAY = 1000;
    private static final String TAG = "NumberAssistantProxy";
    private BindCallback mBindCallback;
    private Context mContext;
    private boolean mIsUnbindByManual;
    private INumberAssistant mNumberAssistant;
    private ServiceConnection mNumberAssistantConn;
    private boolean mNumberAssistantFeatureEnable;
    private int mRetryCount;

    public interface BindCallback {
        void onConnected();

        void onDisconnected();
    }

    private static final class Hold {
        private static NumberAssistantProxy sInstance;

        private Hold() {
        }

        static /* synthetic */ NumberAssistantProxy access$100() {
            return sInstance;
        }

        static {
            sInstance = new NumberAssistantProxy(null);
        }
    }

    static {
    }

    /* synthetic */ NumberAssistantProxy(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ String access$200() {
        return TAG;
    }

    static /* synthetic */ void access$300(NumberAssistantProxy r0) {
        r0.onNumberAssistantDisconnected();
    }

    static /* synthetic */ boolean access$400(NumberAssistantProxy r0) {
        return r0.mIsUnbindByManual;
    }

    static /* synthetic */ int access$500(NumberAssistantProxy r0) {
        return r0.mRetryCount;
    }

    static /* synthetic */ int access$502(NumberAssistantProxy r0, int r1) {
        r0.mRetryCount = r1;
        return r1;
    }

    static /* synthetic */ int access$508(NumberAssistantProxy r2) {
        int r0 = r2.mRetryCount;
        r2.mRetryCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ boolean access$600(NumberAssistantProxy r0) {
        return r0.bindInternal();
    }

    static /* synthetic */ void access$700(NumberAssistantProxy r0, ComponentName r1, IBinder r2) {
        r0.onNumberAssistantConnected(r1, r2);
    }

    public static NumberAssistantProxy getInstance() {
        return Hold.access$100();
    }

    private NumberAssistantProxy() {
        this.mIsUnbindByManual = false;
        this.mRetryCount = 0;
        this.mNumberAssistantConn = new AnonymousClass1(this);
    }

    private void onNumberAssistantConnected(ComponentName name, IBinder service) {
        this.mNumberAssistant = INumberAssistant.Stub.asInterface(service);
        BindCallback r0 = this.mBindCallback;
        if (r0 == null) goto L6;
        r0.onConnected();
        return;
    }

    private void onNumberAssistantDisconnected() {
        this.mNumberAssistant = null;
        BindCallback r1 = this.mBindCallback;
        if (r1 == null) goto L6;
        r1.onDisconnected();
        return;
    }

    public boolean bind(Context context, BindCallback callback) {
        this.mContext = context;
        this.mBindCallback = callback;
        if (context != null) goto L5;
        return false;
    L5:
        boolean r2 = Constants.IS_FEATURE_DOMESTIC.booleanValue();
        this.mNumberAssistantFeatureEnable = r2;
        if (r2 == true) goto L9;
        return false;
    L9:
        if (this.mNumberAssistant == null) goto L15;
        BindCallback r1 = this.mBindCallback;
        if (r1 == null) goto L13;
        r1.onConnected();
    L13:
        return true;
    L15:
        if (bindInternal() == false) goto L17;
        return true;
    L17:
        unbind();
        return false;
    }

    private boolean bindInternal() {
        if (this.mContext != null) goto L6;
        return false;
    L6:
        Intent r0 = new Intent(BYTEDANCEOS_NUMBER_ASSISTANT_SERVICE_ACTION);
        r0.setPackage(BYTEDANCEOS_NUMBER_ASSISTANT_PACKAGE);
        return this.mContext.bindService(r0, this.mNumberAssistantConn, 1);
    }

    public void unbind() {
        this.mIsUnbindByManual = true;
        Context r0 = this.mContext;
        if (r0 == null) goto L5;
        r0.unbindService(this.mNumberAssistantConn);
        this.mContext = null;
    L5:
        this.mBindCallback = null;
        this.mNumberAssistant = null;
    }

    public void queryNumberInfo(final NumberQueryParams queryParams, final NumberAssistantCallback numberAssistantCallback) {
        INumberAssistant r0 = this.mNumberAssistant;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mNumberAssistantFeatureEnable == false) goto L15;
        r0.queryNumberInfo(queryParams, numberAssistantCallback);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void uploadNumberMark(List<NumberMarkInfo> markInfoList, NumberAssistantCallback numberAssistantCallback) {
        INumberAssistant r0 = this.mNumberAssistant;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mNumberAssistantFeatureEnable == false) goto L15;
        r0.uploadNumberMark(markInfoList, numberAssistantCallback);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
