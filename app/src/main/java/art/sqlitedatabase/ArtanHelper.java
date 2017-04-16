package art.sqlitedatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ArtanHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "artanDatabase";
    public static final String TABLE_NAME = "ARTANTABLE";
    private static final int DATABASE_VERSION = 3;
    private static final String UID = "_id";
    public static final String NAME = "Name";
    public static final String PASSWORD = "Password";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+PASSWORD+" VARCHAR(255));";
    private static final String DELETE_TABLE = "DROP TABLE "+TABLE_NAME+" IF EXISTS";

    private Context mContext;

    public ArtanHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        Toast.makeText(mContext,"Constructor", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Toast.makeText(mContext,"onCreate", Toast.LENGTH_SHORT).show();
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            Toast.makeText(mContext,e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Toast.makeText(mContext,"onUpgrade", Toast.LENGTH_SHORT).show();
        try {
            sqLiteDatabase.execSQL(DELETE_TABLE);
            onCreate(sqLiteDatabase);
        } catch (SQLException e) {
            Toast.makeText(mContext,e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}

















