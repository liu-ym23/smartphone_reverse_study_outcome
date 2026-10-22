package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.bytedance.platform.godzilla.common.Constant;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    public JsonArrayRequest(String r7, Response.Listener<JSONArray> r8, Response.ErrorListener r9) {
        super(0, r7, null, r8, r9);
    }

    public JsonArrayRequest(int r7, String r8, JSONArray r9, Response.Listener<JSONArray> r10, Response.ErrorListener r11) {
        if (r9 != null) goto L4;
        String r12 = null;
    L5:
        super(r7, r8, r12, r10, r11);
        return;
    L4:
        r12 = r9.toString();
        goto L5
    }

    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse r4) {
        return Response.success(new JSONArray(new String(r4.data, HttpHeaderParser.parseCharset(r4.headers, Constant.CHARSET_UTF_8))), HttpHeaderParser.parseCacheHeaders(r4));
    L7:
        e = move-exception;
        return Response.error(new ParseError(e));
    L4:
        e = move-exception;
        return Response.error(new ParseError(e));
    }
}
