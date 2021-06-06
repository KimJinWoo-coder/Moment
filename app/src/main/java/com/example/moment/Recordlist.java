package com.example.moment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.File;

@Entity
public class Recordlist {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public static Class<? extends String[]> file;
}
