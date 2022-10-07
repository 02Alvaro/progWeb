import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import entities.*;
import entities.enums.*;
import factory.ModalidadBono;
import factory.ModalidadIndividual;
import factory.ReservaAdultos;
import factory.ReservaFamiliar;
import factory.ReservaInfantil;
import handlers.CircuitHandler;
import handlers.ReservaHandler;
import handlers.UsuarioHandler;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println(UsuarioHandler.getInstance().getAllUsers());
		System.out.println(CircuitHandler.getInstance().getAllKarts());
		System.out.println(CircuitHandler.getInstance().getAllPistas());
		System.out.println(ReservaHandler.getInstance().getAllReserves());
		
		/*CircuitHandler.getInstance().addPista(new Pista(1,"Alvaro",true,DificultadPista.FAMILIAR,10));
		CircuitHandler.getInstance().addPista(new Pista(2,"Tom�s",true,DificultadPista.ADULTOS,10));
		CircuitHandler.getInstance().addPista(new Pista(5,"Juan",true,DificultadPista.INFANTIL,10));		
		for(int i=0;i<20;i++) {
			Kart aux = new Kart((i%2==0),EstadoKart.DISPONIBLE);
			CircuitHandler.getInstance().addKart(aux);
			CircuitHandler.getInstance().getPistaByID(5).asociarKartAPista(aux); 
		}
		for(int i=35;i<40;i++) {
			Kart aux = new Kart(true,EstadoKart.DISPONIBLE);
			CircuitHandler.getInstance().addKart(aux);
			CircuitHandler.getInstance().getPistaByID(2).asociarKartAPista(aux); 
		}
		for(int i=35;i<40;i++) {
			Kart aux = new Kart(true,EstadoKart.DISPONIBLE);
			CircuitHandler.getInstance().addKart(aux);
			CircuitHandler.getInstance().getPistaByID(1).asociarKartAPista(aux); 
		}
		
		UsuarioHandler.getInstance().addUser(new Usuario(2,"Alvaro",LocalDate.of(2000,12,31),"alvaro@gmail.com",LocalDate.of(2019, 1, 1)));
		UsuarioHandler.getInstance().addUser(new Usuario(1,"Juan",LocalDate.of(2000,1,1),"juan@gmail.com",LocalDate.of(2022, 12, 31)));
		
		
		
		ReservaAdultos ra	= new ModalidadBono().createReservaAdultos(1, LocalDateTime.now().plus(100,ChronoUnit.MINUTES), 100, 2, 0, 1, 1, 3);
		ReservaFamiliar mf	= new ModalidadBono().createReservaFamiliar(1, LocalDateTime.now().plus(100,ChronoUnit.MINUTES), 50, 1, 0, 1, 2, 1, 4);
		ReservaInfantil mi 	= new ModalidadBono().createReservaInfantil(2,LocalDateTime.now().plus(2,ChronoUnit.MINUTES),100,5,10f,0f,1,10);
		
		ReservaHandler.getInstance().addReservaIndividual(mi);
		ReservaHandler.getInstance().addReservaIndividual(mf);
		ReservaHandler.getInstance().addReservaIndividual(ra);		
*/
		
		// Menú
		// Declaracion de variables
	/*
		String fullName, email;
		boolean valid = false;
		int mainSelect = 0;
		int subMainSelect = 0;
		LocalDate date = LocalDate.now();
		

		Scanner input = new Scanner(System.in);
		do {
			mainMenu();
			mainSelect = input.nextInt();
			input.nextLine();
			switch (mainSelect) {
			case 0: // Salir
				// TO DO
				//writeFile();
				System.out.println("Saliendo del sistema");
				break;

			case 1:
				userMenu();
				subMainSelect = input.nextInt();
				input.nextLine();

				// AÑADIR USUARIO
				if (subMainSelect == 1) {
					valid=false;
					fullName="";
					email="";
					date=LocalDate.now();

					System.out.println("Ha seleccionado la opcion añadir usuario, introduzca los siguientes datos:");

					System.out.println("Nombre completo:");
					fullName = input.nextLine();

					System.out.println("Fecha de nacimiento (formato(dd-mm-yyyy):");
					while (!valid) {
						try {
							date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
							valid = true;
						} catch (Exception e) {
							System.out.println("Formato de fecha no válido,vuelva a intentarlo:");
						}
					}

					System.out.println("Correo electronico:");
					email = input.nextLine();

					System.out.println("Añadiendo usuario...");
					UsuarioHandler.getInstance().addUser(new Usuario(fullName, date, email));
					System.out.println("El usuario ha sido añadido correctamente.");
				}

				// MODIFICAR USUARIO
				else if (subMainSelect == 2) {
					valid=false;
					fullName="";
					email="";
					date=LocalDate.now();
					
					System.out.println("Selecciona el id del usuario que quieres modificar.");
					Usuario userMod = UsuarioHandler.getInstance().getUserByID( input.nextInt());
					input.nextLine();
							
					System.out.println("Nombre completo:");
					fullName = input.nextLine();
	
			
					System.out.println("Fecha de nacimiento (formato(dd-mm-yyyy):");
					while (!valid) {
						try {
							date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
							valid = true;
						} catch (Exception e) {
							System.out.println("Formato de fecha no válido,vuelva a intentarlo:");
						}
					}

					System.out.println("Correo electronico:");
					email = input.nextLine();

					userMod.setBirthdayDate(date);
					userMod.setEmail(email);
					userMod.setFullName(fullName);
					UsuarioHandler.getInstance().editUser(userMod);
					System.out.println("Mostrando el nuevo usuario...");
					System.out.println(userMod);
				}

				else if (subMainSelect == 3) {
					
					System.out.println("Estos son los usuarios de la lista.");
					for (Usuario us : UsuarioHandler.getInstance().getAllUsers()) {
						System.out.println(us);
					}

				} else if (subMainSelect == 4) {
					System.out.println("Estos son los nombres de los usuarios de la lista.");
					UsuarioHandler.getInstance().printNameUsers();
					valid=false;
					System.out.println("Selecciona el nombre del usuario que quieres borrar.");
					while (!valid) {
						try {
							int id =input.nextInt();
							input.nextLine();
							if(UsuarioHandler.getInstance().existUser(id)){
								UsuarioHandler.getInstance()
								.removeUser(UsuarioHandler.getInstance().getAllUsers().get(input.nextInt()).getId());
								valid=true;
							}
						} catch (Exception e) {
							System.out.println("Formato de id no correcto o id no existente");
						}
					}

				} else if (subMainSelect == 5) {

					System.out.println("Estos son los nombres de los usuarios de la lista.");
					UsuarioHandler.getInstance().printNameUsers();

					System.out.println("Selecciona el nombre del usuario que quieres ver.");
					System.out.println(UsuarioHandler.getInstance().getAllUsers().get(input.nextInt()));
					input.nextLine();
				} else if (subMainSelect == 6) {
					mainMenu();
					mainSelect = input.nextInt();
				} else if (subMainSelect == 0) {
					input.close();
					return;
				}

				break;

			case 2:

				circuitMenu();
				subMainSelect = input.nextInt();

				if (subMainSelect == 1) {
					int adult = 1;
					System.out.println("Introduce los datos para añadir un kart");
					System.out.println("Si el kart a añadir es para adultos pulse 1, sino pulse 0");
					adult = input.nextInt();
					input.nextLine();
					CircuitHandler.getInstance().addKart(new Kart((adult == 1), EstadoKart.DISPONIBLE));
				}
				
				if(subMainSelect == 2) {
					int adult, id;
					Kart k;
					ArrayList<EstadoKart> state = new ArrayList<EstadoKart>();
					state.add(EstadoKart.DISPONIBLE);
					state.add(EstadoKart.MANTENIMIENTO);
					state.add(EstadoKart.RESERVADO);
					
					System.out.println("Selecciona el id del kart que quieres modificar.");
					CircuitHandler.getInstance().printAllKarts();
					
					id = input.nextInt();
					input.nextLine();
					k = CircuitHandler.getInstance().getKartByID(id);
					
					System.out.println("Introduce los nuevos datos del usuario:");
					System.out.println("Si el kart a añadir es para adultos pulse 1, sino pulse 0");
					adult = input.nextInt();
					input.nextLine();
					
					k.setAdult((adult == 1));
					
					System.out.println("Introduce el estado del kart:");
					System.out.println("1 --> Disponible");
					System.out.println("2 --> Reservado");
					System.out.println("3 --> Mantenimiento");
					
					
					k.setState(state.get(input.nextInt()-1));
					input.nextLine();
					
					System.out.println("Mostrando de nuevo la lista de karts...");

					for (Kart k2 : CircuitHandler.getInstance().getAllKarts()) {
						System.out.println(k2);
					}
					
					
				}

				if (subMainSelect == 5) {
					
					System.out.println("Estos son los nombres de los karts de la lista.");

					CircuitHandler.getInstance().printAllKarts();
				}

				break;

			case 3:
				
				reserveMenu();
				/*
				subMainSelect = input.nextInt();
				input.nextLine();

				if (subMainSelect == 1) {
					UsuarioHandler.getInstance().printNameUsers();
					System.out.println("Introduce el ID del usuario encargado de la reserva");
					int idUser=input.nextInt();
					input.nextLine();
					int tipoReserva=0;
					
					System.out.println("Introduce el tiempo que quieras estar");
					int time=input.nextInt();
					
					do {
						System.out.println("Que tipo de reserva quieres?");
						System.out.println("1.Tipo familiar");
						System.out.println("2.Tipo adultos");
						System.out.println("3.Tipo infantil");
						tipoReserva=input.nextInt();
						input.nextLine();
					}while(tipoReserva>3 || tipoReserva<0);
					System.out.println("Fecha de nacimiento (formato(dd-mm-yyyy):");
					while (!valid) {
						try {
							date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
							valid = true;
						} catch (Exception e) {
							System.out.println("Formato de fecha no válido,vuelva a intentarlo:");
						}
					}
					if(tipoReserva==1) {
						//ReservaAbstracta resFamiliar=new ReservaAbstracta(idUser,ReservaHandler.getInstance().calculatePrice(time),date,time,time,time);
					}
					
					System.out.println();
				}
				
				break;

			}

		} while (mainSelect != 0);

		input.close();
		*/
	}

	public static void mainMenu() {
		System.out.println("\n\n================================");
		System.out.println("  SISTEMA DE RESERVA DE KARTS");
		System.out.println("================================");
		System.out.println("1) Menú Usuario");
		System.out.println("2) Menú Circuito");
		System.out.println("3) Menú Reserva\n");
		System.out.println("0) Salir\n");
		System.out.println("-> Introduce una opcion: ");
	}

	public static void userMenu() {
		System.out.println("\n\n================================");
		System.out.println("  GESTIÓN DE USUARIOS");
		System.out.println("================================");
		System.out.println("1) Alta de usuario no registrado");
		System.out.println("2) Modificar usuario");
		System.out.println("3) Listar todos los usuarios");
		System.out.println("4) Eliminar usuario");
		System.out.println("5) Ver datos de un usuario");
		System.out.println("6) Atrás");
		System.out.println("0) Salir");
		System.out.println("-> Introduce una opcion: ");
	}

	public static void circuitMenu() {
		System.out.println("\n\n================================");
		System.out.println("  GESTIÓN DE CIRCUITOS");
		System.out.println("================================");
		System.out.println("1) Añadir kart");
		System.out.println("2) Editar kart");
		System.out.println("3) Eliminar kart");
		System.out.println("4) Ver kart de usuario");
		System.out.println("5) Ver todos los karts");
		System.out.println("6) Añadir pista");
		System.out.println("7) Editar pista");
		System.out.println("8) Eliminar pista");
		System.out.println("9) Ver pista por nombre");
		System.out.println("10) Ver todas las pistas");
		System.out.println("11) Atrás");
		System.out.println("0) Salir");
		System.out.println("-> Introduce una opcion: ");
	}

	public static void reserveMenu() {
		System.out.println("\n\n================================");
		System.out.println("  GESTIÓN DE RESERVAS");
		System.out.println("================================");
		System.out.println("1) Añadir reserva");
		System.out.println("2) Modificar reserva");
		System.out.println("3) Ver reserva por usuario");
		System.out.println("4) Ver reserva por pista");
		System.out.println("5) Eliminar reserva");
		System.out.println("6) Atrás");
		System.out.println("0) Salir");
		System.out.println("-> Introduce una opcion: ");
	}

	public static void writeFile() {
		String pathUser="datos/usuarios.txt";
		String pathReserve="datos/reservas.txt";
		String pathKart="datos/karts.txt";
		String pathPista="datos/pistas.txt";
		try {
			
			FileOutputStream fileOut = new FileOutputStream(pathUser);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(UsuarioHandler.getInstance().getAllUsers());
			fileOut.close();
			
			fileOut = new FileOutputStream(pathReserve);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(ReservaHandler.getInstance().getAllReserves());
			fileOut.close();
			
			fileOut = new FileOutputStream(pathPista);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(CircuitHandler.getInstance().getAllPistas());
			fileOut.close();
			
			fileOut = new FileOutputStream(pathKart);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(CircuitHandler.getInstance().getAllKarts());
			fileOut.close();
			
			objectOut.close();
			System.out.println("OK: Se han guardados los cambios");

		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: No se ha encontrado el fichero");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	



}
