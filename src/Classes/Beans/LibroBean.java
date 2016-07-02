
package Classes.Beans;

public class LibroBean implements java.io.Serializable{
    
    private String isbn;
    private String titulo;
    private int paginas;
    private String estatus;
    private int numeroPrestamos;
    private int idLibro;
    private int Editorial_idEditorial;
    private int Area_idArea;
    
    public LibroBean(){}
    
//    Setters for class LibroBean

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

    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    
//    Getters for class LibroBean

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

    public int getNumeroPrestamos() {
        return numeroPrestamos;
    }

    public int getIdLibro() {
        return idLibro;
    }
}
