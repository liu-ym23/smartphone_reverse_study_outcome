package com.qihoo360.mobilesafe.common.ui.checkbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.i.checkbox.ICheckBox;

/* JADX INFO: loaded from: classes4.dex */
public class CommonCheckBox extends ImageView implements ICheckBox.ICheckBoxBase {

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.common.ui.checkbox.CommonCheckBox$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$qihoo360$mobilesafe$common$ui$checkbox$CommonCheckBox$CheckBoxStyle = null;

        static {
            int[] r0 = new int[CheckBoxStyle.values().length];
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$checkbox$CommonCheckBox$CheckBoxStyle = r0;
            r0[CheckBoxStyle.CHECK_BOX_STYLE_1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$checkbox$CommonCheckBox$CheckBoxStyle[CheckBoxStyle.CHECK_BOX_STYLE_2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum CheckBoxStyle extends Enum<CheckBoxStyle> {
        private static final /* synthetic */ CheckBoxStyle[] $VALUES = null;
        public static final CheckBoxStyle CHECK_BOX_STYLE_1 = null;
        public static final CheckBoxStyle CHECK_BOX_STYLE_2 = null;

        private CheckBoxStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static CheckBoxStyle valueOf(String r1) {
            return (CheckBoxStyle) Enum.valueOf(CheckBoxStyle.class, r1);
        }

        public static CheckBoxStyle[] values() {
            return (CheckBoxStyle[]) $VALUES.clone();
        }

        static {
            CheckBoxStyle r0 = new CheckBoxStyle("CHECK_BOX_STYLE_1", 0);
            CHECK_BOX_STYLE_1 = r0;
            CheckBoxStyle r1 = new CheckBoxStyle("CHECK_BOX_STYLE_2", 1);
            CHECK_BOX_STYLE_2 = r1;
            $VALUES = new CheckBoxStyle[]{r0, r1};
        }
    }

    public CommonCheckBox(Context r2) {
        this(r2, null);
    }

    public CommonCheckBox(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.checkbox.ICheckBox.ICheckBoxBase
    public void setUICheckBoxStyle(CheckBoxStyle r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$qihoo360$mobilesafe$common$ui$checkbox$CommonCheckBox$CheckBoxStyle[r2.ordinal()];
        if (r3 != 1) goto L5;
        setImageDrawable(getResources().getDrawable(R.drawable.inner_row_checkbox1_selector));
        return;
    L5:
        if (r3 != 2) goto L11;
        setImageDrawable(getResources().getDrawable(R.drawable.inner_row_checkbox2_selector));
        return;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.checkbox.ICheckBox.ICheckBoxBase
    public void setUICheckBoxClickListener(View.OnClickListener r1) {
        setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.checkbox.ICheckBox.ICheckBoxBase
    public void setUICheckBoxChecked(boolean r1) {
        setSelected(r1);
        setDescription(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.checkbox.ICheckBox.ICheckBoxBase
    public boolean isUICheckBoxChecked() {
        return isSelected();
    }

    private void setDescription(boolean r2) {
        if (r2 == false) goto L4;
        Context r3 = getContext();
        int r0 = R.string.common_selected;
    L5:
        setContentDescription(r3.getString(r0));
        return;
    L4:
        r3 = getContext();
        r0 = R.string.common_unselected;
        goto L5
    }
}
