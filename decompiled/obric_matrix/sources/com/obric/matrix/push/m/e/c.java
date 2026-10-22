package com.obric.matrix.push.m.e;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/push/base/handler/PbMsgHandler;", "Lcom/obric/matrix/push/base/handler/IMsgHandler;", "canHandle", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/obric/matrix/push/Packet;", "handle", "", "data", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface c extends com.obric.matrix.push.m.e.a {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(c r0, byte[] r1) {
            o.f(r1, "data");
        }
    }

    boolean a(com.obric.matrix.push.e r1);

    void b(com.obric.matrix.push.e r1);
}
