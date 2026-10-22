package obric.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class ProgressDialog extends Dialog {
    private Drawable mBackground;
    private LinearLayout mContent;
    private Context mContext;
    private boolean mHasSetMessageColor;
    private boolean mHasSetTitleColor;
    private boolean mHideProgressBar;
    private Drawable mIndeterminateDrawable;
    private boolean mIsDarkTheme;
    private CharSequence mMessage;
    private int mMessageColor;
    private TextView mMessageView;
    private ProgressBar mProgress;
    private int mSystemUiVisibility;
    private CharSequence mTitle;
    private int mTitleColor;
    private TextView mTitleView;

    public void setProgress(int value) {
    }

    public ProgressDialog(Context context) {
        super(context);
        this.mTitleColor = -1677721600;
        this.mMessageColor = -1677721600;
        this.mHideProgressBar = false;
        this.mIsDarkTheme = false;
        this.mContext = context;
    }

    public static ProgressDialog show(Context context, CharSequence title, CharSequence message) {
        ProgressDialog r0 = new ProgressDialog(context);
        r0.setTitle(title);
        r0.setMessage(message);
        r0.show();
        return r0;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View r3 = LayoutInflater.from(this.mContext).inflate(R.layout.obric_progress_dialog, null);
        this.mTitleView = (TextView) r3.findViewById(R.id.progress_dialog_title);
        this.mProgress = (ProgressBar) r3.findViewById(R.id.progress);
        this.mMessageView = (TextView) r3.findViewById(R.id.message);
        this.mContent = (LinearLayout) r3.findViewById(R.id.progress_dialog_content);
        this.mProgress.setIndeterminate(true);
        getWindow().requestFeature(1);
        getWindow().setFlags(131072, 131072);
        getWindow().setContentView(r3);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override // android.app.Dialog
    public void onStart() {
        this.mTitleView.setText(this.mTitle);
        this.mTitleView.setTextColor(this.mTitleColor);
        TextView r0 = this.mTitleView;
        if (this.mTitle != null) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.mMessageView.setText(this.mMessage);
        this.mMessageView.setTextColor(this.mMessageColor);
        TextView r2 = this.mMessageView;
        if (this.mMessage != null) goto L9;
        int r3 = 8;
    L10:
        r2.setVisibility(r3);
        Drawable r4 = this.mBackground;
        if (r4 == null) goto L14;
        this.mContent.setBackground(r4);
    L17:
        Drawable r5 = this.mIndeterminateDrawable;
        if (r5 == null) goto L21;
    L24:
        updateDrawableBounds(r5, this.mProgress.getWidth(), this.mProgress.getHeight());
        this.mProgress.setIndeterminateDrawable(r5);
        if (this.mHideProgressBar == false) goto L27;
        this.mProgress.setIndeterminate(false);
        this.mProgress.setIndeterminateDrawable(null);
        this.mProgress.setVisibility(8);
    L27:
        this.mContent.getRootView().setSystemUiVisibility(this.mSystemUiVisibility);
        return;
    L21:
        if (this.mIsDarkTheme == true) goto L23;
        r5 = getContext().getResources().getDrawable(R.drawable.progress_medium_obric_light);
        goto L24
    L23:
        r5 = getContext().getResources().getDrawable(R.drawable.progress_medium_obric_dark);
        goto L24
    L14:
        if (this.mIsDarkTheme == true) goto L16;
        this.mContent.setBackground(getContext().getResources().getDrawable(R.drawable.obric_progress_dialog_bg));
        goto L17
    L16:
        this.mContent.setBackground(getContext().getResources().getDrawable(R.drawable.obric_progress_dialog_bg_dark));
        goto L17
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    private void updateDrawableBounds(Drawable progressDrawable, int w, int h) {
        Rect r6 = new Rect();
        progressDrawable.getPadding(r6);
        int r0 = r6.left;
        int r8 = w - (r6.right + r0);
        int r9 = h - (r6.top + r6.bottom);
        if (progressDrawable == null) goto L15;
        int r1 = 0;
        if ((progressDrawable instanceof AnimationDrawable) == true) goto L12;
        float r7 = progressDrawable.getIntrinsicWidth() / progressDrawable.getIntrinsicHeight();
        float r2 = r8;
        float r3 = r9;
        float r4 = r2 / r3;
        if (Float.compare(r7, r4) == 0) goto L12;
        if (r4 <= r7) goto L11;
        int r10 = (int) (r3 * r7);
        int r11 = (r8 - r10) / 2;
        r8 = r10 + r11;
        int r12 = 0;
        r1 = r11;
    L13:
        progressDrawable.setBounds(r1, r12, r8, r9);
        return;
    L11:
        int r13 = (int) (r2 * (1.0f / r7));
        int r14 = (r9 - r13) / 2;
        r9 = r13 + r14;
        r12 = r14;
    L12:
        r12 = 0;
        goto L13
    }

    public void setDarkTheme(boolean isDark) {
        this.mIsDarkTheme = isDark;
        if (isDark == true) goto L11;
        if (this.mHasSetTitleColor == true) goto L8;
        this.mTitleColor = -1677721600;
    L8:
        if (this.mHasSetMessageColor == true) goto L17;
        this.mMessageColor = -1677721600;
        return;
    L17:
        return;
    L11:
        if (this.mHasSetTitleColor == true) goto L14;
        this.mTitleColor = -1;
    L14:
        if (this.mHasSetMessageColor == true) goto L19;
        this.mMessageColor = -1;
        return;
    }

    @Override // android.app.Dialog
    public void setTitle(int titleId) {
        setTitle(this.mContext.getText(titleId));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence title) {
        this.mTitle = title;
        TextView r0 = this.mTitleView;
        if (r0 == null) goto L10;
        r0.setText(title);
        TextView r2 = this.mTitleView;
        if (this.mTitle != null) goto L7;
        int r1 = 8;
    L8:
        r2.setVisibility(r1);
        return;
    L7:
        r1 = 0;
        goto L8
    }

    public void setIndeterminateDrawableResource(int resId) {
        setIndeterminateDrawable(this.mContext.getResources().getDrawable(resId));
    }

    public void setIndeterminateDrawable(Drawable d) {
        this.mIndeterminateDrawable = d;
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L6;
        r0.setIndeterminateDrawable(d);
        this.mProgress.requestLayout();
        return;
    }

    public void setHideProgressBar(boolean bool) {
        this.mHideProgressBar = bool;
    }

    public void setMessage(int msgId) {
        setMessage(this.mContext.getText(msgId));
    }

    public void setMessage(CharSequence message) {
        this.mMessage = message;
        TextView r0 = this.mMessageView;
        if (r0 == null) goto L10;
        r0.setText(message);
        TextView r2 = this.mMessageView;
        if (this.mMessage != null) goto L7;
        int r1 = 8;
    L8:
        r2.setVisibility(r1);
        return;
    L7:
        r1 = 0;
        goto L8
    }

    public void setBackgroundResource(int resId) {
        setBackground(this.mContext.getResources().getDrawable(resId));
    }

    public void setBackground(Drawable d) {
        this.mBackground = d;
    }

    public void setSystemUiVisibility(int visibility) {
        this.mSystemUiVisibility = visibility;
    }

    public void setTitleColor(int color) {
        this.mHasSetTitleColor = true;
        this.mTitleColor = color;
    }

    public void setMessageColor(int color) {
        this.mHasSetMessageColor = true;
        this.mMessageColor = color;
    }
}
