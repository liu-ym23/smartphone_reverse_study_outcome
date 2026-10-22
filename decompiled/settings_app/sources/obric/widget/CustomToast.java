package obric.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import obric.InvokeApi;

/* JADX INFO: loaded from: classes5.dex */
public class CustomToast {
    public static final int DURATION_LONG = 3500;
    public static final int DURATION_SHORT = 2000;
    static final int SNACKBAR_DURATION = 2000;
    public static final int STYLE_DARK = 1;
    public static final int STYLE_LIGHT = 0;
    static final String TAG = "CustomToast";
    static final boolean localLOGV = false;
    final Context mContext;
    int mDuration;
    View mNextView;
    final TN mTN;

    private static class TN {
        private static final int MSG_HIDE = 2;
        private static final int MSG_SHOW = 1;
        Activity mActivity;
        int mDuration;
        int mGravity;
        final Handler mHandler;
        float mHorizontalMargin;
        View mNextView;
        private final WindowManager.LayoutParams mParams;
        float mVerticalMargin;
        View mView;
        WindowManager mWM;
        int mX;
        int mY;

        static /* synthetic */ void access$000(TN r0) {
            r0.handleShow();
        }

        static /* synthetic */ void access$100(TN r0) {
            r0.handleHide();
        }

        TN() {
            WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
            this.mParams = r0;
            this.mHandler = new AnonymousClass1(this);
            r0.height = -2;
            r0.width = -2;
            r0.format = -3;
            r0.windowAnimations = InvokeApi.xComAndroidInternalR.getResId("style", "Animation_Toast");
            r0.type = 2;
            r0.flags = 168;
            r0.setTitle(CustomToast.TAG);
        }

        public void show() {
            this.mHandler.sendEmptyMessage(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(2, this.mDuration);
        }

        public void hide() {
            this.mHandler.sendEmptyMessage(2);
        }

        private void handleShow() {
            handleHide();
            View r0 = this.mNextView;
            this.mView = r0;
            Context r1 = r0.getContext().getApplicationContext();
            String r2 = this.mView.getContext().getPackageName();
            if (r1 != null) goto L5;
            r1 = this.mView.getContext();
        L5:
            this.mWM = (WindowManager) r1.getSystemService("window");
            Configuration r3 = this.mView.getContext().getResources().getConfiguration();
            int r4 = Gravity.getAbsoluteGravity(this.mGravity, r3.getLayoutDirection());
            this.mParams.gravity = r4;
            if ((r4 & 7) != 7) goto L9;
            this.mParams.horizontalWeight = 1.0f;
        L9:
            if ((r4 & 112) != 112) goto L11;
            this.mParams.verticalWeight = 1.0f;
        L11:
            WindowManager.LayoutParams r5 = this.mParams;
            r5.x = this.mX;
            WindowManager.LayoutParams r6 = this.mParams;
            r6.y = this.mY;
            WindowManager.LayoutParams r7 = this.mParams;
            r7.verticalMargin = this.mVerticalMargin;
            WindowManager.LayoutParams r8 = this.mParams;
            r8.horizontalMargin = this.mHorizontalMargin;
            WindowManager.LayoutParams r9 = this.mParams;
            r9.token = this.mActivity.getWindow().getAttributes().token;
            this.mParams.packageName = r2;
            if (this.mView.getParent() == null) goto L14;
            this.mWM.removeView(this.mView);
        L14:
            this.mWM.addView(this.mView, this.mParams);
        }

        private void handleHide() {
            View r0 = this.mView;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getParent() == null) goto L7;
            this.mWM.removeView(this.mView);
        L7:
            this.mView = null;
        }
    }

    private CustomToast(Context context) {
        this.mContext = context;
        TN r0 = new TN();
        this.mTN = r0;
        r0.mY = context.getResources().getDimensionPixelSize(R.dimen.toast_y_offset);
        r0.mGravity = 81;
    }

    public static CustomToast makeText(Context context, CharSequence text, int duration, int style) {
        CustomToast r0 = new CustomToast(context);
        View r1 = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_toast_layout, null);
        TextView r2 = (TextView) r1.findViewById(R.id.message);
        r2.setText(text);
        Resources r4 = context.getResources();
        if (style != 0) goto L5;
        r1.setBackgroundResource(R.drawable.tip_toast_bg_light);
        r2.setTextColor(r4.getColor(R.color.toast_light_text_color));
    L10:
        r0.mNextView = r1;
        r0.mDuration = duration;
        return r0;
    L5:
        if (style != 1) goto L8;
        r1.setBackgroundResource(R.drawable.tip_toast_bg_dark);
        r2.setTextColor(r4.getColor(R.color.toast_dark_text_color));
        r2.setShadowLayer(0.1f, 0.0f, -2.0f, r4.getColor(R.color.text_shadow_color_enable));
        goto L10
    L8:
        throw new IllegalArgumentException("unknown style value:" + style + ", available values: {STYLE_LIGHT=0, STYLE_DARK=1}");
    }

    public static CustomToast makeButtonSnackbar(Context context, CharSequence msg, CharSequence btnText, final View.OnClickListener actionListener) {
        final CustomToast r0 = new CustomToast(context);
        SnackbarWithButton r1 = new SnackbarWithButton(context);
        r1.setBackgroundResource(R.drawable.toast_frame_obric);
        r1.setMessage(msg);
        r1.setActionText(btnText);
        r1.setActionListener(new AnonymousClass1(r0, actionListener));
        r0.mNextView = r1;
        r0.mDuration = 2000;
        return r0;
    }

    public static CustomToast makeDrawableSnackbar(Context context, CharSequence msg, int drawableResId, final View.OnClickListener actionListener) {
        final CustomToast r0 = new CustomToast(context);
        SnackbarWithDrawable r1 = new SnackbarWithDrawable(context);
        r1.setBackgroundResource(R.drawable.toast_frame_obric);
        r1.setMessage(msg);
        if (drawableResId <= 0) goto L5;
        r1.setImageResource(drawableResId);
    L5:
        r1.setActionListener(new AnonymousClass2(r0, actionListener));
        r0.mNextView = r1;
        r0.mDuration = 2000;
        return r0;
    }

    public void setAnchorView(View anchorView) {
        int[] r1 = new int[2];
        Rect r2 = new Rect();
        anchorView.getLocationOnScreen(r1);
        anchorView.getWindowVisibleDisplayFrame(r2);
        int r3 = anchorView.getWidth();
        int r4 = anchorView.getHeight();
        int r6 = r1[1] + (r4 / 2);
        int r5 = r3 / 2;
        int r8 = r1[0] + r5;
        DisplayMetrics r0 = this.mContext.getResources().getDisplayMetrics();
        if (anchorView.getLayoutDirection() != 0) goto L6;
        r8 = (r0.widthPixels - r8) - r5;
    L6:
        if (r6 < r2.height()) goto L8;
        setGravity(81, 0, r4);
        return;
    L8:
        if ((r2.bottom - r1[1]) <= (r0.density * 100.0f)) goto L10;
        setGravity(8388661, r8, (r1[1] + r4) - r2.top);
        return;
    L10:
        setGravity(8388693, r8, r2.bottom - r1[1]);
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        this.mTN.mGravity = gravity;
        this.mTN.mX = xOffset;
        this.mTN.mY = yOffset;
    }

    public int getGravity() {
        return this.mTN.mGravity;
    }

    public int getXOffset() {
        return this.mTN.mX;
    }

    public int getYOffset() {
        return this.mTN.mY;
    }

    public void setText(int resId) {
        setText(this.mContext.getText(resId));
    }

    public void setText(CharSequence s) {
        View r2 = this.mNextView;
        if (r2 == null) goto L11;
        TextView r3 = (TextView) r2.findViewById(R.id.message);
        if (r3 == null) goto L9;
        r3.setText(s);
        return;
    L9:
        throw new RuntimeException("This Toast was not created with Toast.makeText()");
    L11:
        throw new RuntimeException("This Toast was not created with Toast.makeText()");
    }

    public void show(Activity activity) {
        View r0 = this.mNextView;
        if (r0 == null) goto L7;
        TN r1 = this.mTN;
        r1.mNextView = r0;
        r1.mDuration = this.mDuration;
        r1.mActivity = activity;
        r1.show();
        return;
    L7:
        throw new RuntimeException("setView must have been called");
    }

    public void cancel() {
        this.mTN.hide();
    }
}
