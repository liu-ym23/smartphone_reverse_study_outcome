package we;

import ai.h0;
import ai.j0;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.SeekBar;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import bi.e;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.salamander.anniex.n;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.google.common.reflect.w;
import com.google.gson.Gson;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse$Type;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.utils.k;
import com.obric.oui.slider.OSlider;
import com.obric.oui.slider.TickMarkSeekBar;
import fo.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ym.o;
import z2.f;
import z2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g, com.obric.oui.slider.b, d, XIRetrofit {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f22856b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f22857a;

    public /* synthetic */ a(Object r5) {
        this.f22857a = r5;
    }

    public n a(e r10) {
        LinkedHashMap r5 = new LinkedHashMap();
        HashMap r11 = (HashMap) r10.d;
        if (r11 == null) goto L9;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.add(new bi.c((String) r14.getKey(), (String) r14.getValue()));
    L9:
        n r15 = new n(4);
        Pair r16 = com.bytedance.frameworks.baselib.network.http.util.c.c((String) r10.f931c, r5);     // Catch: Exception -> L21
        String r17 = (String) r16.first;     // Catch: Exception -> L21
        String r18 = (String) r16.second;     // Catch: Exception -> L21
        o r19 = (o) this.f22857a;     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r17, "baseUrl");     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(wf.a.class, "api");     // Catch: Exception -> L21
        ((r9.c) r19.f23310b).getClass();     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r17, "baseUrl");     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(wf.a.class, "api");     // Catch: Exception -> L21
        if (com.bytedance.ttnet.utils.d.c(wf.a.class, r17) != null) goto L26;
        if (TextUtils.isEmpty((String) r10.e) == true) goto L24;
        String r20 = (String) r10.f;     // Catch: Exception -> L21
        if (r20 != null) goto L17;
        throw null;     // Catch: Exception -> L21
    L17:
        if (r20.getBytes() == null) goto L20;
        throw null;     // Catch: Exception -> L21
    L20:
        throw new NullPointerException("bytes");     // Catch: Exception -> L21
    L24:
        throw null;     // Catch: Exception -> L21
    L26:
        throw new ClassCastException();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        Log.e("scc_sdk", Log.getStackTraceString(e));
        r15.f7268b = -1;
        r15.f7269c = e.getMessage();
        return r15;
    }

    @Override // z2.g
    public void b(f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        PageInfo r10 = (PageInfo) this.f22857a;
        String r11 = r10.getMessageId();
        if (r11 == null) goto L5;
        r5.c("message_id", r11);
    L5:
        RenderType[] r12 = RenderType.f2230a;
        r5.c("renderType", "lynx");
        JSONObject r13 = new JSONObject(new Gson().toJson(r10));
        Intrinsics.checkNotNullParameter("pageInfo", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r13, "value");
        if (r13.length() <= 0) goto L8;
        r5.b("pageInfo", r13);
    L8:
        Intrinsics.checkNotNullParameter("success", STGroup.DICT_KEY);
        r5.b("success", Boolean.TRUE);
    }

    @Override // fo.d
    public void c(fo.f r5) {
        InputStream r10 = r5.f16963b;
        int r11 = 0;
        if (r10 != null) goto L18;
    L8:
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        if (k.n(r10, r12, r11) == false) goto L11;
        byte[] r13 = r12.toByteArray();
    L12:
        if (r13 == null) goto L14;
        int r14 = 6;
        q7.a r15 = new q7.a(r14, AnimaXLoaderResponse$Type.f9628a, false, r13);
    L15:
        ((AnimaXLoaderCompletionHandler) this.f22857a).a(r15);
        return;
    L14:
        Throwable r16 = new Throwable("Failed to load raw data with LynxResRequest");
        int r17 = 6;
        r15 = new q7.a(r17, AnimaXLoaderResponse$Type.f9630c, false, r16);
        goto L15
    L11:
        r13 = null;
        goto L12
    L18:
        r11 = r10.available();     // Catch: IOException -> L17
    L6:
        if (r11 > 0) goto L8;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "LynxResourceUtil", "no length from stream, responseContentLength = 0");
        goto L8
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit
    public Object create(Class r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        return ((h0) this.f22857a).b(r5);
    }

    @Override // fo.d
    public void d(fo.f r5) {
        Throwable r10 = new Throwable(j0.q(new StringBuilder("LynxResRequest failed with error: "), r5.f16962a, "status code: 0"));
        int r11 = 6;
        q7.a r12 = new q7.a(r11, AnimaXLoaderResponse$Type.f9630c, false, r10);
        ((AnimaXLoaderCompletionHandler) this.f22857a).a(r12);
    }

    public String e(Context r5, String r10, String r11) {
        monitor-enter(this);
        if (r5 != null) goto L18;
    L12:
        monitor-exit(this);
    L13:
        SharedPreferences r12 = (SharedPreferences) this.f22857a;
        if (r12 != null) goto L17;
        return r11;
    L17:
        return r12.getString(r10, r11);
    L18:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (((SharedPreferences) this.f22857a) != null) goto L12;
        this.f22857a = r5.getSharedPreferences("sp_gecko", 0);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        goto L13
    }

    public void f(Context r5) {
        monitor-enter(this);
        if (r5 != null) goto L19;
    L13:
        monitor-exit(this);
    L14:
        SharedPreferences r10 = (SharedPreferences) this.f22857a;
        if (r10 != null) goto L17;
        return;
    L17:
        r10.edit().remove("gecko_settings").apply();
        return;
    L19:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (((SharedPreferences) this.f22857a) != null) goto L13;
        this.f22857a = r5.getSharedPreferences("sp_gecko", 0);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        goto L14
    }

    public void g(Context r5, String r10, String r11) {
        monitor-enter(this);
        if (r5 != null) goto L18;
    L12:
        monitor-exit(this);
    L13:
        SharedPreferences r12 = (SharedPreferences) this.f22857a;
        if (r12 != null) goto L16;
        return;
    L16:
        r12.edit().putString(r10, r11).apply();
        return;
    L18:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (((SharedPreferences) this.f22857a) != null) goto L12;
        this.f22857a = r5.getSharedPreferences("sp_gecko", 0);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        goto L13
    }

    public void h(SeekBar r5, float r10, boolean r11) {
        OSlider r12 = (OSlider) this.f22857a;
        com.obric.oui.slider.b r13 = r12.f14525l;
        if (r13 == null) goto L7;
        a r14 = (a) r13;
        r14.h(r5, r12.e(r10), r11);
        return;
    }

    public void i(int r5) {
        com.obric.oui.slider.b r10 = ((OSlider) this.f22857a).f14525l;
        if (r10 == null) goto L7;
        ((a) r10).i(r5);
        return;
    }

    public void j(SeekBar r5) {
        int r10 = OSlider.f14520p;
        OSlider r11 = (OSlider) this.f22857a;
        r11.getClass();
        com.obric.oui.slider.b r12 = r11.f14525l;
        if (r12 == null) goto L7;
        ((a) r12).j(r5);
        return;
    }

    public void k(SeekBar r5) {
        int r10 = OSlider.f14520p;
        OSlider r11 = (OSlider) this.f22857a;
        r11.getClass();
        com.obric.oui.slider.b r12 = r11.f14525l;
        if (r12 == null) goto L7;
        ((a) r12).k(r5);
        return;
    }

    public void l(TickMarkSeekBar r5) {
        com.obric.oui.slider.b r10 = ((OSlider) this.f22857a).f14525l;
        if (r10 == null) goto L7;
        ((a) r10).l(r5);
        return;
    }

    public void m(TickMarkSeekBar r5, float r10) {
        com.obric.oui.slider.b r11 = ((OSlider) this.f22857a).f14525l;
        if (r11 == null) goto L7;
        ((a) r11).m(r5, r10);
        return;
    }

    public a(int r5) {
        switch(r5) {
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        this.f22857a = new w("gecko-timer-task", 1);
        return;
    L5:
        w8.f r10 = new w8.f();
        r10.f22816a = new com.bytedance.android.monitorV2.k(3, 1);
        this.f22857a = r10;
    }
}
