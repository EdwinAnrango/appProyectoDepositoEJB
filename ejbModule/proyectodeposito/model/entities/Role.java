package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLES_IDROL_GENERATOR", sequenceName="SEQ_ROLES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_IDROL_GENERATOR")
	@Column(name="id_rol")
	private long idRol;

	@Column(name="detalle_rol")
	private String detalleRol;

	@Column(name="tipo_rol")
	private String tipoRol;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="role")
	private List<Usuario> usuarios;

	public Role() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getDetalleRol() {
		return this.detalleRol;
	}

	public void setDetalleRol(String detalleRol) {
		this.detalleRol = detalleRol;
	}

	public String getTipoRol() {
		return this.tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRole(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRole(null);

		return usuario;
	}

}