package com.android.settings.provision;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ActivateRequest extends JsonObjectRequest {
    private Map<String, String> responseHeaders;

    public ActivateRequest(int r1, String r2, JSONObject r3, Response.Listener<JSONObject> r4, Response.ErrorListener r5) {
        super(r1, r2, r3, r4, r5);
    }

    public ActivateRequest(String r1, JSONObject r2, Response.Listener<JSONObject> r3, Response.ErrorListener r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.android.volley.toolbox.JsonObjectRequest, com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse r2) {
        this.responseHeaders = r2.headers;
        return super.parseNetworkResponse(r2);
    }

    public Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap r0 = new HashMap();
        Map<String, String> r1 = super.getHeaders();     // Catch: AuthFailureError -> L7
        if (r1 == null) goto L6;
        r0.putAll(r1);     // Catch: AuthFailureError -> L7
    L6:
        return r0;
    }
}
