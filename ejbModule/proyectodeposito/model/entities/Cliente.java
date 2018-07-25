package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private String idCliente;

	@Column(name="ciudad_cliente")
	private String ciudadCliente;

	@Column(name="descripcion_cliente")
	private String descripcionCliente;

	@Column(name="direccion_cliente")
	private String direccionCliente;

	@Column(name="email_cliente")
	private String emailCliente;

	@Column(name="nombre_cliente")
	private String nombreCliente;

	@Column(name="telefono_cliente")
	private BigDecimal telefonoCliente;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="cliente")
	private List<Transaccion> transaccions;

	public Cliente() {
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCiudadCliente() {
		return this.ciudadCliente;
	}

	public void setCiudadCliente(String ciudadCliente) {
		this.ciudadCliente = ciudadCliente;
	}

	public String getDescripcionCliente() {
		return this.descripcionCliente;
	}

	public void setDescripcionCliente(String descripcionCliente) {
		this.descripcionCliente = descripcionCliente;
	}

	public String getDireccionCliente() {
		return this.direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public BigDecimal getTelefonoCliente() {
		return this.telefonoCliente;
	}

	public void setTelefonoCliente(BigDecimal telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setCliente(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setCliente(null);

		return transaccion;
	}

}