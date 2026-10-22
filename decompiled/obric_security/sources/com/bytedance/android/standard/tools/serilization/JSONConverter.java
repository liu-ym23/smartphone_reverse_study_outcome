package com.bytedance.android.standard.tools.serilization;

import com.google.gson.Gson;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class JSONConverter {
    private static final Gson GSON = null;

    public JSONConverter() {
    }

    static {
        GSON = new Gson();
    }

    public static <T> T fromJson(String r1, Class<T> r2) {
        return (T) GSON.fromJson(r1, r2);
    }

    public static <T> T fromJson(String r1, Type r2) {
        return (T) GSON.fromJson(r1, r2);
    }

    public static String toJson(Object r1) {
        return GSON.toJson(r1);
    }

    public static <T> String toJson(Object r1, Type r2) {
        return GSON.toJson(r1, r2);
    }

    public static Type canonicalize(Type r0) {
        return C$Gson$Types.canonicalize(r0);
    }

    public static <T> T fromJsonSafely(String r1, Class<T> r2) {
        return (T) GSON.fromJson(r1, r2);
    L4:
        return null;
    }

    public static <T> T fromJsonSafely(String r1, Type r2) {
        return (T) GSON.fromJson(r1, r2);
    L4:
        return null;
    }
}
