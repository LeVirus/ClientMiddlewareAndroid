package ceri.clientmiddleware;

import java.util.ArrayList;

/**
 * Created by cyril on 07/05/16.
 */
public class InterpretVocal {

    //actions possibles :: listen, stop, remove, upload, display
    String action, music;
    ArrayList<String> request;

    public InterpretVocal(){
        reinit();
    }

    public InterpretVocal(ArrayList<String> requ){
        reinit();
        setRequest(requ);
    }

    public void reinit(){
        action = "no";
        music = "no";
    }

    public void setRequest(ArrayList<String> requ){
        request = requ;
    }




    public boolean launchInterpret(){
        if(request == null || request.isEmpty() )return false;

        reinit();

        checkAction();
        checkMusic();

        String str =  new String("no");

        return ( action.compareTo( str ) != 0 /*&& music.compareTo( str ) != 0*/ );
    }

    void checkMusic(){
        for(String s :request){
            System.out.print(s);

            //partie action
            if( s.contains("écout" ) || s.contains("lire" ) || s.contains("lis" )){
                action = "listen";
                System.out.print("\nlisten\n");
                break;
            }

            else if(s.contains("stop" ) || s.contains("arrê" ) ){
                action = "stop";
                System.out.print("\nstop\n");
                break;
            }

            else if(s.contains("suppr" ) || s.contains("vir" ) || s.contains("enlèv" ) || s.contains("enlev" )){
                action = "remove";
                System.out.print("\nremove\n");
                break;
            }

            else if(s.contains("affich" ) || s.contains("montr" )){
                action = "display";
                System.out.print("\ndisplay\n");
                break;
            }

        }
    }

    void checkAction(){
        for(String s :request){
            System.out.print(s);

            //partie action
            if( s.contains("écout" ) || s.contains("lire" ) || s.contains("lis" )){
                action = "listen";
                System.out.print("\nlisten\n");
                break;
            }

            else if(s.contains("stop" ) || s.contains("arrê" ) ){
                action = "stop";
                System.out.print("\nstop\n");
                break;
            }

            else if(s.contains("suppr" ) || s.contains("vir" ) || s.contains("enlèv" ) || s.contains("enlev" )){
                action = "remove";
                System.out.print("\nremove\n");
                break;
            }

            else if(s.contains("affich" ) || s.contains("montr" )){
                action = "display";
                System.out.print("\ndisplay\n");
                break;
            }

        }
    }
}
