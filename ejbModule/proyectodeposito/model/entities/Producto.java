package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCTO_IDPRODUCTO_GENERATOR", sequenceName="SEQ_PRODUCTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTO_IDPRODUCTO_GENERATOR")
	@Column(name="id_producto")
	private long idProducto;

	@Column(name="descripcion_producto")
	private String descripcionProducto;

	@Column(name="nombre_producto")
	private String nombreProducto;

	//bi-directional many-to-one association to Acopio
	@OneToMany(mappedBy="producto")
	private List<Acopio> acopios;

	//bi-directional many-to-one association to TipoMedida
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private TipoMedida tipoMedida;

	//bi-directional many-to-one association to UnidadMedida
	@ManyToOne
	@JoinColumn(name="id_medida")
	private UnidadMedida unidadMedida;

	public Producto() {
	}

	public long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public List<Acopio> getAcopios() {
		return this.acopios;
	}

	public void setAcopios(List<Acopio> acopios) {
		this.acopios = acopios;
	}

	public Acopio addAcopio(Acopio acopio) {
		getAcopios().add(acopio);
		acopio.setProducto(this);

		return acopio;
	}

	public Acopio removeAcopio(Acopio acopio) {
		getAcopios().remove(acopio);
		acopio.setProducto(null);

		return acopio;
	}

	public TipoMedida getTipoMedida() {
		return this.tipoMedida;
	}

	public void setTipoMedida(TipoMedida tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public UnidadMedida getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}