package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
final class JsonUtil {
    static boolean isValidString(String s) {
        return JsonParser.isValidString(s);
    }

    static JsonObject parseJson(String jsonString) throws JwtInvalidException {
        return JsonParser.parse(jsonString).getAsJsonObject();
    L4:
        e = move-exception;
        throw new JwtInvalidException("invalid JSON: " + e);
    }

    static JsonArray parseJsonArray(String jsonString) throws JwtInvalidException {
        return JsonParser.parse(jsonString).getAsJsonArray();
    L4:
        e = move-exception;
        throw new JwtInvalidException("invalid JSON: " + e);
    }

    private JsonUtil() {
    }
}
