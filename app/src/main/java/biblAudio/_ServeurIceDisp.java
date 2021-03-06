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

public abstract class _ServeurIceDisp extends Ice.ObjectImpl implements ServeurIce
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::biblAudio::ServeurIce"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public final void afficherMorceaux()
    {
        afficherMorceaux(null);
    }

    public final boolean bAjoutMorceau(String sNomArt, String sNomMorc, String sFic, int uiDureeMorc, int uiDateSortie)
    {
        return bAjoutMorceau(sNomArt, sNomMorc, sFic, uiDureeMorc, uiDateSortie, null);
    }

    public final Morceau bRechercherMorceau(String sNomMusique)
    {
        return bRechercherMorceau(sNomMusique, null);
    }

    public final boolean bSuprMorceau(String sNomMorc, String sNomArt)
    {
        return bSuprMorceau(sNomMorc, sNomArt, null);
    }

    public final Morceau[] getMorceauxArt(String sNomArt)
    {
        return getMorceauxArt(sNomArt, null);
    }

    public final Morceau[] getMorceauxMorc(String sNomMorc)
    {
        return getMorceauxMorc(sNomMorc, null);
    }

    public final void readSound(String sNomMorceau, String sNomArtiste)
    {
        readSound(sNomMorceau, sNomArtiste, null);
    }

    public final void readSoundFic(String pathToFic)
    {
        readSoundFic(pathToFic, null);
    }

    public final void stopSound()
    {
        stopSound(null);
    }

    public static Ice.DispatchStatus ___afficherMorceaux(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.readEmptyParams();
        __obj.afficherMorceaux(__current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___bRechercherMorceau(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String sNomMusique;
        sNomMusique = __is.readString();
        __inS.endReadParams();
        Morceau __ret = __obj.bRechercherMorceau(sNomMusique, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        Morceau.__write(__os, __ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___bAjoutMorceau(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String sNomArt;
        String sNomMorc;
        String sFic;
        int uiDureeMorc;
        int uiDateSortie;
        sNomArt = __is.readString();
        sNomMorc = __is.readString();
        sFic = __is.readString();
        uiDureeMorc = __is.readInt();
        uiDateSortie = __is.readInt();
        __inS.endReadParams();
        boolean __ret = __obj.bAjoutMorceau(sNomArt, sNomMorc, sFic, uiDureeMorc, uiDateSortie, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeBool(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___bSuprMorceau(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String sNomMorc;
        String sNomArt;
        sNomMorc = __is.readString();
        sNomArt = __is.readString();
        __inS.endReadParams();
        boolean __ret = __obj.bSuprMorceau(sNomMorc, sNomArt, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeBool(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getMorceauxArt(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String sNomArt;
        sNomArt = __is.readString();
        __inS.endReadParams();
        Morceau[] __ret = __obj.getMorceauxArt(sNomArt, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        mvectRechercheHelper.write(__os, __ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getMorceauxMorc(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String sNomMorc;
        sNomMorc = __is.readString();
        __inS.endReadParams();
        Morceau[] __ret = __obj.getMorceauxMorc(sNomMorc, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        mvectRechercheHelper.write(__os, __ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___stopSound(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.readEmptyParams();
        __obj.stopSound(__current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___readSoundFic(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String pathToFic;
        pathToFic = __is.readString();
        __inS.endReadParams();
        __obj.readSoundFic(pathToFic, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___readSound(ServeurIce __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String sNomMorceau;
        String sNomArtiste;
        sNomMorceau = __is.readString();
        sNomArtiste = __is.readString();
        __inS.endReadParams();
        __obj.readSound(sNomMorceau, sNomArtiste, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "afficherMorceaux",
        "bAjoutMorceau",
        "bRechercherMorceau",
        "bSuprMorceau",
        "getMorceauxArt",
        "getMorceauxMorc",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "readSound",
        "readSoundFic",
        "stopSound"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___afficherMorceaux(this, in, __current);
            }
            case 1:
            {
                return ___bAjoutMorceau(this, in, __current);
            }
            case 2:
            {
                return ___bRechercherMorceau(this, in, __current);
            }
            case 3:
            {
                return ___bSuprMorceau(this, in, __current);
            }
            case 4:
            {
                return ___getMorceauxArt(this, in, __current);
            }
            case 5:
            {
                return ___getMorceauxMorc(this, in, __current);
            }
            case 6:
            {
                return ___ice_id(this, in, __current);
            }
            case 7:
            {
                return ___ice_ids(this, in, __current);
            }
            case 8:
            {
                return ___ice_isA(this, in, __current);
            }
            case 9:
            {
                return ___ice_ping(this, in, __current);
            }
            case 10:
            {
                return ___readSound(this, in, __current);
            }
            case 11:
            {
                return ___readSoundFic(this, in, __current);
            }
            case 12:
            {
                return ___stopSound(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}
