package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the detalleventas database table.
 * 
 */
@Entity
@Table(name="detalleventas")
@NamedQuery(name="Detalleventa.findAll", query="SELECT d FROM Detalleventa d")
public class Detalleventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLEVENTAS_IDVENTAS_GENERATOR", sequenceName="SEQ_DETALLEVENTAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLEVENTAS_IDVENTAS_GENERATOR")
	@Column(name="id_ventas")
	private long idVentas;

	@Column(name="cantidad_venta")
	private BigDecimal cantidadVenta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_venta")
	private Date fechaVenta;

	@Column(name="preciototal_venta")
	private BigDecimal preciototalVenta;

	@Column(name="preciounitario_vent")
	private BigDecimal preciounitarioVent;

	//bi-directional many-to-one association to Acopio
	@ManyToOne
	@JoinColumn(name="id_acopio")
	private Acopio acopio;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="detalleventa")
	private List<Transaccion> transaccions;

	public Detalleventa() {
	}

	public long getIdVentas() {
		return this.idVentas;
	}

	public void setIdVentas(long idVentas) {
		this.idVentas = idVentas;
	}

	public BigDecimal getCantidadVenta() {
		return this.cantidadVenta;
	}

	public void setCantidadVenta(BigDecimal cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}

	public Date getFechaVenta() {
		return this.fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public BigDecimal getPreciototalVenta() {
		return this.preciototalVenta;
	}

	public void setPreciototalVenta(BigDecimal preciototalVenta) {
		this.preciototalVenta = preciototalVenta;
	}

	public BigDecimal getPreciounitarioVent() {
		return this.preciounitarioVent;
	}

	public void setPreciounitarioVent(BigDecimal preciounitarioVent) {
		this.preciounitarioVent = preciounitarioVent;
	}

	public Acopio getAcopio() {
		return this.acopio;
	}

	public void setAcopio(Acopio acopio) {
		this.acopio = acopio;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setDetalleventa(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setDetalleventa(null);

		return transaccion;
	}

}