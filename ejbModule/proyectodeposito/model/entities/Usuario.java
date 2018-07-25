package proyectodeposito.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_IDUSUARIO_GENERATOR", sequenceName="SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_IDUSUARIO_GENERATOR")
	@Column(name="id_usuario")
	private long idUsuario;

	@Column(name="contrasena_usuario")
	private String contrasenaUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-one association to Acopio
	@OneToMany(mappedBy="usuario")
	private List<Acopio> acopios;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="usuario")
	private List<Transaccion> transaccions;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Role role;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasenaUsuario() {
		return this.contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Acopio> getAcopios() {
		return this.acopios;
	}

	public void setAcopios(List<Acopio> acopios) {
		this.acopios = acopios;
	}

	public Acopio addAcopio(Acopio acopio) {
		getAcopios().add(acopio);
		acopio.setUsuario(this);

		return acopio;
	}

	public Acopio removeAcopio(Acopio acopio) {
		getAcopios().remove(acopio);
		acopio.setUsuario(null);

		return acopio;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setUsuario(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setUsuario(null);

		return transaccion;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}