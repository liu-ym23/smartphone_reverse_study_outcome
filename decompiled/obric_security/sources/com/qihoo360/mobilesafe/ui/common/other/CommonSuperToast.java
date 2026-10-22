package com.qihoo360.mobilesafe.ui.common.other;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonSuperToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    private int mDelay;
    private int mDuration;
    private int mGravity;
    private final Handler mHandler;
    private final Runnable mHide;
    private float mHorizontalMargin;
    private View mNextView;
    private WindowManager.LayoutParams mParams;
    private final Runnable mShow;
    private float mVerticalMargin;
    private View mView;
    private WindowManager mWM;
    private int mX;
    private int mY;

    static /* synthetic */ void access$000(CommonSuperToast r0) {
        r0.handleShow();
    }

    static /* synthetic */ void access$100(CommonSuperToast r0) {
        r0.handleHide();
    }

    public static CommonSuperToast makeText(Context r1, CharSequence r2, int r3) {
        return new CommonSuperToast(r1, r2, r3);
    }

    public static CommonSuperToast makeView(Context r1, View r2, int r3) {
        return new CommonSuperToast(r1, r2, r3);
    }

    private CommonSuperToast(Context r3, CharSequence r4, int r5) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDuration = 2000;
        this.mGravity = 80;
        this.mShow = new AnonymousClass1(this);
        this.mHide = new AnonymousClass2(this);
        LinearLayout r0 = new LinearLayout(r3);
        TextView r1 = new TextView(r3);
        r1.setText(r4);
        r1.setTextColor(-1);
        r1.setGravity(81);
        r0.setBackgroundResource(R.drawable.toast_frame);
        r1.setMaxWidth(r3.getResources().getDisplayMetrics().widthPixels);
        r0.addView(r1);
        this.mY = r3.getResources().getDimensionPixelSize(com.qihoo360.mobilesafe.common.ui.R.dimen.inner_common_dimen_64dp);
        init(r3, r0, r5);
    }

    private CommonSuperToast(Context r3, View r4, int r5) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDuration = 2000;
        this.mGravity = 80;
        this.mShow = new AnonymousClass1(this);
        this.mHide = new AnonymousClass2(this);
        init(r3, r4, r5);
    }

    private void init(Context r3, View r4, int r5) {
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.mParams = r0;
        r0.height = -2;
        this.mParams.width = -2;
        this.mParams.flags = 152;
        this.mParams.format = -3;
        this.mParams.windowAnimations = R.style.Animation.Toast;
        WindowManager.LayoutParams r1 = this.mParams;
        r1.type = CommonUtils.getLayoutParamsType();
        this.mParams.setTitle("Toast");
        this.mWM = (WindowManager) r3.getApplicationContext().getSystemService("window");
        this.mNextView = r4;
        this.mDuration = r5;
    }

    public CommonSuperToast setDelay(int r1) {
        this.mDelay = r1;
        return this;
    }

    public CommonSuperToast setView(View r1) {
        this.mNextView = r1;
        return this;
    }

    public CommonSuperToast setParamFlags(int r2) {
        this.mParams.flags = r2;
        return this;
    }

    public CommonSuperToast setDuration(int r1) {
        this.mDuration = r1;
        return this;
    }

    public CommonSuperToast setMargin(float r1, float r2) {
        this.mHorizontalMargin = r1;
        this.mVerticalMargin = r2;
        return this;
    }

    public CommonSuperToast setGravity(int r1, int r2, int r3) {
        this.mGravity = r1;
        this.mX = r2;
        this.mY = r3;
        return this;
    }

    public CommonSuperToast setLayoutParams(int r2, int r3) {
        this.mParams.width = r2;
        this.mParams.height = r3;
        return this;
    }

    public CommonSuperToast show() {
        this.mHandler.postDelayed(this.mShow, this.mDelay);
        int r0 = this.mDuration;
        if (r0 <= 0) goto L5;
        this.mHandler.postDelayed(this.mHide, r0 + this.mDelay);
    L5:
        return this;
    }

    public CommonSuperToast hide() {
        this.mHandler.post(this.mHide);
        return this;
    }

    private void handleShow() {
        if (this.mView == this.mNextView) goto L9;
        handleHide();     // Catch: Exception -> L6
        this.mView = this.mNextView;     // Catch: Exception -> L6
        WindowManager.LayoutParams r0 = this.mParams;     // Catch: Exception -> L6
        r0.gravity = this.mGravity;     // Catch: Exception -> L6
        WindowManager.LayoutParams r1 = this.mParams;     // Catch: Exception -> L6
        r1.x = this.mX;     // Catch: Exception -> L6
        WindowManager.LayoutParams r2 = this.mParams;     // Catch: Exception -> L6
        r2.y = this.mY;     // Catch: Exception -> L6
        WindowManager.LayoutParams r3 = this.mParams;     // Catch: Exception -> L6
        r3.verticalMargin = this.mVerticalMargin;     // Catch: Exception -> L6
        WindowManager.LayoutParams r4 = this.mParams;     // Catch: Exception -> L6
        r4.horizontalMargin = this.mHorizontalMargin;     // Catch: Exception -> L6
        this.mWM.addView(this.mView, this.mParams);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private void handleHide() {
        View r0 = this.mView;     // Catch: Exception -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() == null) goto L12;
        this.mWM.removeView(this.mView);     // Catch: Exception -> L8
        this.mView = null;     // Catch: Exception -> L8
        return;
    L12:
        return;
    }
}
