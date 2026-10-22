package com.obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.android.settings.utils.UIUtils;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes5.dex */
public class SettingListItem extends LinearLayout {
    private ImageView contentImageView;
    private FrameLayout iconContain;
    private ImageView infoImageView;
    private LinearLayout mContentView;
    private LinearLayout mSettingItem;
    private OSwitch oSwitch;
    private OTextView subtitleTextView;
    private LinearLayout switchContain;
    private LinearLayout tailContain;
    private ImageView tailTips;
    private OTextView tailTitleTextView;
    private ImageView titleInfo;
    private OTextView titleTextView;

    public ImageView getTitleInfoImg() {
        return this.titleInfo;
    }

    public OSwitch getoSwitch() {
        return this.oSwitch;
    }

    public ImageView getTailTips() {
        return this.tailTips;
    }

    public SettingListItem(Context r3, AttributeSet r4) {
        super(r3, r4);
        init(r3);
        int r1 = 0;
        TypedArray r5 = r3.getTheme().obtainStyledAttributes(r4, R.styleable.SettingListItem, 0, 0);
        this.titleTextView.setText(r5.getText(0));
        Boolean r6 = Boolean.valueOf(r5.getBoolean(1, true));
        FrameLayout r2 = this.iconContain;
        if (r6.booleanValue() == true) goto L6;
        r1 = 8;
    L6:
        r2.setVisibility(r1);
    }

    public SettingListItem(Context r1) {
        super(r1);
        init(r1);
    }

    private void init(Context r3) {
        LayoutInflater.from(r3).inflate(R.layout.setting_list_item, this, true);
        this.titleTextView = (OTextView) findViewById(R.id.tv_content_title);
        this.subtitleTextView = (OTextView) findViewById(R.id.tv_content_subtitle);
        this.tailTitleTextView = (OTextView) findViewById(R.id.tv_content_tailtitle);
        this.contentImageView = (ImageView) findViewById(R.id.iv_content_img);
        this.infoImageView = (ImageView) findViewById(R.id.iv_content_info_img);
        this.tailTips = (ImageView) findViewById(R.id.trailingTips);
        this.tailContain = (LinearLayout) findViewById(R.id.tail_contail);
        this.switchContain = (LinearLayout) findViewById(R.id.item_switch_contain);
        this.oSwitch = (OSwitch) findViewById(R.id.item_switch);
        this.titleInfo = (ImageView) findViewById(R.id.iv_title_info_img);
        this.iconContain = (FrameLayout) findViewById(R.id.fl_content_element);
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.mSettingItem = (LinearLayout) findViewById(R.id.setting_item);
    }

    public void bindData(String r3, String r4, String r5, int r6) {
        this.titleTextView.setText(r3);
        this.subtitleTextView.setText(r4);
        this.tailTitleTextView.setText(r5);
        OTextView r7 = this.tailTitleTextView;
        int r0 = 8;
        if (r5.isEmpty() == false) goto L5;
        int r8 = 8;
    L6:
        r7.setVisibility(r8);
        OTextView r9 = this.subtitleTextView;
        if (r4.isEmpty() == true) goto L10;
        r0 = 0;
    L10:
        r9.setVisibility(r0);
        this.contentImageView.setImageResource(r6);
        return;
    L5:
        r8 = 0;
        goto L6
    }

    public void fixLongTailTitleUI(int r3) {
        this.tailTitleTextView.setMaxWidth(UIUtils.INSTANCE.dp2px(r3));
        this.tailTitleTextView.setMaxLines(1);
        this.tailTitleTextView.setGravity(8388629);
    }

    public OTextView getTitleTextView() {
        return this.titleTextView;
    }

    public OTextView getSubtitleTextView() {
        return this.subtitleTextView;
    }

    public OTextView getTailTitleTextView() {
        return this.tailTitleTextView;
    }

    public ImageView getContentImageView() {
        return this.contentImageView;
    }

    public ImageView getInfoImageView() {
        return this.infoImageView;
    }

    public void setSwitchVisibility(boolean r3) {
        if (r3 == false) goto L5;
        this.tailContain.setVisibility(8);
        this.switchContain.setVisibility(0);
        return;
    L5:
        this.tailContain.setVisibility(0);
        this.switchContain.setVisibility(8);
    }

    public void setTailText(String r3) {
        this.tailTitleTextView.setVisibility(0);
        this.tailTitleTextView.setText(r3);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        this.iconContain.setAlpha(1.0f);
        this.tailContain.setAlpha(1.0f);
        this.mContentView.setAlpha(1.0f);
        return;
    L5:
        this.iconContain.setAlpha(0.3f);
        this.tailContain.setAlpha(0.3f);
        this.mContentView.setAlpha(0.3f);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        if (this.mSettingItem == null) goto L14;
        LinearLayout r0 = this.switchContain;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getVisibility() == 0) goto L16;
        LinearLayout r1 = this.mSettingItem;
        Resources r3 = getResources();
        if (r2 == false) goto L11;
        int r4 = R.drawable.setting_item_backgroud_pressed;
    L12:
        r1.setBackground(r3.getDrawable(r4));
        return;
    L11:
        r4 = R.drawable.setting_item_backgroud_card;
        goto L12
    L16:
        return;
    }
}
