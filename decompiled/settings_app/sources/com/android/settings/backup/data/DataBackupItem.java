package com.android.settings.backup.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataBackupItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u0003R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/android/settings/backup/data/DataBackupItem;", "", "settingKey", "", "settingValue", "settingKeyAccessType", "Lcom/android/settings/backup/data/SettingKeyAccessType;", "xmlKey", "(Ljava/lang/String;Ljava/lang/Object;Lcom/android/settings/backup/data/SettingKeyAccessType;Ljava/lang/String;)V", "mSettingKey", "getMSettingKey", "()Ljava/lang/String;", "setMSettingKey", "(Ljava/lang/String;)V", "mSettingKeyAccessType", "getMSettingKeyAccessType", "()Lcom/android/settings/backup/data/SettingKeyAccessType;", "setMSettingKeyAccessType", "(Lcom/android/settings/backup/data/SettingKeyAccessType;)V", "mSettingValue", "getMSettingValue", "()Ljava/lang/Object;", "setMSettingValue", "(Ljava/lang/Object;)V", "mXmlKey", "getMXmlKey", "setMXmlKey", "isMeetCondition", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DataBackupItem {
    private String mSettingKey;
    private SettingKeyAccessType mSettingKeyAccessType;
    private Object mSettingValue;
    private String mXmlKey;

    public final String getMSettingKey() {
        return this.mSettingKey;
    }

    public final void setMSettingKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSettingKey = r2;
    }

    public final Object getMSettingValue() {
        return this.mSettingValue;
    }

    public final void setMSettingValue(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSettingValue = r2;
    }

    public final SettingKeyAccessType getMSettingKeyAccessType() {
        return this.mSettingKeyAccessType;
    }

    public final void setMSettingKeyAccessType(SettingKeyAccessType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSettingKeyAccessType = r2;
    }

    public final String getMXmlKey() {
        return this.mXmlKey;
    }

    public final void setMXmlKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mXmlKey = r2;
    }

    public final boolean isMeetCondition(String r2) {
        Intrinsics.checkNotNullParameter(r2, "xmlKey");
        return Intrinsics.areEqual(this.mXmlKey, r2);
    }

    public DataBackupItem(String r2, Object r3, SettingKeyAccessType r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "settingKey");
        Intrinsics.checkNotNullParameter(r3, "settingValue");
        Intrinsics.checkNotNullParameter(r4, "settingKeyAccessType");
        Intrinsics.checkNotNullParameter(r5, "xmlKey");
        this.mSettingKey = r2;
        this.mSettingValue = r3;
        this.mSettingKeyAccessType = r4;
        this.mXmlKey = r5;
    }
}
