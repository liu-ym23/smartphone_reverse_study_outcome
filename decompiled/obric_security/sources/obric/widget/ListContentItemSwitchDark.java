package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class ListContentItemSwitchDark extends ListContentItemDark {
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private OnDisabledClickListenerDelegate mOnDisabledClickListenerDelegate;
    private LinearLayout mRightSlotView;
    private SettingsSwitchEx mSwitch;

    private static class OnDisabledClickListenerDelegate implements ListContentItem.OnDisabledClickListener {
        private SwitcherCallback mDelegate;

        /* synthetic */ OnDisabledClickListenerDelegate(SwitcherCallback r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$200(OnDisabledClickListenerDelegate r0, SwitcherCallback r1) {
            r0.setDelegate(r1);
        }

        private OnDisabledClickListenerDelegate(SwitcherCallback delegate) {
            setDelegate(delegate);
        }

        private void setDelegate(SwitcherCallback delegate) {
            this.mDelegate = delegate;
        }

        @Override // obric.widget.ListContentItem.OnDisabledClickListener
        public void onDisabledClick() {
            SwitcherCallback r0 = this.mDelegate;
            if (r0 == null) goto L6;
            r0.onDisabledSwitchClicked();
            return;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isChecked;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        private SavedState(Parcel source) {
            super(source);
            this.isChecked = ((Boolean) source.readValue(null)).booleanValue();
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeValue(Boolean.valueOf(this.isChecked));
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public interface SwitcherCallback {
        void onDisabledSwitchClicked();
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(ListContentItemSwitchDark r0) {
        return r0.mOnCheckedChangeListener;
    }

    public ListContentItemSwitchDark(Context context) {
        super(context);
    }

    public ListContentItemSwitchDark(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListContentItemSwitchDark(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.ListContentItemSwitch, defStyleAttr, 0);
        boolean r4 = r3.getBoolean(R.styleable.ListContentItemSwitch_isChecked, false);
        r3.recycle();
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        setClickable(false);
        setFocusable(false);
        this.mSwitch.setChecked(r4);
        this.mSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
        setSaveFromParentEnabled(false);
        setPressable(false);
    }

    @Override // obric.widget.ListContentItemDark, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mSwitch.setSwitchDrawableStyle(2);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public void setChecked(boolean isChecked) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        CompoundButton.OnCheckedChangeListener r0 = this.mOnCheckedChangeListener;
        this.mOnCheckedChangeListener = null;
        this.mSwitch.setChecked(isChecked);
        this.mOnCheckedChangeListener = r0;
    }

    public void setCheckedWithListenerCallback(boolean isChecked) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        this.mSwitch.setChecked(isChecked);
    }

    public boolean isChecked() {
        if (this.mIsCustomRightView == false) goto L7;
        return false;
    L7:
        return this.mSwitch.isChecked();
    }

    public SettingsSwitchEx getSwitch() {
        return this.mSwitch;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        this.mSwitch.setEnabled(enabled);
        if (this.mSummary == null) goto L9;
        this.mSummary.setEnabled(enabled);
    L9:
        if (this.mTitle == null) goto L12;
        this.mTitle.setEnabled(enabled);
        return;
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
        SettingsSwitchEx r0 = (SettingsSwitchEx) findViewById(R.id.switchex);
        this.mSwitch = r0;
        r0.setDarkEnable(true);
        this.mRightSlotView = (LinearLayout) findViewById(R.id.rightExpandView);
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return R.layout.list_content_right_switch_dark;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.isChecked = isChecked();
        return r0;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState r2 = (SavedState) state;
        super.onRestoreInstanceState(r2.getSuperState());
        setChecked(r2.isChecked);
        requestLayout();
    }

    @Deprecated
    public void setSwitcherCallback(SwitcherCallback cb) {
        AnonymousClass1 r0 = null;
        if (cb != null) goto L5;
        this.mOnDisabledClickListenerDelegate = null;
    L9:
        setOnDisabledClickListener(this.mOnDisabledClickListenerDelegate);
        return;
    L5:
        OnDisabledClickListenerDelegate r1 = this.mOnDisabledClickListenerDelegate;
        if (r1 != null) goto L8;
        this.mOnDisabledClickListenerDelegate = new OnDisabledClickListenerDelegate(cb, r0);
        goto L9
    L8:
        OnDisabledClickListenerDelegate.access$200(r1, cb);
        goto L9
    }

    @Override // obric.widget.ListContentItem
    protected boolean shouldHandleDisabledTouchEvent(MotionEvent event) {
        SettingsSwitchEx r0 = getSwitch();
        if (r0 != null) goto L5;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
        Rect r4 = new Rect();
        r0.getGlobalVisibleRect(r4);
        return r4.contains((int) event.getRawX(), (int) event.getRawY());
    L15:
        return false;
    L5:
        if (r0.isEnabled() == true) goto L11;
        if (this.mOnDisabledClickListenerDelegate == null) goto L9;
    L10:
        r3 = true;
        goto L12
    L9:
        if (this.mDisableReasonStringId <= 0) goto L11;
        goto L10
    }

    public void setRightExpandView(View view) {
        if (this.mIsCustomRightView == false) goto L5;
        return;
    L5:
        this.mRightSlotView.removeAllViews();
        if (view == null) goto L8;
        this.mRightSlotView.addView(view);
        this.mRightSlotView.setVisibility(0);
        return;
    L8:
        if (this.mRightSlotView.getVisibility() == 8) goto L12;
        this.mRightSlotView.setVisibility(8);
        return;
    }
}
