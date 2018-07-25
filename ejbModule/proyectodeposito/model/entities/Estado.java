package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADOS_IDESTADO_GENERATOR", sequenceName="SEQ_ESTADOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOS_IDESTADO_GENERATOR")
	@Column(name="id_estado")
	private long idEstado;

	@Column(name="detalle_estado")
	private String detalleEstado;

	@Column(name="nombre_estado")
	private String nombreEstado;

	//bi-directional many-to-one association to Proveedor
	@OneToMany(mappedBy="estado")
	private List<Proveedor> proveedors;

	public Estado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDetalleEstado() {
		return this.detalleEstado;
	}

	public void setDetalleEstado(String detalleEstado) {
		this.detalleEstado = detalleEstado;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Proveedor> getProveedors() {
		return this.proveedors;
	}

	public void setProveedors(List<Proveedor> proveedors) {
		this.proveedors = proveedors;
	}

	public Proveedor addProveedor(Proveedor proveedor) {
		getProveedors().add(proveedor);
		proveedor.setEstado(this);

		return proveedor;
	}

	public Proveedor removeProveedor(Proveedor proveedor) {
		getProveedors().remove(proveedor);
		proveedor.setEstado(null);

		return proveedor;
	}

}