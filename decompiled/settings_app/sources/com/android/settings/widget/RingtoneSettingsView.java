package com.android.settings.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes.dex */
public class RingtoneSettingsView extends SettingItemCheck {
    private ImageView mImageViewSoundPlay;
    private int mSoundViewWidth;

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.ringtone_settings_item_mid_layout;
    }

    static /* synthetic */ LinearLayout access$000(RingtoneSettingsView r0) {
        return r0.mRightContainer;
    }

    static /* synthetic */ float access$100(RingtoneSettingsView r0) {
        return r0.getLeftContentWidth();
    }

    static /* synthetic */ int access$200(RingtoneSettingsView r0) {
        return r0.mSoundViewWidth;
    }

    static /* synthetic */ TextView access$300(RingtoneSettingsView r0) {
        return r0.mTitle;
    }

    public RingtoneSettingsView(Context r2) {
        this(r2, null);
    }

    public RingtoneSettingsView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RingtoneSettingsView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        this.mTitle = (TextView) findViewById(R.id.item_title);
        this.mSummary = (TextView) findViewById(R.id.item_summary);
        ImageView r0 = (ImageView) findViewById(R.id.image_sound_play);
        this.mImageViewSoundPlay = r0;
        this.mSoundViewWidth = r0.getBackground().getIntrinsicWidth() + getResources().getDimensionPixelSize(R.dimen.ring_tone_play_img_margin_left);
    }

    public ImageView getImageRemoveView() {
        return getIconView();
    }

    public void setRemoveViewVisible(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = R.drawable.ic_remove;
    L5:
        setIcon(r2);
        return;
    L4:
        r2 = 0;
        goto L5
    }

    public void playRingtoneAnimation(boolean r3) {
        ImageView r0 = this.mImageViewSoundPlay;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        setMaxTitleWidth(r3);
        AnimationDrawable r2 = (AnimationDrawable) this.mImageViewSoundPlay.getBackground();
        if (r3 == false) goto L9;
        r2.start();
        return;
    L9:
        r2.stop();
        return;
    L5:
        r1 = 4;
        goto L6
    }

    private void setMaxTitleWidth(final boolean r3) {
        getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(this, r3));
    }
}
