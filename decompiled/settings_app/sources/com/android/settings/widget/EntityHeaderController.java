package com.android.settings.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.Fragment;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.spa.app.appinfo.AppInfoSettingsProvider;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.android.settingslib.widget.LayoutPreference;
import com.obric.olog.OLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class EntityHeaderController {
    public static final String PREF_KEY_APP_HEADER = "pref_app_header";
    private static final String TAG = "AppDetailFeature";
    private int mAction1;
    private int mAction2;
    private final Context mAppContext;
    private Intent mAppNotifPrefIntent;
    private View.OnClickListener mEditOnClickListener;
    private final Fragment mFragment;
    private boolean mHasAppInfoLink;
    private final View mHeader;
    private Drawable mIcon;
    private String mIconContentDescription;
    private boolean mIsInstantApp;
    private CharSequence mLabel;
    private final int mMetricsCategory;
    private String mPackageName;
    private int mPrefOrder;
    private CharSequence mSecondSummary;
    private CharSequence mSummary;
    private int mUid;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionType {
        public static final int ACTION_EDIT_PREFERENCE = 2;
        public static final int ACTION_NONE = 0;
        public static final int ACTION_NOTIF_PREFERENCE = 1;
    }

    public static EntityHeaderController newInstance(Activity r1, Fragment r2, View r3) {
        return new EntityHeaderController(r1, r2, r3);
    }

    private EntityHeaderController(Activity r2, Fragment r3, View r4) {
        this.mPrefOrder = -1000;
        this.mUid = -10000;
        this.mAppContext = r2.getApplicationContext();
        this.mFragment = r3;
        this.mMetricsCategory = new MetricsFeatureProvider().getMetricsCategory(r3);
        if (r4 == null) goto L5;
        this.mHeader = r4;
        return;
    L5:
        this.mHeader = LayoutInflater.from(r3.getContext()).inflate(R.layout.settings_entity_header, null);
    }

    public EntityHeaderController setIcon(Drawable r2) {
        if (r2 == null) goto L7;
        Drawable.ConstantState r0 = r2.getConstantState();
        if (r0 == null) goto L6;
        r2 = r0.newDrawable(this.mAppContext.getResources());
    L6:
        this.mIcon = r2;
    L7:
        return this;
    }

    public EntityHeaderController setIcon(ApplicationsState.AppEntry r2) {
        this.mIcon = Utils.getBadgedIcon(this.mAppContext, r2.info);
        return this;
    }

    public EntityHeaderController setIconContentDescription(String r1) {
        this.mIconContentDescription = r1;
        return this;
    }

    public EntityHeaderController setLabel(CharSequence r1) {
        this.mLabel = r1;
        return this;
    }

    public EntityHeaderController setLabel(ApplicationsState.AppEntry r1) {
        this.mLabel = r1.label;
        return this;
    }

    public EntityHeaderController setSummary(CharSequence r1) {
        this.mSummary = r1;
        return this;
    }

    public EntityHeaderController setSummary(PackageInfo r1) {
        if (r1 == null) goto L4;
        this.mSummary = r1.versionName;
    L4:
        return this;
    }

    public EntityHeaderController setSecondSummary(CharSequence r1) {
        this.mSecondSummary = r1;
        return this;
    }

    public EntityHeaderController setHasAppInfoLink(boolean r1) {
        this.mHasAppInfoLink = r1;
        return this;
    }

    public EntityHeaderController setButtonActions(int r1, int r2) {
        this.mAction1 = r1;
        this.mAction2 = r2;
        return this;
    }

    public EntityHeaderController setPackageName(String r1) {
        this.mPackageName = r1;
        return this;
    }

    public EntityHeaderController setUid(int r1) {
        this.mUid = r1;
        return this;
    }

    public EntityHeaderController setAppNotifPrefIntent(Intent r1) {
        this.mAppNotifPrefIntent = r1;
        return this;
    }

    public EntityHeaderController setIsInstantApp(boolean r1) {
        this.mIsInstantApp = r1;
        return this;
    }

    public EntityHeaderController setEditListener(View.OnClickListener r1) {
        this.mEditOnClickListener = r1;
        return this;
    }

    public EntityHeaderController setOrder(int r1) {
        this.mPrefOrder = r1;
        return this;
    }

    public LayoutPreference done(Context r3) {
        LayoutPreference r0 = new LayoutPreference(r3, done());
        r0.setOrder(this.mPrefOrder);
        r0.setSelectable(false);
        r0.setKey(PREF_KEY_APP_HEADER);
        r0.setAllowDividerBelow(true);
        return r0;
    }

    public View done(boolean r3) {
        ImageView r0 = (ImageView) this.mHeader.findViewById(R.id.entity_header_icon);
        if (r0 == null) goto L5;
        r0.setImageDrawable(this.mIcon);
        r0.setContentDescription(this.mIconContentDescription);
    L5:
        setText(R.id.entity_header_title, this.mLabel);
        setText(R.id.entity_header_summary, this.mSummary);
        setText(R.id.entity_header_second_summary, this.mSecondSummary);
        if (this.mIsInstantApp == false) goto L8;
        setText(R.id.install_type, this.mHeader.getResources().getString(R.string.install_type_instant));
    L8:
        if (r3 == false) goto L11;
        bindHeaderButtons();
    L11:
        return this.mHeader;
    }

    public EntityHeaderController bindHeaderButtons() {
        View r0 = this.mHeader.findViewById(R.id.entity_header_content);
        ImageButton r1 = (ImageButton) this.mHeader.findViewById(android.R.id.button1);
        ImageButton r2 = (ImageButton) this.mHeader.findViewById(android.R.id.button2);
        bindAppInfoLink(r0);
        bindButton(r1, this.mAction1);
        bindButton(r2, this.mAction2);
        return this;
    }

    private void bindAppInfoLink(View r3) {
        if (this.mHasAppInfoLink == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L15;
        String r0 = this.mPackageName;
        if (r0 == null) goto L15;
        if (r0.equals("os") == true) goto L15;
        if (this.mUid == (-10000)) goto L15;
        r3.setOnClickListener(new EntityHeaderController$$ExternalSyntheticLambda0(this));
        return;
    L15:
        OLog.w(TAG, "Missing ingredients to build app info link, skip");
    }

    /* JADX INFO: renamed from: lambda$bindAppInfoLink$0$com-android-settings-widget-EntityHeaderController, reason: not valid java name */
    /* synthetic */ void m653x2aad435e(View r4) {
        AppInfoSettingsProvider.startAppInfoSettings(this.mPackageName, this.mUid, this.mFragment, 0, this.mMetricsCategory);
    }

    View done() {
        return done(true);
    }

    private void bindButton(ImageButton r4, int r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r5 != 0) goto L7;
        r4.setVisibility(8);
        return;
    L7:
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L12;
        return;
    L12:
        if (this.mEditOnClickListener != null) goto L14;
        r4.setVisibility(8);
        return;
    L14:
        r4.setImageResource(android.R.drawable.pointer_top_left_diagonal_double_arrow_vector);
        r4.setVisibility(0);
        r4.setOnClickListener(this.mEditOnClickListener);
        return;
    L17:
        if (this.mAppNotifPrefIntent != null) goto L19;
        r4.setVisibility(8);
        return;
    L19:
        r4.setOnClickListener(new EntityHeaderController$$ExternalSyntheticLambda1(this));
        r4.setVisibility(0);
    }

    /* JADX INFO: renamed from: lambda$bindButton$1$com-android-settings-widget-EntityHeaderController, reason: not valid java name */
    /* synthetic */ void m654x2053f6c0(View r7) {
        new MetricsFeatureProvider().action(0, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, this.mMetricsCategory, null, 0);
        this.mFragment.startActivity(this.mAppNotifPrefIntent);
    }

    private void setText(int r1, CharSequence r2) {
        TextView r0 = (TextView) this.mHeader.findViewById(r1);
        if (r0 == null) goto L10;
        r0.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L7;
        int r3 = 8;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 0;
        goto L8
    }
}
