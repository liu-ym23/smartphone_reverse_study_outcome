package xh;

import com.bytedance.keva.Keva;
import io.reactivex.internal.observers.h;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23147b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f23148c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23149a;

    static {
        f23147b = new a(0);
        f23148c = new a(1);
    }

    public /* synthetic */ a(int r5) {
        this.f23149a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f23149a) {
            case 0: goto L36;
            default: goto L4;
        };
    L4:
        Iterator<Map.Entry<String, ?>> r10 = zh.b.f23447a.getAll().entrySet().iterator();
        long r5 = System.currentTimeMillis();
    L6:
        if (r10.hasNext() == false) goto L34;
        Map.Entry<String, ?> r11 = r10.next();
        if (StringsKt.k(r11.getKey(), "_detail_id") == true) goto L6;
        String r12 = r11.getKey();
        Keva r13 = zh.b.c(r12);
        if (r13 == null) goto L31;
        Iterator<Map.Entry<String, ?>> r14 = r13.getAll().entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L28;
        Map.Entry<String, ?> r15 = r14.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L17
        Object r17 = r15.getValue();     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
        Object r18 = Result.m124constructorimpl(new JSONObject((String) r17));     // Catch: Throwable -> L17
    L20:
        if (Result.m127exceptionOrNullimpl(r18) == null) goto L23;
        r13.erase(r15.getKey());
    L23:
        if (Result.m131isSuccessimpl(r18) == false) goto L13;
        JSONObject r19 = (JSONObject) r18;
        if (r19.getLong("expire_time") > r5) goto L13;
        String r20 = r19.getString("content_UUID");
        zh.b.f23448b.erase(r20);
        r13.erase(r15.getKey());
    L17:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    L28:
        if (r13.count() != 0) goto L30;
        Keva r22 = zh.b.f23447a;
        r22.erase(r12);
        r22.erase(h.b(r12, "_detail_id"));
    L30:
        Unit r23 = Unit.INSTANCE;
    L32:
        if (r23 != null) goto L6;
        Keva r24 = zh.b.f23447a;
        r24.erase(r12);
        r24.erase(h.b(r12, "_detail_id"));
        goto L6
    L31:
        r23 = null;
        goto L32
    L34:
        return;
    L36:
        if (b.f23150a.compareAndSet(false, true) == false) goto L55;
        Pattern.compile("<meta name=\"pia-snapshot\" content=\"(.*?)\">", 0);
        return;
    }
}
