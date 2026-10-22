package com.android.settings.users;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.RestrictedPreference;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class UserPreference extends RestrictedPreference {
    private static final int ALPHA_DISABLED = 102;
    private static final int ALPHA_ENABLED = 255;
    static final int DELETE_ID = 2131431450;
    public static final Comparator<UserPreference> SERIAL_NUMBER_COMPARATOR = null;
    static final int SETTINGS_ID = 2131429848;
    public static final int USERID_GUEST_DEFAULTS = -11;
    public static final int USERID_UNKNOWN = -10;
    private View.OnClickListener mDeleteClickListener;
    private int mSerialNumber;
    private View.OnClickListener mSettingsClickListener;
    private int mUserId;

    static /* synthetic */ int access$000(UserPreference r0) {
        return r0.getSerialNumber();
    }

    static {
        SERIAL_NUMBER_COMPARATOR = new AnonymousClass1();
    }

    public UserPreference(Context r7, AttributeSet r8) {
        this(r7, r8, -10, null, null);
    }

    UserPreference(Context r1, AttributeSet r2, int r3, View.OnClickListener r4, View.OnClickListener r5) {
        super(r1, r2);
        this.mSerialNumber = -1;
        this.mUserId = -10;
        if (r5 != null) goto L5;
        if (r4 != null) goto L5;
    L6:
        this.mDeleteClickListener = r5;
        this.mSettingsClickListener = r4;
        this.mUserId = r3;
        useAdminDisabledSummary(true);
        return;
    L5:
        setWidgetLayoutResource(R.layout.restricted_preference_user_delete_widget);
        goto L6
    }

    private void dimIcon(boolean r3) {
        Drawable r0 = getIcon();
        if (r0 == null) goto L10;
        Drawable r1 = r0.mutate();
        if (r3 == false) goto L7;
        int r4 = 102;
    L8:
        r1.setAlpha(r4);
        setIcon(r0);
        return;
    L7:
        r4 = 255;
        goto L8
    }

    @Override // com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r9) {
        super.onBindViewHolder(r9);
        boolean r0 = isDisabledByAdmin();
        dimIcon(r0);
        View r1 = r9.findViewById(R.id.user_delete_widget);
        int r2 = 0;
        if (r1 == null) goto L8;
        if (r0 == false) goto L6;
        int r4 = 8;
    L7:
        r1.setVisibility(r4);
        goto L8
    L6:
        r4 = 0;
    L8:
        if (r0 == true) goto L28;
        UserManager r3 = (UserManager) getContext().getSystemService(PickApplicationActivity.EXTRA_USER);
        View r5 = r9.findViewById(R.id.divider_delete);
        View r6 = r9.findViewById(R.id.divider_manage);
        View r7 = r9.findViewById(R.id.trash_user);
        if (r7 != null) goto L12;
    L17:
        ImageView r10 = (ImageView) r9.findViewById(R.id.manage_user);
        if (r10 != null) goto L20;
        return;
    L20:
        if (this.mSettingsClickListener == null) goto L26;
        r10.setVisibility(0);
        if (this.mDeleteClickListener == null) goto L25;
        r2 = 8;
    L25:
        r6.setVisibility(r2);
        r10.setOnClickListener(this.mSettingsClickListener);
        r10.setTag(this);
        return;
    L26:
        r10.setVisibility(8);
        r6.setVisibility(8);
        return;
    L12:
        if (this.mDeleteClickListener != null) goto L14;
    L16:
        r7.setVisibility(8);
        r5.setVisibility(8);
        goto L17
    L14:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(getContext(), "no_remove_user", UserHandle.myUserId()) == true) goto L16;
        r7.setVisibility(0);
        r5.setVisibility(0);
        r7.setOnClickListener(this.mDeleteClickListener);
        r7.setTag(this);
        goto L17
    }

    @Override // com.android.settingslib.widget.TwoTargetPreference
    protected boolean shouldHideSecondTarget() {
        if (this.mSettingsClickListener != null) goto L7;
        if (this.mDeleteClickListener != null) goto L7;
    L8:
        return true;
    L7:
        if (isDisabledByAdmin() == true) goto L8;
        return false;
    }

    private int getSerialNumber() {
        if (this.mUserId != UserHandle.myUserId()) goto L7;
        return Integer.MIN_VALUE;
    L7:
        if (this.mSerialNumber >= 0) goto L24;
        int r0 = this.mUserId;
        if (r0 != (-10)) goto L13;
        return Integer.MAX_VALUE;
    L13:
        if (r0 != (-11)) goto L16;
        return 2147483646;
    L16:
        UserManager r1 = (UserManager) getContext().getSystemService(PickApplicationActivity.EXTRA_USER);
        if (r1 == null) goto L20;
        this.mSerialNumber = r1.getUserSerialNumber(this.mUserId);
    L20:
        if (this.mSerialNumber >= 0) goto L24;
        return this.mUserId;
    L24:
        return this.mSerialNumber;
    }

    public int getUserId() {
        return this.mUserId;
    }
}
