// **********************************************************************
//
// Copyright (c) 2003-2015 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.1
//
// <auto-generated>
//
// Generated from file `interface.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package biblAudio;

public interface _ServeurIceOperationsNC
{
    void afficherMorceaux();

    Morceau bRechercherMorceau(String sNomMusique);

    boolean bAjoutMorceau(String sNomArt, String sNomMorc, String sFic, int uiDureeMorc, int uiDateSortie);

    boolean bSuprMorceau(String sNomMorc, String sNomArt);

    Morceau[] getMorceauxArt(String sNomArt);

    Morceau[] getMorceauxMorc(String sNomMorc);

    void stopSound();

    void readSoundFic(String pathToFic);

    void readSound(String sNomMorceau, String sNomArtiste);
}
