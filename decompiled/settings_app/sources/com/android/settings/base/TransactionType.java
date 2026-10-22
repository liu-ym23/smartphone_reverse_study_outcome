package com.android.settings.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TransactionType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/base/TransactionType;", "", "(Ljava/lang/String;I)V", "SLIDE", "POPUP", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum TransactionType extends Enum<TransactionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TransactionType[] $VALUES = null;
    public static final TransactionType POPUP = null;
    public static final TransactionType SLIDE = null;

    private static final /* synthetic */ TransactionType[] $values() {
        return new TransactionType[]{SLIDE, POPUP};
    }

    public static EnumEntries<TransactionType> getEntries() {
        return $ENTRIES;
    }

    public static TransactionType valueOf(String r1) {
        return (TransactionType) Enum.valueOf(TransactionType.class, r1);
    }

    public static TransactionType[] values() {
        return (TransactionType[]) $VALUES.clone();
    }

    private TransactionType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SLIDE = new TransactionType("SLIDE", 0);
        POPUP = new TransactionType("POPUP", 1);
        TransactionType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }
}
