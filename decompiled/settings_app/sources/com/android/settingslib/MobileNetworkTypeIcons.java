package com.android.settingslib;

import com.android.settingslib.mobile.TelephonyIcons;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MobileNetworkTypeIcons.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/settingslib/MobileNetworkTypeIcons;", "", "()V", "Companion", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MobileNetworkTypeIcons {
    public static final Companion Companion = null;
    private static final Map<String, MobileNetworkTypeIcon> MOBILE_NETWORK_TYPE_ICONS = null;

    /* JADX INFO: compiled from: MobileNetworkTypeIcons.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\f\u0010\n\u001a\u00020\u0006*\u00020\tH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/settingslib/MobileNetworkTypeIcons$Companion;", "", "()V", "MOBILE_NETWORK_TYPE_ICONS", "", "", "Lcom/android/settingslib/MobileNetworkTypeIcon;", "getNetworkTypeIcon", "mobileIconGroup", "Lcom/android/settingslib/SignalIcon$MobileIconGroup;", "toNetworkTypeIcon", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ MobileNetworkTypeIcon access$toNetworkTypeIcon(Companion r0, SignalIcon.MobileIconGroup r1) {
            return r0.toNetworkTypeIcon(r1);
        }

        @JvmStatic
        public final MobileNetworkTypeIcon getNetworkTypeIcon(SignalIcon.MobileIconGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "mobileIconGroup");
            MobileNetworkTypeIcon r0 = (MobileNetworkTypeIcon) MobileNetworkTypeIcons.access$getMOBILE_NETWORK_TYPE_ICONS$cp().get(r3.name);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return toNetworkTypeIcon(r3);
        }

        private final MobileNetworkTypeIcon toNetworkTypeIcon(SignalIcon.MobileIconGroup r3) {
            String r0 = r3.name;
            Intrinsics.checkNotNullExpressionValue(r0, "this.name");
            return new MobileNetworkTypeIcon(r0, r3.dataType, r3.dataContentDescription);
        }
    }

    @JvmStatic
    public static final MobileNetworkTypeIcon getNetworkTypeIcon(SignalIcon.MobileIconGroup r1) {
        return Companion.getNetworkTypeIcon(r1);
    }

    public MobileNetworkTypeIcons() {
    }

    public static final /* synthetic */ Map access$getMOBILE_NETWORK_TYPE_ICONS$cp() {
        return MOBILE_NETWORK_TYPE_ICONS;
    }

    static {
        Companion = new Companion(null);
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, SignalIcon.MobileIconGroup> r1 = TelephonyIcons.ICON_NAME_TO_ICON;
        Intrinsics.checkNotNullExpressionValue(r1, "ICON_NAME_TO_ICON");
        Iterator<Map.Entry<String, SignalIcon.MobileIconGroup>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        SignalIcon.MobileIconGroup r3 = r2.next().getValue();
        String r4 = r3.name;
        Intrinsics.checkNotNullExpressionValue(r4, "mobileIconGroup.name");
        Companion r5 = Companion;
        Intrinsics.checkNotNullExpressionValue(r3, "mobileIconGroup");
        r0.put(r4, Companion.access$toNetworkTypeIcon(r5, r3));
        goto L4
    L6:
        MOBILE_NETWORK_TYPE_ICONS = r0;
    }
}
