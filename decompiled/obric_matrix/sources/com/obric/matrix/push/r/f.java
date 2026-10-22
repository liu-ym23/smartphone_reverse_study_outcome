package com.obric.matrix.push.r;

import android.text.TextUtils;
import com.bytedance.security.Sword.Sword;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/push/utils/EncryptUtils;", "", "()V", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9795a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/push/utils/EncryptUtils$Companion;", "", "()V", "encrypt", "", "data", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final String a(String r1) {
            if (TextUtils.isEmpty(r1) == false) goto L6;
            return null;
        L6:
            o.c(r1);
            byte[] r0 = r1.getBytes(kotlin.u0.d.f21429a);
            o.e(r0, "this as java.lang.String).getBytes(charset)");
            return Sword.clientPackedBase64(r0, r0.length);
        }
    }

    static {
        f9795a = new a(null);
    }
}
