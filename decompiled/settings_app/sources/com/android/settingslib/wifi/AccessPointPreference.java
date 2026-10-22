package com.android.settingslib.wifi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.wifi.WifiConfiguration;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.R;
import com.android.settingslib.TronUtils;
import com.android.settingslib.Utils;

/* JADX INFO: loaded from: classes.dex */
public class AccessPointPreference extends Preference {
    private static final int[] FRICTION_ATTRS = null;
    private static final int[] STATE_METERED = null;
    private static final int[] STATE_SECURED = null;
    private static final int[] WIFI_CONNECTION_STRENGTH = null;
    private AccessPoint mAccessPoint;
    private Drawable mBadge;
    private final UserBadgeCache mBadgeCache;
    private final int mBadgePadding;
    private CharSequence mContentDescription;
    private int mDefaultIconResId;
    private boolean mForSavedNetworks;
    private final StateListDrawable mFrictionSld;
    private final IconInjector mIconInjector;
    private int mLevel;
    private final Runnable mNotifyChanged;
    private boolean mShowDivider;
    private TextView mTitleView;
    private int mWifiSpeed;
    private int mWifiStandard;

    static class IconInjector {
        private final Context mContext;

        public IconInjector(Context r1) {
            this.mContext = r1;
        }

        public Drawable getIcon(int r1) {
            return this.mContext.getDrawable(Utils.getWifiIconResource(r1));
        }

        public Drawable getIcon(int r1, int r2) {
            return this.mContext.getDrawable(Utils.getWifiIconResource(r1, r2));
        }
    }

    public static class UserBadgeCache {
        private final SparseArray<Drawable> mBadges;
        private final PackageManager mPm;

        static /* synthetic */ Drawable access$000(UserBadgeCache r0, int r1) {
            return r0.getUserBadge(r1);
        }

        public UserBadgeCache(PackageManager r2) {
            this.mBadges = new SparseArray();
            this.mPm = r2;
        }

        private Drawable getUserBadge(int r4) {
            int r0 = this.mBadges.indexOfKey(r4);
            if (r0 >= 0) goto L7;
            Drawable r1 = this.mPm.getUserBadgeForDensity(new UserHandle(r4), 0);
            this.mBadges.put(r4, r1);
            return r1;
        L7:
            return this.mBadges.valueAt(r0);
        }
    }

    static {
        STATE_SECURED = new int[]{R.attr.state_encrypted};
        STATE_METERED = new int[]{R.attr.state_metered};
        FRICTION_ATTRS = new int[]{R.attr.wifi_friction};
        WIFI_CONNECTION_STRENGTH = new int[]{R.string.accessibility_no_wifi, R.string.accessibility_wifi_one_bar, R.string.accessibility_wifi_two_bars, R.string.accessibility_wifi_three_bars, R.string.accessibility_wifi_signal_full};
    }

    private static StateListDrawable getFrictionStateListDrawable(Context r2) {
        TypedArray r3 = r2.getTheme().obtainStyledAttributes(FRICTION_ATTRS);     // Catch: Resources.NotFoundException -> L5
    L6:
        if (r3 == null) goto L11;
        StateListDrawable r0 = (StateListDrawable) r3.getDrawable(0);
        r3.recycle();
        return r0;
    L11:
        return null;
    L5:
        r3 = null;
        goto L6
    }

    public AccessPointPreference(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mForSavedNetworks = false;
        this.mWifiSpeed = 0;
        this.mNotifyChanged = new AnonymousClass1(this);
        this.mFrictionSld = null;
        this.mBadgePadding = 0;
        this.mBadgeCache = null;
        this.mIconInjector = new IconInjector(r2);
    }

    public AccessPointPreference(AccessPoint r7, Context r8, UserBadgeCache r9, boolean r10) {
        this(r7, r8, r9, 0, r10);
        refresh();
    }

    public AccessPointPreference(AccessPoint r10, Context r11, UserBadgeCache r12, int r13, boolean r14) {
        this(r10, r11, r12, r13, r14, getFrictionStateListDrawable(r11), -1, new IconInjector(r11));
    }

    AccessPointPreference(AccessPoint r2, Context r3, UserBadgeCache r4, int r5, boolean r6, StateListDrawable r7, int r8, IconInjector r9) {
        super(r3);
        this.mForSavedNetworks = false;
        this.mWifiSpeed = 0;
        this.mNotifyChanged = new AnonymousClass1(this);
        setLayoutResource(R.layout.preference_access_point);
        setWidgetLayoutResource(getWidgetLayoutResourceId());
        this.mBadgeCache = r4;
        this.mAccessPoint = r2;
        this.mForSavedNetworks = r6;
        r2.setTag(this);
        this.mLevel = r8;
        this.mDefaultIconResId = r5;
        this.mFrictionSld = r7;
        this.mIconInjector = r9;
        this.mBadgePadding = r3.getResources().getDimensionPixelSize(R.dimen.wifi_preference_badge_padding);
    }

    protected int getWidgetLayoutResourceId() {
        return R.layout.access_point_friction_widget;
    }

    public AccessPoint getAccessPoint() {
        return this.mAccessPoint;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        super.onBindViewHolder(r4);
        if (this.mAccessPoint != null) goto L5;
        return;
    L5:
        Drawable r0 = getIcon();
        if (r0 == null) goto L8;
        r0.setLevel(this.mLevel);
    L8:
        TextView r1 = (TextView) r4.findViewById(android.R.id.title);
        this.mTitleView = r1;
        if (r1 == null) goto L11;
        r1.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, this.mBadge, null);
        this.mTitleView.setCompoundDrawablePadding(this.mBadgePadding);
    L11:
        r4.itemView.setContentDescription(this.mContentDescription);
        bindFrictionImage((ImageView) r4.findViewById(R.id.friction_icon));
        View r5 = r4.findViewById(R.id.two_target_divider);
        if (shouldShowDivider() == false) goto L14;
        int r3 = 0;
    L15:
        r5.setVisibility(r3);
        return;
    L14:
        r3 = 4;
        goto L15
    }

    public boolean shouldShowDivider() {
        return this.mShowDivider;
    }

    public void setShowDivider(boolean r1) {
        this.mShowDivider = r1;
        notifyChanged();
    }

    protected void updateIcon(int r2, int r3, Context r4) {
        if (r2 != (-1)) goto L6;
        safeSetDefaultIcon();
        return;
    L6:
        TronUtils.logWifiSettingsSpeed(r4, this.mWifiSpeed);
        Drawable r5 = this.mIconInjector.getIcon(r2, r3);
        if (this.mForSavedNetworks == true) goto L10;
        if (r5 == null) goto L10;
        r5.setTintList(Utils.getColorAttr(r4, android.R.attr.colorControlNormal));
        setIcon(r5);
        return;
    L10:
        safeSetDefaultIcon();
    }

    private void bindFrictionImage(ImageView r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mFrictionSld != null) goto L7;
        return;
    L7:
        if (this.mAccessPoint.getSecurity() == 0) goto L12;
        if (this.mAccessPoint.getSecurity() == 4) goto L12;
        this.mFrictionSld.setState(STATE_SECURED);
    L14:
        r3.setImageDrawable(this.mFrictionSld.getCurrent());
        return;
    L12:
        if (this.mAccessPoint.isMetered() == false) goto L14;
        this.mFrictionSld.setState(STATE_METERED);
        goto L14
    }

    private void safeSetDefaultIcon() {
        int r0 = this.mDefaultIconResId;
        if (r0 == 0) goto L5;
        setIcon(r0);
        return;
    L5:
        setIcon(null);
    }

    protected void updateBadge(Context r2) {
        WifiConfiguration r3 = this.mAccessPoint.getConfig();
        if (r3 == null) goto L6;
        this.mBadge = UserBadgeCache.access$000(this.mBadgeCache, r3.creatorUid);
        return;
    }

    public void refresh() {
        setTitle(this, this.mAccessPoint);
        Context r0 = getContext();
        int r1 = this.mAccessPoint.getLevel();
        int r2 = this.mAccessPoint.getSpeed();
        int r3 = this.mAccessPoint.getWifiStandard();
        if (r1 == this.mLevel) goto L5;
    L8:
        this.mLevel = r1;
        this.mWifiSpeed = r2;
        this.mWifiStandard = r3;
        updateIcon(r1, r3, r0);
        notifyChanged();
    L9:
        updateBadge(r0);
        if (this.mForSavedNetworks == false) goto L12;
        String r4 = this.mAccessPoint.getSavedNetworkSummary();
    L14:
        if (this.mAccessPoint.isPskSaeTransitionMode() == false) goto L17;
        r4 = "WPA3(SAE Transition Mode) " + r4;
    L25:
        setSummary(r4);
        this.mContentDescription = buildContentDescription(getContext(), this, this.mAccessPoint);
        return;
    L17:
        if (this.mAccessPoint.isOweTransitionMode() == false) goto L20;
        r4 = "WPA3(OWE Transition Mode) " + r4;
        goto L25
    L20:
        if (this.mAccessPoint.getSecurity() != 5) goto L23;
        r4 = "WPA3(SAE) " + r4;
        goto L25
    L23:
        if (this.mAccessPoint.getSecurity() != 4) goto L25;
        r4 = "WPA3(OWE) " + r4;
        goto L25
    L12:
        r4 = this.mAccessPoint.getSettingsSummary();
        goto L14
    L5:
        if (r2 != this.mWifiSpeed) goto L8;
        if (r3 == this.mWifiStandard) goto L9;
        goto L8
    }

    @Override // androidx.preference.Preference
    protected void notifyChanged() {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
        postNotifyChanged();
        return;
    L5:
        super.notifyChanged();
    }

    static void setTitle(AccessPointPreference r0, AccessPoint r1) {
        r0.setTitle(r1.getTitle());
    }

    static CharSequence buildContentDescription(Context r8, Preference r9, AccessPoint r10) {
        CharSequence r0 = r9.getTitle();
        CharSequence r11 = r9.getSummary();
        if (TextUtils.isEmpty(r11) == true) goto L5;
        r0 = TextUtils.concat(new CharSequence[]{r0, ",", r11});
    L5:
        int r12 = r10.getLevel();
        if (r12 < 0) goto L10;
        int[] r1 = WIFI_CONNECTION_STRENGTH;
        if (r12 >= r1.length) goto L10;
        r0 = TextUtils.concat(new CharSequence[]{r0, ",", r8.getString(r1[r12])});
    L10:
        CharSequence[] r13 = new CharSequence[3];
        r13[0] = r0;
        r13[1] = ",";
        if (r10.getSecurity() != 0) goto L13;
        String r14 = r8.getString(R.string.accessibility_wifi_security_type_none);
    L14:
        r13[2] = r14;
        return TextUtils.concat(r13);
    L13:
        r14 = r8.getString(R.string.accessibility_wifi_security_type_secured);
        goto L14
    }

    public void onLevelChanged() {
        postNotifyChanged();
    }

    private void postNotifyChanged() {
        TextView r0 = this.mTitleView;
        if (r0 == null) goto L6;
        r0.post(this.mNotifyChanged);
        return;
    }
}
