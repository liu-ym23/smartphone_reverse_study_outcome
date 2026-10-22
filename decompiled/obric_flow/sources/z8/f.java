package z8;

import android.text.TextUtils;
import com.bytedance.crash.n;
import com.bytedance.crash.util.NativeTools;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c {
    public static f q(StackTraceElement r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        f r5 = new f();
        String r17 = r10.getClassName();
        String r18 = r10.getMethodName();
        int r19 = r10.getLineNumber();
        JSONObject r20 = r5.f23416a;
        mh.e.g("exception", "event_type", r20);
        mh.e.g(r15, "log_type", r20);
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "timestamp", r20);
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "crash_time", r20);
        mh.e.g(r17, "class_ref", r20);
        mh.e.g(r18, "method", r20);
        mh.e.g(Integer.valueOf(r19), "line_num", r20);
        mh.e.g(r11, "stack", r20);
        if (TextUtils.isEmpty(r16) == false) goto L5;
        mh.e.g(com.bytedance.crash.util.d.b(r11), "crash_md5", r20);
    L6:
        mh.e.g(1, "exception_type", r20);
        mh.e.g(r14, "ensure_type", r20);
        mh.e.g(1, "is_core", r20);
        mh.e.g(r12, "message", r20);
        mh.e.g(m.o(n.f4057a), "process_name", r20);
        mh.e.g(r13, "crash_thread_name", r20);
        i.a.m(r20);
        return r5;
    L5:
        mh.e.g(r16, "crash_md5", r20);
        goto L6
    }

    public static f r(String r10, String r11, String r12, String r13) {
        f r14 = q(new StackTraceElement("Native", "Native", "Native.java", -1), r11, r12, r13, "EnsureNotReachHere", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, null);
        JSONObject r5 = r14.f23416a;
        mh.e.g("native_exception", "event_type", r5);
        mh.e.g(r10, "java_data", r5);
        NativeTools.k().getClass();
        mh.e.g(NativeTools.F(r11), "crash_lib_uuid", r5);
        return r14;
    }
}
