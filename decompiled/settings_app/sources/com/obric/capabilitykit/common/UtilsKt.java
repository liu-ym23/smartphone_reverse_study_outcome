package com.obric.capabilitykit.common;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "dateToTimeStamp", "", "pattern", "date", "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtilsKt {
    private static final Lazy gson$delegate = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Gson> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    static {
        gson$delegate = LazyKt.lazy(a.a);
    }

    public static final String dateToTimeStamp(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "pattern");
        Intrinsics.checkNotNullParameter(r4, "date");
        Object r0 = null;
        Date r5 = new SimpleDateFormat(r3, Locale.getDefault()).parse(r4);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        String r6 = Long.valueOf(r5.getTime()).toString();     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.m1508constructorimpl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.m1514isFailureimpl(r7) == true) goto L15;
        r0 = r7;
    L15:
        String r1 = (String) r0;
        if (r1 != null) goto L21;
        return "";
    L21:
        return r1;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }
}
