package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TitleSummaryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u000267B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\u0013\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\rJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003J\u0006\u0010!\u001a\u00020\u000fJ\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\n\u0010%\u001a\u0004\u0018\u00010$H\u0014J\u000e\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fJ\u001b\u0010'\u001a\u00020 2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010)J\u001b\u0010*\u001a\u00020 2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010)J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\u0013J\u000e\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\rJ\u0010\u00105\u001a\u00020 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/android/settings/TitleSummaryItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mEntries", "", "", "[Ljava/lang/CharSequence;", "mEntryValues", "mInputMethodMethod", "", "mIsChecked", "", "mSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "mText", "", "mType", "mValue", "findIndexOfValue", "value", "getEntries", "()[Ljava/lang/CharSequence;", "getEntryValues", "getInputMethodType", "getText", "getType", "getValue", "init", "", EntriesProvider.METHOD_IS_CHECKED, "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setChecked", "setEntries", "entries", "([Ljava/lang/CharSequence;)V", "setEntryValues", "entryValues", "setInputMethodType", "inputMethodType", "setOnCheckedChangeListener", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setText", "text", "setType", "type", "setValue", "Companion", "SavedState", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TitleSummaryItem extends OCardListItem {
    public static final Companion Companion = null;
    public static final int TYPE_CHECKBOX = 2;
    public static final int TYPE_EDIT = 0;
    public static final int TYPE_LIST = 1;
    public static final int TYPE_SWITCH = 3;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private int mInputMethodMethod;
    private boolean mIsChecked;
    private OSwitch mSwitch;
    private String mText;
    private int mType;
    private String mValue;

    /* JADX INFO: compiled from: TitleSummaryItem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/settings/TitleSummaryItem$Companion;", "", "()V", "TYPE_CHECKBOX", "", "TYPE_EDIT", "TYPE_LIST", "TYPE_SWITCH", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: TitleSummaryItem.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/android/settings/TitleSummaryItem$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "writeToParcel", "", "out", BaseIconCache.IconDB.COLUMN_FLAGS, "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public static final Companion Companion = null;
        private String text;

        /* JADX INFO: compiled from: TitleSummaryItem.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/settings/TitleSummaryItem$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/android/settings/TitleSummaryItem$SavedState;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String r1) {
            this.text = r1;
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.text = r2.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "out");
            super.writeToParcel(r2, r3);
            r2.writeString(this.text);
        }

        static {
            Companion = new Companion(null);
            CREATOR = new TitleSummaryItem$SavedState$Companion$CREATOR$1();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TitleSummaryItem(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ TitleSummaryItem(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public TitleSummaryItem(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        init(r8, r9);
    }

    private final void init(Context r3, AttributeSet r4) {
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.TitleSummaryItem, 0, 0);
        this.mType = r5.getInt(3, 0);
        this.mInputMethodMethod = r5.getInt(2, 0);
        this.mEntries = r5.getTextArray(0);
        this.mEntryValues = r5.getTextArray(1);
        r5.recycle();
        if (this.mType != 3) goto L14;
        View r6 = getCustomEndView();
        if ((r6 instanceof OSwitch) == false) goto L7;
        OSwitch r7 = (OSwitch) r6;
    L8:
        if (r7 == null) goto L15;
        this.mSwitch = r7;
        if (r7 == null) goto L16;
        r7.setChecked(this.mIsChecked);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void setText(String r1) {
        this.mText = r1;
    }

    public final String getText() {
        return this.mText;
    }

    public final void setType(int r1) {
        this.mType = r1;
    }

    public final int getType() {
        return this.mType;
    }

    public final void setInputMethodType(int r1) {
        this.mInputMethodMethod = r1;
    }

    public final int getInputMethodType() {
        return this.mInputMethodMethod;
    }

    public final void setValue(String r1) {
        this.mValue = r1;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final int findIndexOfValue(String r5) {
        if (r5 == null) goto L17;
        CharSequence[] r4 = this.mEntryValues;
        boolean r1 = true;
        if (r4 != null) goto L7;
    L13:
        if (r1 == true) goto L18;
        if (r4 != null) goto L16;
        return -1;
    L16:
        return ArraysKt.indexOf(r4, r5);
    L18:
        return -1;
    L7:
        if (r4.length != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = false;
        goto L13
    L9:
        r2 = false;
        goto L10
    L17:
        return -1;
    }

    public final void setEntries(CharSequence[] r1) {
        this.mEntries = r1;
    }

    public final CharSequence[] getEntries() {
        return this.mEntries;
    }

    public final void setEntryValues(CharSequence[] r1) {
        this.mEntryValues = r1;
    }

    public final CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public final void setChecked(boolean r5) {
        this.mIsChecked = r5;
        boolean r1 = true;
        if (this.mSwitch != null) goto L20;
        View r0 = getCustomEndView();
        if ((r0 instanceof OSwitch) == false) goto L7;
        OSwitch r2 = (OSwitch) r0;
    L8:
        if (r2 == null) goto L20;
        this.mSwitch = r2;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        OSwitch r4 = this.mSwitch;
        if (r4 == null) goto L20;
        r4.setChecked(r5);
        goto L20
    L12:
        if (r2.isChecked() != r5) goto L14;
        r3 = true;
        goto L15
    L7:
        r2 = null;
    L20:
        OSwitch r6 = this.mSwitch;
        if (r6 != null) goto L23;
    L25:
        r1 = false;
    L26:
        if (r1 == true) goto L32;
        OSwitch r7 = this.mSwitch;
        if (r7 == null) goto L33;
        r7.setChecked(r5);
        return;
    L33:
        return;
    L32:
        return;
    L23:
        if (r6.isChecked() != r5) goto L25;
        goto L25
    }

    public final boolean isChecked() {
        return this.mIsChecked;
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (this.mSwitch != null) goto L13;
        View r0 = getCustomEndView();
        if ((r0 instanceof OSwitch) == false) goto L7;
        OSwitch r1 = (OSwitch) r0;
    L8:
        if (r1 == null) goto L13;
        this.mSwitch = r1;
        if (r1 == null) goto L13;
        r1.setChecked(this.mIsChecked);
        goto L13
    L7:
        r1 = null;
    L13:
        OSwitch r2 = this.mSwitch;
        if (r2 == null) goto L17;
        r2.setOnCheckedChangeListener(r3);
        return;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.setText(getText());
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == false) goto L7;
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        if (TextUtils.isEmpty(r3.getText()) == true) goto L9;
        setTitle(r3.getText());
        setSubTitle(r3.getText());
        return;
    L9:
        return;
    L7:
        super.onRestoreInstanceState(r2);
    }
}
