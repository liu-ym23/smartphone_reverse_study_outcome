package com.android.settings.core;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.Utils;
import com.android.settingslib.core.AbstractPreferenceController;
import com.obric.olog.OLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePreferenceController extends AbstractPreferenceController {
    public static final int AVAILABLE = 0;
    public static final int AVAILABLE_UNSEARCHABLE = 1;
    public static final int CONDITIONALLY_UNAVAILABLE = 2;
    public static final int DISABLED_DEPENDENT_SETTING = 5;
    public static final int DISABLED_FOR_USER = 4;
    private static final String TAG = "SettingsPrefController";
    public static final int UNSUPPORTED_ON_DEVICE = 3;
    private boolean mIsForWork;
    private int mMetricsCategory;
    private boolean mPrefVisibility;
    protected final String mPreferenceKey;
    protected UiBlockListener mUiBlockListener;
    protected boolean mUiBlockerFinished;
    private UserHandle mWorkProfileUser;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AvailabilityStatus {
    }

    public interface UiBlockListener {
        void onBlockerWorkFinished(BasePreferenceController r1);
    }

    public interface UiBlocker {
    }

    public abstract int getAvailabilityStatus();

    public static BasePreferenceController createInstance(Context r6, String r7, String r8) {
        return (BasePreferenceController) Class.forName(r7).getConstructor(new Class[]{Context.class, String.class}).newInstance(new Object[]{r6, r8});
    L4:
        e = move-exception;
        throw new IllegalStateException("Invalid preference controller: " + r7, e);
    }

    public static BasePreferenceController createInstance(Context r5, String r6) {
        return (BasePreferenceController) Class.forName(r6).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5});
    L4:
        e = move-exception;
        throw new IllegalStateException("Invalid preference controller: " + r6, e);
    }

    public static BasePreferenceController createInstance(Context r6, String r7, String r8, boolean r9) {
        BasePreferenceController r10 = (BasePreferenceController) Class.forName(r7).getConstructor(new Class[]{Context.class, String.class}).newInstance(new Object[]{r6, r8});     // Catch: Throwable -> L4
        r10.setForWork(r9);     // Catch: Throwable -> L4
        return r10;
    L4:
        e = move-exception;
        throw new IllegalStateException("Invalid preference controller: " + r7, e);
    }

    public BasePreferenceController(Context r1, String r2) {
        super(r1);
        this.mPreferenceKey = r2;
        this.mPrefVisibility = true;
        if (TextUtils.isEmpty(r2) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Preference key must be set");
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return this.mPreferenceKey;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public final boolean isAvailable() {
        if (this.mIsForWork == true) goto L5;
    L7:
        int r3 = getAvailabilityStatus();
        if (r3 == 0) goto L13;
        if (r3 == 1) goto L13;
        if (r3 == 5) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (this.mWorkProfileUser != null) goto L7;
        return false;
    }

    private boolean isAvailableForSearch() {
        if (this.mIsForWork == true) goto L5;
    L7:
        int r2 = getAvailabilityStatus();
        if (r2 != 0) goto L10;
    L11:
        return true;
    L10:
        if (r2 == 5) goto L11;
        return false;
    L5:
        if (this.mWorkProfileUser != null) goto L7;
        return false;
    }

    public final boolean isSupported() {
        if (getAvailabilityStatus() == 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r3) {
        super.displayPreference(r3);
        if (getAvailabilityStatus() != 5) goto L8;
        Preference r2 = r3.findPreference(getPreferenceKey());
        if (r2 == null) goto L9;
        r2.setEnabled(false);
        return;
    L9:
        return;
    }

    public void updateNonIndexableKeys(List<String> r3) {
        String r0 = getPreferenceKey();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        OLog.w(TAG, "Skipping updateNonIndexableKeys due to empty key " + this);
        return;
    L7:
        if (r3.contains(r0) == false) goto L9;
        return;
    L9:
        if (isAvailableForSearch() == true) goto L13;
        r3.add(r0);
        return;
    }

    void setForWork(boolean r1) {
        this.mIsForWork = r1;
        if (r1 == false) goto L6;
        this.mWorkProfileUser = Utils.getManagedProfile(UserManager.get(this.mContext));
        return;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean handlePreferenceTreeClick(Preference r5) {
        if (TextUtils.equals(r5.getKey(), getPreferenceKey()) == true) goto L7;
        return super.handlePreferenceTreeClick(r5);
    L7:
        if (this.mIsForWork == false) goto L14;
        if (this.mWorkProfileUser == null) goto L14;
        r5.getExtras().putInt("android.intent.extra.USER_ID", this.mWorkProfileUser.getIdentifier());
        new SubSettingLauncher(r5.getContext()).setDestination(r5.getFragment()).setSourceMetricsCategory(r5.getExtras().getInt("category", 0)).setArguments(r5.getExtras()).setUserHandle(this.mWorkProfileUser).launch();
        return true;
    L14:
        return super.handlePreferenceTreeClick(r5);
    }

    public void setUiBlockListener(UiBlockListener r1) {
        this.mUiBlockListener = r1;
    }

    public void setUiBlockerFinished(boolean r1) {
        this.mUiBlockerFinished = r1;
    }

    public boolean getSavedPrefVisibility() {
        return this.mPrefVisibility;
    }

    public void setMetricsCategory(int r1) {
        this.mMetricsCategory = r1;
    }

    protected int getMetricsCategory() {
        return this.mMetricsCategory;
    }

    protected UserHandle getWorkProfileUser() {
        return this.mWorkProfileUser;
    }

    protected void updatePreferenceVisibilityDelegate(Preference r2, boolean r3) {
        if (this.mUiBlockerFinished == false) goto L6;
        r2.setVisible(r3);
        return;
    L6:
        savePrefVisibility(r3);
        if (r3 == true) goto L10;
        r2.setVisible(false);
        return;
    }

    private void savePrefVisibility(boolean r1) {
        this.mPrefVisibility = r1;
    }
}
