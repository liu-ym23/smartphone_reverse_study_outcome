package com.android.settings.wifi.scanner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NetworkType.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/android/settings/wifi/scanner/NetworkType;", "", "(Ljava/lang/String;I)V", "WEP", "WPA", "SAE", "NO_PASSWORD", "WPA2_EAP", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum NetworkType extends Enum<NetworkType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NetworkType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final NetworkType NO_PASSWORD = null;
    public static final NetworkType SAE = null;
    public static final NetworkType WEP = null;
    public static final NetworkType WPA = null;
    public static final NetworkType WPA2_EAP = null;

    /* JADX INFO: compiled from: NetworkType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/android/settings/wifi/scanner/NetworkType$Companion;", "", "()V", "forIntentValue", "Lcom/android/settings/wifi/scanner/NetworkType;", "networkTypeString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NetworkType forIntentValue(String r1) {
            if (r1 != null) goto L5;
            return NetworkType.NO_PASSWORD;
        L5:
            switch(r1.hashCode()) {
                case -1039816366: goto L23;
                case 81847: goto L20;
                case 85826: goto L17;
                case 86152: goto L14;
                case 2670762: goto L11;
                case 1194974097: goto L8;
                default: goto L27;
            };
        L8:
            if (r1.equals("WPA2-EAP") == false) goto L27;
            return NetworkType.WPA2_EAP;
        L11:
            if (r1.equals("WPA2") == false) goto L27;
        L30:
            return NetworkType.WPA;
        L14:
            if (r1.equals("WPA") == false) goto L27;
        L17:
            if (r1.equals("WEP") == false) goto L27;
            return NetworkType.WEP;
        L20:
            if (r1.equals("SAE") == false) goto L27;
            return NetworkType.SAE;
        L23:
            if (r1.equals("nopass") == false) goto L27;
            return NetworkType.NO_PASSWORD;
        L27:
            throw new IllegalArgumentException(r1);
        }
    }

    private static final /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{WEP, WPA, SAE, NO_PASSWORD, WPA2_EAP};
    }

    @JvmStatic
    public static final NetworkType forIntentValue(String r1) {
        return Companion.forIntentValue(r1);
    }

    public static EnumEntries<NetworkType> getEntries() {
        return $ENTRIES;
    }

    public static NetworkType valueOf(String r1) {
        return (NetworkType) Enum.valueOf(NetworkType.class, r1);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }

    private NetworkType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        WEP = new NetworkType("WEP", 0);
        WPA = new NetworkType("WPA", 1);
        SAE = new NetworkType("SAE", 2);
        NO_PASSWORD = new NetworkType("NO_PASSWORD", 3);
        WPA2_EAP = new NetworkType("WPA2_EAP", 4);
        NetworkType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }
}
