package com.obric.safecheck.data;

import androidx.exifinterface.media.ExifInterface;
import com.obric.safecheck.database.entity.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsedData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/data/ParsedData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/safecheck/database/entity/Item;", "", "()V", "endTime", "", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getCount", "", "getItems", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ParsedData<T extends Item> {
    private String endTime;

    public abstract int getCount();

    public abstract List<T> getItems();

    public ParsedData() {
        this.endTime = "";
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.endTime = r2;
    }
}
