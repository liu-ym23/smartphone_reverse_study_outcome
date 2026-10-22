package com.obric.baseservice.location;

import android.content.Context;
import com.obric.olog.OLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocationAreaMatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fH\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/baseservice/location/LocationAreaMatcher;", "", "()V", "TAG", "", "matches", "", "context", "Landroid/content/Context;", "segments", "", "callback", "Lkotlin/Function1;", "", "resolveCityCode", "data", "Lcom/obric/baseservice/location/DeviceLocationData;", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class LocationAreaMatcher {
    public static final LocationAreaMatcher INSTANCE = null;
    private static final String TAG = "GbtCodeDict";

    static {
        INSTANCE = new LocationAreaMatcher();
    }

    private LocationAreaMatcher() {
    }

    public static final /* synthetic */ String access$resolveCityCode(LocationAreaMatcher r0, Context r1, DeviceLocationData r2) {
        return r0.resolveCityCode(r1, r2);
    }

    @JvmStatic
    public static final void matches(final Context r1, final List<String> r2, final Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "segments");
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r2.isEmpty() == false) goto L6;
        OLog.d(TAG, "segments empty, treat as matched");
        r3.invoke(true);
        return;
    L6:
        DeviceLocationFetcher.fetch(r1, new AnonymousClass1(r3, r1, r2));
    }

    private final String resolveCityCode(Context r6, DeviceLocationData r7) {
        String r5 = r7.getDistrictCode();
        boolean r0 = true;
        if (r5 != null) goto L5;
    L10:
        String r8 = r7.getCityCode();
        if (r8 != null) goto L13;
    L18:
        String r9 = r7.getLocality();
        if (r9 == null) goto L21;
        String r10 = StringsKt.trim(r9).toString();
    L22:
        String r2 = "";
        if (r10 != null) goto L26;
        r10 = "";
    L26:
        if (r10.length() <= 0) goto L28;
        boolean r3 = true;
    L29:
        if (r3 == false) goto L33;
        String r11 = GbtCodeDict.INSTANCE.nameToCode(r6, r10);
        if (r11 == null) goto L33;
        return r11;
    L33:
        String r12 = r7.getProvince();
        if (r12 == null) goto L36;
        String r13 = StringsKt.trim(r12).toString();
    L37:
        if (r13 == null) goto L41;
        r2 = r13;
    L41:
        if (r2.length() > 0) goto L44;
        r0 = false;
    L44:
        if (r0 == false) goto L48;
        String r14 = GbtCodeDict.INSTANCE.nameToCode(r6, r2);
        if (r14 == null) goto L48;
        return r14;
    L48:
        return null;
    L36:
        r13 = null;
        goto L37
    L28:
        r3 = false;
        goto L29
    L21:
        r10 = null;
        goto L22
    L13:
        if ((!StringsKt.isBlank(r8)) == true) goto L16;
        r8 = null;
    L16:
        if (r8 == null) goto L18;
        return r8;
    L5:
        if ((!StringsKt.isBlank(r5)) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        return r5;
    }
}
