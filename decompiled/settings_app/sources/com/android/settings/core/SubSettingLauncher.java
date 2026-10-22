package com.android.settings.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.android.settings.SettingsActivity;
import com.android.settings.SubSettings;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;

/* JADX INFO: loaded from: classes2.dex */
public class SubSettingLauncher {
    public static final String EXTRA_IS_SECOND_LAYER_PAGE = ":settings:is_second_layer_page";
    public static final String EXTRA_PAGE_TRANSITION_TYPE = "page_transition_type";
    private final Context mContext;
    private final LaunchRequest mLaunchRequest;
    private boolean mLaunched;

    static class LaunchRequest {
        Bundle mArguments;
        String mDestinationName;
        Bundle mExtras;
        int mFlags;
        boolean mIsSecondLayerPage;
        int mRequestCode;
        Fragment mResultListener;
        int mSourceMetricsCategory;
        CharSequence mTitle;
        int mTitleResId;
        String mTitleResPackageName;
        int mTransitionType;
        UserHandle mUserHandle;

        LaunchRequest() {
            this.mSourceMetricsCategory = -100;
        }
    }

    public SubSettingLauncher(Context r1) {
        if (r1 == null) goto L7;
        this.mContext = r1;
        LaunchRequest r2 = new LaunchRequest();
        this.mLaunchRequest = r2;
        r2.mTransitionType = 0;
        return;
    L7:
        throw new IllegalArgumentException("Context must be non-null.");
    }

    public SubSettingLauncher setDestination(String r2) {
        this.mLaunchRequest.mDestinationName = r2;
        return this;
    }

    public SubSettingLauncher setTitleRes(int r2) {
        return setTitleRes(null, r2);
    }

    public SubSettingLauncher setTitleRes(String r2, int r3) {
        this.mLaunchRequest.mTitleResPackageName = r2;
        this.mLaunchRequest.mTitleResId = r3;
        this.mLaunchRequest.mTitle = null;
        return this;
    }

    public SubSettingLauncher setTitleText(CharSequence r2) {
        this.mLaunchRequest.mTitle = r2;
        return this;
    }

    public SubSettingLauncher setArguments(Bundle r2) {
        this.mLaunchRequest.mArguments = r2;
        return this;
    }

    public SubSettingLauncher setExtras(Bundle r2) {
        this.mLaunchRequest.mExtras = r2;
        return this;
    }

    public SubSettingLauncher setSourceMetricsCategory(int r2) {
        this.mLaunchRequest.mSourceMetricsCategory = r2;
        return this;
    }

    public SubSettingLauncher setResultListener(Fragment r2, int r3) {
        this.mLaunchRequest.mRequestCode = r3;
        this.mLaunchRequest.mResultListener = r2;
        return this;
    }

    public SubSettingLauncher addFlags(int r3) {
        LaunchRequest r0 = this.mLaunchRequest;
        r0.mFlags = r3 | r0.mFlags;
        return this;
    }

    public SubSettingLauncher setUserHandle(UserHandle r2) {
        this.mLaunchRequest.mUserHandle = r2;
        return this;
    }

    public SubSettingLauncher setTransitionType(int r2) {
        this.mLaunchRequest.mTransitionType = r2;
        return this;
    }

    public SubSettingLauncher setIsSecondLayerPage(boolean r2) {
        this.mLaunchRequest.mIsSecondLayerPage = r2;
        return this;
    }

    public void launch() {
        launchWithIntent(toIntent());
    }

    public void launchWithIntent(Intent r5) {
        verifyIntent(r5);
        if (this.mLaunched == true) goto L26;
        boolean r0 = true;
        this.mLaunched = true;
        if (this.mLaunchRequest.mUserHandle != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (this.mLaunchRequest.mResultListener != null) goto L14;
        r0 = false;
    L14:
        if (r1 == false) goto L17;
        if (r0 == false) goto L17;
        launchForResultAsUser(r5, this.mLaunchRequest.mUserHandle, this.mLaunchRequest.mResultListener, this.mLaunchRequest.mRequestCode);
        return;
    L17:
        if (r1 == false) goto L20;
        if (r0 == true) goto L20;
        launchAsUser(r5, this.mLaunchRequest.mUserHandle);
        return;
    L20:
        if (r1 == true) goto L23;
        if (r0 == false) goto L23;
        launchForResult(this.mLaunchRequest.mResultListener, r5, this.mLaunchRequest.mRequestCode);
        return;
    L23:
        launch(r5);
        return;
    L7:
        if (this.mLaunchRequest.mUserHandle.getIdentifier() == UserHandle.myUserId()) goto L9;
        r1 = true;
        goto L11
    L26:
        throw new IllegalStateException("This launcher has already been executed. Do not reuse");
    }

    public void verifyIntent(Intent r5) {
        String r4 = SubSettings.class.getName();
        ComponentName r0 = r5.getComponent();
        String r1 = r5.getStringExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT);
        int r6 = r5.getIntExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, -1);
        if (r0 == null) goto L10;
        if (TextUtils.equals(r4, r0.getClassName()) == true) goto L10;
        throw new IllegalArgumentException(String.format("Class must be: %s", new Object[]{r4}));
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        if (r6 < 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("Source metrics category must be set");
    L16:
        throw new IllegalArgumentException("Destination fragment must be set");
    }

    public Intent toIntent() {
        Intent r0 = new Intent("android.intent.action.MAIN");
        copyExtras(r0);
        r0.setClass(this.mContext, SubSettings.class);
        if (TextUtils.isEmpty(this.mLaunchRequest.mDestinationName) == true) goto L11;
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT, this.mLaunchRequest.mDestinationName);
        if (this.mLaunchRequest.mSourceMetricsCategory < 0) goto L9;
        r0.putExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, this.mLaunchRequest.mSourceMetricsCategory);
        r0.putExtra(":settings:show_fragment_args", this.mLaunchRequest.mArguments);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RES_PACKAGE_NAME, this.mLaunchRequest.mTitleResPackageName);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID, this.mLaunchRequest.mTitleResId);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE, this.mLaunchRequest.mTitle);
        r0.addFlags(this.mLaunchRequest.mFlags);
        r0.putExtra("page_transition_type", this.mLaunchRequest.mTransitionType);
        r0.putExtra(EXTRA_IS_SECOND_LAYER_PAGE, this.mLaunchRequest.mIsSecondLayerPage);
        return r0;
    L9:
        throw new IllegalArgumentException("Source metrics category must be set");
    L11:
        throw new IllegalArgumentException("Destination fragment must be set");
    }

    void launch(Intent r1) {
        this.mContext.startActivity(r1);
    }

    void launchAsUser(Intent r1, UserHandle r2) {
        this.mContext.startActivityAsUser(r1, r2);
    }

    void launchForResultAsUser(Intent r1, UserHandle r2, Fragment r3, int r4) {
        r3.getActivity().startActivityForResultAsUser(r1, r4, r2);
    }

    void launchForResult(Fragment r1, Intent r2, int r3) {
        r1.startActivityForResult(r2, r3);
    }

    private void copyExtras(Intent r2) {
        if (this.mLaunchRequest.mExtras == null) goto L6;
        r2.replaceExtras(this.mLaunchRequest.mExtras);
        return;
    }
}
