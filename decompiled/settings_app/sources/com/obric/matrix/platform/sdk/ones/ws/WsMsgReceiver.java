package com.obric.matrix.platform.sdk.ones.ws;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: compiled from: WsMsgReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016Jv\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0018H&¨\u0006\u001a"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onWsMsgReceived", "channelId", "", "seqId", "", "logId", "service", "method", "encoding", "", "type", "payload", "", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WsMsgReceiver extends BroadcastReceiver {
    public static final Companion Companion = null;
    private static final String TAG = "WsMsgReceiver";
    private static final String WS_MSG_KEY_CHANNEL_ID = "channel_id";
    private static final String WS_MSG_KEY_HEADERS = "ws_headers";
    private static final String WS_MSG_KEY_IM_CMD = "cmd";
    private static final String WS_MSG_KEY_LOG_ID = "log_id";
    private static final String WS_MSG_KEY_METHOD = "method";
    private static final String WS_MSG_KEY_PAYLOAD = "payload";
    private static final String WS_MSG_KEY_PAYLOAD_ENCODING = "payload_encoding";
    private static final String WS_MSG_KEY_PAYLOAD_TYPE = "payload_type";
    private static final String WS_MSG_KEY_SEQ_ID = "seq_id";
    private static final String WS_MSG_KEY_SERVICE = "service";

    /* JADX INFO: compiled from: WsMsgReceiver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgReceiver$Companion;", "", "()V", "TAG", "", "WS_MSG_KEY_CHANNEL_ID", "WS_MSG_KEY_HEADERS", "WS_MSG_KEY_IM_CMD", "WS_MSG_KEY_LOG_ID", "WS_MSG_KEY_METHOD", "WS_MSG_KEY_PAYLOAD", "WS_MSG_KEY_PAYLOAD_ENCODING", "WS_MSG_KEY_PAYLOAD_TYPE", "WS_MSG_KEY_SEQ_ID", "WS_MSG_KEY_SERVICE", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public abstract void onWsMsgReceived(int r1, long r2, long r4, int r6, int r7, String r8, String r9, byte[] r10, HashMap<String, String> r11);

    public WsMsgReceiver() {
    }

    public void com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver__onReceive$___twin___(Context r21, Intent r22) {
        Log.d(TAG, "onReceive() called with: context = " + r21 + ", intent = " + r22);
        byte[] r2 = null;
        if (r22 == null) goto L5;
        Integer r3 = Integer.valueOf(r22.getIntExtra("channel_id", 0));
    L7:
        if (r22 == null) goto L9;
        Long r6 = Long.valueOf(r22.getLongExtra(WS_MSG_KEY_SEQ_ID, 0));
    L10:
        if (r22 == null) goto L12;
        Long r4 = Long.valueOf(r22.getLongExtra("log_id", 0));
    L13:
        if (r22 == null) goto L15;
        Integer r5 = Integer.valueOf(r22.getIntExtra("service", 0));
    L16:
        if (r22 == null) goto L18;
        Integer r1 = Integer.valueOf(r22.getIntExtra("method", 0));
    L19:
        if (r22 == null) goto L21;
        Serializable r7 = r22.getSerializableExtra(WS_MSG_KEY_HEADERS);
    L22:
        if (r7 == null) goto L35;
        HashMap<String, String> r19 = (HashMap) r7;
        if (r22 == null) goto L26;
        String r17 = r22.getStringExtra(WS_MSG_KEY_PAYLOAD_TYPE);
    L27:
        if (r22 == null) goto L29;
        String r16 = r22.getStringExtra(WS_MSG_KEY_PAYLOAD_ENCODING);
    L30:
        if (r22 == null) goto L32;
        r2 = r22.getByteArrayExtra("payload");
    L32:
        Intrinsics.checkNotNull(r3);
        int r9 = r3.intValue();
        Intrinsics.checkNotNull(r6);
        long r10 = r6.longValue();
        Intrinsics.checkNotNull(r4);
        long r12 = r4.longValue();
        Intrinsics.checkNotNull(r5);
        int r14 = r5.intValue();
        Intrinsics.checkNotNull(r1);
        onWsMsgReceived(r9, r10, r12, r14, r1.intValue(), r16, r17, r2, r19);
        return;
    L29:
        r16 = null;
        goto L30
    L26:
        r17 = null;
        goto L27
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L21:
        r7 = null;
        goto L22
    L18:
        r1 = null;
        goto L19
    L15:
        r5 = null;
        goto L16
    L12:
        r4 = null;
        goto L13
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    @Insert("onReceive")
    public static void com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(WsMsgReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        WsMsgReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_obric_matrix_platform_sdk_ones_ws_WsMsgReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
