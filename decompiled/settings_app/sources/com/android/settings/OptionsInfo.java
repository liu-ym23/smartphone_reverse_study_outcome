package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.olog.OLog;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OptionsInfo implements Parcelable {
    public static final Parcelable.Creator<OptionsInfo> CREATOR = null;
    private Bundle mExtrasArgs;
    private String[] mOptionEntries;
    private String[] mOptionTipEntries;
    private Object[] mOptionValues;
    private OnSelectListener mSelectListener;
    private String mSettingKey;
    private SaveTargetTable mTargetTable;

    /* JADX INFO: renamed from: com.android.settings.OptionsInfo$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$OptionsInfo$SaveTargetTable = null;

        static {
            int[] r0 = new int[SaveTargetTable.values().length];
            $SwitchMap$com$android$settings$OptionsInfo$SaveTargetTable = r0;
            r0[SaveTargetTable.System.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$settings$OptionsInfo$SaveTargetTable[SaveTargetTable.Secure.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$OptionsInfo$SaveTargetTable[SaveTargetTable.Global.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface OnSelectListener extends Serializable {
        boolean onSelect(int r1);
    }

    public static final enum SaveTargetTable extends Enum<SaveTargetTable> implements Serializable {
        private static final /* synthetic */ SaveTargetTable[] $VALUES = null;
        public static final SaveTargetTable Global = null;
        public static final SaveTargetTable Secure = null;
        public static final SaveTargetTable System = null;

        private static /* synthetic */ SaveTargetTable[] $values() {
            return new SaveTargetTable[]{System, Secure, Global};
        }

        private SaveTargetTable(String r1, int r2) {
            super(r1, r2);
        }

        public static SaveTargetTable valueOf(String r1) {
            return (SaveTargetTable) Enum.valueOf(SaveTargetTable.class, r1);
        }

        public static SaveTargetTable[] values() {
            return (SaveTargetTable[]) $VALUES.clone();
        }

        static {
            System = new SaveTargetTable("System", 0);
            Secure = new SaveTargetTable("Secure", 1);
            Global = new SaveTargetTable("Global", 2);
            $VALUES = $values();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ OptionsInfo(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public OptionsInfo(String[] r1, Object[] r2, OnSelectListener r3) {
        this.mOptionEntries = r1;
        this.mOptionValues = r2;
        this.mSelectListener = r3;
    }

    public OptionsInfo(String[] r2, Object[] r3, SaveTargetTable r4, String r5) {
        this(r2, r3, null);
        this.mTargetTable = r4;
        this.mSettingKey = r5;
    }

    public OptionsInfo(String[] r2, String[] r3, Object[] r4, SaveTargetTable r5, String r6) {
        this(r2, r4, null);
        this.mOptionTipEntries = r3;
        this.mTargetTable = r5;
        this.mSettingKey = r6;
    }

    public void setSelectListener(OnSelectListener r1) {
        this.mSelectListener = r1;
    }

    private boolean saveSettingOption(Context r6, int r7) {
        Object[] r0 = this.mOptionValues;
        boolean r3 = false;
        if (r7 >= r0.length) goto L25;
        Object r8 = r0[r7];
        int r1 = AnonymousClass2.$SwitchMap$com$android$settings$OptionsInfo$SaveTargetTable[this.mTargetTable.ordinal()];
        String r4 = null;
        if (r1 != 1) goto L7;
        ContentResolver r9 = r6.getContentResolver();
        String r2 = this.mSettingKey;
        if (r8 == null) goto L22;
        r4 = r8.toString();
    L22:
        boolean r10 = android.provider.Settings.System.putString(r9, r2, r4);
    L23:
        r3 = r10;
    L24:
        OLog.d("", "save [" + this.mSettingKey + ":  " + r8 + "]  " + r3);
    L26:
        return r3;
    L7:
        if (r1 != 2) goto L9;
        ContentResolver r11 = r6.getContentResolver();
        String r5 = this.mSettingKey;
        if (r8 == null) goto L18;
        r4 = r8.toString();
    L18:
        r10 = android.provider.Settings.Secure.putString(r11, r5, r4);
        goto L23
    L9:
        if (r1 != 3) goto L24;
        ContentResolver r12 = r6.getContentResolver();
        String r13 = this.mSettingKey;
        if (r8 == null) goto L14;
        r4 = r8.toString();
    L14:
        r10 = android.provider.Settings.Global.putString(r12, r13, r4);
        goto L23
    L25:
        OLog.w("", "warning: ArrayIndexOutOfBounds exception ?");
        goto L26
    }

    public boolean save(Context r2, int r3) {
        if (this.mSettingKey != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L13;
        OnSelectListener r1 = this.mSelectListener;
        if (r1 != null) goto L12;
        return r4;
    L12:
        return r1.onSelect(r3);
    L13:
        return r4;
    L5:
        if (this.mTargetTable == null) goto L7;
        r4 = saveSettingOption(r2, r3);
        goto L8
    }

    public String[] getOptionEntries() {
        return this.mOptionEntries;
    }

    public String[] getOptionTipEntries() {
        return this.mOptionTipEntries;
    }

    public Object[] getOptionValues() {
        return this.mOptionValues;
    }

    public Bundle getExtrasArgs() {
        return this.mExtrasArgs;
    }

    public void setExtrasArgs(Bundle r1) {
        this.mExtrasArgs = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mOptionEntries.length);
        r1.writeStringArray(this.mOptionEntries);
        String[] r3 = this.mOptionTipEntries;
        if (r3 != null) goto L5;
        r1.writeInt(0);
    L6:
        r1.writeInt(this.mOptionValues.length);
        r1.writeArray(this.mOptionValues);
        r1.writeString(this.mSettingKey);
        r1.writeSerializable(this.mTargetTable);
        r1.writeSerializable(this.mSelectListener);
        r1.writeBundle(this.mExtrasArgs);
        return;
    L5:
        r1.writeInt(r3.length);
        r1.writeStringArray(this.mOptionTipEntries);
        goto L6
    }

    private OptionsInfo(Parcel r2) {
        String[] r0 = new String[r2.readInt()];
        this.mOptionEntries = r0;
        r2.readStringArray(r0);
        int r1 = r2.readInt();
        if (r1 != 0) goto L5;
        this.mOptionTipEntries = null;
    L6:
        r2.readInt();
        this.mOptionValues = r2.readArray(Object.class.getClassLoader());
        this.mSettingKey = r2.readString();
        this.mTargetTable = (SaveTargetTable) r2.readSerializable();
        this.mSelectListener = (OnSelectListener) r2.readSerializable();
        this.mExtrasArgs = r2.readBundle(Object.class.getClassLoader());
        return;
    L5:
        String[] r3 = new String[r1];
        this.mOptionTipEntries = r3;
        r2.readStringArray(r3);
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
