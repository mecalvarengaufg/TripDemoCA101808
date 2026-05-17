package com.claseafe.Proyecto1UFG.service;

import java.util.List;

import com.claseafe.Proyecto1UFG.model.Trip;

public interface ITripService {
	public List<Trip> buscarTodos();
	public Trip buscarPorId(Integer idTrip);
	
	void guardar(Trip trip);
}
