package androidx.slice.widget;

import android.R;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceActionImpl;

/* JADX INFO: loaded from: classes.dex */
public class SliceActionView extends FrameLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static final int[] STATE_CHECKED = null;
    private static final String TAG = "SliceActionView";
    private View mActionView;
    private EventInfo mEventInfo;
    private int mIconSize;
    private int mImageSize;
    private SliceActionLoadingListener mLoadingListener;
    private SliceView.OnSliceActionListener mObserver;
    private ProgressBar mProgressView;
    private SliceActionImpl mSliceAction;

    private static class ImageToggle extends ImageView implements Checkable, View.OnClickListener {
        private boolean mIsChecked;
        private View.OnClickListener mListener;

        ImageToggle(Context r1) {
            super(r1);
            super.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            toggle();
        }

        @Override // android.widget.Checkable
        public void toggle() {
            setChecked(!isChecked());
        }

        @Override // android.widget.Checkable
        public void setChecked(boolean r2) {
            if (this.mIsChecked == r2) goto L8;
            this.mIsChecked = r2;
            refreshDrawableState();
            View.OnClickListener r3 = this.mListener;
            if (r3 == null) goto L9;
            r3.onClick(this);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener r1) {
            this.mListener = r1;
        }

        @Override // android.widget.Checkable
        public boolean isChecked() {
            return this.mIsChecked;
        }

        @Override // android.widget.ImageView, android.view.View
        public int[] onCreateDrawableState(int r1) {
            int[] r2 = super.onCreateDrawableState(r1 + 1);
            if (this.mIsChecked == false) goto L5;
            mergeDrawableStates(r2, SliceActionView.STATE_CHECKED);
        L5:
            return r2;
        }
    }

    interface SliceActionLoadingListener {
        void onSliceActionLoading(SliceItem r1, int r2);
    }

    static {
        STATE_CHECKED = new int[]{R.attr.state_checked};
    }

    public SliceActionView(Context r2) {
        super(r2);
        Resources r3 = getContext().getResources();
        this.mIconSize = r3.getDimensionPixelSize(androidx.slice.view.R.dimen.abc_slice_icon_size);
        this.mImageSize = r3.getDimensionPixelSize(androidx.slice.view.R.dimen.abc_slice_small_image_size);
    }

    public void setAction(SliceActionImpl r3, EventInfo r4, SliceView.OnSliceActionListener r5, int r6, SliceActionLoadingListener r7) {
        View r0 = this.mActionView;
        if (r0 == null) goto L5;
        removeView(r0);
        this.mActionView = null;
    L5:
        View r1 = this.mProgressView;
        if (r1 == null) goto L8;
        removeView(r1);
        this.mProgressView = null;
    L8:
        this.mSliceAction = r3;
        this.mEventInfo = r4;
        this.mObserver = r5;
        this.mActionView = null;
        this.mLoadingListener = r7;
        int r8 = 0;
        if (r3.isDefaultToggle() == false) goto L15;
        Switch r9 = (Switch) LayoutInflater.from(getContext()).inflate(androidx.slice.view.R.layout.abc_slice_switch, this, false);
        addView(r9);
        r9.setChecked(r3.isChecked());
        r9.setOnCheckedChangeListener(this);
        r9.setMinimumHeight(this.mImageSize);
        r9.setMinimumWidth(this.mImageSize);
        if (r6 == (-1)) goto L13;
        Drawable r10 = DrawableCompat.wrap(r9.getTrackDrawable());
        DrawableCompat.setTint(r10, r6);
        r9.setTrackDrawable(r10);
        Drawable r11 = DrawableCompat.wrap(r9.getThumbDrawable());
        DrawableCompat.setTint(r11, r6);
        r9.setThumbDrawable(r11);
    L13:
        this.mActionView = r9;
    L31:
        if (this.mActionView != null) goto L33;
        return;
    L33:
        if (r3.getContentDescription() == null) goto L35;
        CharSequence r12 = r3.getContentDescription();
    L36:
        this.mActionView.setContentDescription(r12);
        return;
    L35:
        r12 = r3.getTitle();
        goto L36
    L15:
        if (r3.getIcon() == null) goto L31;
        if (r3.isToggle() == false) goto L19;
        ImageToggle r13 = new ImageToggle(getContext());
        r13.setChecked(r3.isChecked());
        this.mActionView = r13;
    L20:
        addView(this.mActionView);
        Drawable r14 = this.mSliceAction.getIcon().loadDrawable(getContext());
        ((ImageView) this.mActionView).setImageDrawable(r14);
        if (r6 != (-1)) goto L23;
    L26:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) this.mActionView.getLayoutParams();
        r15.width = this.mImageSize;
        r15.height = this.mImageSize;
        this.mActionView.setLayoutParams(r15);
        if (r3.getImageMode() != 0) goto L29;
        r8 = this.mIconSize / 2;
    L29:
        this.mActionView.setPadding(r8, r8, r8, r8);
        this.mActionView.setBackground(SliceViewUtil.getDrawable(getContext(), R.attr.selectableItemBackgroundBorderless));
        this.mActionView.setOnClickListener(this);
        goto L31
    L23:
        if (this.mSliceAction.getImageMode() != 0) goto L26;
        if (r14 == null) goto L26;
        DrawableCompat.setTint(r14, r6);
        goto L26
    L19:
        this.mActionView = new ImageView(getContext());
        goto L20
    }

    public void setLoading(boolean r5) {
        int r0 = 0;
        if (r5 == true) goto L5;
    L8:
        View r1 = this.mActionView;
        if (r5 == false) goto L11;
        int r3 = 8;
    L12:
        r1.setVisibility(r3);
        ProgressBar r4 = this.mProgressView;
        if (r5 == true) goto L16;
        r0 = 8;
    L16:
        r4.setVisibility(r0);
        return;
    L11:
        r3 = 0;
        goto L12
    L5:
        if (this.mProgressView != null) goto L7;
        ProgressBar r2 = (ProgressBar) LayoutInflater.from(getContext()).inflate(androidx.slice.view.R.layout.abc_slice_progress_view, this, false);
        this.mProgressView = r2;
        addView(r2);
    L7:
        SliceViewUtil.tintIndeterminateProgressBar(getContext(), this.mProgressView);
        goto L8
    }

    public void toggle() {
        if (this.mActionView == null) goto L10;
        SliceActionImpl r0 = this.mSliceAction;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isToggle() == false) goto L12;
        ((Checkable) this.mActionView).toggle();
        return;
    L12:
        return;
    }

    public SliceActionImpl getAction() {
        return this.mSliceAction;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        if (this.mSliceAction != null) goto L5;
        return;
    L5:
        if (this.mActionView == null) goto L10;
        sendActionInternal();
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (this.mSliceAction != null) goto L5;
        return;
    L5:
        if (this.mActionView == null) goto L10;
        sendActionInternal();
        return;
    }

    public void sendAction() {
        SliceActionImpl r0 = this.mSliceAction;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isToggle() == false) goto L8;
        toggle();
        return;
    L8:
        sendActionInternal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void sendActionInternal() {
        SliceActionImpl r0 = this.mSliceAction;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getActionItem() != null) goto L38;
        return;
    L38:
    L32:
        e = move-exception;
        View r4 = this.mActionView;
        if ((r4 instanceof Checkable) == false) goto L36;
        r4.setSelected(true ^ ((Checkable) r4).isChecked());
    L36:
        Log.e(TAG, "PendingIntent for slice cannot be sent", e);
        return;
    L9:
        if (this.mSliceAction.isToggle() == false) goto L16;
        boolean r1 = ((Checkable) this.mActionView).isChecked();     // Catch: PendingIntent.CanceledException -> L32
        Intent r2 = new Intent().addFlags(268435456).putExtra("android.app.slice.extra.TOGGLE_STATE", r1);     // Catch: PendingIntent.CanceledException -> L32
        EventInfo r3 = this.mEventInfo;     // Catch: PendingIntent.CanceledException -> L32
        if (r3 == null) goto L18;
        if (r1 == false) goto L14;
        int r5 = 1;
    L15:
        r3.state = r5;     // Catch: PendingIntent.CanceledException -> L32
        goto L18
    L14:
        r5 = 0;
    L18:
        if (this.mSliceAction.getActionItem().fireActionInternal(getContext(), r2) == false) goto L26;
        setLoading(true);     // Catch: PendingIntent.CanceledException -> L32
        if (this.mLoadingListener == null) goto L26;
        EventInfo r6 = this.mEventInfo;     // Catch: PendingIntent.CanceledException -> L32
        if (r6 == null) goto L24;
        int r7 = r6.rowIndex;     // Catch: PendingIntent.CanceledException -> L32
    L25:
        this.mLoadingListener.onSliceActionLoading(this.mSliceAction.getSliceItem(), r7);     // Catch: PendingIntent.CanceledException -> L32
        goto L26
    L24:
        r7 = -1;
    L26:
        SliceView.OnSliceActionListener r8 = this.mObserver;     // Catch: PendingIntent.CanceledException -> L32
        if (r8 == null) goto L41;
        EventInfo r9 = this.mEventInfo;     // Catch: PendingIntent.CanceledException -> L32
        if (r9 == null) goto L42;
        r8.onSliceAction(r9, this.mSliceAction.getSliceItem());     // Catch: PendingIntent.CanceledException -> L32
        return;
    L42:
        return;
    L41:
        return;
    L16:
        r2 = null;
        goto L18
    }
}
