package obric.tablet.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BytedanceDialogPopupWindow extends BytedancePopupWindowBase implements View.OnClickListener {

    @Deprecated
    public static final int BUTTON_NEGATIVE = -2;

    @Deprecated
    public static final int BUTTON_NEUTRAL = -3;

    @Deprecated
    public static final int BUTTON_POSITIVE = -1;
    private Button mButtonNegative;
    private Button mButtonNeutral;
    private Button mButtonPositive;
    private CallbackListener mCallback;
    private ViewGroup mContentViewGroup;
    private View mCustomView;
    private ImageView mIconView;
    private BytedancePopupWindowInterface.CallbackListener mOnClickCallbackListener;
    private TextView mTitleView;

    @Deprecated
    public interface CallbackListener {
        void onCancel();

        void onConfirm();

        void onNeural();
    }

    protected abstract void initMsgContent(ViewGroup r1);

    public BytedanceDialogPopupWindow(View r1) {
        super(r1);
        this.mCallback = null;
        this.mOnClickCallbackListener = null;
    }

    public void setTitle(int r1) {
        TextView r0 = this.mTitleView;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public void setButton(int r3, CharSequence r4) {
        if (r3 != (-3)) goto L5;
        Button r5 = this.mButtonNeutral;
        if (r5 == null) goto L24;
        r5.setText(r4);
        this.mButtonNeutral.setVisibility(0);
        return;
    L24:
        return;
    L5:
        if (r3 != (-2)) goto L7;
        Button r6 = this.mButtonNegative;
        if (r6 == null) goto L22;
        r6.setText(r4);
        this.mButtonNegative.setVisibility(0);
        return;
    L22:
        return;
    L7:
        if (r3 != (-1)) goto L12;
        Button r7 = this.mButtonPositive;
        if (r7 == null) goto L20;
        r7.setText(r4);
        this.mButtonPositive.setVisibility(0);
        return;
    L20:
        return;
    L12:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void setIcon(int r3) {
        ImageView r0 = this.mIconView;
        if (r0 == null) goto L8;
        if (r3 == 0) goto L6;
        r0.setVisibility(0);
        this.mIconView.setImageResource(r3);
        return;
    L6:
        r0.setVisibility(8);
        return;
    }

    @Override // obric.tablet.widget.BytedancePopupWindowBase
    protected void initContentView(ViewGroup r4) {
        ViewGroup r5 = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.revone_global_popupwindow_dialog, r4, true);
        this.mIconView = (ImageView) r5.findViewById(R.id.revone_popupwindow_dialog_icon);
        this.mTitleView = (TextView) r5.findViewById(R.id.revone_popupwindow_dialog_title);
        this.mButtonPositive = (Button) r5.findViewById(R.id.revone_popupwindow_dialog_button1);
        this.mButtonNeutral = (Button) r5.findViewById(R.id.revone_popupwindow_dialog_button3);
        this.mButtonNegative = (Button) r5.findViewById(R.id.revone_popupwindow_dialog_button2);
        this.mButtonPositive.setOnClickListener(this);
        this.mButtonNeutral.setOnClickListener(this);
        this.mButtonNegative.setOnClickListener(this);
        ViewGroup r6 = (ViewGroup) r5.findViewById(R.id.revone_popupwindow_dialog_layout_content);
        this.mContentViewGroup = r6;
        initMsgContent(r6);
    }

    @Override // obric.tablet.widget.BytedancePopupWindowBase
    protected void preShow() {
        if (this.mCustomView != null) goto L5;
        return;
    L5:
        this.mContentViewGroup.removeAllViews();
        this.mContentViewGroup.addView(this.mCustomView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setView(View r1) {
        this.mCustomView = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        BytedancePopupWindowInterface.CallbackListener r0 = this.mOnClickCallbackListener;
        if (r0 != null) goto L5;
        CallbackListener r1 = this.mCallback;
        if (r1 != null) goto L16;
    L24:
        dismiss();
        return;
    L16:
        if (r3 != this.mButtonPositive) goto L19;
        r1.onConfirm();
        goto L24
    L19:
        if (r3 != this.mButtonNegative) goto L22;
        r1.onCancel();
        goto L24
    L22:
        if (r3 != this.mButtonNeutral) goto L24;
        r1.onNeural();
        goto L24
    L5:
        if (r3 != this.mButtonPositive) goto L8;
        r0.onConfirm();
        goto L24
    L8:
        if (r3 != this.mButtonNegative) goto L11;
        r0.onCancel();
        goto L24
    L11:
        if (r3 != this.mButtonNeutral) goto L24;
        r0.onNeural();
        goto L24
    }

    @Deprecated
    public void setcallbacklistener(CallbackListener r1) {
        this.mCallback = r1;
    }

    public void setCallbackListener(BytedancePopupWindowInterface.CallbackListener r1) {
        this.mOnClickCallbackListener = r1;
    }
}
