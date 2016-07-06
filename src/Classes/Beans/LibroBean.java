
package Classes.Beans;

public class LibroBean implements java.io.Serializable{
    
    private int idLibro;
    private String isbn;
    private String titulo;
    private int paginas;
    private String estatus;
    private int Autor;
    private int numeroPrestamos;
    private int Editorial;
    private int Area;
    private int Localizacion;

    public LibroBean(){}
    
    //Setters for the class LibroBeans
    
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    public void setAutor(int Autor){
    this.Autor=Autor;
    }

    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

    public void setEditorial(int Editorial) {
        this.Editorial = Editorial;
    }

    public void setArea(int Area) {
        this.Area = Area;
    }

    public void setLocalizacion(int Localizacion) {
        this.Localizacion = Localizacion;
    }
    
    // Getters for the class LibroBeans
    
    public int getIdLibro() {
        return idLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getEstatus() {
        return estatus;
    }
    
    public int getAutor(){
        return Autor;
    }

    public int getNumeroPrestamos() {
        return numeroPrestamos;
    }

    public int getEditorial() {
        return Editorial;
    }

    public int getArea() {
        return Area;
    }

    public int getLocalizacion() {
        return Localizacion;
    }

}
