package com.android.settingslib.deviceinfo;

import android.content.Context;
import android.os.PersistableBundle;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.ims.ImsMmTelManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.GlobalProxyLancet;
import com.android.settings.AdaptConstants;
import com.android.settingslib.R;
import com.android.settingslib.core.lifecycle.Lifecycle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractImsStatusPreferenceController extends AbstractConnectivityPreferenceController {
    private static final String[] CONNECTIVITY_INTENTS = null;
    static final String KEY_IMS_REGISTRATION_STATE = "ims_reg_state";
    private static final String LOG_TAG = "AbstractImsPrefController";
    private static final long MAX_THREAD_BLOCKING_TIME_MS = 2000;
    private Preference mImsStatus;

    /* JADX INFO: renamed from: com.android.settingslib.deviceinfo.AbstractImsStatusPreferenceController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class StateCallback extends AtomicBoolean implements Consumer<Integer> {
        private final Semaphore mSemaphore;
        final /* synthetic */ AbstractImsStatusPreferenceController this$0;

        /* synthetic */ StateCallback(AbstractImsStatusPreferenceController r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Integer r1) {
            accept2(r1);
        }

        private StateCallback(AbstractImsStatusPreferenceController r2) {
            this.this$0 = r2;
            super(false);
            this.mSemaphore = new Semaphore(0);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Integer r2) {
            if (r2.intValue() != 2) goto L5;
            boolean r3 = true;
        L6:
            set(r3);
            this.mSemaphore.release();     // Catch: Exception -> L9
            return;
        L12:
            return;
        L5:
            r3 = false;
            goto L6
        }

        public boolean waitUntilResult() {
            if (this.mSemaphore.tryAcquire(AbstractImsStatusPreferenceController.MAX_THREAD_BLOCKING_TIME_MS, TimeUnit.MILLISECONDS) == true) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(AbstractImsStatusPreferenceController.LOG_TAG, "IMS registration state query timeout");     // Catch: Exception -> L9
            return false;
        L8:
            return get();
        }
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_IMS_REGISTRATION_STATE;
    }

    static {
        CONNECTIVITY_INTENTS = new String[]{"android.bluetooth.adapter.action.STATE_CHANGED", "android.net.conn.CONNECTIVITY_CHANGE", AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION, "android.net.wifi.STATE_CHANGE"};
    }

    public AbstractImsStatusPreferenceController(Context r1, Lifecycle r2) {
        super(r1, r2);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        CarrierConfigManager r1 = (CarrierConfigManager) this.mContext.getSystemService(CarrierConfigManager.class);
        int r0 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (r1 == null) goto L5;
        PersistableBundle r2 = r1.getConfigForSubId(r0);
    L6:
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.getBoolean("show_ims_registration_status_bool") == false) goto L10;
        return true;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        this.mImsStatus = r2.findPreference(KEY_IMS_REGISTRATION_STATE);
        updateConnectivity();
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected String[] getConnectivityIntents() {
        return CONNECTIVITY_INTENTS;
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected void updateConnectivity() {
        if (this.mImsStatus != null) goto L5;
        return;
    L5:
        int r0 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (SubscriptionManager.isValidSubscriptionId(r0) == true) goto L9;
        this.mImsStatus.setSummary(R.string.ims_reg_status_not_registered);
        return;
    L9:
        ExecutorService r1 = Executors.newSingleThreadExecutor();
        StateCallback r2 = new StateCallback(this, null);
        ImsMmTelManager.createForSubscriptionId(r0).getRegistrationState(r1, r2);     // Catch: Exception -> L18
    L11:
        Preference r4 = this.mImsStatus;
        if (r2.waitUntilResult() == false) goto L14;
        int r3 = R.string.ims_reg_status_registered;
    L15:
        r4.setSummary(r3);
        r1.shutdownNow();     // Catch: Exception -> L19
        return;
    L24:
        return;
    L14:
        r3 = R.string.ims_reg_status_not_registered;
        goto L15
    }
}
