package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidad_medida database table.
 * 
 */
@Entity
@Table(name="unidad_medida")
@NamedQuery(name="UnidadMedida.findAll", query="SELECT u FROM UnidadMedida u")
public class UnidadMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDAD_MEDIDA_IDMEDIDA_GENERATOR", sequenceName="SEQ_UNIDAD_MEDIDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDAD_MEDIDA_IDMEDIDA_GENERATOR")
	@Column(name="id_medida")
	private long idMedida;

	@Column(name="detalle_medida")
	private String detalleMedida;

	@Column(name="nombre_medida")
	private String nombreMedida;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="unidadMedida")
	private List<Producto> productos;

	public UnidadMedida() {
	}

	public long getIdMedida() {
		return this.idMedida;
	}

	public void setIdMedida(long idMedida) {
		this.idMedida = idMedida;
	}

	public String getDetalleMedida() {
		return this.detalleMedida;
	}

	public void setDetalleMedida(String detalleMedida) {
		this.detalleMedida = detalleMedida;
	}

	public String getNombreMedida() {
		return this.nombreMedida;
	}

	public void setNombreMedida(String nombreMedida) {
		this.nombreMedida = nombreMedida;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setUnidadMedida(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setUnidadMedida(null);

		return producto;
	}

}