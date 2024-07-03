package src.UsuarioPackage;

import java.util.ArrayList;
import java.util.HashMap;

import src.NotificadorPackage.Notificador;
import src.UsuarioPackage.TrofeoPackage.TrofeoCalificacion;
import src.UsuarioPackage.TrofeoPackage.TrofeoReseña;
import src.ViajePackage.Reseña;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.ViajePackage.ServicioPackage.Servicio;
import src.ViajePackage.Viaje;

public class Guia extends Usuario<Guia>{

	private static HashMap<Integer, Guia> guias = new HashMap<Integer, Guia>();
	private String pais;
	private String ciudad;
	private ArrayList<Float> calificaciones;
	private ArrayList<Servicio> servicios;
	private ArrayList<String> idiomas;
	private double anticipo;
	private Object foto;

	public Guia() {
		pais = "";
		ciudad = "";
		calificaciones = new ArrayList<Float>();
		servicios = new ArrayList<Servicio>();
		idiomas = new ArrayList<String>();
		anticipo = 0.1;
	}

	private void Initialize(Guia guia) {
		Initialize(guia.medioLogin, guia.nombre, guia.apellido, guia.mail, "", guia.sexo, guia.dni, guia.telefono, guia.pais, guia.ciudad);
		this.calificaciones = guia.calificaciones;
		this.servicios = guia.servicios;
		this.idiomas = guia.idiomas;
		this.id = guia.id;
		this.notificador = guia.notificador;
		this.viajes = guia.viajes;
		this.observadores = guia.observadores;
		this.anticipo = guia.anticipo;
	}

	private void Initialize(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
		InitializeUsuario(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono);
		this.ciudad = ciudad;
		this.pais = pais;
		this.idiomas.add(GuiaDTO.IDIOMA_ESPAÑOL);
	}

	public void RegistrarGuia(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
		medioLogin.RegistrarUsuario(mail, contraseña);

		this.notificador = new Notificador();
		TrofeoCalificacion.GetInstancia().Suscribir(this.notificador);
		this.Suscribir(TrofeoCalificacion.GetInstancia());

		this.Initialize(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad);
		this.id = IDs;
		IDs++;
		guias.put(id, this);
	}

	public float GetPromedio() {
		float promedio = 0;
		for(Float calificacion : calificaciones)
		{
			promedio += calificacion;
		}
		return promedio / calificaciones.size();
	}

	public void AgregarReseña(Reseña reseña) {
		calificaciones.add(reseña.GetCalificacion());
		Publicar(this);
		guias.put(id, this);
	}

	public void AgregarViaje(Viaje viaje) {
		viajes.put(viaje.GetId(), viaje);
		guias.put(id, this);
	}

	public void AgregarServicio(Servicio servicio){
		servicios.add(servicio);
		guias.put(id, this);
	}

	public void AgregarIdioma(String idioma) {
		idiomas.add(idioma);
		guias.put(id, this);
	}

	public static ArrayList<GuiaDTO> GetGuiasDTO() {
		ArrayList<GuiaDTO> dtos = new ArrayList<>();

		for (Guia guia : guias.values()) {
			dtos.add(new GuiaDTO(guia));
		}

		return dtos;
	}

	public boolean Login(String email, String contraseña) {
		return medioLogin.Login(email, contraseña);
	}
	@Override
	public void ActualizarPerfil(String nombre, String apellido, String sexo, int telefono, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.dni = dni;

		guias.put(id, this);
	}

	public GuiaDTO ToDTO() {
		GuiaDTO dto = new GuiaDTO(this);
		return dto;
	}

	public boolean GetPorId(int id) {

		boolean success = false;

		for(Guia guia : guias.values()) {
			if (guia.id == id) {
				Initialize(guia);
				success = true;
			}
		}
		return success;
	}

	public boolean GetPorMail(String email) {

		boolean success = false;

		for(Guia guia : guias.values()) {
			if (guia.mail.compareTo(email) == 0) {
				Initialize(guia);
				success = true;
			}
		}
		return success;
	}

	public boolean GetPorDTO(GuiaDTO guiaDTO) {
		return GetPorMail(guiaDTO.GetMail());
	}

	public String GetCiudad() { return ciudad; }

	public String GetPais() { return pais; }

	public double GetPrecioTotal() {
		double precio = 0;

		for(Servicio servicio : servicios){
			precio += servicio.getCosto();
		}

		return precio;
	}

	public ArrayList<String> GetIdiomas() { return idiomas; }

	public ArrayList<Servicio> GetServicios() { return servicios; }
	@Override
	public String toString() { return ciudad + ", " + pais; }

	public double GetPagoMinimo() { return anticipo * GetPrecioTotal();}
}
