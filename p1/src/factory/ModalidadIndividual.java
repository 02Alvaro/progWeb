package factory;

import java.time.LocalDateTime;

public class ModalidadIndividual extends ModalidadAbstracta{
	
	@Override
	public ReservaInfantil createReservaInfantil(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numChilds) {
		ReservaInfantil modalidad = new ReservaInfantil( idUser,  date,  time,  idPista,  price, discount,  id, numChilds);
		return modalidad;
	}
	
	
	@Override
	public ReservaFamiliar createReservaFamiliar(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numAdults,Integer numChilds) {
		ReservaFamiliar modalidad = new ReservaFamiliar( idUser,  date,  time,  idPista,  price, discount,  id, numAdults, numChilds);
		return modalidad;
	}
	
	@Override
	public ReservaAdultos createReservaAdultos(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numAdults) {
		ReservaAdultos modalidad = new ReservaAdultos( idUser,  date,  time,  idPista,  price, discount,  id, numAdults);
		return modalidad;
	}

}
