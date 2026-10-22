package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import com.bytedance.apm.g0.g.c;
import com.bytedance.apm.g0.j.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class NativeSpan {
    private long finishTime;
    private boolean isErrorSpan;
    private boolean isFinish;
    private String parentId;
    private String referenceId;
    private String spanId;
    private String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;

    public NativeSpan(String r1, String r2, String r3, String r4, long r5, long r7, String r9, HashMap<String, String> r10, boolean r11, boolean r12) {
        this.spanName = r1;
        this.spanId = r2;
        this.parentId = r3;
        this.referenceId = r4;
        this.startTime = r5;
        this.finishTime = r7;
        this.threadName = r9;
        this.tags = r10;
        this.isErrorSpan = r11;
        this.isFinish = r12;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public c parseToSpan(a r4) {
        if (this.isFinish == true) goto L6;
        return null;
    L6:
        c r5 = r4.a(this.spanName, Long.parseLong(this.spanId));
        String r0 = this.parentId;
        if (r0 != null) goto L9;
    L11:
        String r1 = this.referenceId;
        if (r1 != null) goto L14;
    L16:
        r5.e(this.threadName);
        Iterator<Map.Entry<String, String>> r3 = this.tags.entrySet().iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        Map.Entry<String, String> r2 = r3.next();
        r5.d(r2.getKey(), r2.getValue());
        goto L18
    L20:
        return r5;
    L14:
        if (r1.isEmpty() == true) goto L16;
        r5.b(Long.parseLong(this.referenceId));
        goto L16
    L9:
        if (r0.isEmpty() == true) goto L11;
        r5.a(Long.parseLong(this.parentId));
        goto L11
    }

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }
}
