package com.obric.server.security.securityconfig;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.obric.server.security.IObricSecurityPlugin;

/* JADX INFO: loaded from: classes.dex */
public class SecurityConfigServicePlugin implements IObricSecurityPlugin {
    public static final IObricSecurityPlugin.Creator CREATOR = null;
    private static final String TAG = "SecurityConfigServicePlugin";
    private final Context mContext;
    private ObricSecurityConfigManagerService mManagerService;

    static {
        CREATOR = new AnonymousClass1();
    }

    public SecurityConfigServicePlugin(Context context) {
        this.mContext = context;
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStart() {
        Log.i(TAG, "onStart");
        this.mManagerService = new ObricSecurityConfigManagerService(this.mContext);
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStop() {
        Log.i(TAG, "onStop");
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public IBinder asBinder() {
        return this.mManagerService;
    }
}
