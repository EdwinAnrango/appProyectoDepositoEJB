package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proveedor")
	private String idProveedor;

	@Column(name="apellido_proveedor")
	private String apellidoProveedor;

	@Column(name="direccion_proveedor")
	private String direccionProveedor;

	@Column(name="email_proveedor")
	private String emailProveedor;

	@Temporal(TemporalType.DATE)
	@Column(name="fechainscripcion_proveedor")
	private Date fechainscripcionProveedor;

	@Column(name="nombre_proveedor")
	private String nombreProveedor;

	@Column(name="telefono_proveedor")
	private BigDecimal telefonoProveedor;

	//bi-directional many-to-one association to Acopio
	@OneToMany(mappedBy="proveedor")
	private List<Acopio> acopios;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	public Proveedor() {
	}

	public String getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getApellidoProveedor() {
		return this.apellidoProveedor;
	}

	public void setApellidoProveedor(String apellidoProveedor) {
		this.apellidoProveedor = apellidoProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getEmailProveedor() {
		return this.emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	public Date getFechainscripcionProveedor() {
		return this.fechainscripcionProveedor;
	}

	public void setFechainscripcionProveedor(Date fechainscripcionProveedor) {
		this.fechainscripcionProveedor = fechainscripcionProveedor;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public BigDecimal getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(BigDecimal telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public List<Acopio> getAcopios() {
		return this.acopios;
	}

	public void setAcopios(List<Acopio> acopios) {
		this.acopios = acopios;
	}

	public Acopio addAcopio(Acopio acopio) {
		getAcopios().add(acopio);
		acopio.setProveedor(this);

		return acopio;
	}

	public Acopio removeAcopio(Acopio acopio) {
		getAcopios().remove(acopio);
		acopio.setProveedor(null);

		return acopio;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}