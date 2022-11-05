package es.pw.uco.business.reserve.models.factory;

import java.time.LocalDateTime;


public abstract class ModalidadAbstracta {

	public abstract ReservaInfantil createReservaInfantil(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numChilds);
	
	public abstract ReservaFamiliar createReservaFamiliar(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numAdults,Integer numChilds);
	
	public abstract ReservaAdultos createReservaAdultos(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numAdults);
	
}	
