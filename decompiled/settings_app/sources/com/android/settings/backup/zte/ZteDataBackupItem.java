package com.android.settings.backup.zte;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.android.settings.backup.data.DataBackupItem;
import com.android.settings.backup.data.SettingKeyAccessType;
import com.android.settings.backup.zte.api.IDataTransfer;
import com.android.settings.backup.zte.api.ILocalStorage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZteDataBackupItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0012J\u001a\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rJ\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/settings/backup/zte/ZteDataBackupItem;", "Lcom/android/settings/backup/data/DataBackupItem;", "Lcom/android/settings/backup/zte/api/ILocalStorage;", "Lcom/android/settings/backup/zte/api/IDataTransfer;", "settingKey", "", "settingValue", "", "settingKeyAccessType", "Lcom/android/settings/backup/data/SettingKeyAccessType;", "xmlKey", "(Ljava/lang/String;Ljava/lang/Object;Lcom/android/settings/backup/data/SettingKeyAccessType;Ljava/lang/String;)V", "mDefValueProvider", "Lkotlin/Function1;", "Landroid/content/Context;", "getXmlValue", "context", "needTransToZte", "", "readStorage", "", "readXmlValue", "xmlValue", "needTransFromZte", "setDefValueProvider", "defValueProvider", "transData", "value", "transFromZte", "transToZte", "writeStorage", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ZteDataBackupItem extends DataBackupItem implements ILocalStorage, IDataTransfer {
    private Function1<? super Context, ? extends Object> mDefValueProvider;

    /* JADX INFO: compiled from: ZteDataBackupItem.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SettingKeyAccessType.values().length];
            r0[SettingKeyAccessType.SYSTEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SettingKeyAccessType.GLOBAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ZteDataBackupItem(String r2, Object r3, SettingKeyAccessType r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "settingKey");
        Intrinsics.checkNotNullParameter(r3, "settingValue");
        Intrinsics.checkNotNullParameter(r4, "settingKeyAccessType");
        Intrinsics.checkNotNullParameter(r5, "xmlKey");
        super(r2, r3, r4, r5);
    }

    public final void setDefValueProvider(Function1<? super Context, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "defValueProvider");
        this.mDefValueProvider = r2;
    }

    public void readStorage(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Function1<? super Context, ? extends Object> r0 = this.mDefValueProvider;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = null;
        if (r0 == null) goto L8;
        Object r2 = r0.invoke(r10);
    L9:
        int r3 = WhenMappings.$EnumSwitchMapping$0[getMSettingKeyAccessType().ordinal()];
        boolean r4 = false;
        if (r3 != 1) goto L12;
        Object r5 = getMSettingValue();
        if ((r5 instanceof Integer) == false) goto L40;
        ContentResolver r11 = r10.getContentResolver();
        String r6 = getMSettingKey();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        Object r12 = Integer.valueOf(Settings.System.getInt(r11, r6, ((Integer) r2).intValue()));
    L59:
        setMSettingValue(r12);
        return;
    L40:
        if ((r5 instanceof Long) == false) goto L43;
        ContentResolver r13 = r10.getContentResolver();
        String r7 = getMSettingKey();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Long");
        r12 = Long.valueOf(Settings.System.getLong(r13, r7, ((Long) r2).longValue()));
        goto L59
    L43:
        if ((r5 instanceof Float) == false) goto L46;
        ContentResolver r14 = r10.getContentResolver();
        String r8 = getMSettingKey();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Float");
        r12 = Float.valueOf(Settings.System.getFloat(r14, r8, ((Float) r2).floatValue()));
        goto L59
    L46:
        if ((r5 instanceof String) == false) goto L58;
        String r15 = Settings.System.getString(r10.getContentResolver(), getMSettingKey());
        if (r15 != null) goto L50;
    L57:
        r12 = String.valueOf(r2);
        goto L59
    L50:
        if (r15.length() <= 0) goto L52;
        r4 = true;
    L52:
        if (r4 == false) goto L54;
        r1 = r15;
    L54:
        if (r1 == null) goto L57;
    L56:
        r12 = r1;
        goto L59
    L58:
        r12 = String.valueOf(r2);
        goto L59
    L12:
        if (r3 != 2) goto L35;
        Object r9 = getMSettingValue();
        if ((r9 instanceof Integer) == false) goto L17;
        ContentResolver r16 = r10.getContentResolver();
        String r17 = getMSettingKey();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        r12 = Integer.valueOf(Settings.Global.getInt(r16, r17, ((Integer) r2).intValue()));
        goto L59
    L17:
        if ((r9 instanceof Long) == false) goto L20;
        ContentResolver r18 = r10.getContentResolver();
        String r19 = getMSettingKey();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Long");
        r12 = Long.valueOf(Settings.Global.getLong(r18, r19, ((Long) r2).longValue()));
        goto L59
    L20:
        if ((r9 instanceof Float) == false) goto L23;
        ContentResolver r110 = r10.getContentResolver();
        String r20 = getMSettingKey();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Float");
        r12 = Float.valueOf(Settings.Global.getFloat(r110, r20, ((Float) r2).floatValue()));
        goto L59
    L23:
        if ((r9 instanceof String) == false) goto L33;
        String r111 = Settings.Global.getString(r10.getContentResolver(), getMSettingKey());
        if (r111 != null) goto L27;
    L32:
        r12 = String.valueOf(r2);
        goto L59
    L27:
        if (r111.length() <= 0) goto L29;
        r4 = true;
    L29:
        if (r4 == false) goto L31;
        r1 = r111;
    L31:
        if (r1 != null) goto L56;
    L33:
        r12 = String.valueOf(r2);
        goto L59
    L35:
        throw new NoWhenBranchMatchedException();
    L8:
        r2 = null;
        goto L9
    }

    public void writeStorage(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        SettingKeyAccessType r0 = getMSettingKeyAccessType();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        Object r2 = getMSettingValue();
        if ((r2 instanceof Integer) == false) goto L23;
        ContentResolver r8 = r7.getContentResolver();
        String r3 = getMSettingKey();
        Object r6 = getMSettingValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Int");
        Settings.System.putInt(r8, r3, ((Integer) r6).intValue());
        return;
    L23:
        if ((r2 instanceof Long) == false) goto L26;
        ContentResolver r9 = r7.getContentResolver();
        String r4 = getMSettingKey();
        Object r10 = getMSettingValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Long");
        Settings.System.putLong(r9, r4, ((Long) r10).longValue());
        return;
    L26:
        if ((r2 instanceof Float) == false) goto L29;
        ContentResolver r11 = r7.getContentResolver();
        String r5 = getMSettingKey();
        Object r12 = getMSettingValue();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Float");
        Settings.System.putFloat(r11, r5, ((Float) r12).floatValue());
        return;
    L29:
        if ((r2 instanceof String) == false) goto L40;
        ContentResolver r13 = r7.getContentResolver();
        String r14 = getMSettingKey();
        Object r15 = getMSettingValue();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.String");
        Settings.System.putString(r13, r14, (String) r15);
        return;
    L40:
        return;
    L5:
        if (r1 != 2) goto L41;
        Object r16 = getMSettingValue();
        if ((r16 instanceof Integer) == false) goto L11;
        ContentResolver r17 = r7.getContentResolver();
        String r18 = getMSettingKey();
        Object r19 = getMSettingValue();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Int");
        Settings.Global.putInt(r17, r18, ((Integer) r19).intValue());
        return;
    L11:
        if ((r16 instanceof Long) == false) goto L14;
        ContentResolver r20 = r7.getContentResolver();
        String r21 = getMSettingKey();
        Object r22 = getMSettingValue();
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Long");
        Settings.Global.putLong(r20, r21, ((Long) r22).longValue());
        return;
    L14:
        if ((r16 instanceof Float) == false) goto L17;
        ContentResolver r23 = r7.getContentResolver();
        String r24 = getMSettingKey();
        Object r25 = getMSettingValue();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Float");
        Settings.Global.putFloat(r23, r24, ((Float) r25).floatValue());
        return;
    L17:
        if ((r16 instanceof String) == false) goto L35;
        ContentResolver r26 = r7.getContentResolver();
        String r27 = getMSettingKey();
        Object r28 = getMSettingValue();
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type kotlin.String");
        Settings.Global.putString(r26, r27, (String) r28);
        return;
    L35:
        return;
    }

    private final void transData(String r3) {
        Object r0 = getMSettingValue();
        if ((r0 instanceof Integer) == false) goto L6;
        setMSettingValue(Integer.valueOf(Integer.parseInt(r3)));
        return;
    L6:
        if ((r0 instanceof Long) == false) goto L9;
        setMSettingValue(Long.valueOf(Long.parseLong(r3)));
        return;
    L9:
        if ((r0 instanceof Float) == false) goto L12;
        setMSettingValue(Float.valueOf(Float.parseFloat(r3)));
        return;
    L12:
        if ((r0 instanceof String) == false) goto L18;
        setMSettingValue(r3);
        return;
    }

    public void transFromZte(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "value");
        transData(r3);
    }

    public String transToZte(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return getMSettingValue().toString();
    }

    public final String getXmlValue(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        readStorage(r2);
        if (r3 == false) goto L6;
        return transToZte(r2);
    L6:
        return getMSettingValue().toString();
    }

    public final void readXmlValue(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "xmlValue");
        if (r4 == false) goto L5;
        transFromZte(r2, r3);
    L6:
        writeStorage(r2);
        return;
    L5:
        transData(r3);
        goto L6
    }
}
