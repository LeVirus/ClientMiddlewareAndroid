package ceri.clientmiddleware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import Ice.InitializationData;

public class MainActivity extends AppCompatActivity {
    private Ice.Communicator communicator = null;
    private LecteurM lecteurM = null;
    //private AudioRecorder recorder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIce();
        connect();
    }


    void initIce(){
        try{
        InitializationData initData = new InitializationData();
        initData.properties = Ice.Util.createProperties();
        //String address = "127.0.0.1";
        String address = "192.168.1.38";//rasberry
        initData.properties.setProperty("Ice.Default.Router", "Glacier2/router:tcp -h " + address + " -p 10000");
        initData.properties.setProperty("Ice.ACM.Client", "0");
        initData.properties.setProperty("Ice.RetryIntervals", "-1");
        initData.properties.setProperty("CallbackAdapter.Router", "Glacier2/router:tcp -h " + address + " -p 10000");
        communicator = Ice.Util.initialize(initData);
    } catch (Exception e) {
        Log.e("Ice", e.toString());
    }
    }

    private void connect() {
        if (lecteurM == null /*|| lecteurM.isNotWorking()*/)
            lecteurM = new LecteurM(communicator, this);
        //lecteurM.run(communicator, this);
       // recorder = new BuiltinAudioRecorder(this);
    }
}
