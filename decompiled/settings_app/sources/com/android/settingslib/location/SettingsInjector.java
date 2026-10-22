package com.android.settingslib.location;

import android.app.ActivityManager;
import android.app.BackgroundServiceStartNotAllowedException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.preference.Preference;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settingslib.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SettingsInjector {
    private static final long INJECTED_STATUS_UPDATE_TIMEOUT_MILLIS = 1000;
    static final String TAG = "SettingsInjector";
    private static final int WHAT_RECEIVED_STATUS = 2;
    private static final int WHAT_RELOAD = 1;
    private static final int WHAT_TIMEOUT = 3;
    protected final Context mContext;
    private final Handler mHandler;
    protected final Set<Setting> mSettings;

    private static class MessengerHandler extends Handler {
        private Handler mHandler;
        private WeakReference<Setting> mSettingRef;

        public MessengerHandler(Setting r2, Handler r3) {
            this.mSettingRef = new WeakReference(r2);
            this.mHandler = r3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            Setting r0 = this.mSettingRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            Bundle r1 = r6.getData();
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(SettingsInjector.TAG, r0 + ": received " + r6 + ", bundle: " + r1);
        L8:
            boolean r7 = r1.getBoolean(IndexDatabaseHelper.IndexColumns.ENABLED, true);
            String r2 = r1.getString("summary");
            Preference r3 = r0.preference;
            if (TextUtils.isEmpty(r2) == false) goto L11;
            r3.setSummary(R.string.summary_placeholder);
        L12:
            r3.setEnabled(r7);
            Handler r5 = this.mHandler;
            r5.sendMessage(r5.obtainMessage(2, r0));
            return;
        L11:
            r3.setSummary(r2);
            goto L12
        }
    }

    protected class ServiceSettingClickedListener implements Preference.OnPreferenceClickListener {
        private InjectedSetting mInfo;
        final /* synthetic */ SettingsInjector this$0;

        public ServiceSettingClickedListener(SettingsInjector r1, InjectedSetting r2) {
            this.this$0 = r1;
            this.mInfo = r2;
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r3) {
            Intent r4 = new Intent();
            r4.setClassName(this.mInfo.packageName, this.mInfo.settingsActivity);
            this.this$0.logPreferenceClick(r4);
            this.this$0.mContext.startActivityAsUser(r4, this.mInfo.mUserHandle);
            return true;
        }
    }

    protected final class Setting {
        public final Preference preference;
        public final InjectedSetting setting;
        public long startMillis;
        final /* synthetic */ SettingsInjector this$0;

        public Setting(SettingsInjector r1, InjectedSetting r2, Preference r3) {
            this.this$0 = r1;
            this.setting = r2;
            this.preference = r3;
        }

        public String toString() {
            return "Setting{setting=" + this.setting + ", preference=" + this.preference + '}';
        }

        public void startService() {
            ActivityManager r0 = (ActivityManager) this.this$0.mContext.getSystemService("activity");
            if (r0.isUserRunning(this.setting.mUserHandle.getIdentifier()) == false) goto L5;
            MessengerHandler r1 = new MessengerHandler(this, SettingsInjector.access$000(this.this$0));
            Messenger r3 = new Messenger(r1);
            Intent r4 = this.setting.getServiceIntent();
            r4.putExtra("messenger", r3);
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L11;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(SettingsInjector.TAG, this.setting + ": sending update intent: " + r4 + ", handler: " + r1);
            this.startMillis = SystemClock.elapsedRealtime();
        L17:
            this.this$0.mContext.startServiceAsUser(r4, this.setting.mUserHandle);     // Catch: BackgroundServiceStartNotAllowedException -> L14
            return;
        L14:
            e = move-exception;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(SettingsInjector.TAG, "Not allowed to start service Intent in background. User running: " + r0.isUserRunning(this.setting.mUserHandle.getIdentifier()), e);
            return;
        L11:
            this.startMillis = 0;
            goto L17
        L5:
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L19;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(SettingsInjector.TAG, "Cannot start service as user " + this.setting.mUserHandle.getIdentifier() + " is not running");
            return;
        }

        public long getElapsedTime() {
            return SystemClock.elapsedRealtime() - this.startMillis;
        }

        public void maybeLogElapsedTime() {
            if (Log.isLoggable(SettingsInjector.TAG, 3) == true) goto L5;
            return;
        L5:
            if (this.startMillis == 0) goto L9;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(SettingsInjector.TAG, this + " update took " + getElapsedTime() + " millis");
            return;
        }
    }

    private static final class StatusLoadingHandler extends Handler {
        WeakReference<Set<Setting>> mAllSettings;
        private Set<Setting> mSettingsBeingLoaded;
        private Deque<Setting> mSettingsToLoad;

        public StatusLoadingHandler(Set<Setting> r2) {
            super(Looper.getMainLooper());
            this.mSettingsToLoad = new ArrayDeque();
            this.mSettingsBeingLoaded = new ArraySet();
            this.mAllSettings = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r9) {
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(SettingsInjector.TAG, "handleMessage start: " + r9 + ", " + this);
        L5:
            int r2 = r9.what;
            if (r2 == 1) goto L14;
            if (r2 == 2) goto L13;
            if (r2 == 3) goto L10;
            Log.wtf(SettingsInjector.TAG, "Unexpected what: " + r9);
        L18:
            if (this.mSettingsBeingLoaded.size() <= 0) goto L24;
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L33;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(SettingsInjector.TAG, "too many services already live for " + r9 + ", " + this);
            return;
        L33:
            return;
        L24:
            if (this.mSettingsToLoad.isEmpty() == true) goto L26;
            Setting r3 = this.mSettingsToLoad.removeFirst();
            r3.startService();
            this.mSettingsBeingLoaded.add(r3);
            sendMessageDelayed(obtainMessage(3, r3), 1000);
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L35;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(SettingsInjector.TAG, "handleMessage end " + r9 + ", " + this + ", started loading " + r3);
            return;
        L35:
            return;
        L26:
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L34;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(SettingsInjector.TAG, "nothing left to do for " + r9 + ", " + this);
            return;
        L34:
            return;
        L10:
            Setting r4 = (Setting) r9.obj;
            this.mSettingsBeingLoaded.remove(r4);
            if (Log.isLoggable(SettingsInjector.TAG, 5) == false) goto L18;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(SettingsInjector.TAG, "Timed out after " + r4.getElapsedTime() + " millis trying to get status for: " + r4);
            goto L18
        L13:
            Setting r5 = (Setting) r9.obj;
            r5.maybeLogElapsedTime();
            this.mSettingsBeingLoaded.remove(r5);
            removeMessages(3, r5);
            goto L18
        L14:
            Set<Setting> r6 = this.mAllSettings.get();
            if (r6 == null) goto L18;
            this.mSettingsToLoad.clear();
            this.mSettingsToLoad.addAll(r6);
            goto L18
        }

        @Override // android.os.Handler
        public String toString() {
            return "StatusLoadingHandler{mSettingsToLoad=" + this.mSettingsToLoad + ", mSettingsBeingLoaded=" + this.mSettingsBeingLoaded + '}';
        }
    }

    protected void logPreferenceClick(Intent r1) {
    }

    static /* synthetic */ Handler access$000(SettingsInjector r0) {
        return r0.mHandler;
    }

    public SettingsInjector(Context r2) {
        this.mContext = r2;
        HashSet r3 = new HashSet();
        this.mSettings = r3;
        this.mHandler = new StatusLoadingHandler(r3);
    }

    protected List<InjectedSetting> getSettings(UserHandle r12) {
        PackageManager r1 = this.mContext.getPackageManager();
        Intent r2 = new Intent("android.location.SettingInjectorService");
        int r3 = r12.getIdentifier();
        List r4 = r1.queryIntentServicesAsUser(r2, 128, r3);
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Found services for profile id " + r3 + ": " + r4);
    L5:
        PackageManager r5 = this.mContext.createContextAsUser(r12, 0).getPackageManager();
        ArrayList r7 = new ArrayList(r4.size());
        Iterator r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L19;
        ResolveInfo r8 = (ResolveInfo) r6.next();
        InjectedSetting r9 = parseServiceInfo(r8, r12, r5);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L10:
        if (r9 == null) goto L11;
        r7.add(r9);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L7
    L11:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to load service info " + r8);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to load service info " + r8, e);
    L16:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to load service info " + r8, e);
        goto L7
    L19:
        if (Log.isLoggable(TAG, 3) == false) goto L21;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Loaded settings for profile id " + r3 + ": " + r7);
    L21:
        return r7;
    }

    private void populatePreference(Preference r2, InjectedSetting r3) {
        r2.setTitle(r3.title);
        r2.setSummary(R.string.loading_injected_setting_summary);
        r2.setOnPreferenceClickListener(new ServiceSettingClickedListener(this, r3));
    }

    public Map<Integer, List<Preference>> getInjectedSettings(Context r10, Set<UserHandle> r11) {
        List<UserHandle> r0 = ((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserProfiles();
        ArrayMap r1 = new ArrayMap();
        this.mSettings.clear();
        Iterator<UserHandle> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        UserHandle r3 = r2.next();
        if (r11.contains(r3) == false) goto L4;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = getSettings(r3).iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        InjectedSetting r6 = (InjectedSetting) r5.next();
        Preference r7 = createPreference(r10, r6);
        populatePreference(r7, r6);
        r4.add(r7);
        this.mSettings.add(new Setting(this, r6, r7));
        goto L9
    L12:
        if (r4.isEmpty() == true) goto L4;
        r1.put(Integer.valueOf(r3.getIdentifier()), r4);
        goto L4
    L14:
        reloadStatusMessages();
        return r1;
    }

    protected Preference createPreference(Context r1, InjectedSetting r2) {
        return new Preference(r1);
    }

    protected InjectedSetting parseServiceInfo(ResolveInfo r6, UserHandle r7, PackageManager r8) throws XmlPullParserException, IOException {
        ServiceInfo r0 = r6.serviceInfo;
        XmlResourceParser r3 = null;
        if ((r0.applicationInfo.flags & 1) == 0) goto L5;
    L33:
        XmlResourceParser r4 = r0.loadXmlMetaData(r8, "android.location.SettingInjectorService");     // Catch: Throwable -> L26 PackageManager.NameNotFoundException -> L28
        if (r4 == null) goto L25;
        AttributeSet r5 = Xml.asAttributeSet(r4);     // Catch: Throwable -> L26 PackageManager.NameNotFoundException -> L28
    L11:
        int r9 = r4.next();     // Catch: Throwable -> L26 PackageManager.NameNotFoundException -> L28
        if (r9 == 1) goto L17;
        if (r9 != 2) goto L11;
    L17:
        if ("injected-location-setting".equals(r4.getName()) == false) goto L23;
        InjectedSetting r10 = parseAttributes(r0.packageName, r0.name, r7, r8.getResourcesForApplication(r0.packageName), r5);     // Catch: Throwable -> L26 PackageManager.NameNotFoundException -> L28
        if (r4 == null) goto L21;
        r4.close();
    L21:
        return r10;
    L23:
        throw new XmlPullParserException("Meta-data does not start with injected-location-setting tag");     // Catch: Throwable -> L26 PackageManager.NameNotFoundException -> L28
    L25:
        throw new XmlPullParserException("No android.location.SettingInjectorService meta-data for " + r6 + ": " + r0);     // Catch: Throwable -> L26 PackageManager.NameNotFoundException -> L28
    L26:
        th = move-exception;
        if (0 == 0) goto L32;
        r3.close();
    L32:
        throw th;
    L29:
        throw new XmlPullParserException("Unable to load resources for package " + r0.packageName);     // Catch: Throwable -> L26
    L5:
        if (Log.isLoggable(TAG, 5) == false) goto L33;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Ignoring attempt to inject setting from app not in system image: " + r6);
        return null;
    }

    private static InjectedSetting parseAttributes(String r6, String r7, UserHandle r8, Resources r9, AttributeSet r10) {
        TypedArray r11 = r9.obtainAttributes(r10, android.R.styleable.SettingInjectorService);
        String r12 = r11.getString(1);     // Catch: Throwable -> L9
        int r2 = r11.getResourceId(0, 0);     // Catch: Throwable -> L9
        String r3 = r11.getString(2);     // Catch: Throwable -> L9
        String r5 = r11.getString(3);     // Catch: Throwable -> L9
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "parsed title: " + r12 + ", iconId: " + r2 + ", settingsActivity: " + r3);     // Catch: Throwable -> L9
    L6:
        InjectedSetting r13 = new InjectedSetting.Builder().setPackageName(r6).setClassName(r7).setTitle(r12).setIconId(r2).setUserHandle(r8).setSettingsActivity(r3).setUserRestriction(r5).build();     // Catch: Throwable -> L9
        r11.recycle();
        return r13;
    L9:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public void reloadStatusMessages() {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "reloadingStatusMessages: " + this.mSettings);
    L5:
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(1));
    }
}
