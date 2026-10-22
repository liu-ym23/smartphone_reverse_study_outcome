package sj;

import android.util.Log;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bumptech.glide.load.engine.c0;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf$Visibility;
import kotlinx.metadata.internal.protobuf.r;
import kotlinx.metadata.internal.protobuf.s;
import org.threeten.bp.ZoneId;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements s, r0.c, z2.g, com.bytedance.sliver.d, dc.a, k0.g, okhttp3.s, org.threeten.bp.temporal.i, r0.f, ue.a, z.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f21921a;

    @Override // dc.a
    public void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.e("[ResourceLoader]", r5);
    }

    @Override // dc.a
    public void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.d("[ResourceLoader]", r5);
    }

    @Override // dc.a
    public void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.w("[ResourceLoader]", r5);
    }

    @Override // r0.c
    public Object create() {
        return new c0();
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        return ZoneId.from(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.s
    public r findValueByNumber(int r5) {
        return ProtoBuf$Visibility.valueOf(r5);
    }

    @Override // dc.a
    public void a(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r10, "tr");
        Log.e("[ResourceLoader]", r5, r10);
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter("result", STGroup.DICT_KEY);
        r5.b("result", Boolean.TRUE);
        r5.c("message", "evaluate main.js success");
    }

    @Override // r0.f
    public void c(Object r5) {
    }

    @Override // z.d
    public void a(byte[] r5, Object r10, MessageDigest r11) {
    }
}
