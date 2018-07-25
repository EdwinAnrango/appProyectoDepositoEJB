package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_medida database table.
 * 
 */
@Entity
@Table(name="tipo_medida")
@NamedQuery(name="TipoMedida.findAll", query="SELECT t FROM TipoMedida t")
public class TipoMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_MEDIDA_IDTIPO_GENERATOR", sequenceName="SEQ_TIPO_MEDIDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_MEDIDA_IDTIPO_GENERATOR")
	@Column(name="id_tipo")
	private long idTipo;

	@Column(name="detalle_tipo")
	private String detalleTipo;

	@Column(name="nombre_tipo")
	private String nombreTipo;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tipoMedida")
	private List<Producto> productos;

	public TipoMedida() {
	}

	public long getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDetalleTipo() {
		return this.detalleTipo;
	}

	public void setDetalleTipo(String detalleTipo) {
		this.detalleTipo = detalleTipo;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setTipoMedida(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setTipoMedida(null);

		return producto;
	}

}