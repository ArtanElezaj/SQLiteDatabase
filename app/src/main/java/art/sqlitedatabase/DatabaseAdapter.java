package art.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {
 ArtanHelper artanHelper;

    public DatabaseAdapter(Context context){
        artanHelper = new ArtanHelper(context);
    }


    public long insertData (String name, String password){

        SQLiteDatabase db = artanHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ArtanHelper.NAME, name);
        contentValues.put(ArtanHelper.PASSWORD, password);
        long id = db.insert(ArtanHelper.TABLE_NAME, null, contentValues);

        return id;
    }


}
