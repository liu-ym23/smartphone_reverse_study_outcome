package com.android.settings.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class NavigationBarPreview extends LinearLayout implements View.OnClickListener {
    public static final int INDEX_CLASSIC_STYLE = 1;
    public static final int INDEX_NARROW_STYLE = 0;
    public static final int INDEX_THEME_BLACK_STYLE = 2;
    public static final int INDEX_THEME_GRAY_STYLE = 3;
    public static final int INDEX_THEME_RED_WINE_STYLE = 4;
    private static final String TAG = "NavigationBarPreview";
    private PreviewOptionItemView mBlackThemeView;
    private Callback mCallback;
    private PreviewOptionItemView mClassicStyle;
    private ImageView mDisableFrame;
    private ImageView mFrame;
    private PreviewOptionItemView mGrayThemeView;
    private long mLastClickTime;
    private PreviewOptionItemView mNarrowStyle;
    private ImageView mPreview;
    private PreviewOptionItemView mRedWineThemeView;
    private TextView mTitleView;

    public interface Callback {
        void onNavbarOptionsChanged(int r1);

        void onNavbarThemeChanged(int r1);
    }

    private void updatePreview(int r1) {
    }

    public NavigationBarPreview(Context r2) {
        this(r2, null);
    }

    public NavigationBarPreview(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NavigationBarPreview(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        LayoutInflater.from(r4).inflate(R.layout.navigationbar_preview_layout, this, true);
        setOrientation(1);
        View r7 = findViewById(R.id.middle_layout);
        boolean r8 = SettingsFeature.isNarrowModeNavBarSupport();
        int r9 = 0;
        if (r8 == true) goto L6;
        r9 = 8;
    L6:
        r7.setVisibility(r9);
        this.mTitleView = (TextView) findViewById(R.id.id_navbar_mode_setting_title);
        if (r8 == false) goto L9;
        int r10 = R.string.navigation_bar_settings_mode;
    L10:
        setTitle(r10);
        this.mPreview = (ImageView) findViewById(R.id.id_preview);
        this.mFrame = (ImageView) findViewById(R.id.id_frame);
        this.mDisableFrame = (ImageView) findViewById(R.id.id_frame_disable);
        this.mFrame.setImageResource(Utils.getPhoneFrameResId());
        PreviewOptionItemView r11 = (PreviewOptionItemView) findViewById(R.id.id_navbar_narrow);
        this.mNarrowStyle = r11;
        r11.setTag(1);
        this.mNarrowStyle.setOnClickListener(this);
        PreviewOptionItemView r12 = (PreviewOptionItemView) findViewById(R.id.id_navbar_classic);
        this.mClassicStyle = r12;
        r12.setTag(0);
        this.mClassicStyle.setOnClickListener(this);
        this.mNarrowStyle.setItemImageRes(R.drawable.navbar_mode_narrow_bg);
        this.mNarrowStyle.setSelectedImageRes(R.drawable.option_selected_bg);
        this.mClassicStyle.setItemImageRes(R.drawable.navbar_mode_classic_bg);
        this.mClassicStyle.setSelectedImageRes(R.drawable.option_selected_bg);
        this.mBlackThemeView = (PreviewOptionItemView) findViewById(R.id.id_navbar_black_theme);
        this.mGrayThemeView = (PreviewOptionItemView) findViewById(R.id.id_navbar_gray_theme);
        this.mRedWineThemeView = (PreviewOptionItemView) findViewById(R.id.id_navbar_red_wine_theme);
        this.mBlackThemeView.setTag(0);
        this.mGrayThemeView.setTag(1);
        this.mRedWineThemeView.setTag(2);
        this.mBlackThemeView.setOnClickListener(this);
        this.mGrayThemeView.setOnClickListener(this);
        this.mRedWineThemeView.setOnClickListener(this);
        if (SettingsFeature.isWineRedNavigationBarSupport() == true) goto L14;
        this.mRedWineThemeView.setVisibility(8);
        findViewById(R.id.iv_line_left_of_wine_red).setVisibility(8);
        return;
    L14:
        return;
    L9:
        r10 = R.string.navigation_bar_theme;
        goto L10
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void updateViews(int r5, int r6) {
        PreviewOptionItemView r0 = this.mNarrowStyle;
        boolean r1 = false;
        if (r5 != 1) goto L5;
        boolean r3 = true;
    L6:
        r0.setActive(r3);
        PreviewOptionItemView r2 = this.mClassicStyle;
        if (r5 != 0) goto L9;
        boolean r4 = true;
    L10:
        r2.setActive(r4);
        PreviewOptionItemView r7 = this.mBlackThemeView;
        if (r6 != 0) goto L13;
        boolean r8 = true;
    L14:
        r7.setActive(r8);
        PreviewOptionItemView r9 = this.mGrayThemeView;
        if (r6 != 1) goto L17;
        boolean r10 = true;
    L18:
        r9.setActive(r10);
        PreviewOptionItemView r11 = this.mRedWineThemeView;
        if (r6 != 2) goto L21;
        r1 = true;
    L21:
        r11.setActive(r1);
        updatePreview(r5);
        return;
    L17:
        r10 = false;
        goto L18
    L13:
        r8 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public void setTitle(int r1) {
        this.mTitleView.setText(r1);
    }

    public void setTitle(CharSequence r1) {
        this.mTitleView.setText(r1);
    }

    public PreviewOptionItemView getOptionView(int r2) {
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L20;
        if (r2 == 4) goto L19;
        OLog.w(TAG, "getOptionView return null, index:" + r2);
        return null;
    L19:
        return this.mRedWineThemeView;
    L20:
        return this.mGrayThemeView;
    L21:
        return this.mBlackThemeView;
    L22:
        return this.mClassicStyle;
    L17:
        return this.mNarrowStyle;
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        ImageView r0 = this.mDisableFrame;
        if (r3 == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.mNarrowStyle.enableChildViews(r3);
        this.mClassicStyle.enableChildViews(r3);
        this.mBlackThemeView.enableChildViews(r3);
        this.mGrayThemeView.enableChildViews(r3);
        this.mRedWineThemeView.enableChildViews(r3);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if ((r8 instanceof PreviewOptionItemView) == false) goto L8;
        if (((PreviewOptionItemView) r8).isActive() == false) goto L8;
        return;
    L8:
        if (r8 != this.mNarrowStyle) goto L10;
    L24:
        long r3 = SystemClock.elapsedRealtime() - this.mLastClickTime;
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (r3 >= 300) goto L27;
        return;
    L27:
        Callback r7 = this.mCallback;
        if (r7 == null) goto L34;
        r7.onNavbarOptionsChanged(((Integer) r8.getTag()).intValue());
        return;
    L34:
        return;
    L10:
        if (r8 == this.mClassicStyle) goto L24;
        if (r8 != this.mBlackThemeView) goto L15;
    L18:
        long r4 = SystemClock.elapsedRealtime() - this.mLastClickTime;
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (r4 >= 300) goto L21;
        return;
    L21:
        Callback r9 = this.mCallback;
        if (r9 == null) goto L32;
        r9.onNavbarThemeChanged(((Integer) r8.getTag()).intValue());
        return;
    L32:
        return;
    L15:
        if (r8 == this.mGrayThemeView) goto L18;
        if (r8 == this.mRedWineThemeView) goto L18;
    }
}
