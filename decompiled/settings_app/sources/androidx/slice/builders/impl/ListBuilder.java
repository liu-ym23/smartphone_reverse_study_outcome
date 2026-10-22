package androidx.slice.builders.impl;

import android.app.PendingIntent;
import androidx.slice.builders.GridRowBuilder;
import androidx.slice.builders.SliceAction;
import java.time.Duration;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface ListBuilder {
    void addAction(SliceAction r1);

    void addGridRow(GridRowBuilder r1);

    void addInputRange(androidx.slice.builders.ListBuilder.InputRangeBuilder r1);

    void addRange(androidx.slice.builders.ListBuilder.RangeBuilder r1);

    void addRow(androidx.slice.builders.ListBuilder.RowBuilder r1);

    void setColor(int r1);

    void setHeader(androidx.slice.builders.ListBuilder.HeaderBuilder r1);

    void setIsError(boolean r1);

    void setKeywords(Set<String> r1);

    void setLayoutDirection(int r1);

    void setSeeMoreAction(PendingIntent r1);

    void setSeeMoreRow(androidx.slice.builders.ListBuilder.RowBuilder r1);

    void setTtl(long r1);

    void setTtl(Duration r1);
}
