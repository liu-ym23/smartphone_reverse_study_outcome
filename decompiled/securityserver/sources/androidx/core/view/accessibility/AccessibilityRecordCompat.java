package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    @Deprecated
    public AccessibilityRecordCompat(Object r1) {
        this.mRecord = (AccessibilityRecord) r1;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat r1) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(r1.mRecord));
    }

    @Deprecated
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AccessibilityRecordCompat) == true) goto L8;
        return false;
    L8:
        AccessibilityRecordCompat r5 = (AccessibilityRecordCompat) r4;
        AccessibilityRecord r3 = this.mRecord;
        if (r3 != null) goto L14;
        if (r5.mRecord == null) goto L16;
        return false;
    L16:
        return true;
    L14:
        if (r3.equals(r5.mRecord) == true) goto L16;
        return false;
    }

    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord r0 = this.mRecord;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated
    public void setAddedCount(int r1) {
        this.mRecord.setAddedCount(r1);
    }

    @Deprecated
    public void setBeforeText(CharSequence r1) {
        this.mRecord.setBeforeText(r1);
    }

    @Deprecated
    public void setChecked(boolean r1) {
        this.mRecord.setChecked(r1);
    }

    @Deprecated
    public void setClassName(CharSequence r1) {
        this.mRecord.setClassName(r1);
    }

    @Deprecated
    public void setContentDescription(CharSequence r1) {
        this.mRecord.setContentDescription(r1);
    }

    @Deprecated
    public void setCurrentItemIndex(int r1) {
        this.mRecord.setCurrentItemIndex(r1);
    }

    @Deprecated
    public void setEnabled(boolean r1) {
        this.mRecord.setEnabled(r1);
    }

    @Deprecated
    public void setFromIndex(int r1) {
        this.mRecord.setFromIndex(r1);
    }

    @Deprecated
    public void setFullScreen(boolean r1) {
        this.mRecord.setFullScreen(r1);
    }

    @Deprecated
    public void setItemCount(int r1) {
        this.mRecord.setItemCount(r1);
    }

    @Deprecated
    public void setMaxScrollX(int r1) {
        setMaxScrollX(this.mRecord, r1);
    }

    @Deprecated
    public void setMaxScrollY(int r1) {
        setMaxScrollY(this.mRecord, r1);
    }

    @Deprecated
    public void setParcelableData(Parcelable r1) {
        this.mRecord.setParcelableData(r1);
    }

    @Deprecated
    public void setPassword(boolean r1) {
        this.mRecord.setPassword(r1);
    }

    @Deprecated
    public void setRemovedCount(int r1) {
        this.mRecord.setRemovedCount(r1);
    }

    @Deprecated
    public void setScrollX(int r1) {
        this.mRecord.setScrollX(r1);
    }

    @Deprecated
    public void setScrollY(int r1) {
        this.mRecord.setScrollY(r1);
    }

    @Deprecated
    public void setScrollable(boolean r1) {
        this.mRecord.setScrollable(r1);
    }

    @Deprecated
    public void setSource(View r1) {
        this.mRecord.setSource(r1);
    }

    @Deprecated
    public void setToIndex(int r1) {
        this.mRecord.setToIndex(r1);
    }

    public static int getMaxScrollX(AccessibilityRecord r0) {
        return r0.getMaxScrollX();
    }

    public static int getMaxScrollY(AccessibilityRecord r0) {
        return r0.getMaxScrollY();
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(AccessibilityRecord r0, int r1) {
        r0.setMaxScrollX(r1);
    }

    public static void setMaxScrollY(AccessibilityRecord r0, int r1) {
        r0.setMaxScrollY(r1);
    }

    @Deprecated
    public void setSource(View r1, int r2) {
        setSource(this.mRecord, r1, r2);
    }

    public static void setSource(@NonNull AccessibilityRecord r0, View r1, int r2) {
        r0.setSource(r1, r2);
    }
}
