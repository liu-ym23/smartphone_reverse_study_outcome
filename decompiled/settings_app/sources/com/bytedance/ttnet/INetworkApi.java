package com.bytedance.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface INetworkApi {
    @GET
    Call<String> doGet(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@MaxLength int r1, @Url String r2, @QueryMap Map<String, String> r3, @FieldMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @POST
    Call<String> postBody(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5);

    @Multipart
    @POST
    Call<String> postMultiPart(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @PartMap Map<String, TypedOutput> r4, @HeaderList List<Header> r5);
}
