/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad.controlador;

/**
 *
 * @author movi2
 */
public class clsBitacora {
    int iId_bitacora;
    String sFecha;
    String sArea;
    String sAccion;
    String sIp;
    String sNombrepc;
    int iId_usuario;
    int iId_aplicacion;
    String area;
//ip
//usuario en compu
//scriptgeneral_g3

    public clsBitacora() {
    }

    public clsBitacora(int iId_bitacora) {
        this.iId_bitacora = iId_bitacora;
    }

    public clsBitacora(String area,String sFecha, String sArea, String sAccion, String sIp, String sNombrepc, int iId_usuario,int iId_aplicacion) {
        this.sFecha = sFecha;
        this.sArea = sArea;
        this.sAccion = sAccion;
        this.sIp = sIp;
        this.sNombrepc = sNombrepc;
        this.iId_usuario = iId_usuario;
        this.iId_aplicacion = iId_aplicacion;
        this.area=area;
    }

    public int fGetId_bitacora() {
        return iId_bitacora;
    }

    public void fSetId_Bitacora(int iId_bitacora) {
        this.iId_bitacora = iId_bitacora;
    }

    public String fGetfecha_Bitacora() {
        return sFecha;
    }

    public void fSetfecha_Bitacora(String sFecha) {
        this.sFecha = sFecha;
    }


    public String fGetarea_Bitacora() {
        return sArea;
    }

    public void fSetarea_Bitacora(String sArea) {
        this.sArea = sArea;
    }


    public String fGetaccion_Bitacora() {
        return sAccion;
    }

    public void fSetaccion_Bitacora(String sAccion) {
        this.sAccion = sAccion;
    }

    public String fGetip_Bitacora() {
        return sIp;
    }

    public void fSetip_Bitacora(String sIp) {
        this.sIp = sIp;
    }

    public String fGetnombrepc_Bitacora() {
        return sNombrepc;
    }

    public void fSetnombrepc_Bitacora(String sNombrepc) {
        this.sNombrepc = sNombrepc;
    }


  public int fGetId_Usuario() {
        return iId_usuario;
    }

    public void fSetId_Usuario(int iId_usuario) {
        this.iId_usuario = iId_usuario;
    }

  public int fGetId_Aplicacion() {
        return iId_aplicacion;
    }

    public void fSetId_Aplicacion(int iId_aplicacion) {
        this.iId_aplicacion = iId_aplicacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "clsBitacora{" + "iId_bitacora=" + iId_bitacora + ", sFecha=" + sFecha + ", sArea=" + sArea + ", sAccion=" + sAccion + ", sIp=" + sIp + ", sNombrepc=" + sNombrepc + ", iId_usuario=" + iId_usuario + ", iId_aplicacion=" + iId_aplicacion + ", area=" + area + '}';
    }





    
}
