package com.obric.capabilitykit;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.logger.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J1\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+H\u0016J\u001c\u0010,\u001a\u00020\u00062\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u0010/\u001a\u00020+H\u0016J\u0018\u00100\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0016J\u0018\u00101\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J:\u00103\u001a\u00020\u00062\n\u0010*\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00112\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000106H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/EmptyCapabilityManager;", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "()V", "TAG", "", "finishFloatingActivity", "", "questionId", "", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "params", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "hideIntentResultCard", "isCardViewVisible", "", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "registerIntent", "name", "implClassName", "serviceName", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "requestStateChanged", "id", "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "callback", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", "timeout", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;)V", "requestUriFileAccess", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "sendActionExecuteResult", "result", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendIntentExecutionResult", "intentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "stopUriFileAccess", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "isStatusChange", "ext", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements a {
    public static final f a = null;
    private static final String b = "EmptyCapabilityManager";

    static {
        a = new f();
    }

    private f() {
    }

    @Override // com.obric.capabilitykit.a
    public PendingIntent a(long r1, Intent r3, FloatingIntentParams r4) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        Intrinsics.checkNotNullParameter(r4, "params");
        Logger.INSTANCE.w(b, "getFloatingPendingIntent");
        return null;
    }

    @Override // com.obric.capabilitykit.a
    public void a(long r1) {
        Logger.INSTANCE.w(b, "hideIntentResultCard");
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Logger.INSTANCE.w(b, "stopUriFileAccess");
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r1, String r2, IUriFileReceiver r3) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "requester");
        Logger.INSTANCE.w(b, "requestUriFileAccess");
    }

    @Override // com.obric.capabilitykit.a
    public void a(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Logger.INSTANCE.w(b, "unregisterResultCallback");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IMAppAction r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Logger.INSTANCE.w(b, "sendActionExecuteResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r1, long r2, boolean r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Logger.INSTANCE.w(b, "updateIntentResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r1, IMAppAction r2) {
        Intrinsics.checkNotNullParameter(r1, "intentResult");
        Intrinsics.checkNotNullParameter(r2, "oldResult");
        Logger.INSTANCE.w(b, "sendActionExecuteResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4) {
        Intrinsics.checkNotNullParameter(r1, "id");
        Intrinsics.checkNotNullParameter(r2, "stateInfo");
        Logger.INSTANCE.w(b, "requestStateChanged");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "implClassName");
        Logger.INSTANCE.w(b, "unregisterIntent");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "implClassName");
        Logger.INSTANCE.w(b, "registerIntent");
    }

    @Override // com.obric.capabilitykit.a
    public boolean a() {
        Logger.INSTANCE.w(b, "isKeyguardReallyLocked");
        return true;
    }

    @Override // com.obric.capabilitykit.a
    public void b(long r1) {
        Logger.INSTANCE.w(b, "finishFloatingActivity");
    }

    @Override // com.obric.capabilitykit.a
    public void b(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Logger.INSTANCE.w(b, "registerResultCallback");
    }

    @Override // com.obric.capabilitykit.a
    public Boolean c(long r1) {
        Logger.INSTANCE.w(b, "isCardViewVisible");
        return null;
    }
}
