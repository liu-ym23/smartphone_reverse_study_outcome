package com.android.settingslib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class TwoTargetPreference extends Preference {
    public static final int ICON_SIZE_DEFAULT = 0;
    public static final int ICON_SIZE_MEDIUM = 1;
    public static final int ICON_SIZE_SMALL = 2;
    private int mIconSize;
    private int mMediumIconSize;
    private int mSmallIconSize;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconSize {
    }

    protected int getSecondTargetResId() {
        return 0;
    }

    public TwoTargetPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        init(r1);
    }

    public TwoTargetPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1);
    }

    public TwoTargetPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    public TwoTargetPreference(Context r1) {
        super(r1);
        init(r1);
    }

    private void init(Context r3) {
        setLayoutResource(R.layout.preference_two_target);
        this.mSmallIconSize = r3.getResources().getDimensionPixelSize(R.dimen.two_target_pref_small_icon_size);
        this.mMediumIconSize = r3.getResources().getDimensionPixelSize(R.dimen.two_target_pref_medium_icon_size);
        int r4 = getSecondTargetResId();
        if (r4 == 0) goto L6;
        setWidgetLayoutResource(r4);
        return;
    }

    public void setIconSize(int r1) {
        this.mIconSize = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        ImageView r0 = (ImageView) r5.itemView.findViewById(android.R.id.icon);
        int r1 = this.mIconSize;
        if (r1 != 1) goto L5;
        int r2 = this.mMediumIconSize;
        r0.setLayoutParams(new LinearLayout.LayoutParams(r2, r2));
    L9:
        View r3 = r5.findViewById(R.id.two_target_divider);
        View r6 = r5.findViewById(android.R.id.widget_frame);
        boolean r4 = shouldHideSecondTarget();
        int r7 = 8;
        if (r3 == null) goto L15;
        if (r4 == false) goto L13;
        int r8 = 8;
    L14:
        r3.setVisibility(r8);
        goto L15
    L13:
        r8 = 0;
    L15:
        if (r6 == null) goto L21;
        if (r4 == true) goto L19;
        r7 = 0;
    L19:
        r6.setVisibility(r7);
        return;
    L21:
        return;
    L5:
        if (r1 != 2) goto L9;
        int r9 = this.mSmallIconSize;
        r0.setLayoutParams(new LinearLayout.LayoutParams(r9, r9));
        goto L9
    }

    protected boolean shouldHideSecondTarget() {
        if (getSecondTargetResId() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
