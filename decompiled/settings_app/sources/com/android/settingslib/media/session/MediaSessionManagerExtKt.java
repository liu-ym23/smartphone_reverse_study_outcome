package com.android.settingslib.media.session;

import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MediaSessionManagerExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\"#\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"activeMediaChanges", "Lkotlinx/coroutines/flow/Flow;", "", "Landroid/media/session/MediaController;", "Landroid/media/session/MediaSessionManager;", "getActiveMediaChanges", "(Landroid/media/session/MediaSessionManager;)Lkotlinx/coroutines/flow/Flow;", "defaultRemoteSessionChanged", "Landroid/media/session/MediaSession$Token;", "getDefaultRemoteSessionChanged", "app_debug"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MediaSessionManagerExtKt {
    public static final Flow<List<MediaController>> getActiveMediaChanges(MediaSessionManager r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return FlowKt.buffer$default(FlowKt.callbackFlow(new MediaSessionManagerExtKt$activeMediaChanges$1(r3, null)), -1, null, 2, null);
    }

    public static final Flow<MediaSession.Token> getDefaultRemoteSessionChanged(MediaSessionManager r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return FlowKt.buffer$default(FlowKt.callbackFlow(new MediaSessionManagerExtKt$defaultRemoteSessionChanged$1(r3, null)), -1, null, 2, null);
    }
}
