package com.android.settings.backup.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: DataBackupItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/backup/data/SettingKeyAccessType;", "", "(Ljava/lang/String;I)V", "SYSTEM", "GLOBAL", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum SettingKeyAccessType extends Enum<SettingKeyAccessType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SettingKeyAccessType[] $VALUES = null;
    public static final SettingKeyAccessType GLOBAL = null;
    public static final SettingKeyAccessType SYSTEM = null;

    private static final /* synthetic */ SettingKeyAccessType[] $values() {
        return new SettingKeyAccessType[]{SYSTEM, GLOBAL};
    }

    public static EnumEntries<SettingKeyAccessType> getEntries() {
        return $ENTRIES;
    }

    public static SettingKeyAccessType valueOf(String r1) {
        return (SettingKeyAccessType) Enum.valueOf(SettingKeyAccessType.class, r1);
    }

    public static SettingKeyAccessType[] values() {
        return (SettingKeyAccessType[]) $VALUES.clone();
    }

    private SettingKeyAccessType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SYSTEM = new SettingKeyAccessType("SYSTEM", 0);
        GLOBAL = new SettingKeyAccessType("GLOBAL", 1);
        SettingKeyAccessType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }
}
