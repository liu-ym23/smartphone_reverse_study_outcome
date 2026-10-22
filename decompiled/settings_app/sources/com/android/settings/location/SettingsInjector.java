package com.android.settings.location;

import android.R;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.preference.Preference;
import com.android.settings.DimmableIconPreference;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class SettingsInjector {
    private static final long INJECTED_STATUS_UPDATE_TIMEOUT_MILLIS = 1000;
    static final String TAG = "SettingsInjector";
    private static final int WHAT_RECEIVED_STATUS = 2;
    private static final int WHAT_RELOAD = 1;
    private static final int WHAT_TIMEOUT = 3;
    private final Context mContext;
    private final Handler mHandler;
    private final Set<Setting> mSettings;

    /* JADX INFO: renamed from: com.android.settings.location.SettingsInjector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ServiceSettingClickedListener implements Preference.OnPreferenceClickListener {
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
            r4.setFlags(268468224);
            SettingsInjector.access$200(this.this$0).startActivityAsUser(r4, this.mInfo.mUserHandle);
            return true;
        }
    }

    private final class Setting {
        public final Preference preference;
        public final InjectedSetting setting;
        public long startMillis;
        final /* synthetic */ SettingsInjector this$0;

        /* synthetic */ Setting(SettingsInjector r1, InjectedSetting r2, Preference r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private Setting(SettingsInjector r1, InjectedSetting r2, Preference r3) {
            this.this$0 = r1;
            this.setting = r2;
            this.preference = r3;
        }

        public String toString() {
            return "Setting{setting=" + this.setting + ", preference=" + this.preference + '}';
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
        L9:
            return true;
        L4:
            if ((r2 instanceof Setting) == true) goto L6;
        L8:
            return false;
        L6:
            if (this.setting.equals(((Setting) r2).setting) == false) goto L8;
            goto L8
        }

        public int hashCode() {
            return this.setting.hashCode();
        }

        public void startService() {
            if (((ActivityManager) SettingsInjector.access$200(this.this$0).getSystemService("activity")).isUserRunning(this.setting.mUserHandle.getIdentifier()) == false) goto L5;
            Handler r0 = new AnonymousClass1(this);
            Messenger r2 = new Messenger(r0);
            Intent r3 = this.setting.getServiceIntent();
            r3.putExtra("messenger", r2);
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L11;
            OLog.d(SettingsInjector.TAG, this.setting + ": sending update intent: " + r3 + ", handler: " + r0);
            this.startMillis = SystemClock.elapsedRealtime();
        L12:
            SettingsInjector.access$200(this.this$0).startServiceAsUser(r3, this.setting.mUserHandle);
            return;
        L11:
            this.startMillis = 0;
            goto L12
        L5:
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L14;
            OLog.v(SettingsInjector.TAG, "Cannot start service as user " + this.setting.mUserHandle.getIdentifier() + " is not running");
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
            OLog.d(SettingsInjector.TAG, this + " update took " + getElapsedTime() + " millis");
            return;
        }
    }

    private final class StatusLoadingHandler extends Handler {
        private boolean mReloadRequested;
        private Set<Setting> mSettingsBeingLoaded;
        private Set<Setting> mSettingsToLoad;
        private Set<Setting> mTimedOutSettings;
        final /* synthetic */ SettingsInjector this$0;

        private StatusLoadingHandler(SettingsInjector r1) {
            this.this$0 = r1;
            this.mSettingsToLoad = new HashSet();
            this.mSettingsBeingLoaded = new HashSet();
            this.mTimedOutSettings = new HashSet();
        }

        /* synthetic */ StatusLoadingHandler(SettingsInjector r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L5;
            OLog.d(SettingsInjector.TAG, "handleMessage start: " + r10 + ", " + this);
        L5:
            int r2 = r10.what;
            if (r2 == 1) goto L14;
            if (r2 == 2) goto L13;
            if (r2 == 3) goto L10;
            OLog.e(SettingsInjector.TAG, "Unexpected what: " + r10);
            Log.wtf(SettingsInjector.TAG, "Unexpected what: " + r10);
        L16:
            if (this.mSettingsBeingLoaded.size() > 0) goto L43;
            if (this.mTimedOutSettings.size() > 1) goto L43;
            if (this.mReloadRequested == true) goto L23;
        L32:
            Iterator<Setting> r3 = this.mSettingsToLoad.iterator();
            if (r3.hasNext() == false) goto L35;
            Setting r4 = r3.next();
            r3.remove();
            r4.startService();
            this.mSettingsBeingLoaded.add(r4);
            sendMessageDelayed(obtainMessage(3, r4), 1000);
            if (Log.isLoggable(SettingsInjector.TAG, 3) == false) goto L47;
            OLog.d(SettingsInjector.TAG, "handleMessage end " + r10 + ", " + this + ", started loading " + r4);
            return;
        L47:
            return;
        L35:
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L46;
            OLog.v(SettingsInjector.TAG, "nothing left to do for " + r10 + ", " + this);
            return;
        L46:
            return;
        L23:
            if (this.mSettingsToLoad.isEmpty() == false) goto L32;
            if (this.mSettingsBeingLoaded.isEmpty() == false) goto L32;
            if (this.mTimedOutSettings.isEmpty() == false) goto L32;
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L31;
            OLog.v(SettingsInjector.TAG, "reloading because idle and reload requesteed " + r10 + ", " + this);
        L31:
            this.mSettingsToLoad.addAll(SettingsInjector.access$300(this.this$0));
            this.mReloadRequested = false;
        L43:
            if (Log.isLoggable(SettingsInjector.TAG, 2) == false) goto L48;
            OLog.v(SettingsInjector.TAG, "too many services already live for " + r10 + ", " + this);
            return;
        L48:
            return;
        L10:
            Setting r5 = (Setting) r10.obj;
            this.mSettingsBeingLoaded.remove(r5);
            this.mTimedOutSettings.add(r5);
            if (Log.isLoggable(SettingsInjector.TAG, 5) == false) goto L16;
            OLog.w(SettingsInjector.TAG, "Timed out after " + r5.getElapsedTime() + " millis trying to get status for: " + r5);
            goto L16
        L13:
            Setting r6 = (Setting) r10.obj;
            r6.maybeLogElapsedTime();
            this.mSettingsBeingLoaded.remove(r6);
            this.mTimedOutSettings.remove(r6);
            removeMessages(3, r6);
            goto L16
        L14:
            this.mReloadRequested = true;
            goto L16
        }

        @Override // android.os.Handler
        public String toString() {
            return "StatusLoadingHandler{mSettingsToLoad=" + this.mSettingsToLoad + ", mSettingsBeingLoaded=" + this.mSettingsBeingLoaded + ", mTimedOutSettings=" + this.mTimedOutSettings + ", mReloadRequested=" + this.mReloadRequested + '}';
        }
    }

    static /* synthetic */ Context access$200(SettingsInjector r0) {
        return r0.mContext;
    }

    static /* synthetic */ Set access$300(SettingsInjector r0) {
        return r0.mSettings;
    }

    static /* synthetic */ Handler access$400(SettingsInjector r0) {
        return r0.mHandler;
    }

    public SettingsInjector(Context r2) {
        this.mContext = r2;
        this.mSettings = new HashSet();
        this.mHandler = new StatusLoadingHandler(this, null);
    }

    private List<InjectedSetting> getSettings(UserHandle r12) {
        PackageManager r1 = this.mContext.getPackageManager();
        Intent r2 = new Intent("android.location.SettingInjectorService");
        int r3 = r12.getIdentifier();
        List r4 = ((PackageManager) NullSafe.nonNull(r1)).queryIntentServicesAsUser(r2, 128, r3);
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        OLog.d(TAG, "Found services for profile id " + r3 + ": " + r4);
    L5:
        ArrayList r6 = new ArrayList(r4.size());
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L19;
        ResolveInfo r8 = (ResolveInfo) r5.next();
        InjectedSetting r9 = parseServiceInfo(r8, r12, r1);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L10:
        if (r9 == null) goto L11;
        r6.add(r9);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L7
    L11:
        OLog.w(TAG, "Unable to load service info " + r8);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L14:
        e = move-exception;
        OLog.w(TAG, "Unable to load service info " + r8, e);
    L16:
        e = move-exception;
        OLog.w(TAG, "Unable to load service info " + r8, e);
        goto L7
    L19:
        if (Log.isLoggable(TAG, 3) == false) goto L21;
        OLog.d(TAG, "Loaded settings for profile id " + r3 + ": " + r6);
    L21:
        return r6;
    }

    private InjectedSetting parseServiceInfo(ResolveInfo r6, UserHandle r7, PackageManager r8) throws XmlPullParserException, IOException {
        ServiceInfo r1 = r6.serviceInfo;
        XmlResourceParser r4 = null;
        if ((r1.applicationInfo.flags & 1) != 0) goto L9;
        if (Log.isLoggable(TAG, 5) == false) goto L36;
        OLog.w(TAG, "Ignoring attempt to inject setting from app not in system image: " + r6);
        return null;
    L36:
        XmlResourceParser r5 = r1.loadXmlMetaData(r8, "android.location.SettingInjectorService");     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
        if (r5 == null) goto L28;
        AttributeSet r9 = Xml.asAttributeSet(r5);     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
    L14:
        int r10 = r5.next();     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L14;
    L20:
        if ("injected-location-setting".equals(r5.getName()) == false) goto L26;
        InjectedSetting r11 = parseAttributes(r1.packageName, r1.name, r7, r8.getResourcesForApplicationAsUser(r1.packageName, r7.getIdentifier()), r9);     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
        if (r5 == null) goto L24;
        r5.close();
    L24:
        return r11;
    L26:
        throw new XmlPullParserException("Meta-data does not start with injected-location-setting tag");     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
    L28:
        throw new XmlPullParserException("No android.location.SettingInjectorService meta-data for " + r6 + ": " + r1);     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
    L29:
        th = move-exception;
        if (0 == 0) goto L35;
        r4.close();
    L35:
        throw th;
    L32:
        throw new XmlPullParserException("Unable to load resources for package " + r1.packageName);     // Catch: Throwable -> L29
    L9:
        if (DimmableIZatIconPreference.showIzat(this.mContext, r1.packageName) == true) goto L36;
        return null;
    }

    private static InjectedSetting parseAttributes(String r8, String r9, UserHandle r10, Resources r11, AttributeSet r12) {
        TypedArray r13 = r11.obtainAttributes(r12, R.styleable.SettingInjectorService);
        String r4 = r13.getString(1);     // Catch: Throwable -> L9
        int r5 = r13.getResourceId(0, 0);     // Catch: Throwable -> L9
        String r7 = r13.getString(2);     // Catch: Throwable -> L9
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        OLog.d(TAG, "parsed title: " + r4 + ", iconId: " + r5 + ", settingsActivity: " + r7);     // Catch: Throwable -> L9
    L6:
        InjectedSetting r14 = InjectedSetting.newInstance(r8, r9, r4, r5, r10, r7);     // Catch: Throwable -> L9
        r13.recycle();
        return r14;
    L9:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public List<Preference> getInjectedSettings(int r11) {
        List<UserHandle> r0 = ((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserProfiles();
        ArrayList r1 = new ArrayList();
        int r2 = r0.size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        UserHandle r4 = r0.get(r3);
        if (r11 != (-2)) goto L7;
    L8:
        Iterator<T> r5 = getSettings(r4).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        InjectedSetting r6 = (InjectedSetting) r5.next();
        Preference r7 = addServiceSetting(r1, r6);
        this.mSettings.add(new Setting(this, r6, r7, null));
    L12:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r11 != r4.getIdentifier()) goto L12;
    L13:
        reloadStatusMessages();
        return r1;
    }

    public void reloadStatusMessages() {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        OLog.d(TAG, "reloadingStatusMessages: " + this.mSettings);
    L5:
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(1));
    }

    private Preference addServiceSetting(List<Preference> r6, InjectedSetting r7) {
        PackageManager r0 = this.mContext.getPackageManager();
        Drawable r1 = r0.getUserBadgedIcon(r0.getDrawable(r7.packageName, r7.iconId, null), r7.mUserHandle);
        CharSequence r2 = r0.getUserBadgedLabel(r7.title, r7.mUserHandle);
        if (r7.title.contentEquals(r2) == false) goto L5;
        r2 = null;
    L5:
        DimmableIconPreference r3 = DimmableIZatIconPreference.newInstance(this.mContext, r2, r7);
        r3.setTitle(r7.title);
        r3.setSummary(null);
        r3.setIcon(r1);
        r3.setOnPreferenceClickListener(new ServiceSettingClickedListener(this, r7));
        r6.add(r3);
        return r3;
    }
}
