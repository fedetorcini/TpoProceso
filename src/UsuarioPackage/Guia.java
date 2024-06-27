package src.UsuarioPackage;

import java.util.ArrayList;
import java.util.HashMap;

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
	private Object foto;

	public Guia() {
		pais = "";
		ciudad = "";
		calificaciones = new ArrayList<Float>();
		servicios = new ArrayList<Servicio>();
		idiomas = new ArrayList<String>();
	}

	private void Initialize(Guia guia) {
		Initialize(guia.medioLogin, guia.nombre, guia.apellido, guia.mail, "", guia.sexo, guia.dni, guia.telefono, guia.pais, guia.ciudad);
		this.calificaciones = guia.calificaciones;
		this.servicios = guia.servicios;
		this.id = guia.id;
	}

	private void Initialize(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
		InitializeUsuario(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono);
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public void RegistrarGuia(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {

		boolean success = medioLogin.RegistrarUsuario(mail, contraseña);
		Initialize(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad);
		this.id = IDs;
		IDs++;
		guias.put(id, this);

		System.out.println("Guia " + this + " fue creado exitosamente");
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

	public static ArrayList<GuiaDTO> GetGuiasDTO() {
		ArrayList<GuiaDTO> dtos = new ArrayList<>();

		for (Guia guia : guias.values()) {
			dtos.add(new GuiaDTO(guia));
		}

		return dtos;
	}

	public boolean Login(String email, String contraseña) {
		return false;
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
			if (guia.mail == email) {
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
	@Override
	public String toString() { return ciudad + ", " + pais; }
}
