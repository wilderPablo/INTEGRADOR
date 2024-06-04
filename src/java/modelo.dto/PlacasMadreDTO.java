package modelo.dto;

/**
 *
 * @author ander
 */
public class PlacasMadreDTO {

    private int idProducto;
    private String marca;
    private String chipset;
    private String socket;
    private String procesadoresCompatibles;
    private String tipoDeMemoria;
    private int ranurasDeMemoriaRAM;
    private String nombre;
    private double precio;
    private String imagen;

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getProcesadoresCompatibles() {
        return procesadoresCompatibles;
    }

    public void setProcesadoresCompatibles(String procesadoresCompatibles) {
        this.procesadoresCompatibles = procesadoresCompatibles;
    }

    public String getTipoDeMemoria() {
        return tipoDeMemoria;
    }

    public void setTipoDeMemoria(String tipoDeMemoria) {
        this.tipoDeMemoria = tipoDeMemoria;
    }

    public int getRanurasDeMemoriaRAM() {
        return ranurasDeMemoriaRAM;
    }

    public void setRanurasDeMemoriaRAM(int ranurasDeMemoriaRAM) {
        this.ranurasDeMemoriaRAM = ranurasDeMemoriaRAM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
