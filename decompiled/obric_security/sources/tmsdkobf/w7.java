package tmsdkobf;

import android.text.format.DateFormat;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.tencent.qqimagecompare.QQImageFeatureHSV;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class w7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f597a;
    public String b;
    public ArrayList c;

    public static class a extends d9 {
        public boolean h;
        public QQImageFeatureHSV i;
        public int j;
        public int k;

        public a(d9 r1) {
            super(r1);
        }

        public static String a(long r2) {
            if (r2 != 0) goto L7;
            return "";
        L7:
            return DateFormat.format(DateUtils.PATTERN_YEAR, r2).toString();
        }
    }

    public w7(long r2) {
        this.c = new ArrayList();
        this.f597a = r2;
        this.b = a.a(r2);
    }

    public w7(w7 r3) {
        this.f597a = r3.f597a;
        this.b = r3.b;
        this.c = new ArrayList();
    }
}
