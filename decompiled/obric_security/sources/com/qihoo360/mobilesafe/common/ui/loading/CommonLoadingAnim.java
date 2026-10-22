package com.qihoo360.mobilesafe.common.ui.loading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonLoadingAnim extends LinearLayout {
    private final Context mContext;
    private final String mDefineTxt;
    private boolean mHasStartAnimation;
    private AnimationDrawable mLoadingDrawable;
    private ImageView mLoadingIcon;
    private TextView mLoadingText;
    private TextView mSymbolText;

    public CommonLoadingAnim(Context r2, AttributeSet r3) {
        super(r2, r3);
        setOrientation(1);
        setGravity(17);
        this.mContext = r2;
        this.mDefineTxt = CommonUtils.getTextFromAttrs(r2, r3);
        initView();
    }

    private void initView() {
        inflate(this.mContext, R.layout.inner_common_running_man_anim, this);
        this.mLoadingIcon = (ImageView) findViewById(R.id.common_loading_icon);
        this.mLoadingText = (TextView) findViewById(R.id.common_loading_text);
        this.mSymbolText = (TextView) findViewById(R.id.common_loading_symbol);
        if (TextUtils.isEmpty(this.mDefineTxt) == false) goto L5;
        this.mLoadingText.setText(R.string.inner_common_loading);
        return;
    L5:
        this.mLoadingText.setText(this.mDefineTxt);
    }

    public void setSize(int r2) {
        ViewGroup.LayoutParams r0 = this.mLoadingIcon.getLayoutParams();
        r0.width = r2;
        r0.height = r0.width;
        this.mLoadingIcon.setLayoutParams(r0);
    }

    public void setText(int r1) {
        this.mLoadingText.setText(r1);
    }

    public void setText(CharSequence r1) {
        this.mLoadingText.setText(r1);
    }

    public void setTextAndSymbol(CharSequence r1, boolean r2) {
        setText(r1);
        TextView r0 = this.mSymbolText;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        startAnimation();
        return;
    L5:
        stopAnimation();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r4) {
        super.onWindowVisibilityChanged(r4);
        int r0 = getVisibility();
        if (r0 != 8) goto L5;
    L10:
        stopAnimation();
        return;
    L5:
        if (r0 == 4) goto L10;
        if (r4 == 8) goto L10;
        if (r4 == 4) goto L10;
        startAnimation();
    }

    private void startAnimation() {
        if (this.mHasStartAnimation == false) goto L6;
        return;
    L6:
        if (this.mLoadingDrawable != null) goto L8;
        this.mLoadingDrawable = (AnimationDrawable) this.mLoadingIcon.getDrawable();
    L8:
        this.mLoadingDrawable.start();
        this.mHasStartAnimation = true;
    }

    private void stopAnimation() {
        if (this.mHasStartAnimation == true) goto L5;
        return;
    L5:
        AnimationDrawable r0 = this.mLoadingDrawable;
        if (r0 == null) goto L9;
        r0.stop();
        this.mHasStartAnimation = false;
        return;
    }
}
