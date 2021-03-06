package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		if(!checkOut.after(checkIn)) { // programação defensiva = tratar exceções no começo dos metodos
			throw new DomainException("Check-out date must be after check-in date"); 
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	/* Não está gerado o setCheckOut e setCheckIn. pq essas datas não podem ser alteradas/atualizadas,
	 pois já tem um metodo para isso (updateDates)*/
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	//metodo duraçãoEmDias
	public long duration() {
		long difference = checkOut.getTime() - checkIn.getTime(); /* calculo que "retorna" os milissegundos da tal data.*/
		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS); /*Converte milissegundos para dias*/
	}
	
	/*metodo que irá receber duas datas novas e irá atualizar o checkIn e checkOut */
	public void updateDates(Date checkIn, Date checkOut) { 
		/*Implemtando codigo : verificando se a data for antes da data atual(agora), se for, não poderá reservar*/
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {/* metodo Date :before() - verifica se a data for antes da data atual(agora).*/
			throw new DomainException("Reservation dates for update must be future dates"); // alteração do codigo c/ exception
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date"); // altereção do codigo c/ exception
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", check-in: "
				+ sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+ " nights.";
	}
	
	
	
}
