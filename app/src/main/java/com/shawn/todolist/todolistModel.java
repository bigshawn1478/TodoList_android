package com.shawn.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class todolistModel {
    public final static String CreateTableSQL =
            "CREATE TABLE TodoList ( _ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "                        TITLE TEXT NOT NULL," +
            "                        CONTENT TEXT )";

    private SQLiteDatabase db;

    public todolistModel(Context context) {
        db = DBHelper.getDatabase(context);
    }

    public todolistItem insert(todolistItem item) {
        ContentValues contentValue = new ContentValues();

        contentValue.put("title", item.getTitle());
        contentValue.put("content", item.getContent());

        long id = db.insert("TodoList", null, contentValue);

        item.setId(id);

        return item;
    }

    public boolean update (todolistItem item) {
        ContentValues contentValue = new ContentValues();

        contentValue.put("title", item.getTitle());
        contentValue.put("content", item.getContent());

        String where = "_ID = " + item.getId();

        return  db.update("TodoList", contentValue, where, null) > 0;
    }

    public boolean delete (long id) {
        String where = String.format("_ID = %d", id);

        return db.delete("TodoList", where, null) > 0;
    }

    public List<todolistItem> getAll() {
        List<todolistItem> result = new ArrayList<>();
        Cursor cursor = db.query("TodoList", null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();

        return result;
    }

    public todolistItem getItem (long id) {
        todolistItem item = null;

        String where = String.format("_ID = %d", id);

        Cursor cursor = db.query("TodoList", null, where,null, null, null, null);

        if (cursor.moveToFirst()) {
            item = getRecord(cursor);
        }

        cursor.close();

        return item;
    }

    public todolistItem getRecord(Cursor cursor) {
        todolistItem item = new todolistItem(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2));



        return item;
    }

    public int getCount () {
        int count = 0;

        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM TodoList", null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(1);
        }

        return count;
    }
}
