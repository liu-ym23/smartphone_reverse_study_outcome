package androidx.slice.builders;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.core.SliceActionImpl;

/* JADX INFO: loaded from: classes.dex */
public class SliceAction implements androidx.slice.core.SliceAction {
    private SliceActionImpl mSliceAction;

    @Override // androidx.slice.core.SliceAction
    public /* bridge */ /* synthetic */ androidx.slice.core.SliceAction setChecked(boolean r1) {
        return setChecked(r1);
    }

    @Override // androidx.slice.core.SliceAction
    public /* bridge */ /* synthetic */ androidx.slice.core.SliceAction setContentDescription(CharSequence r1) {
        return setContentDescription(r1);
    }

    @Override // androidx.slice.core.SliceAction
    public /* bridge */ /* synthetic */ androidx.slice.core.SliceAction setPriority(int r1) {
        return setPriority(r1);
    }

    public SliceAction(PendingIntent r2, Icon r3, CharSequence r4) {
        this(r2, r3, 0, r4);
    }

    public SliceAction(PendingIntent r1, Icon r2, int r3, CharSequence r4) {
        this(r1, IconCompat.createFromIcon(r2), r3, r4);
    }

    public SliceAction(PendingIntent r1, Icon r2, CharSequence r3, boolean r4) {
        this(r1, IconCompat.createFromIcon(r2), r3, r4);
    }

    public SliceAction(PendingIntent r2, IconCompat r3, CharSequence r4) {
        this(r2, r3, 0, r4);
    }

    public SliceAction(PendingIntent r2, IconCompat r3, int r4, CharSequence r5) {
        this.mSliceAction = new SliceActionImpl(r2, r3, r4, r5);
    }

    public SliceAction(PendingIntent r2, IconCompat r3, CharSequence r4, boolean r5) {
        this.mSliceAction = new SliceActionImpl(r2, r3, r4, r5);
    }

    public SliceAction(PendingIntent r2, CharSequence r3, boolean r4) {
        this.mSliceAction = new SliceActionImpl(r2, r3, r4);
    }

    public static SliceAction create(PendingIntent r1, IconCompat r2, int r3, CharSequence r4) {
        return new SliceAction(r1, r2, r3, r4);
    }

    public static SliceAction createDeeplink(PendingIntent r1, IconCompat r2, int r3, CharSequence r4) {
        SliceAction r0 = new SliceAction(r1, r2, r3, r4);
        r0.mSliceAction.setActivity(true);
        return r0;
    }

    public static SliceAction createToggle(PendingIntent r1, CharSequence r2, boolean r3) {
        return new SliceAction(r1, r2, r3);
    }

    public static SliceAction createToggle(PendingIntent r1, IconCompat r2, CharSequence r3, boolean r4) {
        return new SliceAction(r1, r2, r3, r4);
    }

    @Override // androidx.slice.core.SliceAction
    public SliceAction setContentDescription(CharSequence r2) {
        this.mSliceAction.setContentDescription(r2);
        return this;
    }

    @Override // androidx.slice.core.SliceAction
    public SliceAction setChecked(boolean r2) {
        this.mSliceAction.setChecked(r2);
        return this;
    }

    @Override // androidx.slice.core.SliceAction
    public SliceAction setPriority(int r2) {
        this.mSliceAction.setPriority(r2);
        return this;
    }

    @Override // androidx.slice.core.SliceAction
    public PendingIntent getAction() {
        return this.mSliceAction.getAction();
    }

    @Override // androidx.slice.core.SliceAction
    public IconCompat getIcon() {
        return this.mSliceAction.getIcon();
    }

    @Override // androidx.slice.core.SliceAction
    public CharSequence getTitle() {
        return this.mSliceAction.getTitle();
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isActivity() {
        return this.mSliceAction.isActivity();
    }

    @Override // androidx.slice.core.SliceAction
    public CharSequence getContentDescription() {
        return this.mSliceAction.getContentDescription();
    }

    @Override // androidx.slice.core.SliceAction
    public int getPriority() {
        return this.mSliceAction.getPriority();
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isToggle() {
        return this.mSliceAction.isToggle();
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isChecked() {
        return this.mSliceAction.isChecked();
    }

    @Override // androidx.slice.core.SliceAction
    public int getImageMode() {
        return this.mSliceAction.getImageMode();
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isDefaultToggle() {
        return this.mSliceAction.isDefaultToggle();
    }

    public Slice buildSlice(Slice.Builder r1) {
        return this.mSliceAction.buildSlice(r1);
    }

    public SliceActionImpl getImpl() {
        return this.mSliceAction;
    }

    public void setPrimaryAction(Slice.Builder r3) {
        r3.addAction(this.mSliceAction.getAction(), this.mSliceAction.buildPrimaryActionSlice(r3), this.mSliceAction.getSubtype());
    }
}
