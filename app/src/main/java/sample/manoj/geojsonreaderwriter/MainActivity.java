package sample.manoj.geojsonreaderwriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.R.attr.data;

public class MainActivity extends Activity {

    public static final String LOG_TAG = "GEOJSONREADERWRITER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeToJSONFile();
    }

    private void writeToJSONFile(){
        File file = createNewFile();
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            Log.d(LOG_TAG, "File not found exception");
        }
        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
        try {
            myOutWriter.append("manoj");
            myOutWriter.close();
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.d(LOG_TAG, "Unable to write to file : "+ e.getMessage());
        }
    }

    private File createNewFile(){
        File file = new File(Environment.getExternalStorageDirectory()+ "/documents", "test1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            Log.d(LOG_TAG, "Exception in creating new file : "+ e.getMessage());
        }
        return file;
    }
}
