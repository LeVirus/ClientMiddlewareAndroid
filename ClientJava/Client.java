import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import biblAudio.Morceau;
import java.util.ArrayList;


class MonitorI extends biblAudio._MonitorDisp {
	@Override
		public void report(String action, biblAudio.Morceau morceau, Ice.Current __current) {
			System.out.print(action+"\n");
		}
}

public class Client extends HttpServlet{

	String action, music, nomArtiste;
	String requestt = null;
	ArrayList<Morceau> arrMorc;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {

			requestt =  request.getParameter("requete");

			boolean granted =  launchInterpret();

			if(granted)sendIce();

			else System.out.println("requete FAUSSE");

		}

	public void reinit(){
		action = "no";
		music = "no";
		nomArtiste = "no";
	}

	public boolean launchInterpret(){
		if(requestt == null || requestt.isEmpty() )return false;

		reinit();

		checkAction();
		if( action == "listen" || action == "display" )checkMusic();

		String str =  new String("no");

		return ( action.compareTo( str ) != 0 && music.compareTo( str ) != 0 );
	}

	void checkMusic() {

		String[] mots = requestt.split(" ");

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

		String[] mots = requestt.split(" ");

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

	void sendIce()
	{
		int status = 0;
		Ice.Communicator ic = null;
		IceStorm.TopicPrx topic = null;
		Ice.ObjectPrx proxy = null;
		try {
			String[] s=new String[0];
			ic = Ice.Util.initialize(s);
			Ice.ObjectPrx base = ic.stringToProxy("BiblAudio:default -p 10000");//local
			//Ice.ObjectPrx base = ic.stringToProxy("BiblAudio:tcp -h 192.168.1.43 -p 10000");//rasberry

			biblAudio.ServeurIcePrx serverIce = biblAudio.ServeurIcePrxHelper.checkedCast(base);
			if (serverIce == null){
				System.out.println("Invalid proxy.");
				throw new Error("Invalid proxy");
			}



	//		serverIce.afficherMorceaux();

			//serverIce.bAjoutMorceau(na,  nm,  cf,  d ,  ds);
			//					monitor.report(m);

			//serverIce.bSuprMorceau( nmm, nma );

			//biblAudio.Morceau[] vect = serverIce.getMorceauxArt( naa );
			//biblAudio.Morceau[] vectt = serverIce.getMorceauxMorc( nab );

			//serverIce.readSoundFic(nac);
			String test="music/fez.mp3";
			serverIce.readSoundFic(test);

			//serverIce.readSound(nmt,nmy);

	//		serverIce.stopSound();



	//		ic.waitForShutdown();


		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			// Clean up
			//
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}
}
