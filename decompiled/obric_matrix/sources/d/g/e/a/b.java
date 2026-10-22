package d.g.e.a;

import android.util.Log;
import androidx.annotation.RequiresApi;
import h.a.b1;
import h.a.h;
import h.a.m0;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/obric/sdk/osettings/FileUtils;", "", "()V", "TAG", "", "readFileAsString", "fileName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "osettings_sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16944a = null;

    @kotlin.k0.j.a.f(c = "com.obric.sdk.osettings.FileUtils$readFileAsString$2", f = "FileUtils.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends l implements p<m0, kotlin.k0.d<? super String>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f16945f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f16946g;

        a(String r1, kotlin.k0.d<? super a> r2) {
            this.f16946g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new a(this.f16946g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super String> r2) {
            return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super String> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            kotlin.k0.i.b.c();
            if (this.f16945f != 0) goto L14;
            w.b(r5);
            Log.d("FileUtils", o.m("readFileAsString: ", this.f16946g));
            String r6 = null;
            Path r1 = Paths.get(this.f16946g, new String[0]);     // Catch: IOException -> L10
            if (Files.exists(r1, new LinkOption[0]) == true) goto L8;
            Log.e("FileUtils", "文件 " + this.f16946g + " 不存在");     // Catch: IOException -> L10
        L15:
        L12:
            return r6;
        L8:
            byte[] r4 = Files.readAllBytes(r1);     // Catch: IOException -> L10
            o.e(r4, "bytes");     // Catch: IOException -> L10
            r6 = new String(r4, kotlin.u0.d.f21429a);     // Catch: IOException -> L10
        L10:
            e = move-exception;
            Log.e("FileUtils", "读文件失败", e);
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f16944a = new b();
    }

    private b() {
    }

    @RequiresApi(26)
    public final Object a(String r3, kotlin.k0.d<? super String> r4) {
        return h.e(b1.b(), new a(r3, null), r4);
    }
}
