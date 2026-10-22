package com.obric.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class OSettingItemSwitch extends OListItemGeneral {
    public static final int BG_STYLE_BOTTOM = 4;
    public static final int BG_STYLE_MIDDLE = 3;
    public static final int BG_STYLE_SINGLE = 1;
    public static final int BG_STYLE_TOP = 2;
    private final OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isChecked;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.isChecked = ((Boolean) r2.readValue(null)).booleanValue();
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeValue(Boolean.valueOf(this.isChecked));
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public void setBackgroundStyle(int r1) {
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(OSettingItemSwitch r0) {
        return r0.mOnCheckedChangeListener;
    }

    public OSettingItemSwitch(Context r5, AttributeSet r6) {
        super(r5, r6);
        OSwitch r7 = new OSwitch(r5);
        this.mOSwitch = r7;
        r7.setOnCheckedChangeListener(new AnonymousClass1(this));
        r7.setClickable(true);
        LinearLayout r1 = new LinearLayout(r5);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        int r8 = (int) TypedValue.applyDimension(1, 4.0f, r5.getResources().getDisplayMetrics());
        r2.leftMargin = r8;
        r2.rightMargin = r8;
        r1.setLayoutParams(r2);
        r1.addView(r7, r2);
        setTrailingView(r1);
        setClickable(false);
        setFocusable(false);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnCheckedChangeListener = r1;
    }

    public void setChecked(boolean r3) {
        CompoundButton.OnCheckedChangeListener r0 = this.mOnCheckedChangeListener;
        this.mOnCheckedChangeListener = null;
        this.mOSwitch.setChecked(r3);
        this.mOnCheckedChangeListener = r0;
    }

    public boolean isChecked() {
        return this.mOSwitch.isChecked();
    }

    public OSwitch getSwitch() {
        return this.mOSwitch;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.mOSwitch.setEnabled(r2);
        this.mOSwitch.setAlpha(1.0f);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.isChecked = isChecked();
        return r0;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setChecked(r3.isChecked);
        requestLayout();
    }

    public void setTitle(String r1) {
        setTitleString(r1);
    }

    public void setTitle(int r2) {
        setTitle(getContext().getString(r2));
    }
}
