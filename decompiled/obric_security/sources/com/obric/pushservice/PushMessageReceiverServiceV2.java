package com.obric.pushservice;

import com.obric.matrix.sdk.push.cross_process.MatrixMessageService;
import com.obric.matrix.sdk.push.model.Message;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushMessageReceiverServiceV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/pushservice/PushMessageReceiverServiceV2;", "Lcom/obric/matrix/sdk/push/cross_process/MatrixMessageService;", "()V", "onReceiveMsg", "", "message", "Lcom/obric/matrix/sdk/push/model/Message;", "Companion", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushMessageReceiverServiceV2 extends MatrixMessageService {
    public static final Companion Companion = null;
    private static final String TAG = "PushMsgHandleService";

    /* JADX INFO: compiled from: PushMessageReceiverServiceV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/pushservice/PushMessageReceiverServiceV2$Companion;", "", "()V", "TAG", "", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PushMessageReceiverServiceV2() {
    }

    @Override // com.obric.matrix.sdk.push.cross_process.MatrixMessageService
    public void onReceiveMsg(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        OLog.d(TAG, "onReceiveMsg PushMsgHandleService: " + r4.getData());
        String r3 = r4.getData();
        String r1 = r3;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L17;
        OLog.d(TAG, "onReceiveMsg data is empty, drop, msgId is " + r4.getMsgId());
        return;
    L17:
        PushMessageCallbackRegistry.dispatch(r3, r4.getMsgId());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        OLog.e(TAG, "dispatch push message failed, msgId is " + r4.getMsgId(), th);
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
