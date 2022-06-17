package seguridad.controlador;


public class clsPeliculas {
 private int idPeliculas;   
 private String Nombre;
 private String Clasificación;
 private String Genero;
 private String Subtitulado;
 private String Idioma;
 private int precio;

 
 

    public clsPeliculas() {
    }

    public clsPeliculas(int idPeliculas, String Nombre, String Clasificación, String Genero, String Subtitulado, String Idioma, int precio ) {
        this.idPeliculas = idPeliculas;
        this.Nombre = Nombre;
        this.Clasificación = Clasificación;
        this.Genero = Genero;
        this.Subtitulado = Subtitulado;
        this.Idioma = Idioma;
        this.precio = precio;
    }



    public int getidPeliculas() {
        return idPeliculas;
    }

    public void setProdid(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }
 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClasificación() {
        return Clasificación;
    }

    public void setClasificación(String Clasificación) {
        this.Clasificación = Clasificación;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getSubtitulado() {
        return Subtitulado;
    }

    public void setSubtitulado(String Subtitulado) {
        this.Subtitulado = Subtitulado;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }
    public int getidprecio() {
        return precio;
    }

    public void setprecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "clsPeliculas{" + "idPeliculas=" + idPeliculas + ", Nombre=" + Nombre + ", Clasificación=" + Clasificación + ", Genero=" + Genero + ", Subtitulado=" + Subtitulado + ", Idioma=" + Idioma + ", precio=" + precio + '}';
    }
    

    


 
    
}
