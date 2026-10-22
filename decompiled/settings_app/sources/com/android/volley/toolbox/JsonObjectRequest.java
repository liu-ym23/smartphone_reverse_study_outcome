package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.bytedance.platform.godzilla.common.Constant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonObjectRequest extends JsonRequest<JSONObject> {
    public JsonObjectRequest(int r7, String r8, JSONObject r9, Response.Listener<JSONObject> r10, Response.ErrorListener r11) {
        if (r9 != null) goto L4;
        String r12 = null;
    L5:
        super(r7, r8, r12, r10, r11);
        return;
    L4:
        r12 = r9.toString();
        goto L5
    }

    public JsonObjectRequest(String r8, JSONObject r9, Response.Listener<JSONObject> r10, Response.ErrorListener r11) {
        if (r9 != null) goto L4;
        int r0 = 0;
    L5:
        this(r0, r8, r9, r10, r11);
        return;
    L4:
        r0 = 1;
        goto L5
    }

    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse r4) {
        return Response.success(new JSONObject(new String(r4.data, HttpHeaderParser.parseCharset(r4.headers, Constant.CHARSET_UTF_8))), HttpHeaderParser.parseCacheHeaders(r4));
    L7:
        e = move-exception;
        return Response.error(new ParseError(e));
    L4:
        e = move-exception;
        return Response.error(new ParseError(e));
    }
}
