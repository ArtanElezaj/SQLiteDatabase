package art.sqlitedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseAdapter databaseAdapter;
    EditText mName, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mName = (EditText)findViewById(R.id.name);
        mPassword= (EditText) findViewById(R.id.password);
        databaseAdapter = new DatabaseAdapter(this);
    }

    public void onLogin(View v){

        String name = mName.getText().toString();
        String password = mPassword.getText().toString();

        long id = databaseAdapter.insertData(name, password);
        if(id < 0){
            Toast.makeText(this,"unsuccessfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"successfully added", Toast.LENGTH_SHORT).show();
        }

    }
}
