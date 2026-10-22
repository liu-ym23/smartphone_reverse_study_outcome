package zm;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ChannelType;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.lynx.tasm.ui.image.FlattenUIImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.bytedance.ies.bullet.kit.web.g, com.lynx.tasm.ui.image.r, z.a, ln.a, pt.o, k0.g, yq.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23470b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f23469a = r10;
        this.f23470b = r5;
    }

    public static ConcurrentHashMap i(LinkedHashMap r5, String r10, boolean r11) {
        if (r10 == null) goto L15;
        monitor-enter(r5);
        ConcurrentHashMap r12 = (ConcurrentHashMap) r5.get(r10);     // Catch: Throwable -> L9
        if (r11 == false) goto L11;
        if (r12 != null) goto L11;
        r12 = new ConcurrentHashMap();     // Catch: Throwable -> L9
        r5.put(r10, r12);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);
        return r12;
    L9:
        th = move-exception;
        throw th;
    L15:
        return null;
    }

    @Override // com.lynx.tasm.ui.image.r
    public void a() {
        FlattenUIImage.access$400((FlattenUIImage) this.f23470b);
    }

    @Override // pt.o
    public Object apply(Object r5) {
        return ((Class) this.f23470b).cast(r5);
    }

    @Override // yq.c
    public CharSequence b(DayOfWeek r5) {
        return ((CharSequence[]) this.f23470b)[r5.getValue() - 1];
    }

    public float c(int r10, float r11, float r12, float r13) {
        float r5 = r13 - r12;
        List r14 = (List) this.f23470b;
        switch(r10) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L13;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        r11 = 0.0f;
        goto L13
    L5:
        r11 = ((((-((Float) r14.get(0)).floatValue()) - ((Float) r14.get(1)).floatValue()) + r12) + r13) * 0.5f;
        goto L13
    L6:
        r11 = (((Float) r14.get(3)).floatValue() * r11) / 100.0f;
        goto L13
    L7:
        r11 = r13 - ((Float) r14.get(1)).floatValue();
        goto L13
    L8:
        float r15 = ((Float) r14.get(2)).floatValue();
        r11 = (r15 + (r13 + r12)) * 0.5f;
        goto L13
    L9:
        r11 = r12 - ((Float) r14.get(0)).floatValue();
        goto L13
    L10:
        r11 = r5 * 0.1f;
        goto L13
    L11:
        r11 = (-r5) * 0.1f;
    L13:
        return (-r11) + r12;
    }

    public ConnectionState d(int r5, int r10) {
        ConnectionState r11 = ConnectionState.f3982b;
        if (r10 == 0) goto L18;
        if (r10 != 1) goto L9;
        r11 = ConnectionState.f3983c;
        goto L18
    L9:
        if (r10 != 2) goto L12;
        r11 = ConnectionState.d;
        goto L18
    L12:
        if (r10 != 3) goto L15;
        r11 = ConnectionState.e;
        goto L18
    L15:
        if (r10 != 4) goto L18;
        r11 = ConnectionState.f;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r10 + " connectionState = " + r11);
    L20:
        ((m8.a) this.f23470b).a(r5, r11);
        return r11;
    }

    public Object e(Object r5, String r10) {
        ConcurrentHashMap r11 = i((LinkedHashMap) this.f23470b, r10, false);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.get(r5);
    }

    @Override // z.a
    public boolean g(Object r5, File r10, z.f r11) {
        InputStream r12 = (InputStream) r5;
        com.bumptech.glide.load.engine.bitmap_recycle.f r13 = (com.bumptech.glide.load.engine.bitmap_recycle.f) this.f23470b;
        byte[] r14 = (byte[]) r13.c(65536, byte[].class);
        FileOutputStream r15 = null;
        FileOutputStream r16 = new FileOutputStream(r10);     // Catch: Throwable -> L14 IOException -> L16
    L41:
        int r17 = r12.read(r14);     // Catch: Throwable -> L7 IOException -> L9
        if (r17 == (-1)) goto L11;
        r16.write(r14, 0, r17);     // Catch: Throwable -> L7 IOException -> L9
        goto L41
    L11:
        r16.close();     // Catch: Throwable -> L7 IOException -> L9
        r16.close();     // Catch: IOException -> L29
    L13:
        r13.h(r14);
        return true;
    L9:
        e = e;
        r15 = r16;
    L19:
        if (Log.isLoggable("StreamEncoder", 3) == false) goto L21;
        Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);     // Catch: Throwable -> L14
    L21:
        if (r15 != null) goto L32;
    L23:
        r13.h(r14);
        return false;
    L32:
        r15.close();     // Catch: IOException -> L31
    L7:
        th = th;
        r15 = r16;
    L25:
        if (r15 != null) goto L37;
    L27:
        r13.h(r14);
        throw th;
    L37:
        r15.close();     // Catch: IOException -> L30
    L16:
        e = e;
    L14:
        th = th;
        goto L25
    }

    public ConcurrentHashMap h(String r5) {
        monitor-enter(this);
        LinkedHashMap r10 = (LinkedHashMap) this.f23470b;     // Catch: Throwable -> L8
        if (r10 == null) goto L11;
        ConcurrentHashMap r11 = (ConcurrentHashMap) TypeIntrinsics.asMutableMap(r10).remove(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void j(Intent r11) {
        String r5 = r11.getAction();     // Catch: Throwable -> L21
        if (WsConstants.RECEIVE_CONNECTION_ACTION.equals(r5) == false) goto L24;
        r11.setExtrasClassLoader(SocketState.class.getClassLoader());     // Catch: Throwable -> L21
        SocketState r10 = (SocketState) r11.getParcelableExtra(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L21
        ConnectionState r12 = d(r10.d, r10.f3997b);     // Catch: Throwable -> L10
        m8.a r13 = (m8.a) this.f23470b;     // Catch: Throwable -> L10
        if (r10.e != 1) goto L12;
        ChannelType r14 = ChannelType.f3979b;     // Catch: Throwable -> L10
    L13:
        com.bytedance.salamander.anniex.b0 r15 = new com.bytedance.salamander.anniex.b0(r12, r14, r10.d);     // Catch: Throwable -> L10
        r10.d();     // Catch: Throwable -> L10
        r13.e(r15);     // Catch: Throwable -> L10
        int r16 = r12.ordinal();     // Catch: Throwable -> L10
        if (r16 != 2) goto L16;
    L18:
        WsConstants.getLinkProgressChangeListener();     // Catch: Throwable -> L10
    L49:
        if (Logger.debug() == false) goto L63;
        Logger.d("AbsWsClientService", com.lynx.jsbridge.a.d(r11.getIntExtra(WsConstants.MSG_COUNT, -1), "count = "));
        return;
    L63:
        return;
    L16:
        if (r16 == 4) goto L18;
    L12:
        r14 = ChannelType.f3980c;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L49
    L24:
        if (WsConstants.SYNC_CONNECT_STATE.equals(r5) == false) goto L34;
        Logger.d("AbsWsClientService", "sync socket state");     // Catch: Throwable -> L21
        r11.setExtrasClassLoader(SocketState.class.getClassLoader());     // Catch: Throwable -> L21
        ArrayList r17 = r11.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L21
        if (r17 == null) goto L49;
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L21
    L29:
        if (r18.hasNext() == false) goto L49;
        SocketState r19 = (SocketState) r18.next();     // Catch: Throwable -> L21
        if (r19 == null) goto L29;
        d(r19.d, r19.f3997b);     // Catch: Throwable -> L21
        goto L29
    L34:
        if (WsConstants.RECEIVE_PROGRESS_ACTION.equals(r5) == false) goto L40;
        Logger.d("AbsWsClientService", "link process");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty((String) new JSONObject(r11.getStringExtra(WsConstants.KEY_PROGRESS)).remove(WsConstants.KEY_PROGRESS)) == true) goto L49;
        WsConstants.getLinkProgressChangeListener();     // Catch: Throwable -> L21 Exception -> L52
        goto L49
    L40:
        r11.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L21
        if (WsConstants.RECEIVE_PAYLOAD_ACTION.equals(r5) == false) goto L44;
        WsChannelMsg r20 = (WsChannelMsg) r11.getParcelableExtra("payload");     // Catch: Throwable -> L21
        Message r21 = new Message();     // Catch: Throwable -> L21
        r21.what = 40;     // Catch: Throwable -> L21
        r21.getData().putParcelable("payload", r20);     // Catch: Throwable -> L21
        k(r21);     // Catch: Throwable -> L21
        goto L49
    L44:
        if (WsConstants.SEND_PAYLOAD_ACTION.equals(r5) == false) goto L49;
        String r22 = r11.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);     // Catch: Throwable -> L21
        boolean r23 = r11.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);     // Catch: Throwable -> L21
        Message r24 = new Message();     // Catch: Throwable -> L21
        r24.what = 41;     // Catch: Throwable -> L21
        r24.getData().putString(WsConstants.KEY_PAYLOAD_MD5, r22);     // Catch: Throwable -> L21
        r24.getData().putBoolean(WsConstants.KEY_SEND_RESULT, r23);     // Catch: Throwable -> L21
        k(r24);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L49
    }

    public void k(Message r10) {
        r10.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L11
        int r5 = r10.what;     // Catch: Throwable -> L11
        if (r5 != 40) goto L16;
        Parcelable r11 = r10.getData().getParcelable("payload");     // Catch: Throwable -> L11
        if ((r11 instanceof WsChannelMsg) == false) goto L25;
        WsChannelMsg r12 = (WsChannelMsg) r11;     // Catch: Throwable -> L11
        if (Logger.debug() == false) goto L13;
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r12.toString());     // Catch: Throwable -> L11
    L13:
        ((m8.a) this.f23470b).b(r12);     // Catch: Throwable -> L11
        return;
    L25:
        return;
    L16:
        if (r5 != 41) goto L26;
        String r13 = r10.getData().getString(WsConstants.KEY_PAYLOAD_MD5);     // Catch: Throwable -> L11
        boolean r14 = r10.getData().getBoolean(WsConstants.KEY_SEND_RESULT);     // Catch: Throwable -> L11
        if (Logger.debug() == false) goto L24;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r13 + " sendResult = " + r14);     // Catch: Throwable -> L11
        return;
    L24:
        return;
    L26:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void l(String r5, Object r10, Object r11) {
        ConcurrentHashMap r12 = i((LinkedHashMap) this.f23470b, r5, true);
        if (r12 == null) goto L6;
        r12.put(r10, r11);
        return;
    }

    public void m(byte[] r5, Throwable r10) {
        k6.a r11 = (k6.a) this.f23470b;
        r11.getClass();
        if (r10 != null) goto L5;
        boolean r12 = true;
    L7:
        if (r10 == null) goto L9;
        String r13 = r10.getMessage();
    L10:
        ((nn.f) r11.f18623a).b(r12, r5, null, r13);
        return;
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = false;
        goto L7
    }

    public String toString() {
        switch(this.f23469a) {
            case 9: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return super.toString() + "{fragment=" + ((SupportRequestManagerFragment) this.f23470b) + "}";
    }

    public c(int r5) {
        this.f23469a = r5;
        switch(r5) {
            case 4: goto L7;
            default: goto L4;
        };
    L4:
        this.f23470b = new LinkedHashMap();
        return;
    }

    @Override // com.bytedance.ies.bullet.kit.web.g
    public void a(int r5, int r10, int r11, int r12) {
        if (r11 > r10) goto L6;
        boolean r13 = true;
        if (r10 >= 1) goto L6;
    L7:
        AnnieXContainer r14 = (AnnieXContainer) this.f23470b;
        AnnieXContainer.access$setWebViewScrollReachTop$p(r14, r13);
        r14.onWebScrollChanged(r5, r10, r11, r12);
        return;
    L6:
        r13 = false;
        goto L7
    }

    public c(CharSequence[] r5) {
        this.f23469a = 12;
        if (r5 == null) goto L11;
        if (r5.length != 7) goto L9;
        this.f23470b = r5;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }
}
