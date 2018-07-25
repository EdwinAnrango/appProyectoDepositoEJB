package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACCION_IDTRANSACCION_GENERATOR", sequenceName="SEQ_TRANSACCION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACCION_IDTRANSACCION_GENERATOR")
	@Column(name="id_transaccion")
	private long idTransaccion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Detalleventa
	@ManyToOne
	@JoinColumn(name="id_ventas")
	private Detalleventa detalleventa;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Transaccion() {
	}

	public long getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Detalleventa getDetalleventa() {
		return this.detalleventa;
	}

	public void setDetalleventa(Detalleventa detalleventa) {
		this.detalleventa = detalleventa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}