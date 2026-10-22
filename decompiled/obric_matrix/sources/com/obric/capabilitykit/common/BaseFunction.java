package com.obric.capabilitykit.common;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.m;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.k0.d;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/common/BaseFunction;", "", "name", "", "getName", "()Ljava/lang/String;", "doAction", "Lcom/obric/capabilitykit/common/BaseResult;", "params", "Lcom/google/gson/JsonObject;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/google/gson/JsonObject;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "", "translateTimeIntoUTC", "", "input", "translateUTCIntoTime", "time", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BaseFunction {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isBlock(BaseFunction r0) {
            return false;
        }

        public static long translateTimeIntoUTC(BaseFunction r12, String r13) {
            o.f(r13, "input");
            List r14 = k.n0(k.w(r13, "-", "#", false, 4, null), new String[]{"#"}, false, 0, 6, null);
            if (r14.size() < 3) goto L12;
            int r3 = Integer.parseInt((String) r14.get(0));
            int r4 = Integer.parseInt((String) r14.get(1)) - 1;
            int r5 = Integer.parseInt((String) r14.get(2));
            String r0 = (String) r.S(r14, 3);
            String r1 = BDLocationException.ERROR_TIMEOUT;
            if (r0 != null) goto L7;
            r0 = BDLocationException.ERROR_TIMEOUT;
        L7:
            int r6 = Integer.parseInt(r0);
            String r15 = (String) r.S(r14, 4);
            if (r15 == null) goto L11;
            r1 = r15;
        L11:
            int r7 = Integer.parseInt(r1);
            Calendar r16 = Calendar.getInstance();
            r16.setTimeZone(TimeZone.getDefault());
            r16.set(r3, r4, r5, r6, r7, 0);
            r16.set(14, 0);
            return r16.getTimeInMillis();
        L12:
            return -1;
        }

        public static String translateUTCIntoTime(BaseFunction r3, long r4) {
            Calendar r5 = Calendar.getInstance();
            r5.setTimeInMillis(r4);
            r5.setTimeZone(TimeZone.getDefault());
            int r6 = r5.get(1);
            int r0 = r5.get(2) + 1;
            int r7 = r5.get(5);
            int r1 = r5.get(11);
            int r8 = r5.get(12);
            StringBuilder r2 = new StringBuilder();
            r2.append(r6);
            r2.append('/');
            r2.append(r0);
            r2.append('/');
            r2.append(r7);
            r2.append(' ');
            r2.append(r1);
            r2.append(':');
            r2.append(r8);
            return r2.toString();
        }
    }

    Object doAction(m r1, DispatchContext r2, d<? super BaseResult> r3);

    String getName();

    boolean isBlock();

    long translateTimeIntoUTC(String r1);

    String translateUTCIntoTime(long r1);
}
