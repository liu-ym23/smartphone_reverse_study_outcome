package com.android.settings.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.android.internal.logging.MetricsLogger;
import com.android.settings.R;
import com.android.settingslib.RestrictedLockUtils;
import java.util.ArrayList;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class SwitchBar extends LinearLayout implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_SWITCH = 1;
    private static int[] XML_ATTRIBUTES;
    private boolean mDisabledByAdmin;
    private RestrictedLockUtils.EnforcedAdmin mEnforcedAdmin;
    private String mLabel;
    private String mMetricsTag;
    private View mRestrictedIcon;
    private String mSummary;
    private final TextAppearanceSpan mSummarySpan;
    private ToggleSwitch mSwitch;
    private ArrayList<OnSwitchChangeListener> mSwitchChangeListeners;
    private TextView mTextView;
    private int mType;

    public interface OnSwitchChangeListener {
        void onSwitchChanged(Switch r1, boolean r2);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;
        boolean visible;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        private SavedState(Parcel r3) {
            super(r3);
            this.checked = ((Boolean) r3.readValue(null)).booleanValue();
            this.visible = ((Boolean) r3.readValue(null)).booleanValue();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeValue(Boolean.valueOf(this.checked));
            r1.writeValue(Boolean.valueOf(this.visible));
        }

        public String toString() {
            return "SwitchBar.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.checked + " visible=" + this.visible + VectorFormat.DEFAULT_SUFFIX;
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static {
        XML_ATTRIBUTES = new int[]{R.attr.switchBarMarginStart, R.attr.switchBarMarginEnd, R.attr.switchBarBackgroundColor};
    }

    public SwitchBar(Context r2) {
        this(r2, null);
    }

    public SwitchBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SwitchBar(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public SwitchBar(Context r5, AttributeSet r6, int r7, int r8) {
        super(r5, r6, r7, r8);
        this.mDisabledByAdmin = false;
        this.mEnforcedAdmin = null;
        this.mType = 0;
        this.mSwitchChangeListeners = new ArrayList();
        LayoutInflater.from(r5).inflate(R.layout.switch_bar, this);
        TypedArray r9 = r5.obtainStyledAttributes(r6, XML_ATTRIBUTES);
        int r10 = (int) r9.getDimension(0, 0.0f);
        int r11 = (int) r9.getDimension(1, 0.0f);
        int r1 = r9.getColor(2, 0);
        r9.recycle();
        TextView r12 = (TextView) findViewById(R.id.switch_text);
        this.mTextView = r12;
        r12.setImportantForAccessibility(2);
        this.mLabel = getResources().getString(R.string.switch_off_text);
        this.mSummarySpan = new TextAppearanceSpan(this.mContext, R.style.TextAppearance_Small_SwitchBar);
        updateText();
        ((ViewGroup.MarginLayoutParams) this.mTextView.getLayoutParams()).setMarginStart(r10);
        ToggleSwitch r13 = (ToggleSwitch) findViewById(R.id.switch_widget);
        this.mSwitch = r13;
        r13.setSaveEnabled(false);
        this.mSwitch.setImportantForAccessibility(2);
        ((ViewGroup.MarginLayoutParams) this.mSwitch.getLayoutParams()).setMarginEnd(r11);
        setBackgroundColor(r1);
        this.mSwitch.setBackgroundColor(r1);
        addOnSwitchChangeListener(new AnonymousClass1(this));
        this.mRestrictedIcon = findViewById(R.id.restricted_icon);
        setOnClickListener(this);
        setVisibility(8);
    }

    public void setMetricsTag(String r1) {
        this.mMetricsTag = r1;
    }

    public void setTextViewLabel(boolean r3) {
        if (this.mType != 1) goto L5;
        return;
    L5:
        Resources r0 = getResources();
        if (r3 == false) goto L8;
        int r4 = R.string.switch_on_text;
    L9:
        this.mLabel = r0.getString(r4);
        updateText();
        return;
    L8:
        r4 = R.string.switch_off_text;
        goto L9
    }

    public void setSummary(String r1) {
        this.mSummary = r1;
        updateText();
    }

    public void setType(int r2) {
        this.mType = r2;
        if (r2 != 1) goto L6;
        this.mRestrictedIcon.setVisibility(8);
        return;
    }

    public void setTitle(String r1) {
        this.mLabel = r1;
        updateText();
    }

    private void updateText() {
        if (TextUtils.isEmpty(this.mSummary) == false) goto L6;
        this.mTextView.setText(this.mLabel);
        return;
    L6:
        SpannableStringBuilder r0 = new SpannableStringBuilder(this.mLabel).append('\n');
        int r1 = r0.length();
        r0.append(this.mSummary);
        r0.setSpan(this.mSummarySpan, r1, r0.length(), 0);
        this.mTextView.setText(r0);
    }

    public void setChecked(boolean r1) {
        setTextViewLabel(r1);
        this.mSwitch.setChecked(r1);
    }

    public void setCheckedInternal(boolean r1) {
        setTextViewLabel(r1);
        this.mSwitch.setCheckedInternal(r1);
    }

    public boolean isChecked() {
        return this.mSwitch.isChecked();
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L7:
        super.setEnabled(r2);
        this.mTextView.setEnabled(r2);
        this.mSwitch.setEnabled(r2);
        return;
    L4:
        if (this.mDisabledByAdmin == false) goto L7;
        setDisabledByAdmin(null);
    }

    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r4) {
        this.mEnforcedAdmin = r4;
        if (this.mType != 1) goto L9;
        if (r4 == null) goto L6;
        super.setEnabled(true);
        this.mDisabledByAdmin = true;
        this.mTextView.setEnabled(false);
        this.mSwitch.setEnabled(false);
        return;
    L6:
        this.mDisabledByAdmin = false;
        this.mSwitch.setVisibility(0);
        setEnabled(isEnabled());
        return;
    L9:
        if (r4 == null) goto L11;
        super.setEnabled(true);
        this.mDisabledByAdmin = true;
        this.mTextView.setEnabled(false);
        this.mSwitch.setEnabled(false);
        this.mSwitch.setVisibility(8);
        this.mRestrictedIcon.setVisibility(0);
        return;
    L11:
        this.mDisabledByAdmin = false;
        this.mSwitch.setVisibility(0);
        this.mRestrictedIcon.setVisibility(8);
        setEnabled(true);
    }

    public final ToggleSwitch getSwitch() {
        return this.mSwitch;
    }

    public void show() {
        if (isShowing() == true) goto L9;
        setVisibility(0);
        if (this.mType != 1) goto L7;
        this.mSwitch.setVisibility(0);
    L7:
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    }

    public void hide() {
        if (isShowing() == false) goto L9;
        setVisibility(8);
        if (this.mType != 1) goto L7;
        this.mSwitch.setVisibility(8);
    L7:
        this.mSwitch.setOnCheckedChangeListener(null);
        return;
    }

    public boolean isShowing() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (this.mDisabledByAdmin == false) goto L5;
        MetricsLogger.count(this.mContext, this.mMetricsTag + "/switch_bar|restricted", 1);
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, this.mEnforcedAdmin);
        return;
    L5:
        boolean r6 = !this.mSwitch.isChecked();
        MetricsLogger.count(this.mContext, this.mMetricsTag + "/switch_bar|" + r6, 1);
        setChecked(r6);
    }

    public void propagateChecked(boolean r5) {
        int r0 = this.mSwitchChangeListeners.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mSwitchChangeListeners.get(r1).onSwitchChanged(this.mSwitch, r5);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        propagateChecked(r2);
    }

    public void addOnSwitchChangeListener(OnSwitchChangeListener r2) {
        if (this.mSwitchChangeListeners.contains(r2) == true) goto L7;
        this.mSwitchChangeListeners.add(r2);
        return;
    L7:
        throw new IllegalStateException("Cannot add twice the same OnSwitchChangeListener");
    }

    public void removeOnSwitchChangeListener(OnSwitchChangeListener r2) {
        if (this.mSwitchChangeListeners.contains(r2) == false) goto L7;
        this.mSwitchChangeListeners.remove(r2);
        return;
    L7:
        throw new IllegalStateException("Cannot remove OnSwitchChangeListener");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.checked = this.mSwitch.isChecked();
        r1.visible = isShowing();
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        this.mSwitch.setCheckedInternal(r4.checked);
        setTextViewLabel(r4.checked);
        if (r4.visible == false) goto L5;
        int r0 = 0;
    L6:
        setVisibility(r0);
        ToggleSwitch r1 = this.mSwitch;
        if (r4.visible == false) goto L9;
        SwitchBar r5 = this;
    L10:
        r1.setOnCheckedChangeListener(r5);
        requestLayout();
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r0 = 8;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Switch.class.getName();
    }

    public void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfoInternal(r2);
        r2.setText(this.mTextView.getText());
        r2.setCheckable(true);
        r2.setChecked(this.mSwitch.isChecked());
    }

    public void onInitializeAccessibilityEventInternal(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEventInternal(r2);
        r2.setContentDescription(this.mTextView.getText());
        r2.setChecked(this.mSwitch.isChecked());
    }
}
