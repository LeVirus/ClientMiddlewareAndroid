package ceri.clientmiddleware;

import java.util.ArrayList;

import biblAudio.Morceau;


/**
 * Created by cyril on 07/05/16.
 */
public class InterpretVocal {

    ArrayList<Morceau> arrMorc;


    //actions possibles :: listen, stop, remove, upload, display
    String action, music, nomArtiste;
    ArrayList<String> request;

    public InterpretVocal(){
        reinit();
        initMusicBase();
    }

    public InterpretVocal(ArrayList<String> requ){
        reinit();
        initMusicBase();
        setRequest(requ);
    }

    void initMusicBase(){
        arrMorc = new ArrayList<Morceau>();
        arrMorc.add(new Morceau("hotelcalifornia", "eagles", "/music/ht.mp3", 1980, 360));
        arrMorc.add(new Morceau("goingtobrazil", "motorhead", "/music/ht.mp3", 1980, 360));
        arrMorc.add(new Morceau("Dracula", "gorillaz", "/music/ht.mp3", 1980, 360));
        arrMorc.add(new Morceau("fez", "disasterpiece", "/music/ht.mp3", 1980, 360));
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
        if( action == "listen" || action == "display" )checkMusic();

        String str =  new String("no");

        return ( action.compareTo( str ) != 0 && music.compareTo( str ) != 0 );
    }

    void checkMusic() {

        String[] mots = request.get(0).split(" ");

        for ( String s : mots ){
            //String[] mots = s.split(" ");
            System.out.println( s +"    requ");
            for ( Morceau m : arrMorc ) {
                System.out.println( m.msNomMorceau +"    nommorc");

                //partie action
                if ( m.msNomMorceau.contains( s ) ){
                    music = m.msNomMorceau;
                    nomArtiste = m.msNomArtiste;
                    return;
                }
            }
        }
    }

    void checkAction(){

        String[] mots = request.get(0).split(" ");

        for(String s :mots){
            System.out.println( s +"    requ");
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
