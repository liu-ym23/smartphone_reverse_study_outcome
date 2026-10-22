package com.android.settingslib.core.instrumentation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MetricsFeatureProvider {
    public static final String EXTRA_SOURCE_METRICS_CATEGORY = ":settings:source_metrics";
    protected List<LogWriter> mLoggerWriters;

    public MetricsFeatureProvider() {
        this.mLoggerWriters = new ArrayList();
        installLogWriters();
    }

    protected void installLogWriters() {
        this.mLoggerWriters.add(new EventLogWriter());
    }

    public int getAttribution(Activity r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        Intent r3 = r2.getIntent();
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getIntExtra(EXTRA_SOURCE_METRICS_CATEGORY, 0);
    }

    public void visible(Context r2, int r3, int r4, int r5) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().visible(r2, r3, r4, r5);
        goto L4
    }

    public void hidden(Context r2, int r3, int r4) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().hidden(r2, r3, r4);
        goto L4
    }

    public void clicked(int r2, String r3) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().clicked(r2, r3);
        goto L4
    }

    public void changed(int r2, String r3, int r4) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().changed(r2, r3, r4);
        goto L4
    }

    public void action(Context r2, int r3, Pair<Integer, Object>... r4) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().action(r2, r3, r4);
        goto L4
    }

    public void action(Context r2, int r3, String r4) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().action(r2, r3, r4);
        goto L4
    }

    public void action(int r8, int r9, int r10, String r11, int r12) {
        Iterator<LogWriter> r7 = this.mLoggerWriters.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().action(r8, r9, r10, r11, r12);
        goto L4
    }

    public void action(Context r2, int r3, int r4) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().action(r2, r3, r4);
        goto L4
    }

    public void action(Context r2, int r3, boolean r4) {
        Iterator<LogWriter> r1 = this.mLoggerWriters.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().action(r2, r3, r4);
        goto L4
    }

    public int getMetricsCategory(Object r1) {
        if ((r1 instanceof Instrumentable) == true) goto L7;
        return 0;
    L7:
        return ((Instrumentable) r1).getMetricsCategory();
    }

    public boolean logClickedPreference(Preference r3, int r4) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (logSettingsTileClick(r3.getKey(), r4) == false) goto L8;
    L11:
        return true;
    L8:
        if (logStartedIntent(r3.getIntent(), r4) == true) goto L11;
        if (logSettingsTileClick(r3.getFragment(), r4) == true) goto L11;
        return false;
    }

    public boolean logStartedIntent(Intent r2, int r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        ComponentName r0 = r2.getComponent();
        if (r0 == null) goto L8;
        String r4 = r0.flattenToString();
    L10:
        return logSettingsTileClick(r4, r3);
    L8:
        r4 = r2.getAction();
        goto L10
    }

    public boolean logStartedIntentWithProfile(Intent r2, int r3, boolean r4) {
        if (r2 != null) goto L5;
        return false;
    L5:
        ComponentName r0 = r2.getComponent();
        if (r0 == null) goto L8;
        String r5 = r0.flattenToString();
    L10:
        return logSettingsTileClickWithProfile(r5, r3, r4);
    L8:
        r5 = r2.getAction();
        goto L10
    }

    public boolean logSettingsTileClick(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        clicked(r3, r2);
        return true;
    }

    public boolean logSettingsTileClickWithProfile(String r2, int r3, boolean r4) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        StringBuilder r5 = new StringBuilder().append(r2);
        if (r4 == false) goto L9;
        String r6 = "/work";
    L10:
        clicked(r3, r5.append(r6).toString());
        return true;
    L9:
        r6 = "/personal";
        goto L10
    }
}
