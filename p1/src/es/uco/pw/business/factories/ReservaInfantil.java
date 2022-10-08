package es.uco.pw.business.factories;
import java.time.LocalDateTime;

import es.uco.pw.data.enums.DificultadPista;

//Es una reserva que realiza un adulto, pero en la que solo participan niños en una pista infantil.

public class ReservaInfantil extends ReservaAbstracta {
	

	private static final long serialVersionUID = 1L;

	private Integer numChilds;
	
	public ReservaInfantil() {};
	
	public ReservaInfantil(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount, Integer id,Integer numChilds) {
		super(idUser,  date,  time,  idPista,  price, discount,  id);
		this.numChilds = numChilds;
	}
	
	public ReservaInfantil(Integer idUser, LocalDateTime date, Integer time, Integer idPista, float price,float discount,Integer numChilds) {
		super(idUser,  date,  time,  idPista,  price, discount);
		this.numChilds = numChilds;
	}


	public DificultadPista getType(){
		return DificultadPista.INFANTIL;
	}

	public  boolean validate(){
		return ( numChilds > 0);
	}

	public Integer getNumPlayers() {
		return numChilds;
	}
	
	public Integer getNumChilds() {
		return numChilds;
	}

	public void setNumChilds(Integer numChilds) {
		this.numChilds = numChilds;
	}

	@Override
	public String toString() {
		return "ReservaInfantil [idUser=" + idUser + ", date=" + date + ", time=" + time + ", idPista=" + idPista
				+ ", price=" + price + ", discount=" + discount + ", numChilds=" + numChilds + ", id=" + id + "]";
	}

}