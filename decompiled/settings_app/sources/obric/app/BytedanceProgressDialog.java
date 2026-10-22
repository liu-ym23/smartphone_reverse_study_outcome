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
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class BytedanceProgressDialog extends Dialog {
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

    public void setProgress(int r1) {
    }

    public BytedanceProgressDialog(Context r2) {
        super(r2);
        this.mTitleColor = -1677721600;
        this.mMessageColor = -1677721600;
        this.mHideProgressBar = false;
        this.mIsDarkTheme = false;
        this.mContext = r2;
    }

    public static BytedanceProgressDialog show(Context r1, CharSequence r2, CharSequence r3) {
        BytedanceProgressDialog r0 = new BytedanceProgressDialog(r1);
        r0.setTitle(r2);
        r0.setMessage(r3);
        r0.show();
        return r0;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.bytedance_progress_dialog, null);
        this.mTitleView = (TextView) r4.findViewById(R.id.progress_dialog_title);
        this.mProgress = (ProgressBar) r4.findViewById(R.id.progress);
        this.mMessageView = (TextView) r4.findViewById(R.id.message);
        this.mContent = (LinearLayout) r4.findViewById(R.id.progress_dialog_content);
        this.mProgress.setIndeterminate(true);
        getWindow().requestFeature(1);
        getWindow().setFlags(131072, 131072);
        getWindow().setContentView(r4);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
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
        getContext().getResources().getDrawable(17304588);
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
        r5 = getContext().getResources().getDrawable(17304588);
        goto L24
    L23:
        r5 = getContext().getResources().getDrawable(17304587);
        goto L24
    L14:
        if (this.mIsDarkTheme == true) goto L16;
        this.mContent.setBackground(getContext().getResources().getDrawable(R.drawable.bytedance_progress_dialog_bg));
        goto L17
    L16:
        this.mContent.setBackground(getContext().getResources().getDrawable(R.drawable.bytedance_progress_dialog_bg_dark));
        goto L17
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    private void updateDrawableBounds(Drawable r7, int r8, int r9) {
        Rect r6 = new Rect();
        r7.getPadding(r6);
        int r0 = r6.left;
        int r10 = r8 - (r6.right + r0);
        int r11 = r9 - (r6.top + r6.bottom);
        if (r7 == null) goto L15;
        int r1 = 0;
        if ((r7 instanceof AnimationDrawable) == true) goto L12;
        float r12 = r7.getIntrinsicWidth() / r7.getIntrinsicHeight();
        float r2 = r10;
        float r3 = r11;
        float r4 = r2 / r3;
        if (Float.compare(r12, r4) == 0) goto L12;
        if (r4 <= r12) goto L11;
        int r13 = (int) (r3 * r12);
        int r14 = (r10 - r13) / 2;
        r10 = r13 + r14;
        int r15 = 0;
        r1 = r14;
    L13:
        r7.setBounds(r1, r15, r10, r11);
        return;
    L11:
        int r16 = (int) (r2 * (1.0f / r12));
        int r17 = (r11 - r16) / 2;
        r11 = r16 + r17;
        r15 = r17;
    L12:
        r15 = 0;
        goto L13
    }

    public void setDarkTheme(boolean r2) {
        this.mIsDarkTheme = r2;
        if (r2 == true) goto L11;
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
    public void setTitle(int r2) {
        setTitle(this.mContext.getText(r2));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r2) {
        this.mTitle = r2;
        TextView r0 = this.mTitleView;
        if (r0 == null) goto L10;
        r0.setText(r2);
        TextView r3 = this.mTitleView;
        if (this.mTitle != null) goto L7;
        int r1 = 8;
    L8:
        r3.setVisibility(r1);
        return;
    L7:
        r1 = 0;
        goto L8
    }

    public void setIndeterminateDrawableResource(int r2) {
        setIndeterminateDrawable(this.mContext.getResources().getDrawable(r2));
    }

    public void setIndeterminateDrawable(Drawable r2) {
        this.mIndeterminateDrawable = r2;
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L6;
        r0.setIndeterminateDrawable(r2);
        this.mProgress.requestLayout();
        return;
    }

    public void setHideProgressBar(boolean r1) {
        this.mHideProgressBar = r1;
    }

    public void setMessage(int r2) {
        setMessage(this.mContext.getText(r2));
    }

    public void setMessage(CharSequence r2) {
        this.mMessage = r2;
        TextView r0 = this.mMessageView;
        if (r0 == null) goto L10;
        r0.setText(r2);
        TextView r3 = this.mMessageView;
        if (this.mMessage != null) goto L7;
        int r1 = 8;
    L8:
        r3.setVisibility(r1);
        return;
    L7:
        r1 = 0;
        goto L8
    }

    public void setBackgroundResource(int r2) {
        setBackground(this.mContext.getResources().getDrawable(r2));
    }

    public void setBackground(Drawable r1) {
        this.mBackground = r1;
    }

    public void setSystemUiVisibility(int r1) {
        this.mSystemUiVisibility = r1;
    }

    public void setTitleColor(int r2) {
        this.mHasSetTitleColor = true;
        this.mTitleColor = r2;
    }

    public void setMessageColor(int r2) {
        this.mHasSetMessageColor = true;
        this.mMessageColor = r2;
    }
}
