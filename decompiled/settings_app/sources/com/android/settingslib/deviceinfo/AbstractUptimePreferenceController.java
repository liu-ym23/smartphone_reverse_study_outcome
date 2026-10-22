package com.android.settingslib.deviceinfo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.DateUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractUptimePreferenceController extends AbstractPreferenceController implements LifecycleObserver, OnStart, OnStop {
    private static final int EVENT_UPDATE_STATS = 500;
    static final String KEY_UPTIME = "up_time";
    private Handler mHandler;
    private Preference mUptime;

    private static class MyHandler extends Handler {
        private WeakReference<AbstractUptimePreferenceController> mStatus;

        public MyHandler(AbstractUptimePreferenceController r2) {
            this.mStatus = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            AbstractUptimePreferenceController r0 = this.mStatus.get();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r4.what != 500) goto L10;
            AbstractUptimePreferenceController.access$000(r0);
            sendEmptyMessageDelayed(500, 1000);
            return;
        L10:
            throw new IllegalStateException("Unknown message " + r4.what);
        }
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_UPTIME;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return true;
    }

    static /* synthetic */ void access$000(AbstractUptimePreferenceController r0) {
        r0.updateTimes();
    }

    public AbstractUptimePreferenceController(Context r1, Lifecycle r2) {
        super(r1);
        if (r2 == null) goto L6;
        r2.addObserver(this);
        return;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStart
    public void onStart() {
        getHandler().sendEmptyMessage(500);
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStop
    public void onStop() {
        getHandler().removeMessages(500);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        this.mUptime = r2.findPreference(KEY_UPTIME);
        updateTimes();
    }

    private Handler getHandler() {
        if (this.mHandler != null) goto L6;
        this.mHandler = new MyHandler(this);
    L6:
        return this.mHandler;
    }

    private void updateTimes() {
        this.mUptime.setSummary(DateUtils.formatElapsedTime(SystemClock.elapsedRealtime() / 1000));
    }
}
