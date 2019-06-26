package frame.game;

public class Db2DTO {

	String date;
	String competor;
	String stadium;
	String offense;
	String defense;
	String note;
	
	
	
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getCompetor() {
		return competor;
	}



	public void setCompetor(String competor) {
		this.competor = competor;
	}



	public String getStadium() {
		return stadium;
	}



	public void setStadium(String stadium) {
		this.stadium = stadium;
	}



	public String getOffense() {
		return offense;
	}



	public void setOffense(String offense) {
		this.offense = offense;
	}



	public String getDefense() {
		return defense;
	}



	public void setDefense(String defense) {
		this.defense = defense;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	@Override
	public String toString() {

		return date + ", " + competor + ", " + stadium + ", " + offense + ", " + defense + ", " + note;
				}
	
}
