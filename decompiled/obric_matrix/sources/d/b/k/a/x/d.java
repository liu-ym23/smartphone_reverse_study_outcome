package d.b.k.a.x;

import d.b.k.a.o;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static o a() {
        return (o) Class.forName("com.bytedance.lighten.loader.PicassoImageLoaderDelegate").asSubclass(o.class).getConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
