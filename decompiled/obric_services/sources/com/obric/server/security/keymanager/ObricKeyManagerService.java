package com.obric.server.security.keymanager;

import android.content.Context;
import android.os.IBinder;
import com.obric.server.security.IObricSecurityPlugin;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyManagerService implements IObricSecurityPlugin {
    public static final IObricSecurityPlugin.Creator CREATOR = null;
    private static final String TAG = "ObricKeyManagerService";
    private final Context mContext;
    private ObricKeyManager mKeyManager;

    /* synthetic */ ObricKeyManagerService(Context r1, ObricKeyManagerServiceIA r2) {
        this(r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStart() {
        this.mKeyManager = new ObricKeyManager(this.mContext);
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStop() {
    }

    private ObricKeyManagerService(Context context) {
        this.mContext = context;
    }
}
