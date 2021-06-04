package com.example.moment;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Recordlist.class}, version = 1)
public abstract class RecordlistDatabase extends RoomDatabase {
    public abstract RecordlistDao getRecordlistDao();
}
