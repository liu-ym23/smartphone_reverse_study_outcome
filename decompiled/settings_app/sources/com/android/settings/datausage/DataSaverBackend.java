package com.android.settings.datausage;

import android.content.Context;
import android.net.NetworkPolicyManager;
import android.util.SparseIntArray;
import com.android.settings.fuelgauge.datasaver.DynamicDenylistManager;
import com.android.settingslib.utils.ThreadUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DataSaverBackend {
    private static final String TAG = "DataSaverBackend";
    private boolean mAllowlistInitialized;
    private final Context mContext;
    private boolean mDenylistInitialized;
    private final DynamicDenylistManager mDynamicDenylistManager;
    private final ArrayList<Listener> mListeners;
    private final NetworkPolicyManager.Listener mPolicyListener;
    private final NetworkPolicyManager mPolicyManager;
    private SparseIntArray mUidPolicies;

    /* JADX INFO: renamed from: com.android.settings.datausage.DataSaverBackend$1, reason: invalid class name */
    class AnonymousClass1 extends NetworkPolicyManager.Listener {
        final /* synthetic */ DataSaverBackend this$0;

        AnonymousClass1(DataSaverBackend r1) {
            this.this$0 = r1;
        }

        /* JADX INFO: renamed from: lambda$onUidPoliciesChanged$0$com-android-settings-datausage-DataSaverBackend$1, reason: not valid java name */
        /* synthetic */ void m426x1eeebc4(int r1, int r2) {
            DataSaverBackend.access$100(this.this$0, r1, r2);
        }

        public void onUidPoliciesChanged(final int r2, final int r3) {
            ThreadUtils.postOnMainThread(new DataSaverBackend$1$$ExternalSyntheticLambda0(this, r2, r3));
        }

        /* JADX INFO: renamed from: lambda$onRestrictBackgroundChanged$1$com-android-settings-datausage-DataSaverBackend$1, reason: not valid java name */
        /* synthetic */ void m425xe9adda83(boolean r1) {
            DataSaverBackend.access$000(this.this$0, r1);
        }

        public void onRestrictBackgroundChanged(final boolean r2) {
            ThreadUtils.postOnMainThread(new DataSaverBackend$1$$ExternalSyntheticLambda1(this, r2));
        }
    }

    public interface Listener {
        default void onAllowlistStatusChanged(int r1, boolean r2) {
        }

        void onDataSaverChanged(boolean r1);

        default void onDenylistStatusChanged(int r1, boolean r2) {
        }
    }

    static /* synthetic */ void access$000(DataSaverBackend r0, boolean r1) {
        r0.handleRestrictBackgroundChanged(r1);
    }

    static /* synthetic */ void access$100(DataSaverBackend r0, int r1, int r2) {
        r0.handleUidPoliciesChanged(r1, r2);
    }

    public DataSaverBackend(Context r2) {
        this.mListeners = new ArrayList();
        this.mUidPolicies = new SparseIntArray();
        this.mPolicyListener = new AnonymousClass1(this);
        Context r3 = r2.getApplicationContext();
        this.mContext = r3;
        this.mPolicyManager = NetworkPolicyManager.from(r3);
        this.mDynamicDenylistManager = DynamicDenylistManager.getInstance(r3);
    }

    public void addListener(Listener r3) {
        this.mListeners.add(r3);
        if (this.mListeners.size() != 1) goto L5;
        this.mPolicyManager.registerListener(this.mPolicyListener);
    L5:
        r3.onDataSaverChanged(isDataSaverEnabled());
    }

    public void remListener(Listener r2) {
        this.mListeners.remove(r2);
        if (this.mListeners.size() != 0) goto L6;
        this.mPolicyManager.unregisterListener(this.mPolicyListener);
        return;
    }

    public boolean isDataSaverEnabled() {
        return this.mPolicyManager.getRestrictBackground();
    }

    public void setDataSaverEnabled(boolean r2) {
        this.mPolicyManager.setRestrictBackground(r2);
        OLog.i(TAG, "394, " + r2);
    }

    public void refreshAllowlist() {
        loadAllowlist();
    }

    public void setIsAllowlisted(int r3, String r4, boolean r5) {
        if (r5 == false) goto L4;
        int r0 = 4;
    L5:
        this.mDynamicDenylistManager.setUidPolicyLocked(r3, r0);
        this.mUidPolicies.put(r3, r0);
        if (r5 == false) goto L9;
        OLog.i(TAG, "395, " + r4);
        return;
    L9:
        return;
    L4:
        r0 = 0;
        goto L5
    }

    public boolean isAllowlisted(int r2) {
        loadAllowlist();
        if (this.mUidPolicies.get(r2, 0) != 4) goto L6;
        return true;
    L6:
        return false;
    }

    private void loadAllowlist() {
        if (this.mAllowlistInitialized == false) goto L5;
        return;
    L5:
        int[] r0 = this.mPolicyManager.getUidsWithPolicy(4);
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        int r4 = r0[r3];
        this.mUidPolicies.put(r4, 4);
        r3 = r3 + 1;
        goto L6
    L8:
        this.mAllowlistInitialized = true;
    }

    public void refreshDenylist() {
        loadDenylist();
    }

    public void setIsDenylisted(int r2, String r3, boolean r4) {
        this.mDynamicDenylistManager.setUidPolicyLocked(r2, r4 ? 1 : 0);
        this.mUidPolicies.put(r2, r4 ? 1 : 0);
        if (r4 == false) goto L6;
        OLog.i(TAG, "396, " + r3);
        return;
    }

    public boolean isDenylisted(int r4) {
        loadDenylist();
        if (this.mUidPolicies.get(r4, 0) == 1) goto L5;
        return false;
    L5:
        if (this.mDynamicDenylistManager.isInManualDenylist(r4) == true) goto L7;
        return false;
    L7:
        return true;
    }

    private void loadDenylist() {
        if (this.mDenylistInitialized == false) goto L5;
        return;
    L5:
        int[] r0 = this.mPolicyManager.getUidsWithPolicy(1);
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        int r4 = r0[r3];
        this.mUidPolicies.put(r4, 1);
        r3 = r3 + 1;
        goto L6
    L8:
        this.mDenylistInitialized = true;
    }

    private void handleRestrictBackgroundChanged(boolean r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mListeners.size()) goto L6;
        this.mListeners.get(r0).onDataSaverChanged(r3);
        r0 = r0 + 1;
        goto L4
    }

    private void handleAllowlistChanged(int r3, boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mListeners.size()) goto L6;
        this.mListeners.get(r0).onAllowlistStatusChanged(r3, r4);
        r0 = r0 + 1;
        goto L4
    }

    private void handleDenylistChanged(int r3, boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mListeners.size()) goto L6;
        this.mListeners.get(r0).onDenylistStatusChanged(r3, r4);
        r0 = r0 + 1;
        goto L4
    }

    private void handleUidPoliciesChanged(int r6, int r7) {
        loadAllowlist();
        loadDenylist();
        boolean r1 = false;
        int r0 = this.mUidPolicies.get(r6, 0);
        if (r7 != 0) goto L5;
        this.mUidPolicies.delete(r6);
    L7:
        if (r0 != 4) goto L9;
        boolean r4 = true;
    L10:
        if (r0 != 1) goto L12;
        boolean r2 = true;
    L13:
        if (r7 != 4) goto L15;
        boolean r3 = true;
    L16:
        if (r7 != 1) goto L18;
        r1 = true;
    L18:
        if (r4 == r3) goto L20;
        handleAllowlistChanged(r6, r3);
    L20:
        if (r2 == r1) goto L23;
        handleDenylistChanged(r6, r1);
        return;
    L23:
        return;
    L15:
        r3 = false;
        goto L16
    L12:
        r2 = false;
        goto L13
    L9:
        r4 = false;
        goto L10
    L5:
        this.mUidPolicies.put(r6, r7);
        goto L7
    }
}
