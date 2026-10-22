package com.qihoo360.mobilesafe.common.ui.btn;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn;
import com.qihoo360.mobilesafe.common.ui.ripple.CommonRippleButton;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonButton extends CommonRippleButton implements IBtn {

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.common.ui.btn.CommonButton$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle = null;

        static {
            int[] r0 = new int[BtnStyle.values().length];
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle = r0;
            r0[BtnStyle.BTN_STYLE_A_GREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle[BtnStyle.BTN_STYLE_B_GREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle[BtnStyle.BTN_STYLE_C_GRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle[BtnStyle.BTN_STYLE_D_GRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle[BtnStyle.BTN_STYLE_F_BLUE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum BtnStyle extends Enum<BtnStyle> {
        private static final /* synthetic */ BtnStyle[] $VALUES = null;
        public static final BtnStyle BTN_STYLE_A_GREEN = null;
        public static final BtnStyle BTN_STYLE_B_GREEN = null;
        public static final BtnStyle BTN_STYLE_C_GRAY = null;
        public static final BtnStyle BTN_STYLE_D_GRAY = null;
        public static final BtnStyle BTN_STYLE_F_BLUE = null;

        private BtnStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static BtnStyle valueOf(String r1) {
            return (BtnStyle) Enum.valueOf(BtnStyle.class, r1);
        }

        public static BtnStyle[] values() {
            return (BtnStyle[]) $VALUES.clone();
        }

        static {
            BtnStyle r0 = new BtnStyle("BTN_STYLE_A_GREEN", 0);
            BTN_STYLE_A_GREEN = r0;
            BtnStyle r1 = new BtnStyle("BTN_STYLE_B_GREEN", 1);
            BTN_STYLE_B_GREEN = r1;
            BtnStyle r3 = new BtnStyle("BTN_STYLE_C_GRAY", 2);
            BTN_STYLE_C_GRAY = r3;
            BtnStyle r5 = new BtnStyle("BTN_STYLE_D_GRAY", 3);
            BTN_STYLE_D_GRAY = r5;
            BtnStyle r7 = new BtnStyle("BTN_STYLE_F_BLUE", 4);
            BTN_STYLE_F_BLUE = r7;
            $VALUES = new BtnStyle[]{r0, r1, r3, r5, r7};
        }
    }

    public CommonButton(Context r1) {
        super(r1);
        intiView();
    }

    public CommonButton(Context r2, AttributeSet r3) {
        super(r2, r3);
        int r4 = CommonUtils.getTextSizeFromAttrs(r2, r3);
        if (r4 == 0) goto L5;
        setTextSize(0, r4);
    L6:
        intiView();
        return;
    L5:
        setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.inner_common_font_size_f));
        goto L6
    }

    private void intiView() {
        setGravity(17);
        setMinWidth(getResources().getDimensionPixelOffset(R.dimen.inner_common_dimen_50dp));
    }

    public void parseStyleToButton(int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r5, R.styleable.Btn);
        setBackgroundDrawable(r6.getDrawable(R.styleable.Btn_btnBackground));
        setTextColor(r6.getColorStateList(R.styleable.Btn_btnTextColor));
        setPadding(r6.getDimensionPixelOffset(R.styleable.Btn_btnPaddingLeft, getPaddingLeft()), getPaddingTop(), r6.getDimensionPixelOffset(R.styleable.Btn_btnPaddingRight, getPaddingRight()), getPaddingBottom());
        r6.recycle();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn
    public void setUIButtonText(CharSequence r1) {
        setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn
    public void setUIButtonText(int r2) {
        setUIButtonText(getContext().getString(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn
    public void setUIButtonTextColor(int r2) {
        setTextColor(getContext().getResources().getColor(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn
    public void setUIButtonTextSize(int r2) {
        setTextSize(0, getContext().getResources().getDimensionPixelSize(r2));
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn
    public void setUIButtonStyle(BtnStyle r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$qihoo360$mobilesafe$common$ui$btn$CommonButton$BtnStyle[r2.ordinal()];
        if (r3 != 1) goto L5;
        parseStyleToButton(R.style.inner_btn_style_a);
        return;
    L5:
        if (r3 != 2) goto L7;
        parseStyleToButton(R.style.inner_btn_style_b);
        return;
    L7:
        if (r3 != 3) goto L9;
        parseStyleToButton(R.style.inner_btn_style_c);
        return;
    L9:
        if (r3 != 4) goto L11;
        parseStyleToButton(R.style.inner_btn_style_d);
        return;
    L11:
        if (r3 != 5) goto L23;
        parseStyleToButton(R.style.inner_btn_style_f);
        return;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtn
    public void setUIButtonEnable(boolean r1) {
        setEnabled(r1);
    }
}
