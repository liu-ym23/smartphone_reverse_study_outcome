package com.android.settings.accounts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.GlobalProxyLancet;
import com.android.settings.Utils;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ManagedProfileQuietModeEnabler implements DefaultLifecycleObserver {
    private static final String TAG = "QuietModeEnabler";
    private final Context mContext;
    private final QuietModeChangeListener mListener;

    @Nullable
    private final UserHandle mManagedProfile;
    final BroadcastReceiver mReceiver;
    private final UserManager mUserManager;

    public interface QuietModeChangeListener {
        void onQuietModeChanged();
    }

    static /* synthetic */ UserHandle access$000(ManagedProfileQuietModeEnabler r0) {
        return r0.mManagedProfile;
    }

    static /* synthetic */ void access$100(ManagedProfileQuietModeEnabler r0) {
        r0.refreshQuietMode();
    }

    public ManagedProfileQuietModeEnabler(Context r2, QuietModeChangeListener r3) {
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = r2;
        this.mListener = r3;
        UserManager r4 = (UserManager) r2.getSystemService(UserManager.class);
        this.mUserManager = r4;
        this.mManagedProfile = Utils.getManagedProfile(r4);
    }

    public void setQuietModeEnabled(boolean r2) {
        if (this.mManagedProfile != null) goto L6;
        return;
    L6:
        if (isQuietModeEnabled() == r2) goto L9;
        this.mUserManager.requestQuietModeEnabled(r2, this.mManagedProfile);
        return;
    }

    public boolean isQuietModeEnabled() {
        UserHandle r0 = this.mManagedProfile;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mUserManager.isQuietModeEnabled(r0) == false) goto L7;
        return true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner r3) {
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.intent.action.MANAGED_PROFILE_AVAILABLE");
        r4.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, r4, 4);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner r1) {
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    public boolean isAvailable() {
        if (this.mManagedProfile == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void refreshQuietMode() {
        QuietModeChangeListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onQuietModeChanged();
        return;
    }
}
