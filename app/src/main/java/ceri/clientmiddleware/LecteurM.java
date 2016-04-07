package ceri.clientmiddleware;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;

import biblAudio.Morceau;
import biblAudio.ServeurIcePrx;
import biblAudio.ServeurIcePrxHelper;

/**
 * Created by cyril on 07/04/16.
 */
public class LecteurM implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer = null;
    private String token = null;
    private Morceau playingSong = null;
    private Morceau selectedSong = null;
    private ServeurIcePrx serveur = null;
    private boolean lectureEnCours = false;
    private boolean enPause = false;
    private boolean isLoading = false;
    private boolean connecte = false;
    private boolean lance = false;
    private Activity memActivity = null;
    private Ice.Communicator communicator;
    private Activity mainActivity;
    private Glacier2.RouterPrx brasier = null;

    public LecteurM(Ice.Communicator comm, final Activity mainAct){
        communicator = comm;
        mainActivity = mainAct;
        initRouter();
        initServer();
    }


    private void initRouter() {
        System.out.print("initRooter\n");

        try {
            System.out.print("try\n");

            Ice.RouterPrx defaultRouter = communicator.getDefaultRouter();
            brasier = Glacier2.RouterPrxHelper.checkedCast(defaultRouter);
            try {
                brasier.createSession("alarm", "alarm");
                connecte = true;
            } catch (Exception e) {
                System.out.print("sss\n");

                Log.e("Glacier2Login", e.toString());
            }
        } catch (Exception e) {
            System.out.print("qqq\n");

            Log.e("Glacier2", e.toString());
        }
    }

    private void initServer() {
        System.out.print("kikooooo\n");

        if (connecte)
            return;
        try {

            Ice.ObjectPrx base = communicator.stringToProxy("BiblAudio:tcp -h 192.168.1.38 -p 10000");
            //Ice.ObjectPrx base = communicator.stringToProxy("StreamMetaServer:tcp -h " + address + " -p " + port);
            serveur = ServeurIcePrxHelper.checkedCast(base);
            lance = true;
            connecte = true;
            System.out.print("connecté\n");

        } catch (Exception e) {
            System.out.print("sdijbgdofui\n");

            Log.e("StreamMetaServer", e.toString());
        }
    }

    public void lireMorceauParfichier(String pathFic){
        if(serveur == null){
            System.out.print("serveur non detecte\n");
            return;
        }
        serveur.readSoundFic(pathFic);
    }


    public void onPrepared(MediaPlayer mp) {
        Play();
    }

    public void Play() {
        if (token == null /*|| isNotWorking()*/)
            return;
        if (selectedSong.equals(playingSong)) {
            lectureEnCours = true;
            enPause = false;
            memActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //controlButton.setImageResource(R.drawable.ic_pause_white_24dp);
                    //controlButton.setEnabled(true);
                }
            });
        }
        isLoading = false;
        mediaPlayer.start();
    }
}
