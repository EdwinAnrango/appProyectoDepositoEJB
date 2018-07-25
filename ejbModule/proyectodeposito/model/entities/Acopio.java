package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the acopio database table.
 * 
 */
@Entity
@NamedQuery(name="Acopio.findAll", query="SELECT a FROM Acopio a")
public class Acopio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACOPIO_IDACOPIO_GENERATOR", sequenceName="SEQ_ACOPIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACOPIO_IDACOPIO_GENERATOR")
	@Column(name="id_acopio")
	private long idAcopio;

	@Column(name="cantidad_acopio")
	private BigDecimal cantidadAcopio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_acopio")
	private Date fechaAcopio;

	@Column(name="precio_total")
	private BigDecimal precioTotal;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Detalleventa
	@OneToMany(mappedBy="acopio")
	private List<Detalleventa> detalleventas;

	public Acopio() {
	}

	public long getIdAcopio() {
		return this.idAcopio;
	}

	public void setIdAcopio(long idAcopio) {
		this.idAcopio = idAcopio;
	}

	public BigDecimal getCantidadAcopio() {
		return this.cantidadAcopio;
	}

	public void setCantidadAcopio(BigDecimal cantidadAcopio) {
		this.cantidadAcopio = cantidadAcopio;
	}

	public Date getFechaAcopio() {
		return this.fechaAcopio;
	}

	public void setFechaAcopio(Date fechaAcopio) {
		this.fechaAcopio = fechaAcopio;
	}

	public BigDecimal getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Detalleventa> getDetalleventas() {
		return this.detalleventas;
	}

	public void setDetalleventas(List<Detalleventa> detalleventas) {
		this.detalleventas = detalleventas;
	}

	public Detalleventa addDetalleventa(Detalleventa detalleventa) {
		getDetalleventas().add(detalleventa);
		detalleventa.setAcopio(this);

		return detalleventa;
	}

	public Detalleventa removeDetalleventa(Detalleventa detalleventa) {
		getDetalleventas().remove(detalleventa);
		detalleventa.setAcopio(null);

		return detalleventa;
	}

}