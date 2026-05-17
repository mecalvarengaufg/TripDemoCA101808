package com.claseafe.Proyecto1UFG.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.claseafe.Proyecto1UFG.model.Trip;

import java.text.SimpleDateFormat;

@Service
public class TripServiceImpl implements ITripService {
	private List<Trip> lista = null;
	public TripServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Trip>();
		try {
			Trip trip1 = new Trip();
			trip1.setId(1);
			trip1.setNombre("Rapel en Volcatenango");
			trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
			trip1.setFecha(sdf.parse("10-02-2026"));
			trip1.setCosto(5.0);
			trip1.setDestacado(1);
			// Se agrega la calificacion
			trip1.setCalificacion(1);
			// Actividad 1 Unidad 2
			trip1.setImagen("Imagen1.jpg");
			trip1.setEstatus("Creada");
			
			Trip trip2 = new Trip();
			trip2.setId(2);
			trip2.setNombre("Deslizadero en Picnic");
			trip2.setDescripcion("Deslizarte en un divertido tovogan desde la colina");
			trip2.setFecha(sdf.parse("15-02-2026"));
			trip2.setCosto(10.0);
			trip2.setDestacado(0);
			// Se agrega la calificacion
			trip2.setCalificacion(3);
			// Actividad 1 Unidad 2
			trip2.setImagen("Imagen2.jpg");
			trip2.setEstatus("Creada");
			
			Trip trip3 = new Trip();
			trip3.setId(3);
			trip3.setNombre("Comida y Flores");
			trip3.setDescripcion("Disfrutar de un amplio jardin en el cual podras comprar");
			trip3.setFecha(sdf.parse("09-02-2026"));
			trip3.setCosto(8.0);
			trip3.setDestacado(0);
			// Se agrega la calificacion
			trip3.setCalificacion(5);
			// Actividad 1 Unidad 2
			trip3.setImagen("Imagen3.jpg");
			trip3.setEstatus("Creada");
			
			Trip trip4 = new Trip();
			trip4.setId(4);
			trip4.setNombre("Caminatas");
			trip4.setDescripcion("Disfruta hacer senderismo por las montanas Chalatecas");
			trip4.setFecha(sdf.parse("22-02-2026"));
			trip4.setCosto(2.0);
			trip4.setDestacado(1);
			// Se agrega la calificacion
			trip4.setCalificacion(7);
			// Actividad 1 Unidad 2
			trip4.setImagen("Imagen4.jpg");
			trip4.setEstatus("Creada");
			
			Trip trip5 = new Trip();
			trip5.setId(5);
			trip5.setNombre("Centro Historico");
			trip5.setDescripcion("Desfrutar de una caminata por el Centro Historico");
			trip5.setFecha(sdf.parse("05-03-2026"));
			trip5.setCosto(25.0);
			trip5.setDestacado(1);
			// Se agrega la calificacion
			trip5.setCalificacion(9);
			// Actividad 1 Unidad 2
			trip5.setImagen("Imagen5.jpg");
			trip5.setEstatus("Creada");
			
			// Se agregan 4 objetos mas
			Trip trip6 = new Trip();
			trip6.setId(6);
			trip6.setNombre("Playa El Tunco");
			trip6.setDescripcion("Disfrute en los Restaurantes a la orilla del mar");
			trip6.setFecha(sdf.parse("05-05-2026"));
			trip6.setCosto(8.0);
			trip6.setDestacado(1);
			trip6.setCalificacion(10);
			// Actividad 1 Unidad 2
			trip6.setImagen("Imagen6.jpg");
			trip6.setEstatus("Creada");
			
			Trip trip7 = new Trip();
			trip7.setId(7);
			trip7.setNombre("Lago de Coatepeque");
			trip7.setDescripcion("Disfrute en los Restaurantes a la orilla del lago");
			trip7.setFecha(sdf.parse("20-08-2026"));
			trip7.setCosto(4.0);
			trip7.setDestacado(0);
			trip7.setCalificacion(6);
			// Actividad 1 Unidad 2
			trip7.setImagen("Imagen7.jpg");
			trip7.setEstatus("Creada");
			
			Trip trip8 = new Trip();
			trip8.setId(8);
			trip8.setNombre("Parque Montecristo");
			trip8.setDescripcion("Caminatas al aire libre dentro del Parque");
			trip8.setFecha(sdf.parse("25-06-2026"));
			trip8.setCosto(2.0);
			trip8.setDestacado(1);
			trip8.setCalificacion(4);
			// Actividad 1 Unidad 2
			trip8.setImagen("Imagen8.jpg");
			trip8.setEstatus("Creada");
			
			Trip trip9 = new Trip();
			trip9.setId(9);
			trip9.setNombre("Ruta de las Flores");
			trip9.setDescripcion("Ruta turistica de las FLores con familia y amigos");
			trip9.setFecha(sdf.parse("14-08-2026"));
			trip9.setCosto(25.0);
			trip9.setDestacado(1);
			trip9.setCalificacion(7);
			// Actividad 1 Unidad 2
			trip9.setImagen("Imagen9.jpg");
			trip9.setEstatus("Creada");
			
			
			lista.add(trip1);
			lista.add(trip2);
			lista.add(trip3);
			lista.add(trip4);
			lista.add(trip5);
			// Se agregan 4 objetos mas
			lista.add(trip6);
			lista.add(trip7);
			lista.add(trip8);
			lista.add(trip9);
			
        } catch (Exception e) {
            System.out.println("Error al convertir fecha: " + e.getMessage());
        }
    }

    @Override
    public List<Trip> buscarTodos() {
        return lista;
    }

    @Override
    public void guardar(Trip trip) {
    	lista.add(trip);
    }
    
    @Override
    public Trip buscarPorId(Integer idTrip) {
        for (Trip trip : lista) {
            if (trip.getId().equals(idTrip)) {
                return trip;
            }
        }
        return null;
    }
}
