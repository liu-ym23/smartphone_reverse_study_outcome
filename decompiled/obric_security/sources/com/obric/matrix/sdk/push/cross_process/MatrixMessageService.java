package com.obric.matrix.sdk.push.cross_process;

import a.a.a.a.a.b.c.b;
import a.a.a.a.a.c.c;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.sdk.push.model.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MatrixMessageService;", "Lcom/obric/matrix/sdk/push/cross_process/CrossProcessService;", "()V", "onReceiveMsg", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/obric/matrix/sdk/push/model/Message;", "registerCrossProcessMethod", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MatrixMessageService extends CrossProcessService {

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/matrix/sdk/push/cross_process/MatrixMessageService$registerCrossProcessMethod$1", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "getMethodName", "", "onMethodInvoke", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixMessageService f16a;

        public a(MatrixMessageService r1) {
            this.f16a = r1;
        }

        @Override // a.a.a.a.a.b.c.b
        public String a() {
            return ".action.MESSAGE_EVENT";
        }

        @Override // a.a.a.a.a.b.c.b
        public void a(String r2, List<Object> r3, a.a.a.a.a.b.a r4) {
            Intrinsics.checkNotNullParameter(r2, "originPkgName");
            if (r3 != null) goto L5;
        L21:
            c.a("message service v2 args is null or size < 2");
            return;
        L5:
            if (r3.size() < 2) goto L21;
            Object r5 = r3.get(0);     // Catch: Throwable -> L18
            if (r5 == null) goto L17;
            String r6 = (String) r5;     // Catch: Throwable -> L18
            Object r7 = r3.get(1);     // Catch: Throwable -> L18
            if (r7 == null) goto L15;
            this.f16a.onReceiveMsg(new Message(r6, (String) r7));     // Catch: Throwable -> L18
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            c.a("message service v2 error: " + th);
        }
    }

    public MatrixMessageService() {
    }

    public abstract void onReceiveMsg(Message r1);

    @Override // com.obric.matrix.sdk.push.cross_process.CrossProcessService
    public void registerCrossProcessMethod() {
        a.a.a.a.a.a.f5a.a(this).registerCrossProcessMethod(new a(this));
    }
}
