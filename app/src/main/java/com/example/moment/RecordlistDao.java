package com.example.moment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface RecordlistDao {
    @Insert
    void insert(Recordlist recordlist);

    @Update
    void update(Recordlist recordlist);

    @Delete
    void delete(Recordlist recordlist);

    @Query("SELECT * FROM Recordlist")
    List<Recordlist> getAll();
}
