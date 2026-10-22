package com.android.settings.wifi;

import com.android.wifitrackerlib.WifiEntry;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheMgr.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/settings/wifi/CacheMgr;", "", "()V", "connectedEntry", "Lcom/android/wifitrackerlib/WifiEntry;", "getConnectedEntry", "()Lcom/android/wifitrackerlib/WifiEntry;", "setConnectedEntry", "(Lcom/android/wifitrackerlib/WifiEntry;)V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CacheMgr {
    public static final CacheMgr INSTANCE = null;
    private static WifiEntry connectedEntry;

    static {
        INSTANCE = new CacheMgr();
    }

    private CacheMgr() {
    }

    public final WifiEntry getConnectedEntry() {
        return connectedEntry;
    }

    public final void setConnectedEntry(WifiEntry r1) {
        connectedEntry = r1;
    }
}
