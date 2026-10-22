package com.bytedance.bdturing;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ReentrantLock f3110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<JSONObject> f3111b;

    static {
        f3110a = new ReentrantLock();
        f3111b = new LinkedList();
    }

    public static void a() {
        f3110a.lockInterruptibly();     // Catch: Throwable -> L4 Exception -> L9
        f3111b.clear();     // Catch: Throwable -> L4 Exception -> L9
    L4:
        th = move-exception;
        f3110a.unlock();
        throw th;
    L7:
        f3110a.unlock();
    }

    public static void b(long r2, float r4, float r5, int r6, float r7, float r8) {
        JSONObject r0 = new JSONObject();
        r0.put("timestamp", r2);     // Catch: JSONException -> L11
        r0.put("force", r4);     // Catch: JSONException -> L11
        r0.put("majorRadius", r5);     // Catch: JSONException -> L11
        r0.put(TypedValues.CycleType.S_WAVE_PHASE, r6);     // Catch: JSONException -> L11
        r0.put("x", r7);     // Catch: JSONException -> L11
        r0.put("y", r8);     // Catch: JSONException -> L11
        f3110a.lockInterruptibly();     // Catch: Throwable -> L6 InterruptedException -> L14
        f3111b.add(r0);     // Catch: Throwable -> L6 InterruptedException -> L14
    L6:
        th = move-exception;
        f3110a.unlock();
        throw th;
    L9:
        f3110a.unlock();
        return;
    L11:
        e = move-exception;
        g.e(e);
    }

    public static void c(com.bytedance.bdturing.u.c r4) {
        JSONObject r1 = new JSONObject();
        r1.put("os_name", "android");     // Catch: Throwable -> L5 Exception -> L11
        f3110a.lockInterruptibly();     // Catch: Throwable -> L5 Exception -> L11
        r1.put("touch", new JSONArray(f3111b));     // Catch: Throwable -> L5 Exception -> L11
        g.a("onTouch", "responseGetTouchToJs motion list size " + f3111b.size());     // Catch: Throwable -> L5 Exception -> L11
        f3111b.clear();     // Catch: Throwable -> L5 Exception -> L11
        g.a("onTouch", "responseGetTouchToJs end motion list size " + f3111b.size());     // Catch: Throwable -> L5 Exception -> L11
    L5:
        th = move-exception;
        f3110a.unlock();
        throw th;
    L8:
        f3110a.unlock();
        r4.d(1, r1);     // Catch: Exception -> L12
        return;
    }
}
